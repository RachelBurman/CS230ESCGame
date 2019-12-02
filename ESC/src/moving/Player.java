package moving;

import application.Cell;
import javafx.scene.image.ImageView;

public class Player extends Movable {

	private int currentXLocation;
	private int currentYLocation;
	
	public Player(String playerImageLocation, int currentXLocation, int currentYLocation) {

		super(playerImageLocation, currentXLocation, currentYLocation);
		this.currentXLocation = currentXLocation;
		this.currentYLocation = currentYLocation;
	
		//"https://1001freedownloads.s3.amazonaws.com/vector/thumb/74889/1367934593.png"
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
