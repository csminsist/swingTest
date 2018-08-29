package com.csminsist.simulation.utils.mouse;

import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MouseListener extends java.awt.event.MouseAdapter {
	private MouseListener() {}
	private static MouseListener mlistner = null;
	
	public static MouseListener getMlistner() {
		if(mlistner == null) {
			mlistner = new MouseListener();
		}
		return mlistner;
	}
//	
	private static List<MouseDbClickListener> dbWatcher = new ArrayList<>();
	public void addMdbclickListner(MouseDbClickListener dbClickListener) {
		dbWatcher.add(dbClickListener);
	}
//	
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		System.out.println("click "+e.getClickCount());
//		super.mouseClicked(e);
//		if(e.getClickCount() == 2) {
//			System.out.println("鼠标双击");
//			if(!dbWatcher.isEmpty()) {
//				for (MouseDbClickListener mouseDbClickListener : dbWatcher) {
//					mouseDbClickListener.dbclick();
//				}
//			}
//		}
//	}
	private static boolean flag = false;// 用来判断是否已经执行双击事件
	private static int clickNum = 0;// 用来判断是否该执行双击事件

	public void mouseClicked(MouseEvent e) {
		final MouseEvent me = e;// 事件源

		this.flag = false;// 每次点击鼠标初始化双击事件执行标志为false

		if (this.clickNum == 1) {// 当clickNum==1时执行双击事件
			this.mouseDoubleClicked(me);// 执行双击事件
			this.clickNum = 0;// 初始化双击事件执行标志为0
			this.flag = true;// 双击事件已执行,事件标志为true
			return;
		}

		// 定义定时器
		java.util.Timer timer = new java.util.Timer();

		// 定时器开始执行,延时0.2秒后确定是否执行单击事件
		timer.schedule(new java.util.TimerTask() {
			private int n = 0;// 记录定时器执行次数

			public void run() {
				if (MouseListener.flag) {// 如果双击事件已经执行,那么直接取消单击执行
					n = 0;
					MouseListener.clickNum = 0;
					this.cancel();
					return;
				}
				if (n == 1) {// 定时器等待0.2秒后,双击事件仍未发生,执行单击事件
					mouseSingleClicked(me);// 执行单击事件
					MouseListener.flag = true;
					MouseListener.clickNum = 0;
					n = 0;
					this.cancel();
					return;
				}
				clickNum++;
				n++;
			}
		}, new java.util.Date(), 200);
	}

	/**
	 * 鼠标单击事件
	 * 
	 * @param e 事件源参数
	 */
	public void mouseSingleClicked(MouseEvent e) {
		System.out.println("Single Clicked!");
	}

	/**
	 * 鼠标双击事件
	 * 
	 * @param e 事件源参数
	 */
	public void mouseDoubleClicked(MouseEvent e) {
		System.out.println("Doublc Clicked!");
		if(!dbWatcher.isEmpty()) {
			for (MouseDbClickListener mouseDbClickListener : dbWatcher) {
				mouseDbClickListener.dbclick();
			}
		}
	}

}
