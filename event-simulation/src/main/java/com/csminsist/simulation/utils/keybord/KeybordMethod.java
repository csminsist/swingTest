package com.csminsist.simulation.utils.keybord;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

public class KeybordMethod {

	private static Robot robot;// 创建一个robot对象
	static {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {

		keyPress("f1");

	}

	// shift+ 按键

	/**
	 * @Title: keyPressWithShift
	 * @Description: shift + 按键
	 * @param key
	 * @return: void
	 */
	public static void keyPressWithShift(int key) {

		robot.keyPress(KeyEvent.VK_SHIFT);

		robot.keyPress(key);

		robot.keyRelease(key);

		robot.keyRelease(KeyEvent.VK_SHIFT);

		robot.delay(100);

	}

	// ctrl+ 按键

	/**
	 * @Title: keyPressWithCtrl
	 * @Description: ctrl + 按鍵
	 * @param key
	 * @return: void
	 */
	public static void keyPressWithCtrl(int key) {

		robot.keyPress(KeyEvent.VK_CONTROL);

		robot.keyPress(key);

		robot.keyRelease(key);

		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.delay(100);

	}
	/**
	 * @Title: keyPressWithCtrl
	 * @Description: ctrl + 按鍵
	 * @param key
	 * @return: void
	 */
	public static void keyPressWithCtrl(String key) {

		robot.keyPress(KeyEvent.VK_CONTROL);

		robot.keyPress(Keys.getKey(key));

		robot.keyRelease(Keys.getKey(key));

		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.delay(100);

	}

	// alt+ 按键

	/**
	 * @Title: keyPressWithAlt
	 * @Description: alt + 按鍵
	 * @param key
	 * @return: void
	 */
	public static void keyPressWithAlt(int key) {

		robot.keyPress(KeyEvent.VK_ALT);

		robot.keyPress(key);

		robot.keyRelease(key);

		robot.keyRelease(KeyEvent.VK_ALT);

		robot.delay(100);

	}
	/**
	 * @Title: keyPressWithAlt
	 * @Description: alt + 按鍵
	 * @param key
	 * @return: void
	 */
	public static void keyPressWithAlt(String key) {

		robot.keyPress(KeyEvent.VK_ALT);

		robot.keyPress(Keys.getKey(key));

		robot.keyRelease(Keys.getKey(key));

		robot.keyRelease(KeyEvent.VK_ALT);

		robot.delay(100);

	}

	/**
	 * @Title: keyPressString
	 * @Description: 输入字符串
	 * @param r
	 * @param str
	 * @return: void
	 */
	public static void keyPressString(String str) {
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();// 获取剪切板
		Transferable tText = new StringSelection(str);
		clip.setContents(tText, null); // 设置剪切板内容
		keyPressWithCtrl(KeyEvent.VK_V);// 粘贴
		robot.delay(100);
	}

	// 单个 按键

	/**
	 * @Title: keyPress
	 * @Description: 单个按键
	 * @param key
	 * @return: void
	 */
	public static void keyPress(int key) {

		robot.keyPress(key);

		robot.keyRelease(key);

		robot.delay(100);
	}
	/**
	 * @Title: keyPress
	 * @Description: 单个按键
	 * @param key
	 * @return: void
	 */
	public static void keyPress(String key) {

		robot.keyPress(Keys.getKey(key));

		robot.keyRelease(Keys.getKey(key));

		robot.delay(100);
	}

}
