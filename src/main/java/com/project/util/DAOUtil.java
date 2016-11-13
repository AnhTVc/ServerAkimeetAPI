package com.project.util;

import com.project.DAO.sql.UtilsDao;
import com.project.POJO.Restaurant;
import com.project.POJO.Sale;
import com.project.POJO.result.Campaign;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by VietAnh on 9/14/2016.
 */
public class DAOUtil {
    public static final org.apache.log4j.Logger logger = Logger.getLogger(DAOUtil.class);

    /**
     * Thuc thi query
     * @param connection
     * @param query
     * @return
     */
    public static ResultSet executeQuery(Connection connection, String query){
        logger.info(query);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            return  resultSet;
        }catch (SQLException e){
            logger.error(e);
            e.printStackTrace();
        }

        return null;
    }


    /**
     *
     * @param rs
     * @return
     */
    public static ArrayList<Campaign> resultSetToCampains(ResultSet rs, Connection con){
        if(rs != null){
            ArrayList<Campaign> campaigns = new ArrayList<>();
            Restaurant restaurant;
            Sale sale;
            String address;
            Campaign campaign;
            String idRestaurant;

            try {
                while (rs.next()) {
                    idRestaurant = rs.getString("id_restaurant");
                    restaurant = UtilsDao.getRestaurant(con,idRestaurant);
                    //address = UtilsDao.getAddress(con,idRestaurant);
                    //restaurant.setAddress(address);
                    sale = new Sale(rs.getString("id_sale"), rs.getInt("sale_off"), rs.getString("time"), rs.getString("from_date"), rs.getString("to_date"));
                    //restaurant = new RestaurantDAO(idRestaurant,restaurant.getNameRestaurant(),address,restaurant.getAvatar());

                    campaign = new Campaign(restaurant, sale);
                    campaigns.add(campaign);
                }
                if(campaigns.size() > 0)
                    return campaigns;
                return null;
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }

}
