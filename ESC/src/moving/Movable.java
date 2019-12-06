package moving;


import application.Cell;
import application.Map;
import javafx.scene.image.Image;
public abstract class Movable {
	protected String name;
	protected int xLocation;
	protected int yLocation;
	protected Cell[][] mapActual;
	protected Map map;
	final int CELL_SIZE= 50;
	protected char facing;
	
	public Movable(String name, Cell[][] mapActual) {
		this.name = name;
		this.mapActual = mapActual;
	}
	public void setMapActual(Cell[][] mapActual) {
		this.mapActual=mapActual;
	}
	
	
	public Cell[][] getMapActual() {
		return mapActual;
	}
	public int getXLocation() {
		return xLocation;
	}
	public void setXLocation(int xLocation) {
		this.xLocation = xLocation;
	}
	public int getYLocation() {
		return yLocation;
	}
	public void setYLocation(int currentYLocation) {
		this.yLocation = yLocation;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void moveUp() {
		if (validMove(xLocation, yLocation-1)) {
			this.yLocation = yLocation-1;
			this.facing = 'u';
		}
	}
	
	public void moveDown() {
		if (validMove(xLocation, yLocation+1)) {
			this.yLocation = yLocation+1;
			this.facing = 'd';
		}
	}
	public void moveRight() {
		if (validMove(xLocation+1, yLocation)) {
			this.xLocation = xLocation+1;
			this.facing = 'r';
		}
	}
	
	public void moveLeft() {
		if (validMove(xLocation-1, yLocation)) {
			this.xLocation = xLocation-1;
			this.facing = 'l';
		}
	}
	
	
	protected boolean validMove(int newXLocation, int newYLocation) {
		if (mapActual[newXLocation][newYLocation].getPlayerPass()) {
			return true;
			} else {
				return false;
			}
	}
	
	
	
}
