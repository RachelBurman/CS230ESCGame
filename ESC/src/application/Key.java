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
		Image image = null;
		if (name.equalsIgnoreCase("red")) {
			File file = new File("./src/redkey.png");
		Image cellImage = new Image(file.toURI().toString());
		} else if (name.equalsIgnoreCase("blue")) {
			File file = new File("./src/bluekey.png");
		Image cellImage = new Image(file.toURI().toString());
		} else if (name.equalsIgnoreCase("green")) {
			File file = new File("./src/greenkey.png");
		Image cellImage = new Image(file.toURI().toString());
		}
		super.cellImage = image;
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getFireView() {
		
		return super.getView();
		
	}
	

}
