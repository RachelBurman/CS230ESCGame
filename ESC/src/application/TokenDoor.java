package application;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class contains all attributes and behaviours of Token Door.
 * 
 * @author Group 31
 * @version 3.0
 */
public class TokenDoor extends Cell {

	int tokensNeeded;

	/**
	 * Creates a token door at the given x and y coordinates.
	 * 
	 * @param name        Identifies how many tokens it takes to open the token
	 *                    door.
	 * @param xCoordinate The x coordinate of a token door.
	 * @param yCoordinate The y coordinate of a token door.
	 */
	public TokenDoor(String name, int xCoordinate, int yCoordinate) {

		super(name, xCoordinate, yCoordinate);

		this.playerPass = false;
		this.enemyPass = false;

		System.out.println(name);

		// Sets the door image based on how many tokens are required to open the door.
		File file = null;
		if (name.equals("token door")) {
			file = new File("./src/TokenDoor.jpg");
			tokensNeeded = 1;
		} else if (name.equals("2 door")) {
			file = new File("./src/Tokendoor2.jpg");
			tokensNeeded = 2;
		} else if (name.equals("3 door")) {
			file = new File("./src/Tokendoor3.jpg");
			tokensNeeded = 3;
		}

		Image cellImage = new Image(file.toURI().toString());
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);

	}

	/**
	 * Gets the image view of a token door.
	 * 
	 * @param image view of a token door.
	 */
	public ImageView getTokenDoorView() {

		return super.getView();

	}
}