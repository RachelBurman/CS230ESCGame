package application;

import javafx.scene.image.ImageView;

public class Fire extends Cell{

	public Fire(String fireImageLocation) {
            super(fireImageLocation);
	}
	
	public ImageView getFireImage() {
		
		return super.getCellImage();
		
	}
}
