package com.wonders.bigdata.utils;


import org.apache.commons.lang.math.RandomUtils;

public class RandomUtil {
    private static final String KEYS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String NUMS = "0123456789";

    public static String getStringToLength(Integer length){
        StringBuffer stringBuffer = new StringBuffer();

        for(int i = 0; i<length; i++){
            int j= RandomUtils.nextInt(KEYS.length()-1);
            stringBuffer.append(KEYS.charAt(j));
        }
        return stringBuffer.toString();
    }

    public static String getNumsToLength(Integer length){
        StringBuffer stringBuffer = new StringBuffer();

        for(int i = 0; i<length; i++){
            int j= RandomUtils.nextInt(NUMS.length()-1);
            stringBuffer.append(NUMS.charAt(j));
        }
        return stringBuffer.toString();
    }
}
