package com.wonders.bigdata.webpage;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/9/1 9:33
 */
public class TextParser {
    public static void main(String[] args) {
        String path = "C:\\file\\测试.txt";
        String writeFile = "C:\\file\\修羅武神.txt";
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writeFile, true), "utf-8"));
            List<Map<String, Object>> list = getContent(path);
            for (Map<String, Object> map : list) {
                System.out.println(map.get("name") + "：" + map.get("href"));
                URL url=new URL(map.get("href").toString());
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
                content = content.replace("&nbsp&nbsp&nbsp&nbsp", "");
                System.out.println(content);
                //写入文件
                bufferedWriter.write(map.get("name") + "\r\n");
                bufferedWriter.write(content + "\r\n");
                br.close();
            }
            bufferedWriter.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析文件内容获取关键信息
     * @param path
     * @return
     * @throws Exception
     */
    public static List<Map<String, Object>> getContent(String path) throws Exception {
        List<Map<String, Object>> list = new ArrayList<>();
        BufferedReader reader = null;
        try {
            File file = new File(path);
            reader = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = reader.readLine()) != null) {
                if (!"".equals(s.trim()) && s.contains("\"")) {
                    Map<String, Object> map = new HashMap<>();
                    String[] array = s.split("\"");
                    //取出href
                    String href = array[1];
                    //取出名称
                    String name = array[2].replace("</a></dd>", "")
                            .replace(">", "");
                    map.put("name", name);
                    map.put("href", "https://www.12zw.com/0/11/" + href);
                    list.add(map);
                }
            }
        }catch (Exception e) {
            throw e;
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
