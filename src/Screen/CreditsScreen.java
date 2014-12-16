package Screen;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import Engine.Keyboard;
import Engine.Screen;
import Engine.ScreenEngine;

public class CreditsScreen extends Screen {

	public CreditsScreen(Dimension newDimension) {
		super(newDimension);
		
	}

	@Override
	public void Update(Keyboard keyboard){
		
		if(keyboard.getKeyPressed(Keyboard.ENTER)){
			ScreenEngine.setScreen(new Mainmenu(dimension));
		}
		
		
	}
	
	public void Draw(Graphics g){
		
		g.setFont(new Font("Arial",Font.BOLD, 30));
		
		g.drawString("Matti \"Mach\" Väliaho: code and music", 100,100);
		g.drawString("Michael \"Montora\" Friman: textures", 100,150);
		g.drawString("Press ENTER to go mainmenu", 100,300);
		
		
	}
}
