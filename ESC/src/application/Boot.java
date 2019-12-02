package application;

import javafx.scene.image.ImageView;

public class Boot extends Cell{

	public Boot() {
            super("http://pngimg.com/uploads/boots/boots_PNG7801.png");
	}
	
	public ImageView getBootImage() {
		
		return super.getCellImage();
		
	}
}
