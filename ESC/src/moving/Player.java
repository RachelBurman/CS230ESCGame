package moving;


import java.io.File;

import application.Cell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class represents all attributes and behaviours of a Player.
 * @author Group 31
 * @version 3.0
 */
public class Player extends Movable {

	private Image playerImg;
	private ImageView playerView;
	int redKey = 0;
	int greenKey = 0;
	int blueKey = 0;
	int tokens = 0;
	boolean flippers = false;
	boolean boots = false;
	
	/**
	 * Constructor of Player.
	 * @param name The Player name.
	 * @param mapActual The map of Player.
	 * @param location The array containing location information. 
	 */
	public Player(String name, Cell[][] mapActual, int[] location) {
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
	
	/**
	 * Getter method for amount of tokens.
	 * @return The amount of tokens held by the player.
	 */
	public int getTokens() {
		return tokens;
	}

	/**
	 * Method that teleports player when in contact with teleporter cell.
	 */
	public void teleport() {
		int newX = mapActual[getXLocation()][getYLocation()].getLinkX();
		int newY = mapActual[getXLocation()][getYLocation()].getLinkY();
		if (facing == 'u') {
			this.xLocation = newX;
			this.yLocation = newY - 1;
		} else if (facing == 'd') {
			this.xLocation = newX;
			this.yLocation = newY + 1;
		} else if (facing == 'r') {
			this.xLocation = newX + 1;
			this.yLocation = newY;
		} else if (facing == 'l') {
			this.xLocation = newX - 1;
			this.yLocation = newY;
		}

	}

	/**
	 * Method that increments token amount.
	 */
	public void addToken() {
		this.tokens = tokens + 1;
	}

	/**
	 * Method that removes tokens from token amount.
	 * @param num The amount of removed tokens.
	 */
	public void takeTokens(int num) {
		this.tokens = this.tokens - num;
	}
	
	/**
	 * Setter method for amount of tokens.
	 * @param tokens The amount of tokens.
	 */
	public void setTokens(int tokens) {
		this.tokens = tokens;
	}
	
	/**
	 * Getter method for checking if flippers have been acquired.
	 * @return Return true when flippers are acquired.
	 */
	public boolean getFlippers() {
		return flippers;
	}
	
	/**
	 * Getter method for checking if boots have been acquired.
	 * @return Return true when boots are are acquired.
	 */
	public boolean getBoots() {
		return boots;
	}
	
	/**
	 * Method that helps show that flippers have been acquired.
	 */
	public void changeFlipper() {
		this.flippers = !this.flippers;
	}
	
	/**
	 * Method that helps show that boots have been acquired.
	 */
	public void changeBoot() {
		this.boots = !this.boots;
	}

	/**
	 * Method that increments amount of red keys for player.
	 */
	public void addRedKey() {
		this.redKey = redKey + 1;
	}

	/**
	 * Method that increments amount of blue keys for player.
	 */
	public void addBlueKey() {
		this.blueKey = blueKey + 1;
	}

	/**
	 * Method that increments amount of green keys for player.
	 */
	public void addGreenKey() {
		this.greenKey = greenKey + 1;
	}
	
	/**
	 * Getter method that increments amount of red keys for player.
	 * @return Amount of red keys acquired.
	 */
	public int getRedKey() {
		return redKey;
	}
	
	/**
	 * Getter method that increments amount of green keys for player.
	 * @return Amount of green keys acquired.
	 */
	public int getGreenKey() {
		return greenKey;
	}
	
	/**
	 * Getter method that increments amount of blue keys for player.
	 * @return Amount of blue keys acquired.
	 */
	public int getBlueKey() {
		return blueKey;
	}
	
	/**
	 * Method that decrements amount of red keys.
	 */
	public void minusRedKey() {
		this.redKey = redKey - 1;
	}

	/**
	 * Method that decrements amount of blue keys.
	 */
	public void minusBlueKey() {
		this.blueKey = blueKey - 1;
	}

	/**
	 * Method that decrements amount of green keys.
	 */
	public void minusGreenKey() {
		this.greenKey = greenKey - 1;
	}

	/**
	 * Setter method for Player name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Setter method for player x coordinate.
	 * @param xLocation The player's x coordinate.
	 */
	public void setLocation(int xLocation) {
		this.xLocation = xLocation;
	}

	/**
	 * Setter method for player y coordinate.
	 * @param yLocation The player's y coordinate.
	 */
	public void setyLocation(int yLocation) {
		this.yLocation = yLocation;
	}

	/**
	 * Getter method for Player name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter method for x coordinate of Player
	 * @return Return Player's x coordinate.
	 */
	public int getxLocation() {
		return xLocation;
	}

	/**
	 * Getter method for y coordinate of Player
	 * @return Return Player's y coordinate.
	 */
	public int getyLocation() {
		return yLocation;
	}

	/**
	 * Getter method for player image.
	 * @return Return Player's Image.
	 */
	public Image getPlayerImg() {
		return playerImg;
	}

	/**
	 * Getter method for Player Image View.
	 * @return Return Player's Image View.
	 */
	public ImageView getPlayerView() {
		return playerView;
	}
}