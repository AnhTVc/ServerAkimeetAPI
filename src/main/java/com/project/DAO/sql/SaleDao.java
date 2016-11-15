package com.project.DAO.sql;

import com.project.POJO.GroupMenu;
import com.project.POJO.result.Campaign;
import com.project.POJO.Restaurant;
import com.project.POJO.Sale;
import com.project.POJO.result.SaleResult;
import com.project.util.DAOUtil;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by knight_cs on 23/08/2016.
 */
public class SaleDao {
    public static final Logger logger = Logger.getLogger(SaleDao.class);
    public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Connection con = null;
    PreparedStatement pst = null;

    public SaleDao() {
        try {
            con = PoolManagerRead.getConnection();
            PoolManagerRead.getInfo();

        } catch (SQLException e) {
            logger.error("can not CONNECT PoolRead !");
        }
    }

    public void closeBD() {
        try {
           if(pst != null){
               pst.close();
           }
            if(con != null){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Restaurant getSale(String idSale) {

        String idRestaurant;
        int saleOff;
        String address;
        String hourSale;
        String fromDate;
        String toDate;
        Sale sale = null;
        Restaurant restaurant = null;
        ArrayList<GroupMenu> groupMenu = null;
        Campaign campaign = null;


        try {
            String query = "SELECT   id_restaurant,sale_off, time, from_date,to_date " +
                    " FROM  `sale`"+
                    " WHERE id_sale = ? " +
                    " ;";

            logger.info(query);
            System.out.println(con);
            pst = con.prepareStatement(query);
            pst.setString(1, idSale);
            ResultSet rs = pst.executeQuery();


            while (rs.next()) {
                hourSale = rs.getString("time");
                fromDate = rs.getString("from_date");
                toDate = rs.getString("to_date");
                saleOff = rs.getInt("sale_off");
                idRestaurant = rs.getString("id_restaurant");

                restaurant = UtilsDao.getRestaurantFull(pst, con, idRestaurant);
                address = UtilsDao.getAddress(con, idRestaurant);
                groupMenu = UtilsDao.getMenu(pst, con, idRestaurant);
                sale = new Sale(idSale, saleOff, hourSale, fromDate, toDate);
                restaurant = new Restaurant(idRestaurant,restaurant.getNameRestaurant(),address,
                        restaurant.getAvatar(), restaurant.getPhoneNumber(), restaurant.getIntroduce(), restaurant.getImages());

                ArrayList<Sale> sales = new ArrayList<>();
                sales.add(sale);
                restaurant.setSales(sales);
                restaurant.setGroupMenus(groupMenu);
            }

            return restaurant;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.warn("error query");
            System.out.println(e);

        }
        return null;
    }

    /**
     * Tim kiem => loc thong tin
     * @param city
     * @param district
     * @param date
     * @param time
     * @return
     */
    public SaleResult searchSale(String city, String district, String date, String time, int limit, int offset){
        String query = "SELECT  id_sale,sale.id_restaurant,sale_off, time, from_date,to_date " +
                "FROM sale, address where sale.id_restaurant = address.id_restaurant ";

        if( city != null && !city.trim().isEmpty()){
            //Co tim kiem theo city
            query = query + "and city = " + city + " ";
        }

        if(district != null && !district.isEmpty()){
            query = query + "and district = " + district + " ";
        }
        if (date != null){
            query = query + "and '" + date + "' BETWEEN from_date and to_date ";
        }

        query = query + " limit " + limit + " offset " + offset + ";";

        //TODO bị lỗi sql Injection
        ResultSet rs = DAOUtil.executeQuery(con, query);
        return new SaleResult(DAOUtil.resultSetToRestaurant(rs, con));
    }

    /**
     * Tim kiem nhanh
     * @param keyword
     * @return
     */
    public SaleResult findSale(String keyword){
        String query = "SELECT  id_sale,sale.id_restaurant,sale_off, time, from_date,to_date " +
                "FROM  sale, autocomplete WHERE sale.id_restaurant = autocomplete.id_restaurant " +
                "and MATCH (content_search) AGAINST ( ? IN NATURAL LANGUAGE MODE)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, keyword);
           // ResultSet rs = DAOUtil.executeQuery(con, query);
            ResultSet rs = preparedStatement.executeQuery();
            return new SaleResult(DAOUtil.resultSetToRestaurant(rs, con));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Gợi ý người dùng
     * @return
     */
    public SaleResult recommendSale(){
        String query = "SELECT  id_sale,id_restaurant,sale_off, time, from_date,to_date " +
                "FROM  sale ORDER BY RAND() " +
                "LIMIT 4";

        PreparedStatement preparedStatement;
        String idRestaurant;
        int saleOff;
        String address;
        String hourSale;
        String fromDate;
        String toDate;
        Sale sale;
        Restaurant restaurant ;
        logger.info(query);
        try {
            preparedStatement = con.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();
            ArrayList<Restaurant> restaurants = new ArrayList<>();
            while (rs.next()){
                hourSale = rs.getString("time");
                fromDate = rs.getString("from_date");
                toDate = rs.getString("to_date");
                saleOff = rs.getInt("sale_off");
                idRestaurant = rs.getString("id_restaurant");

                restaurant = UtilsDao.getRestaurant(con, idRestaurant);
                address = UtilsDao.getAddress(con, idRestaurant);
                //TODO bug
                if(address != null){
                    restaurant.setAddress(address);
                }
                sale = new Sale(String.valueOf(rs.getInt("id_sale")), saleOff, hourSale, fromDate, toDate);

                ArrayList<Sale> sales = new ArrayList<>();
                sales.add(sale);
                restaurant.setSales(sales);

                restaurants.add(restaurant);
            }

            return new SaleResult(restaurants);
        }catch (SQLException e){
            logger.error(e);
        }
        return null;
    }

}
