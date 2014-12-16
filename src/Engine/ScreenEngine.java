package Engine;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import Gameplay.Game;

public class ScreenEngine extends JPanel {

	private static final long serialVersionUID = 1L;
	private static Screen currentScreen;
	private Keyboard keyboard;
	
	public ScreenEngine(Container container, Dimension newDimension, Keyboard newKeyboard){
		container.add(this);
		currentScreen = new Screen(newDimension);
		keyboard = newKeyboard;
	}
	public void Update(){
		currentScreen.Update(keyboard);
		if(keyboard.getKey(Keyboard.ESCAPE)) Game.stop();
	}
	@Override
	public void paint(Graphics g){
		super.paint(g);
		
		currentScreen.Draw(g);
		
		getToolkit().sync();
	}
	
	public static void setScreen(Screen newScreen){
		currentScreen = null;
		System.gc();
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		currentScreen = newScreen;
	}
	
}
