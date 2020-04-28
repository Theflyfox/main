package com.wonders.bigdata.importUser;

import com.wonders.bigdata.utils.DateUtils;
import com.wonders.bigdata.utils.PinyinUtils;
import com.wonders.bigdata.utils.UUIDUtils;
import com.wondersgroup.bigdata.DigestFactory;
import com.wondersgroup.bigdata.digest.MD5;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * Description: 导入专家数据<br>
 *
 * @author: XB
 * @date: 2019/11/13 13:38
 */
public class ImportExpertUserData {
    static DecimalFormat decimalFormat=new DecimalFormat("00");
    public static void main(String[] args) {
        Connection ssoCon = null;
        Statement ssoSta = null;
        Connection scientificCon = null;
        Statement scientificSta = null;
        //excel文件路径：1-医生，4-cru，32-专家
        String[] expertArr = {"18916-王理伟", "8847-吕良敬","16217-朱鹤","W0050-李红","W0064-张薇","17115-林厚文",
                "19439-侯健","16344-徐辉明","8612-黄晓钟","8607-曹晖","19860-鄢和新"};
        String[] doctorArr = {"011233-钟璐","011508-韩晓凤","012854-鄢和新","011851-夏强"};
        String[] cruArr = {"010235-黄雪萍","010696-陈绿雨","010694-郭韵悦","017404-滕佳美"};
        try {
            //建立sso和scientific的数据库连接
            ssoCon = SSOUserData.getCon();
            ssoSta = ssoCon.createStatement();
            scientificCon = ScientificUserData.getCon();
            scientificSta = scientificCon.createStatement();
            //用户id
            int id = 227;
            for(int rIndex = 0; rIndex < cruArr.length; rIndex++) {   //遍历行
                id++;
               //用户名
                String name =  cruArr[rIndex].split("-")[1];
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
                String gonghao =  cruArr[rIndex].split("-")[0];
                gonghao = gonghao.replace(" ", "");
                //科室
                String keshi = null;

                //职称
                String zhicheng = null;

                //手机号
                String shoujihao = null;

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
                        + "',1,null,null,'" + date + "','" + date + "',0);" ;
                //scientificSql插入语句：insert into bd_user_info values (1,1,0,'0001','321282198001162932',
                // 'loginUserName','password','salt','userName',1,'mobile',null,2,'科研研究','2019-01-01 01:01:01','2019-01-01 01:01:01',0)
                String scientificSql = "insert into bd_user_info values(" + id + "," + id
                        + ",0,'" + gonghao + "','321282198001162932','" + loginName + "','" + password + "','" + salt
                        + "','" + name + "',4,'" + shoujihao + "',null,2,'科研研究','" + date + "','" + date + "',0);" ;
                //平台权限sql
                String userAuthSql = "insert into bd_user_authority (sso_id,subproject_user_info_id,status,update_date,create_date,delete_flag)" +
                        " values (" + id + ",1,1,'" + date + "','" + date + "',0);";
                //执行插入操作
                System.out.println(ssoSql);
                System.out.println(userAuthSql);
                //ssoSta.execute(ssoSql);
                //ssoSta.execute(userAuthSql);
                System.out.println(scientificSql);
                //scientificSta.execute(scientificSql);
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
