package com.mongoDb.CURDdemo;

import java.util.Arrays;
import java.util.Collections;

import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoInsert {
	public static void main(String[] args) {
		MongoClient client = new  MongoClient();
		MongoDatabase database = client.getDatabase("CurdDemo");
		MongoCollection<Document> collection = database.getCollection("insertMongo");
		
		collection .drop();
		
		Document document = new Document("name","satya")
								.append("age", 25)
								.append("hobby", "cricket");
		Document document1 = new Document("name","Raju")
								.append("age", 30)
								.append("hobby", "hockey");
		
		collection.insertMany(Arrays.asList(document,document1));
		System.out.println(document1.toJson());
		
		//Bson filter = Filters.and(Filters.eq(value));
	}
}
