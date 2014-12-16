package Screen;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Engine.ResourceReader;
import Engine.Keyboard;
import Engine.Screen;
import Engine.ScreenEngine;

public class Mainmenu extends Screen {
	
	int num;
	BufferedImage image;
	
	public Mainmenu(Dimension dimension){
		super(dimension);

		image = ResourceReader.getImage("TestiTausta.png");
		
		num = 0;
	}
	
	@Override
	public void Update(Keyboard keyboard){
		
		
		if(num != 2 && keyboard.getKeyPressed(Keyboard.DOWN)){
			num++;
		}
		if(num != 0 && keyboard.getKeyPressed(Keyboard.UP)){
			num--;
		}
		if(num == 0 && keyboard.getKeyPressed(Keyboard.ENTER)){
			ScreenEngine.setScreen(new GameScreen(dimension));
		}
		else if(num == 1 && keyboard.getKeyPressed(Keyboard.ENTER)){
			ScreenEngine.setScreen(new CreditsScreen(dimension));
		}
		else if(num == 2 && keyboard.getKeyPressed(Keyboard.ENTER)){
			System.exit(0);
		}
		
	}
	@Override
	public void Draw(Graphics g){
		
		
		g.drawImage(image, 0, 0,dimension.width,dimension.height,0,0,1280,720, null);
		
		g.setFont(new Font("Algerian",Font.BOLD,50));
		g.drawString("Ninja Game", dimension.width/2, dimension.height/2);
		
		g.setFont(new Font("Verdana",Font.BOLD, 30));
		g.drawString("New Game", 10, dimension.height/3);
		g.drawString("Credits", 10, dimension.height/3 + 50);
		g.drawString("Quit", 10, dimension.height/3 + 100);
		g.drawRect(0, (int)(dimension.height/3.5) + num * 50, 200, 50);
		
	}
	
}
