package application;

public class MapManager {
	
	private static MapManager onlyMapManager;
	private Map map;
	
	
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

}
