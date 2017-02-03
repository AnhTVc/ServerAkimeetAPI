package com.project.mongdb.feedback;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.project.POJO.Feedback;
import com.project.POJO.Rate;
import com.project.util.constant.Constant;
import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by VietAnh on 11/21/2016.
 */
public class FeedbackMongoDBDAO {
    public static final Logger logger = Logger.getLogger(FeedbackMongoDBDAO.class);

    /**
     * Find Feedback for Restaurant
     * @param idRestaurant
     * @return
     */
    public static ArrayList<Feedback> findFeedbackByIdRestaurant(String idRestaurant){
        logger.info("Find all feedback of Restaurant");
        MongoDBUtil mongoDBUtil = new MongoDBUtil();
        mongoDBUtil.getConnectionMongoDB();
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("idRestaurant", idRestaurant);
        DBCursor dbCursorFeedback = mongoDBUtil.findWithWhereQuery(Constant.DATABASE_MONGODB, Constant.COLLECTION_FEEBACK, whereQuery);

        ArrayList<Feedback> feedbacks = new ArrayList<>();
        Feedback feedback;

        Gson gson = new Gson();
        if(dbCursorFeedback!= null){
            while(dbCursorFeedback.hasNext()) {
                DBObject dbObject = dbCursorFeedback.next();
                feedback = gson.fromJson(dbObject.toString(), Feedback.class);
                feedbacks.add(feedback);
            }
        }

        mongoDBUtil.closeConnection();
        logger.info("Find complete");
        return feedbacks;
    }

    /**
     * Insert feedback to Restaurant
     * @param
     * @return
     */
    public static void insertFeedbacByIdRestaurant(Feedback feedback){
        logger.info("Insert feedback to restaurant");
        MongoDBUtil mongoDBUtil = new MongoDBUtil();
        mongoDBUtil.getConnectionMongoDB();

        Gson gson = new Gson();
        mongoDBUtil.insertDocument(Constant.DATABASE_MONGODB, Constant.COLLECTION_FEEBACK,
                gson.toJson(feedback));

        mongoDBUtil.closeConnection();

        logger.info("Insert feedback complete");
    }

    public static ArrayList<Rate> findRatingByIdRestaurant(String idRestaurant){
        logger.info("Find all rating of Restaurant");
        MongoDBUtil mongoDBUtil = new MongoDBUtil();
        mongoDBUtil.getConnectionMongoDB();
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("idRestaurant", idRestaurant);
        DBCursor dbCursorFeedback = mongoDBUtil.findWithWhereQuery(Constant.DATABASE_MONGODB, Constant.COLLECTION_RATING, whereQuery);

        ArrayList<Rate> rates = new ArrayList<>();
        Rate rate;

        Gson gson = new Gson();
        if(dbCursorFeedback!= null){
            while(dbCursorFeedback.hasNext()) {
                DBObject dbObject = dbCursorFeedback.next();
                rate = gson.fromJson(dbObject.toString(), Rate.class);
                rates.add(rate);
            }
        }

        mongoDBUtil.closeConnection();
        logger.info("Find complete");
        return rates;
    }

}
