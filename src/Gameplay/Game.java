package Gameplay;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Engine.Keyboard;
import Engine.ScreenEngine;
import Screen.Mainmenu;

public class Game extends JFrame implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ScreenEngine screenEngine;
	private static boolean running;
	
	public static void main(String[] args){
		Game game = new Game();
		game.run();
	}
	
	@SuppressWarnings("static-access")
	public Game()
	{
		Dimension dimension = new Dimension(1280, 720);
		Keyboard keyboard = new Keyboard();
		
		this.setTitle("Game");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setPreferredSize(dimension);
		this.setResizable(false);
		
		screenEngine = new ScreenEngine(this.getContentPane(),dimension,keyboard);
		
		this.addKeyListener(keyboard);
		this.pack();
		this.setVisible(true);
		this.setRunning(true);
		screenEngine.setScreen(new Mainmenu(dimension));
		
	}
	
	
	@Override
	public void run(){
		
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 30D;
		
		@SuppressWarnings("unused")
		int ticks = 0;
		@SuppressWarnings("unused")
		int frames = 0;
		
		long lasTimer = System.currentTimeMillis();
		double delta = 0;
		
		while(isRunning()){
			
			try{
				long now = System.nanoTime();
				delta +=(now - lastTime )/nsPerTick;
				lastTime = now;
				boolean shouldRender = false;
			
				while(delta >= 1){
					ticks++;
					screenEngine.Update();
					delta -= 1;
					shouldRender = true;
				}
				if(shouldRender){
					frames++;
					screenEngine.repaint();
				}
				
				if(System.currentTimeMillis() - lasTimer >= 1000){
					lasTimer += 1000;
					frames = 0;
					ticks = 0;
				}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		this.setVisible(false);
		this.dispose();
		System.exit(0); 
		
		
	}
	
	
	public static void stop(){
		System.out.println("Stop");
		setRunning(false);
		
	}

	public static boolean isRunning() {
		return running;
	}

	public static void setRunning(boolean running) {
		Game.running = running;
	}
	
}
