package com.dhxy.xy.screen.click;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 *     @author wangtianze QQ:864620012
 *     @date 2017年4月16日 上午1:20:32
 *     <p>description:Robot测试类，实现效果是运行之后鼠标自动定位到整个屏幕坐标系的(635,454)位置，输入wangtianze</p>
 */
public class RobotTest {
    public static void main(String[] args){
        try {
            Robot robot = new Robot();
            //鼠标移动到坐标(635,454)
            RobotTest.clickMouse(robot, 635, 454, 500);
            
            int[] keys = {
                    KeyEvent.VK_W,KeyEvent.VK_A,
                    KeyEvent.VK_N,KeyEvent.VK_G,
                    KeyEvent.VK_T,KeyEvent.VK_I,
                    KeyEvent.VK_A,KeyEvent.VK_N,
                    KeyEvent.VK_Z,KeyEvent.VK_E};
            robot.delay(500);
            RobotTest.pressKey(robot,keys,500);
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void pressKey(Robot robot,int[] keys,int delay){
        for(int i=0;i<keys.length;i++){
            robot.keyPress(keys[i]);
            robot.keyRelease(keys[i]);
            robot.delay(500);
        }
        //处理完需要延迟
        robot.delay(delay);
    }
    
    public static void clickMouse(Robot robot,int x,int y,int delay){
        robot.mouseMove(x, y);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(delay);
    }
}