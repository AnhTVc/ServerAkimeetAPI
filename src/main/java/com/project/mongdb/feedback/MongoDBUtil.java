package com.project.mongdb.feedback;

import com.mongodb.*;
import com.project.util.constant.Constant;
import org.apache.log4j.Logger;
import com.mongodb.util.JSON;


public class MongoDBUtil {
	public static final Logger logger = Logger.getLogger(MongoDBUtil.class);
	static MongoClient mongoClient;

	public void closeConnection(){
		logger.info("Close conenction to MongoDB");
		mongoClient.close();
	}
	/**
	 * Get connection to mongodb
	 * @return
	 */
	public MongoClient getConnectionMongoDB(){
		logger.info("Connecting to MongoDB");
		try {
			mongoClient = new MongoClient(new MongoClientURI(Constant.URL_MONGODB));
			//DB database = mongoClient.getDB(DATABASE);
			logger.info("Connect to database successfully: " + Constant.URL_MONGODB );

			//DBCollection dbCollection = database.getCollection(COLLECTION);

			return mongoClient;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Insert json to collecion in database
	 * @param database
	 * @param collection
	 * @param jsonData
	 */
	public void insertDocument(String database, String collection, String jsonData){
		logger.info("Insert document to "+ database + "and" + collection);
		DB db = mongoClient.getDB(database);
		DBCollection dbCollection = db.getCollection(collection);
		
		// convert JSON to DBObject directly
		DBObject dbObject = (DBObject) JSON
							.parse(jsonData);
		
		dbCollection.insert(dbObject);
		
		logger.info("Insert successfull");
	}
	
	/**
	 * Find all document
	 * @param database
	 * @param collection
	 * @return
	 */
	public DBCursor findAllDocument(String database, String collection){
		logger.info("Find all document "+ database + "and" + collection);
		DB db = mongoClient.getDB(database);
		DBCollection dbCollection = db.getCollection(collection);
		
		DBCursor cursorDoc = dbCollection.find();
		
		return cursorDoc;
	}

	/**
	 * Find document by wherequery
	 * @param database
	 * @param collection
	 * @param whereQuery
     * @return
     */
	public DBCursor findWithWhereQuery(String database, String collection, BasicDBObject whereQuery){
		logger.info("Find document with where query");
		DB db = mongoClient.getDB(database);
		DBCollection dbCollection = db.getCollection(collection);

		DBCursor cursorWithWhere = dbCollection.find(whereQuery);
		return cursorWithWhere;
	}
}
