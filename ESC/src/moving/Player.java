package moving;


import java.io.File;

import application.Cell;
import application.LevelLoader;
import application.Map;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Player extends Movable {
	
	
	private Image playerImg;
	private ImageView playerView;
	int redKey=0;
	int greenKey=0;
	int blueKey=0;
	int tokens=0;
	boolean flippers= false;
	boolean boots = false;
	public Player(String name,Cell[][] mapActual, int[] location) {
		super (name, mapActual);
		super.name = name;
		super.xLocation = location[0];
		super.yLocation = location[1];
		super.mapActual = mapActual;
		this.mapActual = mapActual;
		File file = new File("./src/player.png");
		Image playerImg = new Image(file.toURI().toString());
		this.playerView = new ImageView(playerImg);
		this.playerView.setFitHeight(CELL_SIZE);
		this.playerView.setFitWidth(CELL_SIZE);

		
		
	}
	public int getTokens() {
		return tokens;
	}
	
	public void teleport() {
		int newX= mapActual[getXLocation()][getYLocation()].getLinkX();
		int newY= mapActual[getXLocation()][getYLocation()].getLinkY();
		if (facing == 'u') {
			this.xLocation = newX;
			this.yLocation = newY-1;
		} else if (facing == 'd') {
			this.xLocation = newX;
			this.yLocation = newY+1;
		} else if (facing == 'r') {
			this.xLocation = newX+1;
			this.yLocation = newY;
		} else if (facing == 'l') {
			this.xLocation = newX-1;
			this.yLocation = newY;
		}
		
	}
	
	public void addToken() {
		this.tokens = tokens+1;
	}
	
	public void takeTokens(int num) {
		this.tokens = this.tokens-num;
	}
	public void setTokens(int tokens) {
		this.tokens = tokens;
	}
	public boolean getFlippers() {
		return flippers;
	}
	public boolean getBoots() {
		return boots;
	}
	public void changeFlipper() {
		this.flippers = !this.flippers;
	}
	public void changeBoot() {
		this.boots = !this.boots;
	}
	
	public void addRedKey() {
		this.redKey = redKey+1;
	}
	
	public void addBlueKey() {
		this.blueKey = blueKey+1;
	}
	
	public void addGreenKey() {
		this.greenKey = greenKey+1;
	}
	public int getRedKey() {
		return redKey;
	}
	public int getGreenKey() {
		return greenKey;
	}
	public int getBlueKey() {
		return blueKey;
	}
	public void minusRedKey() {
		this.redKey = redKey-1;

	}
	
	public void minusBlueKey() {
		this.blueKey = blueKey-1;
	}
	
	public void minusGreenKey() {
		this.greenKey = greenKey-1;
	}

	public void setName(String name) {
		this.name = name;
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
}