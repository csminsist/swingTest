package com.csminsist.simulation.utils.keybord;

import java.awt.Component;
import java.awt.event.KeyEvent;

public class Keys extends KeyEvent {

	/**@fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 4175517356897141714L;

	public Keys(Component source, int id, long when, int modifiers, int keyCode, char keyChar, int keyLocation) {
		super(source, id, when, modifiers, keyCode, keyChar, keyLocation);
	}
	public static void main(String[] args) {
		getKey("f12");
	}

	public static Integer getKey(String keystr) {
		if(keystr != null) {
			try {
				return Integer.valueOf(keystr);
			} catch (Exception ex) {
				String attribute = "VK_"+keystr.toUpperCase();
				try {
					Object object = Keys.class.getField(attribute).get(null);
					return Integer.valueOf(object.toString());
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				}
			}
			
		}
		return 0;
	}

}
