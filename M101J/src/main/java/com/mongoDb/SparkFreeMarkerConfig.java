package com.mongoDb;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.HaltException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.http.matching.Halt;

public class SparkFreeMarkerConfig {
	public static void main(String[] args) {

	       final Configuration configuration = new Configuration();
	       configuration.setClassForTemplateLoading(SparkFreeMarkerConfig.class,"/");
	       
	       Spark.get("/", new Route() {
	    	   StringWriter writer = new StringWriter();  
			public Object handle(Request req, Response res) throws Exception {
				 try{
					 
					 Template template = configuration.getTemplate("index.html");
					 Map<String, Object> map = new HashMap<String, Object>();
					 map.put("fruits",Arrays.asList("mango","orange","peach","lichi") );
					 template.process(map, writer);
					 
		    	   }catch (Exception e) {
		    		   res.status(500);
		    		   return null;
				}
				return writer;
			}
		});
	    
	    Spark.post("/fruits", new Route() {	
			@Override
			public Object handle(Request request, Response response) throws Exception {
				if (request.queryParams("fruit")== null) {
					return "not selected any thing";
				}else{
				    return "you have selected "+ request.queryParams("fruit");
				}
				
			}
		});
	       
	}
}
