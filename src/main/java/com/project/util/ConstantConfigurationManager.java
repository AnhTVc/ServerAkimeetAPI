package com.project.util;

public class ConstantConfigurationManager {
    public static final String URL_SEVER = ConfigurationManager.getInstance().getString("MYSQL_URL_SEVER");
    public static final String USER_SEVER = ConfigurationManager.getInstance().getString("MYSQL_USER_SEVER");
    public static final String PASS_SEVER = ConfigurationManager.getInstance().getString("MYSQL_PASS_SEVER");

    public static final int PORT = ConfigurationManager.getInstance().getInt("PORT");
}
