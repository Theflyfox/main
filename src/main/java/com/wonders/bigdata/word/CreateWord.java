package com.wonders.bigdata.word;


import freemarker.template.Configuration;
import freemarker.template.Template;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/4/28 11:22
 */
public class CreateWord {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("name", "张三");
            map.put("age", "28");
            map.put("phone", "13813426573");
            map.put("imageStr", getImageStr("C:\\file\\timg (1).jpg"));
            //configuration用于读取ftl文件
            Configuration configuration = new Configuration();
            configuration.setDefaultEncoding("utf-8");
            configuration.setDirectoryForTemplateLoading(new File("c:/file/"));
            //输出文档路径及名称
            File outFile = new File("c:/file/测试文档导出.doc");
            //以utf-8的编码读取ftl文件
            Template template = configuration.getTemplate("测试word.ftl", "utf-8");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"), 10240);
            template.process(map, out);
            out.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getImageStr(String imgFile) {
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
}
