package application;

/**
 * This class contains all attributes and behaviours of Map Manager.
 * 
 * @author Group 31
 * @version 3.0
 */
public class MapManager {

	private static MapManager onlyMapManager;
	private Map map;

	/**
	 * Empty MapManager constructor.
	 */
	private MapManager() {

	}

	/**
	 * Make a map manager.
	 * 
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
	 * 
	 * @return map of game
	 */
	public Map getMap() {
		return this.map;
	}

	/**
	 * Set the map.
	 * 
	 * @param map of game
	 */
	public void setMap(Map map) {
		this.map = map;
	}

}
