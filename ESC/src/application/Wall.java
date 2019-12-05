package application;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Wall extends Cell{
	
	public Wall (String name, int xCoordinate, int yCoordinate) {
		super(name, xCoordinate, yCoordinate);
		this.playerPass = false;
		this.enemyPass = false;
		File file = new File("./src/Wall.jpg");
	  Image image = new Image(file.toURI().toString());
	  super.cellImage = image;
	  super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getWallView() {
		
		return super.getView();
		
	}
	

}
