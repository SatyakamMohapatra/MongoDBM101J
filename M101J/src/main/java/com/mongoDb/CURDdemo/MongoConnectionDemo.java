package com.mongoDb.CURDdemo;

import org.bson.BasicBSONCallback;
import org.bson.BsonDocument;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class MongoConnectionDemo {
	public static void main(String[] args) {
		
		MongoClient client = new MongoClient();
		MongoDatabase database = client.getDatabase("video");
		MongoCollection<BsonDocument> collection  =database.getCollection("movies", BsonDocument.class);
		FindIterable<BsonDocument> iterable = collection.find();
		//System.out.println(iterable.first());

	}

}
