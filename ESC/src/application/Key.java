package application;

import javafx.scene.image.ImageView;

public class Key extends Cell{

	public Key(String keyImageLocation) {
            super(keyImageLocation);
	}
	
	public ImageView getKeyImage() {
		
		return super.getCellImage();
		
	}
}
