package com.csminsist.simulation.utils.mouse;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class MouseEvent extends java.awt.event.MouseEvent {
	static Robot robot = null;
	static {
		// 初始化robot
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -51037629864728032L;

	public MouseEvent(Component source, int id, long when, int modifiers, int x, int y, int clickCount,
			boolean popupTrigger) {
		super(source, id, when, modifiers, x, y, clickCount, popupTrigger);
	}

	public static boolean click() {
		Point point = MouseInfo.getPointerInfo().getLocation();
		System.out.println("x=" + point.getX() + ",y=" + point.getY());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		// 鼠标移动到某一点
//		robot.mouseMove(x, y);
		// 模拟鼠标按下左键
		robot.mousePress(InputEvent.BUTTON1_MASK);
		// 模拟鼠标松开左键
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		// 模拟鼠标按下左键
		robot.mousePress(InputEvent.BUTTON1_MASK);
		// 模拟鼠标松开左键
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		return true;
	}

}
