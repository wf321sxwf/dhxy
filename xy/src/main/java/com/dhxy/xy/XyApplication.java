package com.dhxy.xy;

import com.dhxy.xy.screen.ScreenWindow;
import com.dhxy.xy.task.ShotTask;

public class XyApplication {

	public static void main(String[] args) {

		System.out.println("程序开始执行");

		ShotTask shotTask = new ShotTask(new ScreenWindow(), "/Users/jiyanlong/app/dhxy/screen",
				1000, 2000);

		shotTask.begin();

	}

}
