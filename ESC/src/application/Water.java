package application;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
* This class represents a water cell at coordinates x and y.
* @author Group 31 
* @version 2.0
*/
public class Water extends Cell {

	/**
	* Creates a water cell at the given x and y coordinates.
	* @param name the name of a water cell.
	* @param xCoordinate the x coordinate of a water cell.
	* @param yCoordinate the y coordinate of a water cell.
	*/
	public Water(String name,int xCoordinate, int yCoordinate) {
		
		super(name,xCoordinate, yCoordinate);

		this.playerPass = true;
		this.enemyPass = false;
		
		File file = new File("./src/water.jpg");
		Image cellImage = new Image(file.toURI().toString());
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	
	/**
	* Gets the image view of a water cell.
	* @return an image viewer class of a water cell.
	*/
	public ImageView getWaterView() {
		
		return super.getView();
		
	}

}
