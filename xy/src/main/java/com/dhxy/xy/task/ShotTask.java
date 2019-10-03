package com.dhxy.xy.task;

import com.dhxy.xy.answer.Answer;
import com.dhxy.xy.answer.Question;
import com.dhxy.xy.scan.ImageScan;
import com.dhxy.xy.screen.ScreenWindow;

import java.util.Timer;
import java.util.TimerTask;

public class ShotTask {

    private ScreenWindow window;
    private String path;
    private int delay;
    private int period;

    //启动定时器
    public void begin(){

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                String image = null;
                try {
                    //截图
//                    image = ScreenShot.captureScreen(path, window);

                    String path = "/Users/jiyanlong/Desktop/test2.png";
                    // 扫描图片
                    Question question = ImageScan.getQuestion(path);
                    //回答问题
                    Answer answer = question.answer();

                    //点击屏幕


                    System.out.println(answer);
                } catch (Exception e) {
                    System.out.println("定时截图任务失败");
                    e.printStackTrace();
                } finally {

//                    File file = new File(image);
//                    if(file.exists()) file.delete();
                }



            }
        }, delay, period);

    }

    public ShotTask(ScreenWindow window, String path, int delay, int period){
        this.window = window;
        this.path = path;
        this.delay = delay;
        this.period = period;
    }

}
