package moving;

import javafx.scene.image.Image;
public class Movable {
	int currentXLocation;
	int currentYLocation;
	Image image;
	
	
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
	public Movable(int currentXLocation, int currentYLocation) {
		this.currentXLocation = currentXLocation;
		this.currentYLocation = currentYLocation;
		
		
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}