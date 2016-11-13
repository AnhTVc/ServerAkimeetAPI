package com.project.DAO.sql;

import com.project.POJO.Restaurant;
import com.project.POJO.Sale;
import com.project.POJO.result.Campaign;
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
 * Created by knight_cs on 11/08/2016.
 */
//TODO có tối ưu được class này
public class HomeDao {

    public static final Logger logger = Logger.getLogger(HomeDao.class);
    public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Connection con = null;
    PreparedStatement pst = null;

    public HomeDao() {
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
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tìm kiếm ưu đãi đặc biệt
     * @return
     */
    public SaleResult getSpecialSale() {
        String query = "SELECT  id_sale,id_restaurant,sale_off, time, from_date,to_date " +
                " FROM `sale` ORDER BY sale_off DESC " +
                " LIMIT 8;";
        ResultSet rs = DAOUtil.executeQuery(con, query);
        return new SaleResult(DAOUtil.resultSetToCampains(rs, con));
    }


    /**
     * Tìm kiếm ưu đãi mới nhất
     * @return
     */
    public SaleResult getLastSale() {
        String query = " SELECT   id_sale,id_restaurant,sale_off, time, from_date,to_date " +
                " FROM  `sale` ORDER BY time_create DESC " +
                " LIMIT 8;";

        ResultSet rs = DAOUtil.executeQuery(con, query);
        return new SaleResult(DAOUtil.resultSetToCampains(rs, con));
    }

    /**
     * Tìm kiếm ưu đãi quan tâm nhất
     * @return
     */
    public SaleResult getCareSale() {
        String query = "SELECT  id_sale,id_restaurant,sale_off, time, from_date,to_date " +
                " FROM  `sale` ORDER BY transaction DESC " +
                " LIMIT 8;";
        ResultSet rs = DAOUtil.executeQuery(con, query);
        return new SaleResult(DAOUtil.resultSetToCampains(rs, con));
    }

    /**
     * Trả là danh sách các nhà hàng mà muốn quảng cáo
     * @return
     */
    public  SaleResult getBusinessSale(){
        String query = "SELECT  id_sale,id_restaurant,sale_off, time, from_date,to_date " +
                " FROM  `sale` ORDER BY business DESC " +
                " LIMIT 4;";
        ResultSet rs = DAOUtil.executeQuery(con, query);
        return new SaleResult(DAOUtil.resultSetToCampains(rs, con));
    }
}
