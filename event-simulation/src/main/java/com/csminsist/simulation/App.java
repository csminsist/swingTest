package com.csminsist.simulation;

import javax.swing.plaf.SliderUI;

import com.csminsist.simulation.utils.mouse.MouseEvent;
import com.csminsist.simulation.utils.mouse.MouseMthods;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				MouseEvent.click();
			}
		}).start();
        
        while(true) {
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        
    }
}
