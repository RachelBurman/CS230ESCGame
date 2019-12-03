package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TokenDoor extends Cell {

	public TokenDoor(String name, boolean playerPass, boolean enemyPass, int xCoordinate, int yCoordinate) {
		super(name, playerPass, enemyPass, xCoordinate, yCoordinate);
		this.playerPass = playerPass;
		this.enemyPass = enemyPass;
		super.cellImage = new Image("https://banner2.cleanpng.com/20180406/spq/kisspng-door-window-clip-art-open-door-5ac7f9c927a797.2690502815230550491624.jpg");
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getTokenDoorView() {
		
		return super.getView();
		
	}

}
