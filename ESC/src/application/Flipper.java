package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Flipper extends Cell {

	public Flipper(String name, boolean playerPass, boolean enemyPass, int xCoordinate, int yCoordinate) {
		super(name, playerPass, enemyPass, xCoordinate, yCoordinate);
		this.playerPass = playerPass;
		this.enemyPass = enemyPass;
		super.cellImage = new Image("http://pngimg.com/uploads/flippers/flippers_PNG37472.png");
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getFlipperView() {
		
		return super.getView();
		
	}

}
