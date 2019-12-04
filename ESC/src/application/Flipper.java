package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Flipper extends Cell {

	public Flipper(String name, boolean playerPass, boolean enemyPass, int xCoordinate, int yCoordinate) {
		super(name, playerPass, enemyPass, xCoordinate, yCoordinate);
		this.playerPass = playerPass;
		this.enemyPass = enemyPass;
		super.cellImage = new Image("https://images-na.ssl-images-amazon.com/images/I/51mQCH%2BavOL._SX425_.jpg");
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getFlipperView() {
		
		return super.getView();
		
	}

}
