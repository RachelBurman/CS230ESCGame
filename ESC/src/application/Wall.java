package application;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*
* This class represents a wall at coordinates x and y
* @author Group 31 
* @version 3.0
*/
public class Wall extends Cell{
	
	/*
	* Creates a wall at the given x and y coordinate
	* @param name the name of a wall cell
	* @param xCoordinate the x coordinate of a wall cell
	* @param yCoordinate the y coordinate of a wall cell
	*/
	public Wall (String name, int xCoordinate, int yCoordinate) {
		
		super(name, xCoordinate, yCoordinate);
		
		this.playerPass = false;
		this.enemyPass = false;
		
		File file = new File("./src/wall.jpg");
	  	Image image = new Image(file.toURI().toString());
	  	super.cellImage = image;
	  	super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	
	/*
	* Gets the image view of a wall cell
	* @return an image viewer class of a wall cell
	*/
	public ImageView getWallView() {
		
		return super.getView();
		
	}
	
}
