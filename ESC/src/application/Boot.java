package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Boot extends Cell {

	public Boot(String name, int xCoordinate, int yCoordinate) {
		super(name, xCoordinate, yCoordinate);
		this.playerPass = true;
		this.enemyPass = false;
		super.cellImage = new Image("https://images.timberland.com/is/image/TimberlandEU/A1RRK929-hero?wid=720&hei=720&fit=constrain,1&qlt=85,1&op_usm=1,1,6,0");
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getBootView() {
		
		return super.getView();
		
	}

}
