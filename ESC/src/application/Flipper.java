package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Flipper extends Cell {

	public Flipper(String name, int xCoordinate, int yCoordinate) {
		super(name, xCoordinate, yCoordinate);
		this.playerPass = true;
		this.enemyPass = false;
		super.cellImage = new Image("file:flipper.png");
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getFlipperView() {
		
		return super.getView();
		
	}

}
