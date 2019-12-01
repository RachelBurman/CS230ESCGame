package application;

import javafx.scene.image.ImageView;

public class Boot extends Cell{

	public Boot(String bootImageLocation) {
            super(bootImageLocation);
	}
	
	public ImageView getBootImage() {
		
		return super.getCellImage();
		
	}
}
