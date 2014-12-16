package Engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{

	public static final int ESCAPE = KeyEvent.VK_ESCAPE;
	public static final int ENTER = KeyEvent.VK_ENTER;
	public static final int UP = KeyEvent.VK_UP;
	public static final int DOWN = KeyEvent.VK_DOWN;
	public static final int RIGHT = KeyEvent.VK_RIGHT;
	public static final int LEFT = KeyEvent.VK_LEFT;
	
	private boolean[] keys = new boolean[255];
	private boolean[] keys2 = new boolean[255];
	
	public Keyboard(){
		for(int i = 0; i < 255; i++){
			keys[i] = false;
			keys2[i] = false;
		}
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() < keys.length){
			keys[e.getKeyCode()] = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() < keys.length && keys[e.getKeyCode()] == true){
			keys[e.getKeyCode()] = false;
			keys2[e.getKeyCode()] = true;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public boolean getKeyPressed(int num){
		
		if(keys2[num]){
			keys2[num] = false;
			return true;
		}
		return false;
	}
	public boolean getKey(int num){
		
		if(keys[num]){
			return true;
		}
		return false;
	}
}
