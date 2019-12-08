package application;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class represents a boot at coordinates x and y.
 * @author Group 31 
 * @version 2.0
 */
public class Boot extends Cell {

	/**
	 * Creates a boot to be displayed onto the game map.
	 * @param name name of the cell type.
	 * @param xCoordinate the x coordinate of a boot cell.
	 * @param yCoordinate the y coordinate of a boot cell.
	 */
	public Boot(String name, int xCoordinate, int yCoordinate) {

		super(name, xCoordinate, yCoordinate);

		//A player can pass through the cell but an enemy cannot.
		this.playerPass = true;
		this.enemyPass = false;

		//gets the image of a boot to display to the user
		File file = new File("./src/boot.jpg");
		Image cellImage = new Image(file.toURI().toString());
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);

	}

	/**
	 * Gets the image view class type of a boot cell to be displayed
	 * @return an image view with the given x and y coordinates
	 */
	public ImageView getBootView() {

		return super.getView();

	}

}
