package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ground extends Cell{

	public Ground() {
            super("https://www.colorcombos.com/images/colors/999999.png");
	}
	
	public ImageView getGroundImage() {
		
		return super.getCellImage();
		
	}
}
