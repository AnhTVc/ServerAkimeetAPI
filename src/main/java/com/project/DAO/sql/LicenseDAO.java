package com.project.DAO.sql;

import com.google.gson.Gson;
import com.project.POJO.result.DeviceInfo;
import com.project.POJO.result.Licence;
import com.project.POJO.result.Licences;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by VietAnh on 11/1/2016.
 */
public class LicenseDAO {

    public static final Logger logger = Logger.getLogger(LicenseDAO.class);
    public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Connection con = null;

    public LicenseDAO() {
        try {
            con = PoolManagerRead.getConnection();
            PoolManagerRead.getInfo();
        } catch (SQLException e) {
            logger.error("can not CONNECT PoolRead !");
            e.printStackTrace();
        }
    }

    /**
     * Get license
     * @param projectName
     * @return
     */
    public Licences getLicences(String projectName){
        String query = "SELECT * FROM license where project = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, projectName);

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Licence> arrayList = new ArrayList<>();
            Licence licence;
            while (resultSet.next()){
                licence = new Licence();
                licence.setEmail(resultSet.getString("email"));
                licence.setId(resultSet.getInt("id"));
                licence.setInstall(resultSet.getInt("install"));
                licence.setLog(resultSet.getString("log"));
                licence.setSerial(resultSet.getString("serial"));

                arrayList.add(licence);
            }

            Licences licences = new Licences();
            licences.setLicences(arrayList);
            return licences;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeBD() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param projectName
     * @param email
     * @return
     */
    public boolean registerLicences(String projectName, String email, DeviceInfo deviceInfo){
        /*
        Check nếu license đã được cài đặt thì không cài nữa
         */
        int install = 0;
        String log = null;
        Gson gson = new Gson();
        String queryCheck = "SELECT maxinstall, install, log, serial FROM license where email = ? and project = ?;";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(queryCheck);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, projectName);
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean check = true; //Mặc định là chưa có

            if (resultSet.next()){

                install = resultSet.getInt("install");
                log = resultSet.getString("log");
                String se = resultSet.getString("serial");
                if(deviceInfo.getSerial().equals(se))
                    return true;
                else{
                    //cai moi hoac tiep tuc cai tren may khac
                    if(resultSet.getInt("maxinstall") <= resultSet.getInt("install")){
                        //Da dc cài đặt
                        check = false;
                    }
                }
            }else{
                check =  false;
            }

            if(check){
                //Chua dc cai dat\
                String query = "UPDATE license SET serial = ?, install = ?, log = ? WHERE email = ? and project = ?";

                PreparedStatement preparedStatement1 = con.prepareStatement(query, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                preparedStatement1.setString(1, deviceInfo.getSerial());
                preparedStatement1.setInt(2, install + 1);
                preparedStatement1.setString(3, gson.toJson(deviceInfo));

                preparedStatement1.setString(4, email);
                preparedStatement1.setString(5, projectName);

                preparedStatement1.executeUpdate();

                return true;
            }else{
                //da dc cai dat ma van muon cai them
                String query = "UPDATE license SET log = ? WHERE email = ? and project = ?";
                PreparedStatement preparedStatement1 = con.prepareStatement(query);
                preparedStatement1.setString(1, log + gson.toJson(deviceInfo));
                preparedStatement1.setString(2, email);
                preparedStatement1.setString(3, projectName);

                preparedStatement1.executeUpdate();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
