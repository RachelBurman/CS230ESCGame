package application;

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
			 image = new Image("file:redkey.png");
		} else if (name.equalsIgnoreCase("blue")) {
			image = new Image ("file:bluekey.png");
		} else if (name.equalsIgnoreCase("green")) {
			image = new Image ("file:greenkey.png");
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
