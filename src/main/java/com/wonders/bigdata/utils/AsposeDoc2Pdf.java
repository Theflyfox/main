package com.wonders.bigdata.utils;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class AsposeDoc2Pdf {


    public static void main(String[] args) throws Exception {
        doc2pdf("/file/伦理审查申请及受理表.doc", "/file/伦理审查申请及受理表.pdf");
    }

    public static boolean getLicense() throws Exception {
        boolean result = false;
        try {

            InputStream is = com.aspose.words.Document.class
                    .getResourceAsStream("/com.aspose.words.lic_2999.xml");
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    public static void doc2pdf(String inPath, String outPath) throws Exception {
        if (!getLicense()) { // 验证License 若不验证则转化出的pdf文档有水印
            throw new Exception("com.aspose.words lic ERROR!");
        }

        System.out.println("aspose开始转化 -> " + inPath + " -> " + outPath);

        try {
            long old = System.currentTimeMillis();
            File file = new File(outPath);
            FileOutputStream os = new FileOutputStream(file);
            Document doc = new Document(inPath); // word文档
            // 支持RTF HTML,OpenDocument, PDF,EPUB, XPS转换
            doc.save(os, SaveFormat.PDF);
            long now = System.currentTimeMillis();
            System.out.println("convert OK! " + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}