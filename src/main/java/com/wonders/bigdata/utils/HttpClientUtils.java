package com.wonders.bigdata.utils;

import java.io.*;
import java.util.*;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2019/11/12 16:41
 */
public class HttpClientUtils {

    /**
     * 执行一个带参数的HTTP POST请求，返回请求响应的JSON字符串
     *
     * @param url 请求的URL地址
     * @param map 请求的map参数
     * @return 返回请求响应的JSON字符串
     */
    public static String doPost(String url, Map<String, Object> map) {
        // 构造HttpClient的实例
        /*HttpClient httpClient = new HttpClient();
        // 创建POST方法的实例
        PostMethod method = new PostMethod(url);

        // 这个basicNameValue**放在List中
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        // 创建basicNameValue***对象参数
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                nameValuePairs.add(new NameValuePair(entry.getKey(), entry.getValue().toString()));
            }
        }

        // 填入各个表单域的值
        NameValuePair[] param = nameValuePairs.toArray(new NameValuePair[nameValuePairs.size()]);

        method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // 将表单的值放入postMethod中
        method.addParameters(param);
        try {
            // 执行postMethod
            int statusCode = httpClient.executeMethod(method);
            if (method.getStatusCode() == HttpStatus.SC_OK) {
                System.out.println(method.getName());
            }
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }*/
        return null;
    }

}
