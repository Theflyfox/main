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
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 将Excel表中的用户数据导入mysql中<br>
 *
 * @author: XB
 * @date: 2019/11/12 13:16
 */
public class ImportUserData {
    static DecimalFormat decimalFormat=new DecimalFormat("00");

    public static void main(String[] args) {
        Connection ssoCon = null;
        Statement ssoSta = null;
        Connection scientificCon = null;
        Statement scientificSta = null;
        //excel文件路径
        String excelPath = "C:\\Users\\admin\\Documents\\科研项目\\初始化用户清单.xlsx";
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
                int firstIndex = 3;//从第3行开始读
                int lastIndex = 210;//读到211行
                //建立sso和scientific的数据库连接
                ssoCon = SSOUserData.getCon();
                ssoSta = ssoCon.createStatement();
                scientificCon = ScientificUserData.getCon();
                scientificSta = scientificCon.createStatement();
                for(int rIndex = firstIndex; rIndex <= lastIndex; rIndex++) {   //遍历行
                    Row row = sheet.getRow(rIndex);
                    if (row != null) {
                        //用户id
                        int id = rIndex - 2;
                        //用户名
                        Cell cell = row.getCell(0);
                        cell.setCellType(CellType.STRING);
                        String name =  cell.getStringCellValue();
                        name = name.replace(" ", "");
                        String loginName = PinyinUtils.getPingYin(name);
                        loginName = loginName.replace(" ", "");
                        loginName = loginName.replace("u:", "v");
                        String namepy = loginName;
                        ResultSet resultSet = null;
                        for(int i = 1; i<99; i++){
                            //判断用户登录名是否重名，若重名就拼装数字
                            String selectSql = "select id from bd_user_info where login_username = '" + loginName + "' and delete_flag=0";
                            resultSet = ssoSta.executeQuery(selectSql);
                            if(!resultSet.next()) {
                                break;
                            }
                            loginName = namepy + decimalFormat.format(i);
                        }
                        resultSet.close();
                        //工号
                        cell = row.getCell(2);
                        cell.setCellType(CellType.STRING);
                        String gonghao =  cell.getStringCellValue();
                        gonghao = gonghao.replace(" ", "");
                        //科室
                        String keshi = null;
                        cell = row.getCell(3);
                        if(cell != null) {
                            cell.setCellType(CellType.STRING);
                            keshi =  cell.getStringCellValue();
                            keshi = keshi.replace(" ", "");
                        }
                        //职称
                        String zhicheng = null;
                        cell = row.getCell(4);
                        if(cell != null) {
                            cell.setCellType(CellType.STRING);
                            zhicheng =  cell.getStringCellValue();
                            zhicheng = zhicheng.replace(" ", "");
                        }
                        //手机号
                        String shoujihao = null;
                        cell = row.getCell(6);
                        if(cell != null) {
                            cell.setCellType(CellType.STRING);
                            shoujihao =  cell.getStringCellValue();
                            shoujihao = shoujihao.replace(" ", "");
                        }
                        //盐
                        String salt = UUIDUtils.getUUID();
                        //密码
                        MD5 md5 = DigestFactory.getMD5();
                        String password = md5.encode(gonghao + loginName.substring(0,1).toUpperCase()+loginName.substring(1) + salt);
                        //创建时间
                        String date = DateUtils.dateToStr(new Date());
                        //sso插入语句：insert into bd_user_info values (1,'loginUserName','loginPass',2,'salt',
                        // 'userName','email','mobile',1,null,null,'2019-01-01 01:01:01','2019-01-01 01:01:01',0)
                        String ssoSql = "insert into bd_user_info values(" + id + ",'" + loginName
                        + "','" + password + "',2,'" + salt + "','" + name + "','" + loginName + "@renji.com','" + shoujihao
                                + "',1,null,null,'" + date + "','" + date + "',0)" ;
                        //scientificSql插入语句：insert into bd_user_info values (1,1,0,'0001','321282198001162932',
                        // 'loginUserName','password','salt','userName',1,'mobile',null,2,'科研研究','2019-01-01 01:01:01','2019-01-01 01:01:01',0)
                        String scientificSql = "insert into bd_user_info values(" + id + "," + id
                        + ",0,'" + gonghao + "','321282198001162932','" + loginName + "','" + password + "','" + salt
                        + "','" + name + "',1,'" + shoujihao + "',null,2,'科研研究','" + date + "','" + date + "',0)" ;

                        //执行插入操作
                        System.out.println("SSO导入：" + ssoSql);
                        ssoSta.execute(ssoSql);
                        System.out.println("scientific导入：" + scientificSql);
                        scientificSta.execute(scientificSql);
                        //注册仁济门户网站
                        Map<String, Object> json = new HashMap<>();
                        json.put("name", name);
                        json.put("email", loginName + "@renji.com");
                        json.put("password", gonghao + loginName.substring(0,1).toUpperCase()+loginName.substring(1));
                        json.put("jobNumber", gonghao);
                        if(shoujihao != null) {
                            json.put("phone", shoujihao);
                        }
                        json.put("ssoId", id);
                        if(zhicheng != null) {
                            json.put("level", zhicheng);
                        }
                        //根据科室名获取科室id
                        String departmentId = "";
                        ResultSet scRe = scientificSta.executeQuery("select id from bd_department_dic where name = '" + keshi + "'");
                        if(scRe.next()) {
                            departmentId = scRe.getString("id");
                        }
                        json.put("departmentId",departmentId);
                        HttpClientUtils.doPost("http://10.2.100.144:3000/api/auth/import/user", json);
                    }
                }
            } else {
                System.out.println("找不到指定的文件");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(ssoSta != null) {
                    ssoSta.close();
                }
                if(ssoCon != null) {
                    ssoCon.close();
                }
                if(scientificSta != null) {
                    scientificSta.close();
                }
                if(scientificCon != null) {
                    scientificCon.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
