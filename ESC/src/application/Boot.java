package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Boot extends Cell {

	public Boot(String name, boolean playerPass, boolean enemyPass, int xCoordinate, int yCoordinate) {
		super(name, playerPass, enemyPass, xCoordinate, yCoordinate);
		this.playerPass = playerPass;
		this.enemyPass = enemyPass;
		super.cellImage = new Image("https://pngriver.com/wp-content/uploads/2017/11/Boots-shoe-free-PNG-transparent-background-images-free-download-clipart-pics-Boot-PNG-Picture.png");
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getBootView() {
		
		return super.getView();
		
	}

}
