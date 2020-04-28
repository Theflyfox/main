package com.wonders.bigdata.importUser;

import com.wonders.bigdata.utils.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

/**
 * Description: 导入科室数据<br>
 *
 * @author: XB
 * @date: 2020/3/25 10:23
 */
public class ImportDataSyncDept {
    public static void main(String[] args) {
        //excel文件路径
        String excelPath = "C:\\Users\\admin\\Documents\\科研项目\\科室.xlsx";
        String tableName = "bd_dic_department_copy1";
        Date startDate = new Date();
        try {
            System.out.println("开始执行：");
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
                int firstIndex = 2;//从第3行开始读
                int lastIndex = 1075;//读到211行
                for(int rIndex = firstIndex; rIndex <= lastIndex; rIndex++) {   //遍历行
                    Row row = sheet.getRow(rIndex);
                    if (row != null) {
                        Cell cell = row.getCell(0);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        Integer depId =  cell != null && StringUtils.isNotEmpty(cell.getStringCellValue())? Integer.parseInt(cell.getStringCellValue()) : null;

                        cell = row.getCell(1);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String deptCode = cell != null && StringUtils.isNotEmpty(cell.getStringCellValue())? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(11);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String parentDeptId = cell != null && StringUtils.isNotEmpty(cell.getStringCellValue())? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(18);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        Integer deptLeve = cell != null && StringUtils.isNotEmpty(cell.getStringCellValue())?  Integer.parseInt(cell.getStringCellValue()): null;

                        cell = row.getCell(2);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String deptName = cell != null && StringUtils.isNotEmpty(cell.getStringCellValue())? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(3);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String deptNameshort = cell != null && StringUtils.isNotEmpty(cell.getStringCellValue())? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(4);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String deptAttr = cell != null && StringUtils.isNotEmpty(cell.getStringCellValue())? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(5);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        Integer totalBed = cell != null && StringUtils.isNotEmpty(cell.getStringCellValue())? Integer.parseInt(cell.getStringCellValue()) : null;

                        cell = row.getCell(6);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        Integer openBed = cell != null && StringUtils.isNotEmpty(cell.getStringCellValue())? Integer.parseInt(cell.getStringCellValue()) : null;

                        cell = row.getCell(7);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String inputPy = cell != null && StringUtils.isNotEmpty(cell.getStringCellValue())? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(8);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String inputWb = cell != null && StringUtils.isNotEmpty(cell.getStringCellValue())? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(9);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String orgNote = cell != null && StringUtils.isNotEmpty(cell.getStringCellValue())? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(10);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String mapStatus = cell != null && StringUtils.isNotEmpty(cell.getStringCellValue())? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(12);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String parentOrgId = cell != null && StringUtils.isNotEmpty(cell.getStringCellValue())? "'" + cell.getStringCellValue() + "'" : null;

                        Integer lId = null;

                        cell = row.getCell(14);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        Integer delFlag = cell != null && StringUtils.isNotEmpty(cell.getStringCellValue())? Integer.parseInt(cell.getStringCellValue()) : null;

                        cell = row.getCell(15);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String insurDeptId = cell != null && StringUtils.isNotEmpty(cell.getStringCellValue())? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(16);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String insurDeptName = cell != null && StringUtils.isNotEmpty(cell.getStringCellValue())? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(17);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String appSysDomainId = cell != null && StringUtils.isNotEmpty(cell.getStringCellValue())? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(19);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String deptTop = cell != null && StringUtils.isNotEmpty(cell.getStringCellValue())? "'" + cell.getStringCellValue() + "'" : null;

                        cell = row.getCell(20);
                        if (cell != null) cell.setCellType(CellType.STRING);
                        String deptTopName = cell != null && StringUtils.isNotEmpty(cell.getStringCellValue())? "'" + cell.getStringCellValue() + "'" : null;

                        String standFlag = null;
                        String date = "'" + DateUtils.dateToStr(new Date()) + "'";

                        //插入科室数据
                        String insertSql = "insert into " + tableName + " (dept_id,dept_code,dept_name,dept_nameshort," +
                                "dept_attr,total_bed,open_bed,input_py,input_wb,org_note,map_status,parent_dept_id,parent_org_id," +
                                "l_id,del_flag,app_sys_domain_id,stand_flag,insur_dept_id,insur_dept_name,dept_leve,dept_top," +
                                "dept_top_name,create_date,update_date) " +
                                "values " +
                                "(" + depId + "," + deptCode + "," + deptName + "," + deptNameshort + "," + deptAttr + "," +
                                totalBed + "," + openBed + "," + inputPy + "," + inputWb + "," + orgNote + ","
                                + mapStatus + "," + parentDeptId + "," + parentOrgId + "," + lId + "," + delFlag + "," +
                                appSysDomainId + "," + standFlag + "," + insurDeptId + "," + insurDeptName + "," +
                                deptLeve + "," + deptTop + "," + deptTopName + "," + date + "," + date + ");";

                        System.out.println(insertSql);

                    }
                }
            } else {
                System.out.println("找不到指定的文件");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("导入数据结束：" + DateUtils.dateToStr(startDate) + " - " +  DateUtils.dateToStr(new Date()));
    }
}
