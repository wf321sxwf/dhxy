package com.dhxy.xy.screen.click;

import org.omg.CORBA.REBIND;

import javax.sound.midi.Soundbank;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Mouse {

    private int x;
    private int y;

    public void click() {
        Robot robot = null;
        try {
            robot = new Robot();
            robot.setAutoDelay(1000);
            //左键点击

            PointerInfo pointerInfo = MouseInfo.getPointerInfo();
            double xx = pointerInfo.getLocation().getX();
            double yy = pointerInfo.getLocation().getY();

            System.out.println(xx);
            System.out.println(yy);
            robot.mouseMove(103, 58);
            robot.delay(1000);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.delay(500);

            robot.mouseRelease(InputEvent.BUTTON1_MASK);


            pointerInfo = MouseInfo.getPointerInfo();
            double x = pointerInfo.getLocation().getX();
            double y = pointerInfo.getLocation().getY();

            System.out.println(x);
            System.out.println(y);


            System.out.println("滚轴");
            robot.mouseWheel(5);

        } catch (AWTException e) {
            e.printStackTrace();
            System.out.println("鼠标点击执行失败");
        }




        System.out.println("执行完毕");
    }

    public Mouse(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) throws AWTException {
        Point p=new Point(103,58);
        Robot robot=new Robot();
        robot.mouseMove(p.x, p.y);
        robot.delay(5000);
        robot.setAutoDelay(0);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        //按下ESC，退出右键状态
        System.out.println("按下ESC");
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }
}
