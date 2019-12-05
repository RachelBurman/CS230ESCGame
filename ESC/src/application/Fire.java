package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Fire extends Cell {

	public Fire(String name, int xCoordinate, int yCoordinate) {
		super(name, xCoordinate, yCoordinate);
		this.playerPass = false;
		this.enemyPass = false;
		super.cellImage = new Image("file:fire.png");
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getFireView() {
		
		return super.getView();
		
	}

}
