package com.wonders.bigdata.cdh;

import com.wonders.bigdata.utils.DateUtils;
import org.apache.commons.lang.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2019/9/6 14:05
 */
public class TestCDHJdbc {
    private static String url = "jdbc:hive2://**.*.**.95:10000";
    private static String userName = "hive";
    private static String psw = "****";

    public static void main(String[] args) {
        ArrayList<String[]> datas = new ArrayList();
        Connection con = null;
        Statement sta = null;
        ResultSet res = null;
        String sql = "select id from s8_bd_authority  limit 10";
        try {
            //建立连接
            try {
                Class.forName("org.apache.hive.jdbc.HiveDriver");
            } catch (ClassNotFoundException var6) {
                var6.printStackTrace();
            }
            con = DriverManager.getConnection(url, userName, psw);
            sta = con.createStatement();
            System.out.println("开始执行: " + DateUtils.dateToStr(new Date()));
            System.out.println("SQL: " + sql);
            res = sta.executeQuery(sql);
            ResultSetMetaData col = res.getMetaData();
            int count = col.getColumnCount();
            String[] cols = new String[count];

            for(int i = 1; i <= count; ++i) {
                String cloName = col.getColumnName(i);
                cols[i - 1] = cloName;
            }
            datas.add(cols);
            while(res.next()) {
                String[] colDatas = new String[count];
                for(int j = 1; j <= count; ++j) {
                    colDatas[j - 1] = res.getString(j);
                }
                datas.add(colDatas);
            }
            //打印结果
            for (String[] str : datas) {
                System.out.println(StringUtils.join(str, ","));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(res != null) res.close();
                if(sta != null) sta.close();
                if(con != null) con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        System.out.println("执行结束: " + DateUtils.dateToStr(new Date()));
    }



}
