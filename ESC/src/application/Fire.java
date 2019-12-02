package application;

import javafx.scene.image.ImageView;

public class Fire extends Cell{

	public Fire() {
            super("https://png.pngtree.com/png-clipart/20190918/ourmid/pngtree-flaming-fire-3406488-png-image_1737532.jpg");
	}
	
	public ImageView getFireImage() {
		
		return super.getCellImage();
		
	}
}
