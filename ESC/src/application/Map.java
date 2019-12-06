package application;


import java.util.ArrayList;

import moving.DumbTargetingEnemy;
import moving.Player;
import moving.StraightLineEnemy;
import moving.WallFollowingEnemy;

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

	public DumbTargetingEnemy getDummieAt(int num) {
		return dumbList.get(num);

	}

	// New
	public WallFollowingEnemy getWallFollowAt(int num) {
		return wallFollowList.get(num);
	}


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



	public void setMapActual(Cell[][] mapActual) {
		this.mapActual = mapActual;
	}

	public void addPlayer(Player player) {
		this.player1 = player;
	}


	public void removeCell (Map map, int xLocation, int yLocation) {
		mapActual[xLocation][yLocation]= null;

	}

	public void removeCell (int xLocation, int yLocation) {
		mapActual[xLocation][yLocation]= null;

	}
	public void replaceCell(int xLocation, int yLocation) {
		removeCell(xLocation,yLocation);
		addCell(xLocation,yLocation);
	}

	public void addCell(int xLocation, int yLocation) {
		this.mapActual[xLocation][yLocation] = new Cell("Cell", xLocation, yLocation);
	}


	public Cell[][] getMapActual() {
		return mapActual;
	}


	public int getMapLength() {
		return mapLength;
	}


	public int getMapHeight() {
		return mapHeight;
	}


	public int[] getStart() {
		return start;
	}
	public Cell getCell(int x, int y) {

		return mapActual[x][y] ;
	}


	public Player getPlayer1() {
		return player1;
	}


	public StraightLineEnemy getEnemy1() {
		return enemy1;
	}

	public void updateMap(int nextX, int nextY) {
		openDoor(nextX, nextY);


	}
	public void finalize() {
		System.out.println("Map deleted");
	}

	public void openDoor(int nextX, int nextY) {
		String cellName =this.getCell(nextX, nextY).getName();
		Cell nextCell = this.getCell(nextX, nextY);
		Player player = this.getPlayer1();

		if (cellName.equalsIgnoreCase("red door") && player.getRedKey() > 0) {
			nextCell.changePlayerPass();
			nextCell.changeEnemyPass();
			player.minusRedKey();
		} else if (cellName.equalsIgnoreCase("green door") && player.getGreenKey() > 0) {
			nextCell.changePlayerPass();
			nextCell.changeEnemyPass();
			player.minusGreenKey();
		} else if (cellName.equalsIgnoreCase("blue door") && player.getBlueKey() > 0) {
			nextCell.changePlayerPass();
			nextCell.changeEnemyPass();
			player.minusBlueKey();
		} else if (cellName.equalsIgnoreCase("token door") && player.getTokens() == 2) {
			nextCell.changePlayerPass();
			nextCell.changeEnemyPass();
			player.takeTokens();
		}

	}
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
		}
	}
	//THIS WILL NEED CHANGING TO ACCOMODATE MORE ENEMIES
	public void StraightLineMove() {
		if (enemy1.getFacing() == 'u' || enemy1.getFacing() == 'd') {
			enemy1.moveY(enemy1.getXLocation(), enemy1.getYLocation(), enemy1.getFacing());
		} else {
			enemy1.moveX(enemy1.getXLocation(), enemy1.getYLocation(), enemy1.getFacing());
		}
	}

	public void DumbMove() {
		this.dumbList.get(0).setPlayerx(this.player1.getxLocation());
		this.dumbList.get(0).setPlayery(this.player1.getyLocation());
		dumbList.get(0).move();
	}

	// NEW
	public void WallFollowMove() {
		if (wallFollowList.get(0).getFacing() == 'u' || wallFollowList.get(0).getFacing() == 'd') {
			wallFollowList.get(0).moveY(wallFollowList.get(0).getXLocation(), wallFollowList.get(0).getYLocation(), wallFollowList.get(0).getFacing());
		} else {
			wallFollowList.get(0).moveX(wallFollowList.get(0).getXLocation(), wallFollowList.get(0).getYLocation(), wallFollowList.get(0).getFacing());
		}

	}
}


