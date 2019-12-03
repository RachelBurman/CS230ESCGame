package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Door extends Cell {

	public Door(String name, boolean playerPass, boolean enemyPass, int xCoordinate, int yCoordinate) {
		super(name, playerPass, enemyPass, xCoordinate, yCoordinate);
		this.name = name;
		this.playerPass = playerPass;
		this.enemyPass = enemyPass;
	    Image image = new Image("https://windowsupplydirectltd.co.uk/wp-content/uploads/2017/10/TR04-Cezanne-signal-red.jpg");
		this.cellImage = image;
		this.cellView = new ImageView(cellImage);
		this.cellView.setFitHeight(CELL_SIZE);
		this.cellView.setFitWidth(CELL_SIZE);
		// TODO Auto-generated constructor stub
	}

}