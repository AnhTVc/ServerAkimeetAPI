package com.project.DAO.sql;

import com.project.POJO.Address;
import com.project.POJO.Restaurant;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Thực hiện các việc liên quan đến nhà hàng
 * Created by VietAnh on 11/13/2016.
 */

public class RestaurantDAO {
    public static final Logger logger = Logger.getLogger(RestaurantDAO.class);
    static Connection connection = null;
    public RestaurantDAO(){
        try {
            connection = PoolManagerRead.getConnection();
            PoolManagerRead.getInfo();
        } catch (SQLException e) {
            logger.error("can not CONNECT PoolRead !");
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            connection.close();
            logger.info("Close connection");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Find restaurant by type
     * typeRestaurant: 1 => ẩm thực
     * typeRestaurant: 2 => đồ uống
     * typeRestaurant: 3 => giải trí
     * typeRestaurant: 4 => sức khỏe làm đẹp
     * collection: eg: TAG_ENTERTAINMENT_KARAOKE: 3101: Giải trí, thể loại karaoke
     * @param typeCollection
     * @return
     */
    public ArrayList<com.project.POJO.Restaurant> getRestaurantByTypeAndCollection(int typeRestaurant, int typeCollection){
        String query = "SELECT * FROM restaurant,collection  WHERE restaurant.id_restaurant = collection.id_restaurant AND " +
                "restaurant.type = ? AND collection.type = ?;";
        logger.info(query);
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, typeRestaurant);
            preparedStatement.setInt(2, typeCollection);

            ArrayList<Restaurant> restaurants = new ArrayList<>();
            Restaurant restaurant;

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                restaurant = new Restaurant();

                restaurant.setId_restaurant(String.valueOf(resultSet.getInt("id_restaurant")));
                restaurant.setName_restaurant(resultSet.getString("name"));
                restaurant.setPhone_number(resultSet.getString("phone_number"));
                restaurant.setIntroduce(resultSet.getString("introduce"));
                restaurant.setAvatar(resultSet.getString("avatar"));
                restaurant.setImages(resultSet.getString("images"));
                restaurant.setExtend(resultSet.getString("extend"));

                String str = "SELECT * from address WHERE id_restaurant = ?";
                PreparedStatement statement = connection.prepareStatement(str);

                statement.setInt(1, Integer.parseInt(restaurant.getId_restaurant()));
                Address address = new Address();
                ResultSet rs = statement.executeQuery();

                while (rs.next()){
                    address.setCity(rs.getString("city"));
                    address.setDetail(rs.getString("detail"));
                    address.setDistrict(rs.getString("district"));
                    address.setIdAddress(rs.getString("id_address"));
                    address.setIdCity(rs.getString("id_city"));
                    address.setIdDistrict(rs.getString("id_district"));
                }

                restaurant.setPoistion(address);
                restaurants.add(restaurant);
            }

            return restaurants;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Find restaurant by type
     * typeRestaurant: 1 => ẩm thực
     * typeRestaurant: 2 => đồ uống
     * typeRestaurant: 3 => giải trí
     * typeRestaurant: 4 => sức khỏe làm đẹp
     * collection: eg: TAG_ENTERTAINMENT_KARAOKE: 3101: Giải trí, thể loại karaoke
     * @param typeCollection
     * @return
     */
    public ArrayList<com.project.POJO.Restaurant> getRestaurantByTypeAndCollection(int typeRestaurant, int typeCollection, int limit){
        String query = "SELECT * FROM restaurant,collection  WHERE restaurant.id_restaurant = collection.id_restaurant AND " +
                "restaurant.type = ? AND collection.type = ? LIMIT ?;";
        logger.info(query);
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, typeRestaurant);
            preparedStatement.setInt(2, typeCollection);
            preparedStatement.setInt(3, limit);
            ArrayList<Restaurant> restaurants = new ArrayList<>();
            Restaurant restaurant;

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                restaurant = new Restaurant();

                restaurant.setId_restaurant(String.valueOf(resultSet.getInt("id_restaurant")));
                restaurant.setName_restaurant(resultSet.getString("name"));
                restaurant.setPhone_number(resultSet.getString("phone_number"));
                restaurant.setIntroduce(resultSet.getString("introduce"));
                restaurant.setAvatar(resultSet.getString("avatar"));
                restaurant.setImages(resultSet.getString("images"));
                restaurant.setExtend(resultSet.getString("extend"));

                String str = "SELECT * from address WHERE id_restaurant = ?";
                PreparedStatement statement = connection.prepareStatement(str);

                statement.setInt(1, Integer.parseInt(restaurant.getId_restaurant()));
                Address address = new Address();
                ResultSet rs = statement.executeQuery();

                while (rs.next()){
                    address.setCity(rs.getString("city"));
                    address.setDetail(rs.getString("detail"));
                    address.setDistrict(rs.getString("district"));
                    address.setIdAddress(rs.getString("id_address"));
                    address.setIdCity(rs.getString("id_city"));
                    address.setIdDistrict(rs.getString("id_district"));
                }

                restaurant.setPoistion(address);
                restaurants.add(restaurant);
            }

            return restaurants;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
