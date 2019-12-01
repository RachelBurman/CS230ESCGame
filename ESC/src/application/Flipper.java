package application;

import javafx.scene.image.ImageView;

public class Flipper extends Cell{

	public Flipper(String flipperImageLocation) {
            super(flipperImageLocation);
	}
	
	public ImageView getFlipperImage() {
		
		return super.getCellImage();
		
	}
}
