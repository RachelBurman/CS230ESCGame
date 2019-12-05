package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Wall extends Cell{
	
	public Wall (String name, int xCoordinate, int yCoordinate) {
		super(name, xCoordinate, yCoordinate);
		this.playerPass = false;
		this.enemyPass = false;
	    super.cellImage = new Image("file:wall.jpg");
	    super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getWallView() {
		
		return super.getView();
		
	}
	

}
