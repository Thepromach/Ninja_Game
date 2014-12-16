package Gameplay;

import java.util.Random;

public class Boost extends GameObject {
	
	static Random rnd = new Random();
	
	public Boost(int newHeight, int newWidth){
		super( rnd.nextInt(1000)+100,rnd.nextInt(400)+100,newHeight,newWidth);
	}
	
	@Override
	public boolean Collision(Player player){
		
		if(player.getY() + player.getWidth() > y && player.getY() < y + width
				&& player.getX() + player.getHeight() >= x && player.getX() < x + height)
		{
			x = rnd.nextInt(1000) + 100;
			y = rnd.nextInt(400) + 100;
			return true;
		}
		return false;
	}
	
}
