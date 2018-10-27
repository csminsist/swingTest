package com.csminsist.simulation.utils.keybord;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class PKeysEvent implements KeyListener{

	private static List<KeyPressedCallback> watch = new ArrayList<>();
	
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(!watch.isEmpty()) {
			watch.forEach(watch -> {
				watch.keypressed(e.getKeyCode());
			});
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println(e.getKeyCode());
	}

	
	public void addWatch(KeyPressedCallback callback) {
		watch.add(callback);
	}
	
}
