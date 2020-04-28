package com.wonders.bigdata.importUser;

import com.wonders.bigdata.utils.UUIDUtils;
import com.wondersgroup.bigdata.DigestFactory;
import com.wondersgroup.bigdata.digest.MD5;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/1/10 15:53
 */
public class CreatePsw {
    public static void main(String[] args) {
        String psw = "0694Tengjiamei";
        //盐
        String salt = "353ff84b8829479e9b75d261d93a6223";
        //密码
        MD5 md5 = DigestFactory.getMD5();
        String password = md5.encode(psw + salt);
        System.out.println("salt:" + salt);
        System.out.println("psw:" + password);
    }
}
