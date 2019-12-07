package application;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Door extends Cell {

	public Door(String name, int xCoordinate, int yCoordinate) {
		super(name, xCoordinate, yCoordinate);
		this.name = name;
		Image image = null;;
		this.playerPass = false;
		this.enemyPass = false;
		Image doorImage = null;
		if (name.equalsIgnoreCase("red door")) {
			File file = new File("./src/reddoor.png");
			doorImage = new Image(file.toURI().toString());
		} else if (name.equalsIgnoreCase("blue door")) {
			File file = new File("./src/bluedoor.png");
			doorImage = new Image(file.toURI().toString());
		} else if (name.equalsIgnoreCase("green door")) {
			File file = new File("./src/greendoor.png");
			doorImage = new Image(file.toURI().toString());
		}
		
		this.cellImage = doorImage;
		this.cellView = new ImageView(cellImage);
		this.cellView.setFitHeight(CELL_SIZE);
		this.cellView.setFitWidth(CELL_SIZE);
		// TODO Auto-generated constructor stub
	}

}