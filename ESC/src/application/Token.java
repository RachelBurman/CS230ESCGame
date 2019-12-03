package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Token extends Cell {

	public Token(String name, boolean playerPass, boolean enemyPass, int xCoordinate, int yCoordinate) {
		super(name, playerPass, enemyPass, xCoordinate, yCoordinate);
		this.playerPass = playerPass;
		this.enemyPass = enemyPass;
		super.cellImage = new Image("https://img.pngio.com/token-png-1-png-image-token-png-300_277.png");
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getTokenView() {
		
		return super.getView();
		
	}

}
