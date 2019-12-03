package application;

import java.util.Arrays;

import moving.Player;
import moving.StraightLineEnemy;

public class Map {
	private Cell[][] mapActual;
	private int mapLength;
	private int mapHeight;
	private int start[];
	private Player player1;
	private StraightLineEnemy enemy1;
	
	
	public Map (String file) {
		this.mapActual=LevelLoader.loadLevel(file);
		this.start= LevelLoader.getPlayerStart(file);
		int size[] = LevelLoader.getSize(file);
		//Swaps for some reason
		this.mapHeight =size[1];
		this.mapLength = size[0];
		this.player1 = new Player("name",LevelLoader.getPlayerStart(file));
		this.enemy1 = new StraightLineEnemy("Straight enemy", LevelLoader.getStraightEnemy(file));
		
		
	}
	
	public void removeCell (Map map, int xLocation, int yLocation) {
		mapActual[xLocation][yLocation]= null;
		
	}
	public void addCell(Map mapActual, int xLocation, int yLocation) {
		this.mapActual[xLocation][yLocation] = new Cell("Cell", true, true, xLocation, yLocation);
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
	
	
	

}
