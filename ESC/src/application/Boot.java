package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Boot extends Cell {

	public Boot(String name, int xCoordinate, int yCoordinate) {
		super(name, xCoordinate, yCoordinate);
		this.playerPass = true;
		this.enemyPass = false;
		super.cellImage = new Image("file:boot.png");
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getBootView() {
		
		return super.getView();
		
	}

}
