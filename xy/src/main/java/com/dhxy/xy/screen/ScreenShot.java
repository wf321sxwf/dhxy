package com.dhxy.xy.screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {


    /**
     * 截图
     *
     *
     *            截图保存文件夹路径
     *
     *            截图文件名称
     * @throws Exception
     */
    public static String captureScreen(String filePath, ScreenWindow window) throws Exception {

        SimpleDateFormat sdfName = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = sdfName.format(new Date()) + ".png";

        Robot robot = new Robot();
        Rectangle screenRectangle = new Rectangle();

        screenRectangle.setBounds(window.getX(),window.getY(),window.getWidth(),window.getHeight());
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        // 截图保存的路径
        File screenFile = new File(filePath + File.separator+ fileName);
        // 如果文件夹路径不存在，则创建
        if (!screenFile.getParentFile().exists()) {
            screenFile.getParentFile().mkdirs();
        }

        ImageIO.write(image, "png", screenFile);

        return filePath + File.separator+ fileName;

    }




    public static void main(String[] args) throws Exception {
        Date now = new Date();
        SimpleDateFormat sdfPath = new SimpleDateFormat("yyyyMMdd");

//        String path = captureScreen("/Users/jiyanlong/app/dhxy/screen", 0, 0, 100, 200);
//        System.out.println(path);
    }

}
