package application;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Key extends Cell {

	public Key(String name, int xCoordinate, int yCoordinate) {
		super(name, xCoordinate, yCoordinate);
		// TODO Auto-generated constructor stub
		this.name = name;
		this.playerPass = true;
		this.enemyPass = false;
		Image keyImage = null;
		if (name.equalsIgnoreCase("red")) {
			File file = new File("ESC/src/redkey.png");
			keyImage = new Image(file.toURI().toString());
		} else if (name.equalsIgnoreCase("blue")) {
			File file = new File("ESC/src/bluekey.png");
			keyImage = new Image(file.toURI().toString());
		} else if (name.equalsIgnoreCase("green")) {
			File file = new File("ESC/src/greenkey.png");
			keyImage = new Image(file.toURI().toString());
		}
		super.cellImage = keyImage;
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getKeyView() {
		
		return super.getView();
		
	}
	

}
