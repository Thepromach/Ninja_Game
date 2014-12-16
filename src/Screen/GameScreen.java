package Screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Engine.ResourceReader;
import Engine.Keyboard;
import Engine.Screen;
import Engine.ScreenEngine;
import Gameplay.Boost;
import Gameplay.Brick;
import Gameplay.GameObject;
import Gameplay.Player;

public class GameScreen extends Screen{

	int timer, speed;
	String text;
	Player player;
	ArrayList<GameObject> bricks;
	ArrayList<GameObject> boosts;
	BufferedImage image;
	
	public GameScreen(Dimension dimension){
		super(dimension);
		player = new Player(500,30,dimension.width/16,dimension.height/9);
		bricks = new ArrayList<GameObject>();
		boosts = new ArrayList<GameObject>();
		
		bricks.add(new Brick(500,600,dimension.height/18,dimension.width/16 * 3));
		bricks.add(new Brick(500,500,dimension.height/18,dimension.width/16 * 3));
		bricks.add(new Brick(500,300,dimension.height/18,dimension.width/16 * 3));
		
		boosts.add(new Boost(dimension.height/18, dimension.width/32));
		
		
		image = ResourceReader.getImage("Tile.png");
		timer = 0;
		text = "Noob";
		speed = 0;
	}
	
	@Override
	public void Update(Keyboard keyboard){
		
		timer++;
		
		if(player.isAlive()){
			player.Update(keyboard, bricks,boosts);
		}
		else{
			ScreenEngine.setScreen(new ScoreScreen(dimension, player.getScore() + speed * 100 + timer/10));
		}
		
		for(GameObject brick : bricks){
			brick.Update(speed);
			if(brick.getY() > 700){
				brick.setY(-50);
			}
		}
		
		if(timer >= 500){
			text = "Rookie";
			speed = 1;
		}
		if(timer >= 1000){
			text = "Beginner";
			speed = 2;
		}
		if(timer >= 2000){
			text = "Professional";
			speed = 3;
		}
		if(timer >= 5000){
			text = "Legendary";
			speed = 4;
		}
		if(timer >= 10000){
			text = "Master";
			speed = 5;
		}
		if(timer >= 20000){
			text = "Grand Master";
			speed = 6;
		}
		if(timer >= 30000){
			text = "Legendary";
			speed = 7;
		}
		if(timer >= 50000){
			text = "Godlike";
			speed = 10;
		}
		
		
	}
	@Override
	public void Draw(Graphics g){
		
		//Teksti
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial",Font.BOLD, 20));
		g.drawString("Level: " + text, 20, 50);
		
		//Pelaaja
		g.drawImage(image, player.getX(), player.getY(), player.getWidth() + player.getX(), player.getHeight() + player.getY(), 0 + player.getSprite() * 16, 0, 16 + player.getSprite() * 16, 16, null);
		
		
		//GameObjects
		for(GameObject brick : bricks){
			g.drawImage(image, brick.getX(), brick.getY(), brick.getWidth() + brick.getX(), brick.getHeight() + brick.getY(), 0, 16, 32, 32, null);
		}

		for(GameObject boost : boosts){
			g.drawImage(image, boost.getX(), boost.getY(), boost.getWidth() + boost.getX(), boost.getHeight() + boost.getY(), 0, 32, 16, 48, null);
			
		}
		
		
		//Boost palkki
		g.setColor(Color.BLUE);
		g.fillRect(10, 10, player.getBoost(), 20);
	}
	
}
