package com.wonders.bigdata.upload;


import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Description: 上传文件到文件服务器<br>
 *
 * @author: XB
 * @date: 2019/11/21 9:16
 */
public class UploadFile {
    private static final String URL_STR = "http://**.123:9000/filemanager";
    private static final String localFile = "C:\\ssoinsert.sql";

    public static void main(String[] args) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
          httpClient = HttpClients.createDefault();

          // 把一个普通参数和文件上传给下面这个地址 是一个servlet
          HttpPost httpPost = new HttpPost(URL_STR);

           // 把文件转换成流对象FileBody
           FileBody bin = new FileBody(new File(localFile));

           StringBody mode = new StringBody("upload", ContentType.create(
                           "text/plain", Consts.UTF_8));
           StringBody path = new StringBody("/research-platform/", ContentType.create(
                           "text/plain", Consts.UTF_8));

           HttpEntity reqEntity = MultipartEntityBuilder.create()
                   // 相当于<input type="file" name="file"/>
                   .addPart("file", bin)

                   // 相当于<input type="text" name="userName" value=userName>
                   .addPart("mode", mode)
                   .addPart("path", path)
                   .build();

           httpPost.setEntity(reqEntity);

           // 发起请求 并返回请求的响应
           response = httpClient.execute(httpPost);

           System.out.println("The response value of token:" + response.getFirstHeader("token"));

           // 获取响应对象
           HttpEntity resEntity = response.getEntity();
           if (resEntity != null) {
                   // 打印响应长度
                   System.out.println("Response content length: " + resEntity.getContentLength());
                   // 打印响应内容
                   System.out.println(EntityUtils.toString(resEntity, Charset.forName("UTF-8")));
               }

           // 销毁
           EntityUtils.consume(resEntity);
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           try {
                   if(response != null){
                           response.close();
                       }
               } catch (IOException e) {
                   e.printStackTrace();
               }

           try {
                   if(httpClient != null){
                           httpClient.close();
                       }
               } catch (IOException e) {
                   e.printStackTrace();
               }
       }
    }
}
