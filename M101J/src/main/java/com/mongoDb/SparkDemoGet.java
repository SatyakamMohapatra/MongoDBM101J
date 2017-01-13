package com.mongoDb;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkDemoGet {
	public static void main(String[] args) {
		
		Spark.get("/", new Route() {
			public Object handle(Request req, Response res) throws Exception {
				System.out.println("/");
				return "Return /";
			}
		});
		
		Spark.get("/index", new Route() {
				public Object handle(Request req, Response res) throws Exception {
					System.out.println("/hello");
				return "/index page returned";
			}
		});
		
		Spark.get("/echo/:id", new Route() {			
			public Object handle(Request req, Response res) throws Exception {
				System.out.println("/echo/:id");
				return req.params("id");
			}
		});
	
	}
}
