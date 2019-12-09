package application;

import java.io.File;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import moving.DumbTargetingEnemy;
import moving.Player;
import moving.StraightLineEnemy;
import moving.WallFollowingEnemy;

/**
* This class represents the map that the game is played on.
* @author Group 31 
* @version 3.0
*/
public class Map {
	Cell[][] mapActual;
	private int mapLength;
	private int mapHeight;
	private int start[];
	private Player player1;
	private StraightLineEnemy enemy1;
	StraightLineEnemy[] straightEnemyList;
	WallFollowingEnemy[] wallFollowingList;
	ArrayList<DumbTargetingEnemy> dumbList =new ArrayList<DumbTargetingEnemy>();
	//SmartTargetingEnemy[] SmartTargetingList;
	ArrayList<WallFollowingEnemy> wallFollowList =new ArrayList<WallFollowingEnemy>(); //New
	
	/**
	 * Constructor for making a Map object.
	 * Just needs the file where information is stored
	 * @param file The name/path of the file.
	 */
	public Map (String file) {
		this.mapActual=LevelLoader.loadLevel(file);
		this.start= LevelLoader.getPlayerStart(file);
		int size[] = LevelLoader.getSize(file);
		int count=0;
		//Swaps for some reason
		this.mapHeight =size[1];
		this.mapLength = size[0];
		this.player1 = new Player("name",mapActual,LevelLoader.getPlayerStart(file));
		this.enemy1 = new StraightLineEnemy("Straight enemy", mapActual, LevelLoader.getStraightEnemy(file));
		this.dumbList.add(new DumbTargetingEnemy("Dumb",mapActual, LevelLoader.getDumbEnemy(file)));
		this.dumbList.get(0).setPlayerx(this.player1.getxLocation());
		this.dumbList.get(0).setPlayery(this.player1.getyLocation());
		//
		//System.out.println(dumbList.get(0).getXLocation());
		//System.out.println(dumbList.get(0).getYLocation());

		// NEW
		this.wallFollowList.add(new WallFollowingEnemy("Wall Enemy",mapActual, LevelLoader.getWallFollowingEnemy(file)));
		//System.out.println(wallFollowList.get(0).getXLocation());
		//System.out.println(wallFollowList.get(0).getYLocation());

	}
	
	/**
	 * Returns the Enemy at position number.
	 * @param num Index of Dumb Enemy
	 * @return The Enemy at that index
	 */
	public DumbTargetingEnemy getDummieAt(int num) {
		return dumbList.get(num);

	}

	/**
	 * Returns the Enemy at position number.
	 * @param num Index of WallFollowingEnemy
	 * @return Enemy at that index
	 */
	public WallFollowingEnemy getWallFollowAt(int num) {
		return wallFollowList.get(num);
	}


	/**
	 * Set the map of cells.
	 * @param mapActual 2D array of Cells
	 */
	public void setMapActual(Cell[][] mapActual) {
		this.mapActual = mapActual;
	}
	
	/**
	 * Add the player to the Map.
	 * @param player The player to be added.
	 */
	public void addPlayer(Player player) {
		this.player1 = player;
	}

	private void removeCell (int xLocation, int yLocation) {
		mapActual[xLocation][yLocation]= null;

	}
	/**
	 * Removes the cell at X and Y coordinates and adds a default one back in place of it.
	 * @param xLocation The x location of the cell.
	 * @param yLocation The y location of the cell.
	 */
	public void replaceCell(int xLocation, int yLocation) {
		removeCell(xLocation,yLocation);
		addCell(xLocation,yLocation);
	}

	private void addCell(int xLocation, int yLocation) {
		this.mapActual[xLocation][yLocation] = new Cell("Cell", xLocation, yLocation);
	}

	/**
	 * Returns the map of cells.
	 * @return 2D array of Cells
	 */
	public Cell[][] getMapActual() {
		return mapActual;
	}

	/**
	 * Returns the length/width of the map.
	 * @return length of Map
	 */
	public int getMapLength() {
		return mapLength;
	}

	/**
	 * Returns the height of the map.
	 * @return height of Map
	 */
	public int getMapHeight() {
		return mapHeight;
	}

	/**
	 * Returns the player start location.
	 * @return array with x and y location of player start
	 */
	public int[] getStart() {
		return start;
	}
	
	/**
	 * Returns the cell at location X and Y.
	 * @param x location of cell.
	 * @param y location of cell.
	 * @return the cell obejct at location X and Y
	 */
	public Cell getCell(int x, int y) {

		return mapActual[x][y] ;
	}

	/**
	 * Returns the player object.
	 * @return player object
	 */
	public Player getPlayer1() {
		return player1;
	}

	/**
	 * Returns StrightLine Enemy object.
	 * @return StraightLineEnemy
	 */
	public StraightLineEnemy getEnemy1() {
		return enemy1;
	}
	
	/**
	 * Updates the map at location X and Y.
	 * @param nextX next X location
	 * @param nextY next Y location
	 */
	public void updateMap(int nextX, int nextY) {
		openDoor(nextX, nextY);


	}
	/**
	 * Check if the map object is about to be deleted.
	 */
	public void finalize() {
		System.out.println("Map deleted");
	}
	/**
	 * Changes Cell access for certain cells based on location X and Y.
	 * @param nextX next X location
	 * @param nextY next Y location
	 */
	public void openDoor(int nextX, int nextY) {
		String cellName =this.getCell(nextX, nextY).getName();
		Cell nextCell = this.getCell(nextX, nextY);
		Player player = this.getPlayer1();

		if (cellName.equalsIgnoreCase("red door") && player.getRedKey() > 0) {
			nextCell.changePlayerPass();
			nextCell.changeEnemyPass();
			player.minusRedKey();
			
			playDoorNoise();
			
		} else if (cellName.equalsIgnoreCase("green door") && player.getGreenKey() > 0) {
			nextCell.changePlayerPass();
			nextCell.changeEnemyPass();
			player.minusGreenKey();
			
			playDoorNoise();
			
		} else if (cellName.equalsIgnoreCase("blue door") && player.getBlueKey() > 0) {
			nextCell.changePlayerPass();
			nextCell.changeEnemyPass();
			player.minusBlueKey();
			
			playDoorNoise();
			
		}else if (cellName.equalsIgnoreCase("token door") && player.getTokens() > 0 ) {
			nextCell.changePlayerPass();
			nextCell.changeEnemyPass();
			
			playDoorNoise();
			
		} else if (cellName.equalsIgnoreCase("2 door") && player.getTokens() > 1 ) {
			nextCell.changePlayerPass();
			nextCell.changeEnemyPass();
			
			playDoorNoise();
			
		} else if (cellName.equalsIgnoreCase("3 door") && player.getTokens() > 2 ) {
			nextCell.changePlayerPass();
			nextCell.changeEnemyPass();
			
			playDoorNoise();
			
			}
	}
	/**
	 * Plays music when door opens.
	 */
	private static void playDoorNoise() {
		String musicFileLocation = "./src/door_open.mp3";     

		Media doorSound = new Media(new File(musicFileLocation).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(doorSound);
		
		mediaPlayer.play();
	}
	/**
	 * Plays music when on water.
	 */
	private static void playWaterSound() {
		String musicFileLocation = "./src/water.mp3";     

		Media doorSound = new Media(new File(musicFileLocation).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(doorSound);
		
		mediaPlayer.play();
	}
	/**
	 * Plays music when on fire.
	 */
	private static void playFireSound() {
		String musicFileLocation = "./src/fire.mp3";     

		Media doorSound = new Media(new File(musicFileLocation).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(doorSound);
		
		mediaPlayer.play();
	}
	
	/**
	 * Check when player is on a specific cell.
	 * Then adds keys or tokens or teleports them somewhere
	 */
	public void doAction() {
		int playerXLocation = this.getPlayer1().getxLocation();
		int playerYLocation = this.getPlayer1().getyLocation();
		String cellName =this.getCell(playerXLocation, playerYLocation).getName();

		if (cellName.equalsIgnoreCase("red")) {
			this.replaceCell(playerXLocation, playerYLocation);
			this.getPlayer1().addRedKey();
		} else if (cellName.equalsIgnoreCase("blue")) {
			this.replaceCell(playerXLocation, playerYLocation);
			this.getPlayer1().addBlueKey();
		} else if (cellName.equalsIgnoreCase("green")) {
			this.replaceCell(playerXLocation, playerYLocation);
			this.getPlayer1().addGreenKey();
		} else if (cellName.equalsIgnoreCase("boots")) {
			this.replaceCell(playerXLocation, playerYLocation);
			this.getPlayer1().changeBoot();
		} else if (cellName.equalsIgnoreCase("flippers")) {
			this.replaceCell(playerXLocation, playerYLocation);
			this.getPlayer1().changeFlipper();
		} else if (cellName.equalsIgnoreCase("token")) {
			this.replaceCell(playerXLocation, playerYLocation);
			this.getPlayer1().addToken();
		} else if (cellName.equalsIgnoreCase("teleporter")) {
			this.getPlayer1().teleport();
		} else if (cellName.equalsIgnoreCase("red door")) {
			this.replaceCell(playerXLocation, playerYLocation);
		} else if (cellName.equalsIgnoreCase("blue door")) {
			this.replaceCell(playerXLocation, playerYLocation);
		} else if (cellName.equalsIgnoreCase("green door")) {
			this.replaceCell(playerXLocation, playerYLocation);
		} else if (cellName.equalsIgnoreCase("water")) {
			playWaterSound();
		} else if (cellName.equalsIgnoreCase("fire")) {
			playFireSound();
		}
	}
	//THIS WILL NEED CHANGING TO ACCOMODATE MORE ENEMIES
	/**
	 * Moves StraightLine enemy one step.
	 */
	public void StraightLineMove() {
		if (enemy1.getFacing() == 'u' || enemy1.getFacing() == 'd') {
			enemy1.moveY(enemy1.getXLocation(), enemy1.getYLocation(), enemy1.getFacing());
		} else {
			enemy1.moveX(enemy1.getXLocation(), enemy1.getYLocation(), enemy1.getFacing());
		}
	}
	/**
	 * Moves Dumb enemy one step.
	 */
	public void DumbMove() {
		this.dumbList.get(0).setPlayerx(this.player1.getxLocation());
		this.dumbList.get(0).setPlayery(this.player1.getyLocation());
		dumbList.get(0).move();
	}

	/**
	 * Moves Dumb enemy one step.
	 */
	public void WallFollowMove() {
		if (wallFollowList.get(0).getFacing() == 'u' || wallFollowList.get(0).getFacing() == 'd') {
			wallFollowList.get(0).moveY(wallFollowList.get(0).getXLocation(), wallFollowList.get(0).getYLocation(), wallFollowList.get(0).getFacing());
		} else {
			wallFollowList.get(0).moveX(wallFollowList.get(0).getXLocation(), wallFollowList.get(0).getYLocation(), wallFollowList.get(0).getFacing());
		}

	}
	
	
}


