package com.project.DAO.sql;

import com.project.POJO.Affinity;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nguyennhunai on 2016-07-01.
 */
public class AffinityDao {

    public static final Logger logger = Logger.getLogger(AffinityDao.class);
    Connection con = null;
    PreparedStatement pst = null;
    public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    public AffinityDao() {

        try {
            con = PoolManagerRead.getConnection();
            PoolManagerRead.getInfo();

        } catch (SQLException e) {
            logger.error("can not CONNECT PoolRead !");
        }
    }
    public void closeBD() {
        try {
            pst.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Affinity> getAffinityDao(String fromDate, String toDate, String domain, Map<Long, String> topicMap)  {

        ArrayList<Affinity> result = new ArrayList<>();
        String table = "`interest_topic_long_term`";

        Long topic = 0L;
        String topicString = null;
        float percent = 0F;

        try {

            String query = " SELECT   topic,  AVG(percent_interest) as percent" +
                           " FROM  " + table +
                           " WHERE "+
                           " dt >= '" + fromDate + "'" +
                           " AND dt >= '" + toDate + "'" +
                           " AND domain = '" + domain + "'" +
                           " GROUP BY topic" +
                           " ORDER BY percent DESC " +
                           " LIMIT 10;";

            logger.info(query);
            pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                topic = rs.getLong("topic");
                topicString = topicMap.get(topic);
                percent = rs.getFloat("percent");
                result.add( new Affinity(topicString, percent));
            }

//            System.out.println("topic:" + topic);
//            System.out.println("percent:" + percent);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.warn("error query");
        }finally {
            try {
            if(con != null)   con.close();
            if(pst != null)   con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error("Can not CLOSE PrepareStatement");
            }
        }
        return result;
    }

    public Map<Long,String> topicMapDao(){

        Map<Long,String> topicMap = new HashMap<>();
        String table = "`topic`";

        Long id_topic = 0L;
        String topic = null;

        try {

            String query = " SELECT   id_topic,  topic " +
                    " FROM  " + table +
                    " ;";

            logger.info(query);
            pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                id_topic = rs.getLong("id_topic");
                topic = rs.getString("topic");
                topicMap.put(id_topic, topic);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            logger.warn("error query");
        }
        return topicMap;
    }






}
