package application;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*
* This class represents a token door at coordinates x and y
* @author Group 31 
* @version 3.0
*/
public class TokenDoor extends Cell {
	
	int tokensNeeded;

	/*
	* Creates a token door at the given x and y coordinates
	* @param name used to identify how many tokens it takes to open the token door
	* @param xCoordinate the x coordinate of a token door
	* @param yCoordinate the y coordinate of a token door
	*/
	public TokenDoor(String name, int xCoordinate, int yCoordinate) {
		
		super(name, xCoordinate, yCoordinate);
		
		this.playerPass = false;
		this.enemyPass = false;
		
		System.out.println(name);
		
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
	
	/*
	* Gets the image view of a token door
	* @param image viewer class type of a token door
	*/
	public ImageView getTokenDoorView() {
		
		return super.getView();
		
	}

}
