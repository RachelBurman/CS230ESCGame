package moving;

import application.Cell;
import application.Map;

/**
 * This class represents all attributes and behaviours of Movable.
 * @author Group 31
 * @version 3.0
 */
public abstract class Movable {
	protected String name;
	protected int xLocation;
	protected int yLocation;
	protected Cell[][] mapActual;
	protected Map map;
	protected static final int CELL_SIZE= 70;
	protected char facing;

	/**
	 * Constructor of Movable cell.
	 * @param name The name of the Movable Cell.
	 * @param mapActual The map of the Movable Cell.
	 */
	public Movable(String name, Cell[][] mapActual) {
		this.name = name;
		this.mapActual = mapActual;
	}

	/**
	 * Setter method for the map of Movable cell.
	 * @param mapActual The map of Movable cell.
	 */
	public void setMapActual(Cell[][] mapActual) {
		this.mapActual = mapActual;
	}

	/**
	 * Getter method for the map of Movable cell.
	 * @return The map of Movable Cell.
	 */
	public Cell[][] getMapActual() {
		return mapActual;
	}

	/**
	 * Getter method for the x coordinate of Movable Cell.
	 * @return The x coordinate of Movable Cell.
	 */
	public int getXLocation() {
		return xLocation;
	}

	/**
	 * Setter method for the x coordinate of Movable Cell.
	 * @param xLocation The x coordinate for Movable Cell.
	 */
	public void setXLocation(int xLocation) {
		this.xLocation = xLocation;
	}

	/**
	 * Getter method for y coordinate of Movable Cell.
	 * @return The y coordinate of the Movable Cell.
	 */
	public int getYLocation() {
		return yLocation;
	}

	/**
	 * Setter method for y coordinate of Movable Cell.
	 * @param yLocation The y coordinate of the Movable Cell.
	 */
	public void setYLocation(int yLocation) {
		this.yLocation = yLocation;
	}

	/**
	 * Getter method for the name of Movable Cell.
	 * @return The name of Movable Cell.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for the name of Movable Cell.
	 * @param name The name of Movable Cell.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method that moves Movable up if it's valid to do so.
	 */
	public void moveUp() {
		if (validMove(xLocation, yLocation-1)) {
			this.yLocation = yLocation-1;
			this.facing = 'u';
		}
	}

	/**
	 * Method that moves Movable down if it's valid to do so.
	 */
	public void moveDown() {
		if (validMove(xLocation, yLocation+1)) {
			this.yLocation = yLocation+1;
			this.facing = 'd';
		}
	}

	/**
	 * Method that moves Movable right if it's valid to do so.
	 */
	public void moveRight() {
		if (validMove(xLocation+1, yLocation)) {
			this.xLocation = xLocation+1;
			this.facing = 'r';
		}
	}

	/**
	 * Method that moves Movable left if it's valid to do so.
	 */
	public void moveLeft() {
		if (validMove(xLocation-1, yLocation)) {
			this.xLocation = xLocation-1;
			this.facing = 'l';
		}
	}

	/**
	 * Method that checks whether valid to move in certain direction.
	 * @param newXLocation The x coordinate of cell we're checking.
	 * @param newYLocation The y coordinate of cell we're checking
	 * @return
	 */
	protected boolean validMove(int newXLocation, int newYLocation) {
		if (mapActual[newXLocation][newYLocation].getPlayerPass()) {
			return true;
		} else {
			return false;
		}
	}
}
