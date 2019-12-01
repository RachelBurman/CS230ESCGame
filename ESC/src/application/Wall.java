package application;

import javafx.scene.image.ImageView;

public class Wall extends Cell {
	
	public Wall(String wallImageLocation) {
            
            super(wallImageLocation);
            
	}
	
	public ImageView getWallImage() {
		
		return super.getCellImage();
		
	}
}
