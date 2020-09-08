package com.wonders.bigdata.word;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.multiset.HashMultiSet;

import java.io.*;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/8/4 13:41
 */
public class FileOperate {

    public static void main(String[] args) {
        try {
            String oldFile = "C:\\Users\\admin\\Downloads\\测试 - 副本.docx";
            String newFile = "C:\\Users\\admin\\Downloads\\测试.docx";

            FileInputStream fileInputStream = new FileInputStream(oldFile);
            byte[] data1 = readInputStream(fileInputStream);
            String md51 = DigestUtils.md5Hex(data1);

            FileInputStream fileInputStream2 = new FileInputStream(newFile);
            byte[] data2 = readInputStream(fileInputStream2);
            String md52 = DigestUtils.md5Hex(data2);

            if (data1.length < data2.length) {
                byte[] data3 = null;
                data3 = data1;
                data1 = data2;
                data2 = data3;
            }

            MultiSet<Byte> set1 = new HashMultiSet<>();
            for (byte d : data1) {
                set1.add(d);
            }

//            List<Integer> diffLocation = new ArrayList<>();
            int allDiff = 0;
            for (byte d : data2) {
                int remove = set1.remove(d, 1);
                if (remove == 0) {
                    ++allDiff;
                }
            }
            allDiff += set1.size();
//            byte[] view = new byte[200];
//            int j = 0;
//            for (int i = 0; i < data1.length; i++) {
//                if (data1[i] != data2[i]) {
//                    view[j++] = data1[i];
//                    System.out.println(i);
//                }
//            }

            String string = inputStreamString(new FileInputStream(oldFile));
//                    new String(view);
            System.out.println(string);


            // 允许万分之一的误差
            System.out.println("误差值：" + allDiff + "\t误差比例 :" + (allDiff / (double) data1.length) * 10000 + "\t" + data1.length + "/" + data2.length);

            System.out.println(md51.equals(md52));

            System.out.println(chechFile(oldFile, newFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

    public static String inputStreamString (InputStream in) throws IOException {
        String tempLine="";
        StringBuffer resultBuffer = new StringBuffer();
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        while ((tempLine = reader.readLine()) != null) {
            resultBuffer.append(tempLine);
        }
        return  resultBuffer.toString();
    }

    /**
     * 验证两个文件字节流是否相等
     *
     * @return boolean true 相等
     * @throws IOException
     */
    private static boolean isSameFiles(byte[] fileByte1, byte[] fileByte2) {
        String firstFileMd5 = DigestUtils.md5Hex(fileByte1);
        String secondFileMd5 = DigestUtils.md5Hex(fileByte2);
        if (firstFileMd5.equals(secondFileMd5)) {
            System.out.println("---- equals ------ md5 " + firstFileMd5);
            return true;
        } else {
            System.out.println(firstFileMd5 + " is firstFileMd5 ++ unequal ++ secondFileMd5 = " + secondFileMd5);
            return false;
        }
    }

    /**
     * 检查两个文件是否相等，假设 C:\Users\Pictures目录下有两个图片文件
     *
     * @return boolean true 相等
     * @throws IOException
     */
    private static boolean chechFile(String oldFile, String newFIle) throws IOException {
        File file1 = new File(oldFile);
        File file2 = new File(newFIle);
        if (file1.length() != file2.length()) {
            System.out.println("+++++++++ unequal +++++++++++++");
            return false;
        }
        InputStream fileStream1 = new FileInputStream(file1);
        InputStream fileStream2 = new FileInputStream(file2);
//        InputStream 转 byte[]
        byte[] imageByteArray = new byte[fileStream1.available()];
        System.out.println(isSameFiles(imageByteArray, new byte[fileStream2.available()]));
        return true;
    }
}
