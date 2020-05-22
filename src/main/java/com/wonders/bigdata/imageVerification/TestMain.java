package com.wonders.bigdata.imageVerification;

import java.awt.image.BufferedImage;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/5/11 11:33
 */
public class TestMain {
    public static void main(String[] args) {
        try {
            ImageVerificationCode ivc = new ImageVerificationCode();
            BufferedImage image = ivc.getImage();
            System.out.println(ivc);
            System.out.println(ivc.getText());

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
