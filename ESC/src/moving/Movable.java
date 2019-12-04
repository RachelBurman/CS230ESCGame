package moving;


import application.Cell;
import application.Map;
import javafx.scene.image.Image;
public abstract class Movable {
	protected String name;
	protected int xLocation;
	protected int yLocation;
	protected Map map;
	final int CELL_SIZE= 32;
	
	public Movable(String name) {
		this.name = name;
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
	
	
	public void moveUp() {
		if (validMove(xLocation, yLocation-1, map )) {
			this.yLocation = yLocation-1;
		}
	}
	
	public void moveDown() {
		if (validMove(xLocation, yLocation+1, map )) {
			this.yLocation = yLocation+1;
		}
	}
	public void moveRight() {
		if (validMove(xLocation+1, yLocation, map )) {
			this.xLocation = xLocation+1;
		}
	}
	
	public void moveLeft() {
		if (validMove(xLocation-1, yLocation, map )) {
			this.xLocation = xLocation-1;
		}
	}
	public void setMap (Map map) {
		this.map = map;
	}
	
	protected boolean validMove(int newXLocation, int newYLocation, Map map) {
		if (map.getCell(newXLocation, newYLocation).getPlayerPass()) {
			return true;
			} else {
				return false;
			}
	}
	
	
	
}
