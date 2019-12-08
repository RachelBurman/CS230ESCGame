package application;

import javafx.scene.layout.GridPane;

public class MapManager {
	
	private static MapManager onlyMapManager;
	private Map map;
	private GridPane grid =new GridPane();
	
	
	private MapManager() {
		
	}
	/**
	 * Make a map manager.
	 * @return a mapManager object
	 */
	public static MapManager sharedMapManager() {
		
		if (onlyMapManager == null) {
			onlyMapManager = new MapManager();
		}
		return onlyMapManager;
	}
	/**
	 * Return the map.
	 * @return map of game
	 */
	public Map getMap() {
		return this.map;
	}
	/**
	 * Set the map.
	 * @param map of game
	 */
	public void setMap(Map map) {
		this.map = map;
	}
	/**
	 * Returns GridPane of the game
	 * @return grid
	 */
	public GridPane getGrid() {
		return grid;
	}
	/***
	 * Set the GridPane of the game
	 * @param gridpane
	 */
	public void setGrid(GridPane grid) {
		this.grid = grid;
	}
	

}
