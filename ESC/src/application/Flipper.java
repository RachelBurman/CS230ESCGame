package application;

import javafx.scene.image.ImageView;

public class Flipper extends Cell{

	public Flipper() {
            super("https://cdn5.vectorstock.com/i/1000x1000/81/84/blue-flippers-icon-icon-cartoon-vector-13848184.jpg");
	}
	
	public ImageView getFlipperImage() {
		
		return super.getCellImage();
		
	}
}
