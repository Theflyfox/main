package com.wonders.bigdata.importUser;

import com.wonders.bigdata.utils.DateUtils;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * Description: 导入模板数据<br>
 *
 * @author: XB
 * @date: 2019/11/13 14:44
 */
public class ImportModeFile {
    public static void main(String[] args) {
        Connection con = null;
        Statement sta = null;
        ResultSet resultSet = null;
                //excel文件路径
        String excelPath = "C:\\Users\\admin\\Documents\\科研项目\\科研模板\\模板材料-XB.xlsx";
        //组装内容为：研究类型-sheet-行数
        String[] researchTypes = {"细胞治疗-0-30","药物研究-1-36","器械研究（含体外诊断试剂）-2-36","其他研究-3-33"};
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
                //文件id
                int id = 0;
                for (String str : researchTypes) {
                    String[] values = str.split("-");
                    //开始解析
                    Sheet sheet = wb.getSheetAt(Integer.parseInt(values[1]));     //读取sheet 0
                    int firstIndex = 1;//从第3行开始读
                    int lastIndex = Integer.parseInt(values[2]);//读到211行
                    //建立sso和scientific的数据库连接
                    con = LocalData.getCon();
                    sta = con.createStatement();
                    for(int rIndex = firstIndex; rIndex < lastIndex; rIndex++) {   //遍历行
                        id++;
                        Row row = sheet.getRow(rIndex);
                        if (row != null) {
                            //文件编号
                            String fileNumber = null;
                            Cell cell = row.getCell(0);
                            cell.setCellType(CellType.STRING);
                            fileNumber = cell.getStringCellValue().replace(" ","");

                            //研究类型
                            String researchType = values[0];
                            //根据研究类型名称获取研究类型id
                            Long researchTypeId = null;
                            String selectSql = "select id from bd_dic_research_type where name = '" + researchType + "' and delete_flag=0";
                            resultSet = sta.executeQuery(selectSql);
                            if(resultSet.next()) {
                                researchTypeId = resultSet.getLong("id");
                            }

                            //材料提供方：默认为赞助方提供
                            int materialProviderType = 0;
                            cell = row.getCell(2);
                            cell.setCellType(CellType.STRING);
                            if(!"研究者自填".equals(cell.getStringCellValue())) {
                                materialProviderType = 1;
                            }

                            //是否必填
                            int isNeed = 0;//非必填
                            cell = row.getCell(3);
                            if(cell != null) {
                                cell.setCellType(CellType.STRING);
                                if("是".equals(cell.getStringCellValue())) {
                                    isNeed = 1;
                                }
                            }

                            //大步骤id
                            int stepId = 1;
                            cell = row.getCell(4);
                            if(cell != null) {
                                cell.setCellType(CellType.STRING);
                                selectSql = "select step_id from bd_dic_process_step where description = '"
                                        + cell.getStringCellValue().replace(" ", "") + "' and delete_flag=0";
                                resultSet = sta.executeQuery(selectSql);
                                if(resultSet.next()) {
                                    stepId = resultSet.getInt("step_id");
                                }
                            }

                            //材料名称
                            String name = null;
                            cell = row.getCell(5);
                            if(cell != null) {
                                cell.setCellType(CellType.STRING);
                                name = cell.getStringCellValue().replace(" ", "");
                            }

                            Integer weight = null;
                            cell = row.getCell(6);
                            if(cell != null) {
                                cell.setCellType(CellType.STRING);
                                weight = Integer.parseInt(cell.getStringCellValue());
                            }

                            //是否有多份
                            int fileNumType = 1;
                            cell = row.getCell(9);
                            if(cell != null) {
                                cell.setCellType(CellType.STRING);
                                if(cell.getStringCellValue().replace(" ", "").contains("多份")) {
                                    fileNumType = 0;
                                }
                            }
                            //如果文件名包含“其他”字符串说明是多份文件
                            if(name.contains("其他")) {
                                fileNumType = 0;
                            }

                            //文件url
                            String url = null;
                            Long generalFileId = null;
                            selectSql = "select file_id,address from bd_general_file where name = '" + name + "' and delete_flag=0";
                            resultSet = sta.executeQuery(selectSql);
                            if(resultSet.next()) {
                                url = "'" + resultSet.getString("address") + "'";
                                generalFileId = resultSet.getLong("file_id");
                            }
                            //模板文件类型：上传、自动生成文件
                            int type = 0;//用户上传
                            if (name.equals("项目学术审查表")) {
                                type = 1;
                            }

                            String date = DateUtils.dateToStr(new Date());

                            //组装插入项目模板文件表sql
                            String modelFileSql = "insert into bd_dic_project_model_file (id,parent_id,general_file_id,name,url," +
                                    "material_provider_type,is_need_type,file_num_type, weight,file_number,type," +
                                    "update_date,create_date,delete_flag) values " +
                                    "(" + id + ",0," + generalFileId + ",'" + name + "'," + url + ","+ materialProviderType +","+
                                    isNeed +","+ fileNumType +","+ weight +","+ fileNumber +"," + type + ",'" + date + "','" + date + "',0)";
                            System.out.println("1：" + modelFileSql);
                            sta.execute(modelFileSql);

                            //组装研究类型根一级规则
                            String modelRuleSql = "insert into bd_dic_project_model_file_rule (parent_id, project_model_file_id,rule," +
                                    "rule_key,rule_value,update_date,create_date,delete_flag) values " +
                                    "(0," + id + ",'eq','dic_research_type_id'," + researchTypeId + ",'" + date + "','" + date + "',0)";
                            System.out.println("2：" + modelRuleSql);
                            sta.execute(modelRuleSql);

                            //根据模板规则id和rule_key查询记录
                            int parentId = 0;
                            selectSql = "select id from bd_dic_project_model_file_rule where project_model_file_id = " + id
                                    + " and rule_key='dic_research_type_id' and delete_flag=0";
                            resultSet = sta.executeQuery(selectSql);
                            if(resultSet.next()) {
                                parentId = resultSet.getInt("id");
                            }
                            //组装研究类型大步骤级别规则
                            modelRuleSql = "insert into bd_dic_project_model_file_rule (parent_id, project_model_file_id,rule," +
                                    "rule_key,rule_value,update_date,create_date,delete_flag) values " +
                                    "(" + parentId + "," + id + ",'eq','step_id'," + stepId + ",'" + date + "','" + date + "',0)";
                            System.out.println("3：" + modelRuleSql);
                            sta.execute(modelRuleSql);

                            //根据模板规则id和rule_key查询记录
                            selectSql = "select id from bd_dic_project_model_file_rule where project_model_file_id = " + id
                                    + " and rule_key='step_id' and delete_flag=0";
                            resultSet = sta.executeQuery(selectSql);
                            if(resultSet.next()) {
                                parentId = resultSet.getInt("id");
                            }
                            //组装任务类型级别规则
                            modelRuleSql = "insert into bd_dic_project_model_file_rule (parent_id, project_model_file_id,rule," +
                                    "rule_key,rule_value,update_date,create_date,delete_flag) values " +
                                    "(" + parentId + "," + id + ",'eq','task_type',null,'" + date + "','" + date + "',0)";
                            System.out.println("4：" + modelRuleSql);
                            sta.execute(modelRuleSql);
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
                if(sta != null) {
                    sta.close();
                }
                if(con != null) {
                    con.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
