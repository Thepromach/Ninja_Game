package Screen;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import Engine.Keyboard;
import Engine.Screen;
import Engine.ScreenEngine;

public class ScoreScreen extends Screen {
	
	int score;
	
	public ScoreScreen(Dimension dimension, int newScore){
		super(dimension);
		score = newScore;
	}
	
	@Override
	public void Update(Keyboard keyboard){
		if(keyboard.getKeyPressed(Keyboard.ENTER)){
			ScreenEngine.setScreen(new Mainmenu(dimension));
		}
	}
	
	@Override
	public void Draw(Graphics g){
		String text1 = "Press ENTER to go back mainmenu";
		String text2 = "or ESC to close game";
		String text3 = "Your score was " + score;
		g.setFont(new Font("Consolas",Font.BOLD,30));
		g.drawString(text1, dimension.width/2 - text1.length() * 15, dimension.height/2);
		g.drawString(text2, dimension.width/2 - text1.length() * 15, dimension.height/2 + 50);
		g.drawString(text3, dimension.width/2 - text3.length() * 15, dimension.height/2 - 200);
	}
}
