package application;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
* This class represents a teleporter at coordinates x and y.
* @author Group 31 
* @version 5.0
*/
public class Teleporter extends Cell {
	int linkX;
	int linkY;
	/**
	* Creates a teleporter at the given x and y coordinates.
	* @param name the name of the teleporter.
	* @param xCoordinate the x coordinate of a teleporter.
	* @param yCoordinate the y coordinate of a teleporter.
	* @param file the file name of the level the teleporter is located in.
	*/
	public Teleporter(String name,int xCoordinate, int yCoordinate, String file) {
		
		super(name, xCoordinate, yCoordinate);
		//gets the link data from the level
		int info[] =LevelLoader.getTeleporter(file);
		this.playerPass = true;
		this.enemyPass = false;
		File fileA = new File("./src/teleporter.png");
		Image image = new Image(fileA.toURI().toString());
		super.cellView = new ImageView(image);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		//sets the link data so when a player lands on the teleporter they go to the right location
		if (info[0]==xCoordinate && info[1] == yCoordinate) {
			super.linkX = info[2];
			super.linkY = info[3];
			this.linkX = info [2];
			this.linkY = info[3];
		} else {
			super.linkX = info[0];
			super.linkY = info[1];
			this.linkX = info [0];
			this.linkY = info[1];
		}

	}

}
