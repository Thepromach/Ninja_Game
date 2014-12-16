package Gameplay;

public class GameObject {

	int x, y;
	int height, width;
	
	public GameObject(int newX, int newY, int newHeight, int newWidth){
		
		x = newX;
		y = newY;
		height = newHeight;
		width = newWidth;
		
	}
	
	public void Update(int speed){
		
		
	}
	
	public boolean Collision(Player player){
		
		return false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
}
