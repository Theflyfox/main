package com.wonders.bigdata.importUser;

import com.wonders.bigdata.utils.DateUtils;
import com.wonders.bigdata.utils.HttpClientUtils;
import com.wonders.bigdata.utils.PinyinUtils;
import com.wonders.bigdata.utils.UUIDUtils;
import com.wondersgroup.bigdata.DigestFactory;
import com.wondersgroup.bigdata.digest.MD5;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/1/2 16:55
 */
public class ImportDataSyncUser {
    public static void main(String[] args) {
        Connection localCon = null;
        Statement localSta = null;
        //excel文件路径
        String excelPath = "C:\\Users\\admin\\Documents\\科研项目\\仁济部署\\前置机\\人员.xlsx";
        String tableName = "bd_dic_user_info";
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
                Sheet sheet = wb.getSheetAt(0);     //读取sheet 0
                int firstIndex = 1;//从第3行开始读
                int lastIndex = 11208;//读到211行
                //建立sso和scientific的数据库连接
                localCon = LocalData.getCon();
                localSta = localCon.createStatement();
                for(int rIndex = firstIndex; rIndex <= lastIndex; rIndex++) {   //遍历行
                    Row row = sheet.getRow(rIndex);
                    if (row != null) {
                        Cell cell = row.getCell(7);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String stuffId =  cell != null? cell.getStringCellValue() : null;

                        cell = row.getCell(8);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String stuffCode = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(9);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String stuffName = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(10);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String stuffAlias = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(11);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String inputPy2 = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(12);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String inputWb2 = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(13);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String stuffAttr = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(14);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String deptId = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(15);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String deptName = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(16);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String gender = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(17);
                        String birth = null;
                        if(cell != null) {
                            birth = "'" + cell.getStringCellValue() + "'";
                        }

                        cell = row.getCell(18);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String jobTitle = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(19);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String duty = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(20);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String contactNumber = cell != null? "'" + cell.getStringCellValue().replace("/", " ") + "'" : null;

                        cell = row.getCell(21);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String email = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(22);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String address = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(23);
                        String tsEffective = null;
                        if(cell != null) {
                            String d = cell.getStringCellValue().replace("/", "-");
                            tsEffective = "'" + d + "'";
                        }

                        cell = row.getCell(24);
                        String tsExpiry = null;
                        if(cell != null ) {
                            String d = cell.getStringCellValue().replace("/", "-");
                            tsExpiry = "'" + d + "'";
                        }

                        cell = row.getCell(25);
                        String tsDisable = null;
                        if(cell != null) {
                            String d = cell.getStringCellValue().replace("/", "-");
                            tsDisable = "'" + d + "'";
                        }

                        cell = row.getCell(26);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String delFlag = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(27);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String idType = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(28);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String idNumber = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(29);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String medinsuranceId = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(30);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String recipesealno = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(31);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String deptCode1 = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(32);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String deptCode2 = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(33);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String deptCode3 = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(34);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String refresherDoc = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(35);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String refresherStartTime = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(36);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String refresherEndTime = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(37);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String qualificationCode = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(38);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String practiceCode = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(38);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String practiceArea = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(40);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String manageDept = cell != null? "'" + cell.getStringCellValue() + "'" : null;

                        //插入科室数据
                        /*String insertSql = "insert into " + tableName + " (dept_id,dept_code,dept_name,dept_nameshort," +
                                "dept_attr,total_bed,open_bed,input_py,input_wb,org_note,map_status,parent_dept_id,parent_org_id," +
                                "l_id,del_flag,app_sys_domain_id,stand_flag,insur_dept_id,insur_dept_name,dept_leve,dept_top," +
                                "dept_top_name) " +
                                "values " +
                                "(" + depId + ",'" + deptCode + "','" + deptName + "','" + deptNameshort + "','" + deptAttr + "'," +
                                totalBed + "," + openBed + ",'" + inputPy + "'," + inputWb + "," + orgNote + ","
                                + mapStatus + ",'" + parentDeptId + "'," + parentOrgId + "," + lId + "," + delFlag + ",'" +
                                appSysDomainId + "'," + standFlag + ",'" + insurDeptId + "','" + insurDeptName + "'," +
                                deptLeve + ",'" + deptTop + "','" + deptTopName + "')";*/


                        String insertSql = "insert into " + tableName + " (stuff_id,stuff_code,stuff_name,stuff_alias,input_py2," +
                                "input_wb2,stuff_attr,dept_id,dept_name,gender,birth,job_title,duty,contact_number,email,address," +
                                "ts_effective,ts_expiry,ts_disable,del_flag,id_type,id_number,medinsurance_id,recipesealno," +
                                "dept_code1,dept_code2,dept_code3,refresher_doc,refresher_start_time,refresher_end_time," +
                                "qualification_code,practice_code,practice_area,manage_dept) " +
                                "values " +
                                "(" + stuffId + "," + stuffCode + "," + stuffName + "," + stuffAlias + "," + inputPy2 + ","
                                + inputWb2 + "," + stuffAttr + "," + deptId + "," + deptName + "," + gender + "," + birth
                                + "," + jobTitle + "," + duty + "," + contactNumber + "," + email + "," + address + ","
                                + tsEffective + "," + tsExpiry + "," + tsDisable + "," + delFlag + "," + idType + ","
                                + idNumber + "," + medinsuranceId + "," + recipesealno + "," + deptCode1 + "," + deptCode2
                                + "," + deptCode3 + "," + refresherDoc + "," + refresherStartTime + "," + refresherEndTime
                                + "," + qualificationCode + "," + practiceCode + "," + practiceArea + "," + manageDept + ")";
                        System.out.println(insertSql);
                        localSta.execute(insertSql);

                    }
                }
            } else {
                System.out.println("找不到指定的文件");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
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
