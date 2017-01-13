package com.mongoDb;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       @SuppressWarnings("deprecation")
	Configuration configuration = new Configuration();
       configuration.setClassForTemplateLoading(App.class,"/");
       try {
		Template template = configuration.getTemplate("index.html");
		final StringWriter writer = new StringWriter();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "satya");
		template.process(map, writer);
		Spark.get("/hello", new Route() {
			
			public Object handle(Request arg0, Response arg1) throws Exception {
				// TODO Auto-generated method stub
				return writer;
			}
		});
		System.out.print(writer);
	} catch (TemplateNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MalformedTemplateNameException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (TemplateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       

    }
}
