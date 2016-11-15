package com.project.DAO.sql;

import com.project.POJO.Restaurant;
import com.project.POJO.Sale;
import com.project.POJO.result.Campaign;
import com.project.POJO.result.SaleResult;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by knight_cs on 30/08/2016.
 */
public class AddtionDao {

    public static final Logger logger = Logger.getLogger(AddtionDao.class);
    public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Connection con = null;
    PreparedStatement pst = null;

    public AddtionDao() {
        try {
            con = PoolManagerRead.getConnection();
            PoolManagerRead.getInfo();

        } catch (SQLException e) {
            logger.error("can not CONNECT PoolRead !");
            e.printStackTrace();
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

    public SaleResult getAllSale(int limit, int offset, String type) {

        String tableSale = "`sale`";
        String idSale;
        String idRestaurant;
        int saleOff;
        Restaurant restaurant;
        String address;
        String hourSale;
        String fromDate;
        String toDate;
        String orderBy = null;
        Sale sale;

        Campaign campaign;
        SaleResult saleResult = null;
        ArrayList<Campaign> listCampaign = new ArrayList<>();
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        switch (type) {
            case "last_sale" : orderBy = "time_create";
            case "special_sale" : orderBy = "sale_off";
            case "care_sale" : orderBy = "transaction";
        }

        try {
            String query = "SELECT   id_sale,id_restaurant,sale_off, time, from_date,to_date " +
                    " FROM  `sale`"+
                    " ORDER BY " + orderBy + " DESC " +
                    " LIMIT " + limit +
                    " OFFSET " + offset +
                    ";";

            logger.info(query);
            System.out.println(con);
            pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();


            while (rs.next()) {
                idSale = rs.getString("id_sale");
                hourSale = rs.getString("time");
                fromDate = rs.getString("from_date");
                toDate = rs.getString("to_date");
                saleOff = rs.getInt("sale_off");
                idRestaurant = rs.getString("id_restaurant");

                restaurant = UtilsDao.getRestaurant( con, idRestaurant);
                address = UtilsDao.getAddress( con, idRestaurant);
                sale = new Sale(idSale, saleOff, hourSale, fromDate, toDate);
                restaurant = new Restaurant(idRestaurant,restaurant.getNameRestaurant(),address,restaurant.getAvatar());

                ArrayList<Sale> sales = new ArrayList<>();
                sales.add(sale);
                restaurant.setSales(sales);
                restaurants.add(restaurant);
            }
            saleResult = new SaleResult(restaurants);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.warn("error query");
            System.out.println(e);

        }
        return saleResult;
    }

}
