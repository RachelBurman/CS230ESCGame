package application;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
* This class represents a fire cell at coordinates x and y.
* @author Group 31 
* @version 2.0
*/
public class Fire extends Cell {

	/**
	* Creates a fire cell at the given x and y coordinates.
	* @param name the name of the cell.
	* @param xCoordinate the x coordinate of a fire cell.
	* @param yCoordinate the y coordinate of a fire cell.
	*/
	public Fire(String name, int xCoordinate, int yCoordinate) {
		
		super(name, xCoordinate, yCoordinate);
		
		this.playerPass = true;
		this.enemyPass = false;
		File file = new File("./src/fire.png");
		Image cellImage = new Image(file.toURI().toString());
		
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	
	/**
	* Gets the image view of a fire cell.
	* @return the image viewer class type of a fire cell.
	*/
	public ImageView getFireView() {
		
		return super.getView();
		
	}

}
