package Gameplay;

import java.util.Random;

public class Brick extends GameObject {

	int moveY;
	
	public Brick(int newX, int newY, int newHeight, int newWidth){
		super(newX,newY,newHeight,newWidth);
		moveY = 0;
		
	}
	
	@Override
	public void Update(int speed){
		
		if(moveY > 0){
			moveY--;
		}
		else
		{
			y += speed;
		}
		
	}
	
	@Override
	public boolean Collision(Player player){
		
		if(player.getY() + player.getHeight() < y + height && player.y + player.getHeight() > y && 
				player.x + player.getWidth() > x && player.x < x + width)
		{
			moveY = 50;
			int newX = x;
			while(newX == x)newX = new Random().nextInt(10) * 100 + 100;
			x = newX;
			
			return true;
		}
		return false;
	}
	
}
