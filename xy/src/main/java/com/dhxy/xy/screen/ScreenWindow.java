package com.dhxy.xy.screen;

import com.dhxy.xy.screen.event.ReSizeEvent;
import com.sun.awt.AWTUtilities;

import javax.swing.*;
import java.awt.*;

public class ScreenWindow {

    private static JFrame window;

    private int x;
    private int y;
    private int width;
    private int height;

    static {
        window = new JFrame();

        //使用JFrame 来创建一个一个窗口

        //定义窗口的名字
        window.setTitle("屏幕截图窗口");
        window.setLocation(100, 100);
        float alignmentX1 = window.getAlignmentX();
        int x1 = window.getX();


        //设置窗体的高度和宽度
        window.setSize(400, 500);
        window.setResizable(true);
        //当窗体退出时关闭
//        frame.setDefaultCloseOperation(3);
        window.setUndecorated(true);
        window.setBackground(Color.orange);

        AWTUtilities.setWindowOpacity(window, 0.1f);

        ReSizeEvent re = new ReSizeEvent(window);
        window.addMouseListener(re);
        window.addMouseMotionListener(re);
//        window.setAlwaysOnTop(true);

        //设置背景颜色,frame要获取ContentPane()；
        System.out.println(x1);

        //设置船体显示
        window.setVisible(true);

    }

    public int getX() {
        return window.getX();
    }

    public int getY() {
        return window.getY();
    }

    public int getWidth() {
        return window.getWidth();
    }

    public int getHeight() {
        return window.getHeight();
    }
}
