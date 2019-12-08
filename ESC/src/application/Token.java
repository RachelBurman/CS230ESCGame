package application;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
* This class represents a token at coordinates x and y.
* @author Group 31 
* @version 2.0
*/
public class Token extends Cell {

	/**
	* Creates a token at the given x and y coordinates.
	* @param name the name of a token.
	* @param xCoordinate the x coordinate of a token cell.
	* @param yCoordinate the y coordinate of a token cell.
	*/
	public Token(String name, int xCoordinate, int yCoordinate) {
		super(name, xCoordinate, yCoordinate);
		this.playerPass = true;
		this.enemyPass = false;
		File file = new File("./src/Token.png");
		Image cellImage = new Image(file.toURI().toString());
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	
	/**
	* Gets the image view of a token.
	* @return the image viewer cell type of a token.
	*/
	public ImageView getTokenView() {
		
		return super.getView();
		
	}

}
