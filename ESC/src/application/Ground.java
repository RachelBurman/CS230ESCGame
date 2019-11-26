package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ground extends CellType{

	public Ground() {
            super.setImage("https://www.colorcombos.com/images/colors/999999.png");
	}
	
	public ImageView getGroundImage() {
		
		return super.getCellImage();
		
	}
}
