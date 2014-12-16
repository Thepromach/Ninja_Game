package Gameplay;

import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import Engine.Keyboard;
import Engine.ResourceReader;

public class Player {
	
	
	Clip jump, hit;
	
	boolean alive;
	int moveX, moveY;
	int x , y;
	int height, width;
	int sprite;
	int score;
	int boost;
	
	public Player(int newX, int newY, int newHeight, int newWidth){
		
		x = newX;
		y = newY;
		sprite= score = 0;
		moveX = moveY = 0;
		height = newHeight;
		width = newWidth;
		alive = true;
		boost = 0;
		
		try{
			jump = null;
			hit = null;
			
			jump = AudioSystem.getClip();
			jump.open(ResourceReader.getAudio("Jump.wav"));
			
			hit = AudioSystem.getClip();
			hit.open(ResourceReader.getAudio("Hit.wav"));
        
		}
		catch(Exception e){
			System.out.print(e.toString());
		}
		
	}
	public void Update(Keyboard keyboard, ArrayList<GameObject> bricks, ArrayList<GameObject>boosts){
		
		x += moveX;
		y += moveY;
		
		moveX = 0;
		if(Collision(bricks))moveY++;
		else{
			moveY = -20;
			score++;
			if(jump != null){
				jump.stop();
				jump.setFramePosition(0);
				jump.start();
			}
		}
		if(!Collision(boosts)){
			if(boost < 500)boost += 5;
			if(hit != null){
				hit.stop();
				hit.setFramePosition(0);
				hit.start();
			}
		}
		
		
		if(keyboard.getKey(Keyboard.LEFT)){
			moveX = -10;
			sprite = 1;
		}
		if(keyboard.getKey(Keyboard.RIGHT)){
			moveX = 10;
			sprite = 0;
		}
		if(keyboard.getKey(Keyboard.UP) && boost > 0){
			moveY -= 5;
			boost--;
			sprite = 2;
		}
		
		if(y > 1300){
			alive = false;
		}
		if(y < 0)moveY += 5;
		if(moveY < -20)moveY = -20;
		
	}
	
	private boolean Collision(ArrayList<GameObject>blocks){
		
		for(GameObject block : blocks){
			if(block.Collision(this))return false;
		}
		return true;
		
	}
	
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getSprite() {
		return sprite;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public boolean isAlive() {
		return alive;
	}
	public int getScore() {
		return score;
	}
	public int getBoost() {
		return boost;
	}
	
	
}
