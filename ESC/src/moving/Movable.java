package moving;


import application.Cell;
import javafx.scene.image.Image;

public class Movable extends Cell {
	int currentXLocation;
	int currentYLocation;
	
	public Movable (String movableImageLocation, int currentXLocation, int currentYLocation) {
		super(movableImageLocation);
		this.currentXLocation = currentXLocation;
		this.currentYLocation = currentYLocation;

	}
	
	public int getCurrentXLocation() {
		return currentXLocation;
	}
	public void setCurrentXLocation(int currentXLocation) {
		this.currentXLocation = currentXLocation;
	}
	public int getCurrentYLocation() {
		return currentYLocation;
	}
	public void setCurrentYLocation(int currentYLocation) {
		this.currentYLocation = currentYLocation;
	}
	
	/*
	public Movable(int currentXLocation, int currentYLocation) {
		this.currentXLocation = currentXLocation;
		this.currentYLocation = currentYLocation;
		
		
		// TODO Auto-generated constructor stub
	}
	*/
	
	
	
	
}
