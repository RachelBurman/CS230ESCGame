package application;

import javafx.scene.image.ImageView;

public class Token extends Cell{

	public Token() {
            super("https://img.pngio.com/token-png-1-png-image-token-png-300_277.png");
	}
	
	public ImageView getTokenImage() {
		
		return super.getCellImage();
		
	}
}
