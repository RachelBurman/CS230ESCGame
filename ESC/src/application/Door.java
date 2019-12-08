package application;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class contains all attributes and behaviours of Door.
 * @author Group 31 
 * @version 2.0
 */
public class Door extends Cell {

	/**
	 * Constructor for Door class.
	 * Creates a door at the given x and y coordinates.
	 * @param name The colour code of a door.
	 * @param xCoordinate The x coordinate of a door cell.
	 * @param yCoordinate The y coordinate of a door cell.
	 */
	public Door(String name, int xCoordinate, int yCoordinate) {

		super(name, xCoordinate, yCoordinate);

		this.name = name;
		Image image = null;;
		this.playerPass = false;
		this.enemyPass = false;

		//gets the right image of a door depending on what colour door it is
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
		this.cellView = new ImageView(doorImage);
		this.cellView.setFitHeight(CELL_SIZE);
		this.cellView.setFitWidth(CELL_SIZE);

	}

}
