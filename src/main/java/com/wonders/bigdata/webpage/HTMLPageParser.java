package com.wonders.bigdata.webpage;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/8/31 16:54
 */
public class HTMLPageParser {
    public static void main(String[] args) {
        String strurl="https://www.12zw.com/0/11/12359475.html";
        try {
            File newTxt = new File("C:\\file\\修罗武神.txt");
            if (!newTxt.isFile()) {
                newTxt.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newTxt), "utf-8"));
            URL url=new URL(strurl);
            //通过url建立与网页的连接
            URLConnection conn=url.openConnection();
            //通过链接取得网页返回的数据
            InputStream is=conn.getInputStream();
            //一般按行读取网页数据，并进行内容分析
            //因此用BufferedReader和InputStreamReader把字节流转化为字符流的缓冲流
            //进行转换时，需要处理编码格式问题
            BufferedReader br=new BufferedReader(new InputStreamReader(is, "gbk"));

            //按行读取并打印
            String line=null;
            StringBuffer str = new StringBuffer();
            while((line=br.readLine())!=null){
                //拼接所有字符串
                if (!"".equals(line.trim())) {
                    str.append(line.trim());
                }
            }
            String content = str.toString().split("<div id=\"content\">&nbsp;&nbsp;&nbsp;&nbsp;")[1];
            content = content.split("@B</div>")[0];
            content = content.replace("&nbsp;&nbsp;&nbsp;&nbsp;", "");
            content = content.replace("<br /><br />", "\r\n");
            System.out.println(content);
            //写入文件
            /*bufferedWriter.write("第1471章 来自殷妆红的威胁" + "\r\n");
            bufferedWriter.write(content + "\r\n");*/
            br.close();
            bufferedWriter.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
