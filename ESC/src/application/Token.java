package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Token extends Cell {

	public Token(String name, int xCoordinate, int yCoordinate) {
		super(name, xCoordinate, yCoordinate);
		this.playerPass = true;
		this.enemyPass = false;
		super.cellImage = new Image("file:Token.png");
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getTokenView() {
		
		return super.getView();
		
	}

}
