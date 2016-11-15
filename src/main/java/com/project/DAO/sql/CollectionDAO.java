package com.project.DAO.sql;

import com.project.POJO.Restaurant;
import com.project.POJO.Sale;
import com.project.POJO.result.Campaign;
import com.project.util.DAOUtil;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by VietAnh on 9/14/2016.
 */
public class CollectionDAO {

    private  static Connection con = null;
    public static final Logger logger = Logger.getLogger(CollectionDAO.class);
    public CollectionDAO(){

        try {
            con = PoolManagerRead.getConnection();
            PoolManagerRead.getInfo();

        } catch (SQLException e) {
            logger.error("can not CONNECT PoolRead !");
            e.printStackTrace();
        }
    }

    /**
     *
     * @param type
     * @return
     */
    public ArrayList<Restaurant> getCollection(int type, int limit, int offset){
        String query = "SELECT  id_sale,sale_off, time, from_date,to_date, sale.id_restaurant " +
                "FROM  sale, collection " +
                "WHERE sale.id_restaurant = collection.id_restaurant " +
                "and collection.type = ?" +
                " LIMIT ? " +
                " OFFSET ?" +
                ";";

        PreparedStatement preparedStatement = null;
        logger.info(query);
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, type);
            preparedStatement.setInt(2, limit);
            preparedStatement.setInt(3, offset);

            ResultSet resultSet = preparedStatement.executeQuery();
            return DAOUtil.resultSetToRestaurant(resultSet,con);
        } catch (SQLException e) {
            //e.printStackTrace();
            logger.error(e);
        }
       // ResultSet rs = DAOUtil.executeQuery(con, query);
        return null;
    }
    public void closeBD() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
