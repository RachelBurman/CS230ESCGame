package moving;

import java.util.ArrayList;

import application.Map;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Player extends Movable {
	
	
	private Image playerImg;
	private ImageView playerView;
	public Player(String name, int[] location) {
		super (name);
		super.name = name;
		super.xLocation = location[0];
		super.yLocation = location[1];
		this.playerImg = new Image("https://1001freedownloads.s3.amazonaws.com/vector/thumb/74889/1367934593.png");
		this.playerView = new ImageView(this.playerImg);
		this.playerView.setFitHeight(CELL_SIZE);
		this.playerView.setFitWidth(CELL_SIZE);
		
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setMap(Map map) {
		this.map = map;;
	}

	public void setLocation(int xLocation) {
		this.xLocation = xLocation;
	}

	public void setyLocation(int yLocation) {
		this.yLocation = yLocation;
	}

	public String getName() {
		return name;
	}

	public int getxLocation() {
		return xLocation;
	}

	public int getyLocation() {
		return yLocation;
	}

	public Image getPlayerImg() {
		return playerImg;
	}

	public ImageView getPlayerView() {
		return playerView;
	}
	// Check if move is outof bounds
	private boolean validMove(int xLocation, int yLocation, int newXLocation, int newYLocation, Map map) {
		if (map.getCell(newXLocation, newYLocation).getPlayerPass()) {
			return true;
			} else {
				return false;
			}
	}
	
	public void moveUp() {
		if (validMove(xLocation, yLocation, xLocation, yLocation-1, map )) {
			this.yLocation = yLocation-1;
		}
	}
	
	public void moveDown() {
		if (validMove(xLocation, yLocation, xLocation, yLocation+1, map )) {
			this.yLocation = yLocation+1;
		}
	}
	public void moveRight() {
		if (validMove(xLocation, yLocation, xLocation+1, yLocation, map )) {
			this.xLocation = xLocation+1;
		}
	}
	
	public void moveLeft() {
		if (validMove(xLocation, yLocation, xLocation-1, yLocation, map )) {
			this.xLocation = xLocation-1;
		}
	}
}