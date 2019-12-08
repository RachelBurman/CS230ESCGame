package application;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class contains all attributes and behaviours of Flipper.
 * @author Group 31 
 * @version 2.0
 */
public class Flipper extends Cell {

	/**
	 * Constructor of Flipper cell.
	 * Creates a flipper at the given x and y coordinates.
	 * @param name The name of a flipper.
	 * @param xCoordinate The x coordinate of a flipper cell.
	 * @param yCoordinate The y coordinate of a flipper cell.
	 */
	public Flipper(String name, int xCoordinate, int yCoordinate) {

		super(name, xCoordinate, yCoordinate);

		this.playerPass = true;
		this.enemyPass = false;
		File file = new File("./src/flipper.png");
		Image cellImage = new Image(file.toURI().toString());

		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);

	}

	/**
	 * Gets the image view of a flipper cell.
	 * @return A image view of flipper cell.
	 */
	public ImageView getFlipperView() {

		return super.getView();

	}

}
