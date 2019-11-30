package application;

import javafx.scene.image.ImageView;

public class Key extends Cell{

	public Key() {
            super("http://www.pngmart.com/files/8/Key-PNG-Free-Image-1.png");
	}
	
	public ImageView getFlipperImage() {
		
		return super.getCellImage();
		
	}
}
