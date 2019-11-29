package application;

import javafx.scene.image.ImageView;

public class Wall extends Cell {
	
	public Wall() {
            
            super.setImage("https://images.unsplash.com/photo-1520758594221-872948699332?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
            
	}
	
	public ImageView getWallImage() {
		
		return super.getCellImage();
		
	}
}
