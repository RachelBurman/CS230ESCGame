package application;

import javafx.scene.image.ImageView;

public class Token extends Cell{

	public Token(String tokenImageLocation) {
            super(tokenImageLocation);
	}
	
	public ImageView getTokenImage() {
		
		return super.getCellImage();
		
	}
}
