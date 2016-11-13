package com.project.DAO.sql;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.project.util.ConstantConfigurationManager;


/**
 * Created by knight_cs on 03/08/2016.
 *
 * This Class use for use only read on the system
 */
public class PoolManagerRead {

    private static final Logger logger = LoggerFactory.getLogger(PoolManagerRead.class);
    private static final BasicDataSource poolConnnect = new BasicDataSource();

      static  {
        poolConnnect.setDriverClassName("com.mysql.jdbc.Driver");
        poolConnnect.setUrl(ConstantConfigurationManager.URL_SEVER);
        poolConnnect.setUsername(ConstantConfigurationManager.USER_SEVER);
        poolConnnect.setPassword(ConstantConfigurationManager.PASS_SEVER);
        poolConnnect.setDefaultReadOnly(false); // for methods not interactive to database
        poolConnnect.setMaxWaitMillis(20000); // max time wait query from database
        poolConnnect.setMaxConnLifetimeMillis(25000); //vong doi song cua mot connect
        poolConnnect.setMaxTotal(5);
        poolConnnect.setMaxIdle(2);
    }

public static void getInfo(){
    logger.info("Total : " + poolConnnect.getMaxTotal());
    logger.info("NumIdle : " + poolConnnect.getNumIdle());
    logger.info("Active : " +poolConnnect.getNumActive());
}

    public static Connection getConnection() throws SQLException {
        return poolConnnect.getConnection();
    }

    public static  void closePool(){
        try {
            poolConnnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Can not CLOSE poolRead !");
        }
    }


}
