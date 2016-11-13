package com.project.DAO.sql;

import com.project.POJO.result.AutoComplete;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by VietAnh on 9/8/2016.
 */
public class AutoCompleteDAO {

    public static final Logger logger = Logger.getLogger(AddtionDao.class);
    public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Connection con = null;
    PreparedStatement pst = null;

    /**
     * Create connection
     */
    public AutoCompleteDAO() {
        try {
            con = PoolManagerRead.getConnection();
            PoolManagerRead.getInfo();

        } catch (SQLException e) {
            logger.error("can not CONNECT PoolRead !");
            e.printStackTrace();
        }
    }

    /**
     * Close Connection
     */
    public void closeBD() {
        try {
            pst.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Hàm tìm kiếm với keyword
     * @param keyword
     * @return
     */
    public ArrayList<AutoComplete> getAutoCompletes(String keyword){
        ArrayList<AutoComplete> autoCompletes = new ArrayList<>();
        AutoComplete autoComplete = null;

        String query = "SELECT * FROM autocomplete" +
                "  WHERE MATCH (content_search)" +
                "  AGAINST ( ? IN NATURAL LANGUAGE MODE);";

        logger.info(query);
        System.out.println(con);
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, keyword);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                autoComplete = new AutoComplete();

                autoComplete.setAddressRestaurant(rs.getString("address"));
                autoComplete.setAvatarRestaurant(rs.getString("avatar"));
                autoComplete.setIdAutoComplete(String.valueOf(rs.getInt("id_autocomplete")));
                autoComplete.setIdRestaurant(String.valueOf(rs.getInt("id_restaurant")));
                autoComplete.setNameRestaurant(rs.getString("name"));
                autoCompletes.add(autoComplete);
            }

            return autoCompletes;
        }catch (SQLException e){
            logger.warn("error query");
            e.printStackTrace();
        }
        return null;
    }
}
