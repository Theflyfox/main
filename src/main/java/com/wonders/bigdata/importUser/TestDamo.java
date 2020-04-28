package com.wonders.bigdata.importUser;

import com.wonders.bigdata.utils.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/1/8 9:32
 */
public class TestDamo {
    public static void main(String[] args) {
        Connection localCon = null;
        Statement localSta = null;
        ResultSet resultSet = null;
                //excel文件路径
        String excelPath = "C:\\Users\\admin\\Documents\\科研项目\\仁济部署\\研究者姓名--去重.xlsx";
        String tableName = "bd_demo";
        Date startDate = new Date();
        try {
            File excel = new File(excelPath);
            if (excel.isFile() && excel.exists()) {   //判断文件是否存在

                String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
                Workbook wb;
                //根据文件后缀（xls/xlsx）进行判断
                if ("xls".equals(split[1])) {
                    FileInputStream fis = new FileInputStream(excel);   //文件流对象
                    wb = new HSSFWorkbook(fis);
                } else if ("xlsx".equals(split[1])) {
                    wb = new XSSFWorkbook(excel);
                } else {
                    System.out.println("文件类型错误!");
                    return;
                }
                //开始解析
                Sheet sheet = wb.getSheetAt(3);     //读取sheet 0
                int firstIndex = 1;//从第3行开始读
                int lastIndex = 400;//读到211行
                //建立sso和scientific的数据库连接
                localCon = LocalData.getCon();
                localSta = localCon.createStatement();
                for(int rIndex = firstIndex; rIndex <= lastIndex; rIndex++) {   //遍历行
                    Row row = sheet.getRow(rIndex);
                    if (row != null) {
                        Cell cell = row.getCell(0);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String stuffName = cell != null? "'" + cell.getStringCellValue() + "'" : null;


                        String selectSql = "select stuff_code from bd_dic_user_info where stuff_name=" + stuffName + "";
                        //System.out.println(selectSql);
                        resultSet = localSta.executeQuery(selectSql);
                        if (resultSet.next()) {
                            String insertSql = "insert into " + tableName + " (name,number) " +
                                    "values " +
                                    "(" + stuffName + ",'" + resultSet.getString("stuff_code") + "');";
                            System.out.println(insertSql);
                            //localSta.execute(insertSql);
                            while (resultSet.next()) {
                                insertSql = "insert into " + tableName + " (name,number) " +
                                        "values " +
                                        "(" + stuffName + ",'" + resultSet.getString("stuff_code") + "');";
                                System.out.println(insertSql);
                                //localSta.execute(insertSql);
                            }
                        }else {
                            String insertSql = "insert into " + tableName + " (name) " +
                                    "values " +
                                    "(" + stuffName + ");";
                            System.out.println(insertSql);
                            //localSta.execute(insertSql);
                        }
                    }
                }
            } else {
                System.out.println("找不到指定的文件");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if(localSta != null) {
                    localSta.close();
                }
                if(localCon != null) {
                    localCon.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("导入数据结束：" + DateUtils.dateToStr(startDate) + " - " +  DateUtils.dateToStr(new Date()));
    }
}
