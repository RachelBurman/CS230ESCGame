package movables;

import javafx.scene.image.ImageView;

public class Player extends Cell {

	private int currentXLocation;
	private int currentYLocation;
	
	public Player(int currentXLocation, int currentYLocation) {

		super("https://1001freedownloads.s3.amazonaws.com/vector/thumb/74889/1367934593.png");
		this.currentXLocation = currentXLocation;
		this.currentYLocation = currentYLocation;
	
		
	}
	
	public ImageView getPlayerImage() {
		
		return super.getCellImage();
}
	
	public int getX() {
		
		int x = this.currentXLocation;
		
		return x;
	}
	
	public int getY() {
		
		int y = this.currentYLocation;
		
		return y;
	}
	
}
