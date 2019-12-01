package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ground extends Cell{

	public Ground(String groundImageLocation) {
            super(groundImageLocation);
	}
	
	public ImageView getGroundImage() {
		
		return super.getCellImage();
		
	}
}
