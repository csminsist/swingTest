package com.csminsist.simulation.utils.mouse;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class MouseMthods {
	private static Robot robot = null;

	public static void dbclick(int x, int y) {
		_init();
		// 鼠标移动到某一点
		robot.mouseMove(x, y);
		// 模拟鼠标按下左键
		robot.mousePress(InputEvent.BUTTON1_MASK);
		// 模拟鼠标松开左键
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		// 模拟鼠标按下左键
		robot.mousePress(InputEvent.BUTTON1_MASK);
		// 模拟鼠标松开左键
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
	

	private static void _init() {
		try {
			if (robot == null) {
				robot = new Robot();
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

}
