package moving;


import application.Cell;
import application.Map;
import javafx.scene.image.Image;

import javafx.scene.image.Image;
public abstract class Movable {
	protected String name;
	protected int xLocation;
	protected int yLocation;
	protected Map map;
	final int CELL_SIZE= 50;
	
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
	
	
	public int moveY(int currentYLocation) {
		return currentYLocation;
		
	}
	
	public int moveX(int currentXLocation) {
		return currentXLocation;
	}
	
	public void setMap (Map map) {
		this.map = map;
	}
	
	
	
}
