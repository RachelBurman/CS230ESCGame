package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Goal extends Cell {
	
	
	public Goal() {
				
		super.setImage("gate.png");
		
	}	
		
		public ImageView getGoalImage() {
			
			return super.getCellImage();
	}

}
