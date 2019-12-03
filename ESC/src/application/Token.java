package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Token extends Cell {

	public Token(String name, boolean playerPass, boolean enemyPass, int xCoordinate, int yCoordinate) {
		super(name, playerPass, enemyPass, xCoordinate, yCoordinate);
		this.playerPass = playerPass;
		this.enemyPass = enemyPass;
		super.cellImage = new Image("https://en.numista.com/catalogue/photos/tokens/52600-original.jpg");
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getTokenView() {
		
		return super.getView();
		
	}

}
