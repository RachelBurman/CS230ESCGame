package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Fire extends Cell {

	public Fire(String name, int xCoordinate, int yCoordinate) {
		super(name, xCoordinate, yCoordinate);
		this.playerPass = false;
		this.enemyPass = false;
		super.cellImage = new Image("https://png.pngtree.com/png-clipart/20190918/ourmid/pngtree-flaming-fire-3406488-png-image_1737532.jpg");
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getFireView() {
		
		return super.getView();
		
	}

}
