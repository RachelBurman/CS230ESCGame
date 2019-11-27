package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Goal extends CellType {
	
	
	public Goal() {
				
		super.setImage("gate.png");
		
	}	
		
		public ImageView getGoalImage() {
			
			return super.getCellImage();
	}

}
