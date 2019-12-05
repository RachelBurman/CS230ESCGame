package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TokenDoor extends Cell {

	public TokenDoor(String name, int xCoordinate, int yCoordinate) {
		super(name, xCoordinate, yCoordinate);
		this.playerPass = false;
		this.enemyPass = false;
		super.cellImage = new Image("file:Tokendoor.jpg");
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getTokenDoorView() {
		
		return super.getView();
		
	}

}
