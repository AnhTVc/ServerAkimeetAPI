package com.project.DAO.sql;

import com.project.POJO.*;
import com.project.mongdb.feedback.FeedbackMongoDBDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by knight_cs on 23/08/2016.
 */
public class UtilsDao {


    public static final Logger logger = Logger.getLogger(UtilsDao.class);

    public static String getAddress(Connection con, String id_restaurant) {
        String address = null;
        String detail;
        String district;
        String city;

        PreparedStatement pst = null;
        try {
            String query = "SELECT   detail, district , city " +
                    " FROM `address` WHERE id_restaurant = ?";

            logger.info(query);
            pst = con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(id_restaurant));
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                detail = rs.getString("detail");
                district = rs.getString("district");
                city = rs.getString("city");
                address = detail + "," + district + "," + city;
                return address;
            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.warn("error query");
        }
       return null;
    }

    public static Restaurant getRestaurant(Connection con, String id_restaurant) {
        Restaurant restaurantDAO = null;
        String tableRestaurant = "`restaurant`";
        PreparedStatement pst = null;
        try {
            String query = "SELECT  name ,avatar, introduce" +
                    " FROM  " + tableRestaurant +
                    " WHERE id_restaurant = ?";

            logger.info(query);
            pst = con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(id_restaurant));
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                restaurantDAO = new Restaurant();
                restaurantDAO.setName_restaurant(rs.getString("name"));
                restaurantDAO.setAvatar(rs.getString("avatar"));
                restaurantDAO.setIntroduce(rs.getString("introduce"));
            }

            restaurantDAO.setId_restaurant(id_restaurant);
           // logger.info(restaurantDAO.getIntroduce());
            String str = "SELECT * from address WHERE id_restaurant = ?";
            PreparedStatement preparedStatement = con.prepareStatement(str);
            logger.info(str);
            preparedStatement.setInt(1, Integer.parseInt(id_restaurant));
            Address address = new Address();
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                address.setCity(resultSet.getString("city"));
                address.setDetail(resultSet.getString("detail"));
                address.setDistrict(resultSet.getString("district"));
                address.setIdAddress(resultSet.getString("id_address"));
                address.setIdCity(resultSet.getString("id_city"));
                address.setIdDistrict(resultSet.getString("id_district"));
            }

            restaurantDAO.setPoistion(address);

            //Tìm các collection cho nhà hàng
            query = "SELECT * FROM collection where id_restaurant = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(id_restaurant));
            logger.info(query);

            ArrayList<Collection> collections = new ArrayList<>();
            Collection collection;
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                collection = new Collection();
                collection.setIdCollection(String.valueOf(resultSet.getInt("id_collection")));
                collection.setIdRestaurant(String.valueOf(resultSet.getInt("id_restaurant")));
                collection.setType(resultSet.getString("type"));

                collections.add(collection);
            }

            restaurantDAO.setCollections(collections);


            //Sale
            String strSale = "SELECT * from sale WHERE id_restaurant = ?";
            PreparedStatement preparedStatementSale = con.prepareStatement(strSale);

            preparedStatementSale.setInt(1, Integer.parseInt(id_restaurant));
            ResultSet resultSetSale = preparedStatementSale.executeQuery();
            ArrayList<Sale> sales = new ArrayList<>();
            Sale sale;
            if(resultSetSale.next()){
                sale = new Sale();

                sale.setBusiness(resultSetSale.getInt("business"));
                sale.setFrom_date(resultSetSale.getDate("from_date").toString());
                sale.setTo_date(resultSetSale.getDate("to_date").toString());
                sale.setId_sale(String.valueOf(resultSetSale.getInt("id_sale")));
                sale.setSale_off(resultSetSale.getInt("sale_off"));
                sale.setTime(resultSetSale.getString("time"));

                sales.add(sale);
                restaurantDAO.setSales(sales);

                return restaurantDAO;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            logger.warn("error query");
        }
        return null;
    }

    public static Restaurant getRestaurantFull(PreparedStatement pst, Connection con, String id_restaurant) {

        String tableRestaurant = "`restaurant`";
        String nameRestaurant = null;
        String avatarRestaurant = null;
        String introRestaurant = null;
        String phoneRestaurant = null;
        String imgsRestaurant = null;

        try {
            String query = "SELECT name ,avatar, introduce, phone_number, images" +
                    " FROM  " + tableRestaurant +
                    " WHERE id_restaurant ='" + id_restaurant + "';";

            logger.info(query);
            pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                nameRestaurant = rs.getString("name");
                avatarRestaurant = rs.getString("avatar");
                introRestaurant = rs.getString("introduce");
                phoneRestaurant = rs.getString("phone_number");
                imgsRestaurant = rs.getString("images");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.warn("error query");
        }

        Restaurant restaurant = new Restaurant(id_restaurant, nameRestaurant, avatarRestaurant, phoneRestaurant, introRestaurant, imgsRestaurant);

        restaurant.setFeedbacks(FeedbackMongoDBDAO.findFeedbackByIdRestaurant(id_restaurant));
        restaurant.setRates(FeedbackMongoDBDAO.findRatingByIdRestaurant(id_restaurant));
        return restaurant;
    }

    public static ArrayList<GroupMenu> getMenu(PreparedStatement pst, Connection con,String id_restaurant) {

        String tableMenu = "`group_menu`";
        String idGroupMenu;
        String name;
        ArrayList<Menu> menu;
        ArrayList<GroupMenu> result = new ArrayList<>();

        try {
            String query = "SELECT   id_group_menu, name " +
                    " FROM  " + tableMenu +
                    " WHERE id_restaurant ='" + id_restaurant + "';";

            logger.info(query);
            pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                idGroupMenu = rs.getString("id_group_menu");
                name = rs.getString("name");
                menu = getGrMenu(pst,con,idGroupMenu);
                result.add(new GroupMenu(name,menu));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.warn("error query");
        }
        return result;
    }


    public static ArrayList<Menu> getGrMenu(PreparedStatement pst, Connection con,String idGroupMenu) {

        String tableMenu = "`menu`";
        String idMenu;
        String name;
        String price;
        String sale;
        String image;
        ArrayList<Menu> result = new ArrayList<>();

        try {
            String query = "SELECT   id_menu, sale, name, price, image" +
                    " FROM  " + tableMenu +
                    " WHERE id_group_menu ='" + idGroupMenu + "';";

            logger.info(query);
            pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                idMenu = rs.getString("id_menu");
                sale = rs.getString("sale");
                name = rs.getString("name");
                price = rs.getString("price");
                image = rs.getString("image");
                result.add(new Menu(idMenu,name,price,sale,image));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.warn("error query");
        }
        return result;
    }



}
