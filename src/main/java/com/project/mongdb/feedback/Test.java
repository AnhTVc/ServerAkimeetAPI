package com.project.mongdb.feedback;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.project.POJO.Customer;
import com.project.POJO.Feedback;
import com.project.POJO.Rate;
import org.apache.log4j.BasicConfigurator;

public class Test {

	public static void main(String[] args) {
		try {
			BasicConfigurator.configure();
			//Test insert feedback
			Feedback feedback = new Feedback();
			feedback.setContent("Test");
			Customer customer = new Customer();
			customer.setIdCustomer("123456");

			feedback.setCustomer(customer);
			feedback.setIdRestaurant("123456 Id restaurant");
			feedback.setImages("Image");
			Rate rate = new Rate();
			rate.setPrice(8);
			rate.setQuality(8);
			rate.setService(8);
			rate.setSpace(8);

			feedback.setRate(rate);
			feedback.setTimeCreate(new Date());
			feedback.setTitle("Title test");

			FeedbackMongoDBDAO.insertFeedbacByIdRestaurant(feedback);

			//Find feedback
			ArrayList<Feedback> feedbacks = FeedbackMongoDBDAO.findFeedbackByIdRestaurant("123456 Id restaurant");
			System.out.println(feedbacks.size());


			/*MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
			
			DB database = mongoClient.getDB("akimeet");
			System.out.println("Connect to database successfully");
			
			DBCollection dbCollection = database.getCollection("users");
			System.out.println("Collection mycol selected successfully");
			System.out.println("-------------Find doc first-------------------");
			//Find document first
			DBObject doc = dbCollection.findOne();
			System.out.println(doc);
			System.out.println("--------------Find all------------------");
			
			//Find all document
			DBCursor cursor = dbCollection.find();
			while(cursor.hasNext()) {
			    System.out.println(cursor.next());
			}
			System.out.println("--------------find where age: 19------------------");
			
			//find with where
			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("age", 19);
			DBCursor cursorWithWhere = dbCollection.find(whereQuery);
			while(cursorWithWhere.hasNext()) {
			    System.out.println(cursorWithWhere.next());
			}
			System.out.println("---------------Find in-----------------");
			// Find $in exemple
			BasicDBObject inQuery = new BasicDBObject();
			ArrayList<String> list = new ArrayList<String>();
			list.add("P");
			list.add("abc");
			
			inQuery.put("status", new BasicDBObject("$in", list));
			DBCursor cursorIn = dbCollection.find(inQuery);
			while(cursorIn.hasNext()) {
				System.out.println(cursorIn.next());
			}*/
			
			
			//More example https://www.mkyong.com/mongodb/java-mongodb-query-document/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
