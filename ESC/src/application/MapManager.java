package application;

import javafx.scene.layout.GridPane;

public class MapManager {
	
	private static MapManager onlyMapManager;
	private Map map;
	private GridPane grid =new GridPane();
	
	
	private MapManager() {
		
	}
	
	public static MapManager sharedMapManager() {
		
		if (onlyMapManager == null) {
			onlyMapManager = new MapManager();
		}
		return onlyMapManager;
	}
	
	public Map getMap() {
		return this.map;
	}
	
	public void setMap(Map map) {
		this.map = map;
	}

	public GridPane getGrid() {
		return grid;
	}

	public void setGrid(GridPane grid) {
		this.grid = grid;
	}
	

}
