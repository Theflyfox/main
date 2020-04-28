package com.wonders.bigdata.importUser;

import java.sql.*;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2019/11/12 14:24
 */
public class SSOUserData {
    private static String url = "jdbc:mysql://10.1.65.12:3306/clean_sso?useUnicode=true&characterEncoding=UTF-8";
    private static String userName = "root";
    private static String psw = "root";
    private static Connection con = null;
    private static Statement sta = null;
    private static ResultSet res = null;

    public static Connection getCon() throws SQLException {
        //建立连接
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
        } catch (ClassNotFoundException var6) {
            var6.printStackTrace();
        }
        con = DriverManager.getConnection(url, userName, psw);
        return con;
    }

    public static void close() throws SQLException {
        if(res != null) {
            res.close();
        }
        if(sta != null) {
            sta.close();
        }
        if(con != null) {
            con.close();
        }
    }
}
