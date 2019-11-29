package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Door extends Cell {
	
	Image DoorColour;
	ImageView DoorColour2;
	
	
	public Door() { 
		
		super.setImage("red door.jpg, green door.jpg, yellow door.jpg, blue door.jpg");
		
	}
	
	public ImageView getGoalImage() {
		
		return super.getCellImage();
	}

}

