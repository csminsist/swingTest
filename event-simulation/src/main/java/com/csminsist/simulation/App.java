package com.csminsist.simulation;

import com.csminsist.simulation.utils.keybord.KeyPressedCallback;
import com.csminsist.simulation.utils.keybord.PKeysEvent;
import com.csminsist.simulation.utils.mouse.MouseMthods;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
//
//		Thread keylistener = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				PKeysEvent pKeysEvent = new PKeysEvent();
//				pKeysEvent.addWatch(new KeyPressedCallback() {
//					@Override
//					public void keypressed(int keycode) {
//						System.out.println(keycode);
//					}
//				});
//				while(true) {
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		});
//		keylistener.start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				MouseMthods.move(1438, 665);
				
			}
		}).start();
		
//		int[] mouseLocation = MouseMthods.getMouseLocation();
//		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				MouseMthods.move(mouseLocation[0], mouseLocation[1]);
//				while (true) {
//					KeybordMethod.keyPress("f2");
//					try {
//						Thread.sleep(60);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		});
	}
}
