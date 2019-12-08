package application;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class contains all attributes and behaviours of Key.
 * @author Group 31 
 * @version 3.0
 */
public class Key extends Cell {

	/**
	 * Constructor of Key.
	 * Creates a key at the given x and y coordinates.
	 * @param name The name of a key used to identify which door the key opens.
	 * @param xCoordiante The x coordinate of a key cell.
	 * @param yCoordinate The y coordinate of a key cell.
	 */
	public Key(String name, int xCoordinate, int yCoordinate) {

		super(name, xCoordinate, yCoordinate);

		this.name = name;
		this.playerPass = true;
		this.enemyPass = false;

		//sets the right image for a key depending on what colour door the key opens
		Image keyImage = null;
		if (name.equalsIgnoreCase("red")) {
			File file = new File("./src/redkey.png");
			keyImage = new Image(file.toURI().toString());
		} else if (name.equalsIgnoreCase("blue")) {
			File file = new File("./src/bluekey.png");
			keyImage = new Image(file.toURI().toString());
		} else if (name.equalsIgnoreCase("green")) {
			File file = new File("./src/greenkey.png");
			keyImage = new Image(file.toURI().toString());
		}

		super.cellImage = keyImage;
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);

	}

	/**
	 * Gets the image view of a key cell.
	 * @return The image view of a key cell.
	 */
	public ImageView getKeyView() {

		return super.getView();

	}
}
