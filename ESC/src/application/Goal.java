package application;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class contains all attributes and behaviours of Goal.
 * @author Group 31 
 * @version 4.0
 */
public class Goal extends Cell {

	/**
	 * Constructor of Goal cell.
	 * Creates a Goal cell at the given x and y coordinates.
	 * @param name The name of a goal cell.
	 * @param xCoordinate The x coordinate of a goal cell.
	 * @param yCoordinate The y coordinate of a goal cell.
	 */
	public Goal(String name, int xCoordinate, int yCoordinate) {

		super(name, xCoordinate, yCoordinate);

		this.playerPass = true;
		this.enemyPass = false;

		File file = new File("./src/goal.png");
		Image cellImage = new Image(file.toURI().toString());

		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);

	}

	/**
	 * Gets the image view of a goal cell.
	 * @return An image view of a goal cell.
	 */
	public ImageView getGoalView() {

		return super.getView();

	}

}
