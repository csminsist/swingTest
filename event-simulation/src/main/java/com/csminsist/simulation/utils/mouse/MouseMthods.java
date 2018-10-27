package com.csminsist.simulation.utils.mouse;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class MouseMthods {
	private static Robot robot = null;
	static int[] location = new int[] {0,0}; 
	static {
		_init();
	}
	public static void dbclick(int x, int y) {
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
	
	
	public static void move(int x, int y) {
		robot.mouseMove(x, y);
	}
	
	public static int[] getMouseLocation() {
		PointerInfo pinfo = MouseInfo.getPointerInfo();
		Point p = pinfo.getLocation();
		int mx = Double.valueOf(p.getX()).intValue();
		int my = Double.valueOf(p.getY()).intValue();
		location[0] = mx;
		location[1] = my;
		return location;
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
