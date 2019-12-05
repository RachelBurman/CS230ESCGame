package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Door extends Cell {

	public Door(String name, int xCoordinate, int yCoordinate) {
		super(name, xCoordinate, yCoordinate);
		this.name = name;
		Image image = null;;
		this.playerPass = false;
		this.enemyPass = false;
		if (name.equalsIgnoreCase("red door")) {
			 image = new Image("file:reddoor.png");
		} else if (name.equalsIgnoreCase("blue door")) {
			image = new Image ("file:bluedoor.png");
		} else if (name.equalsIgnoreCase("green door")) {
			image = new Image ("file:greendoor.png");
		}
	    
		this.cellImage = image;
		this.cellView = new ImageView(cellImage);
		this.cellView.setFitHeight(CELL_SIZE);
		this.cellView.setFitWidth(CELL_SIZE);
		// TODO Auto-generated constructor stub
	}

}
