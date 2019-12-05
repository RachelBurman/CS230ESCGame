package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Goal extends Cell {

	public Goal(String name, int xCoordinate, int yCoordinate) {
		super(name, xCoordinate, yCoordinate);
		// TODO Auto-generated constructor stub
		this.playerPass = true;
		this.enemyPass = false;
		super.cellImage = new Image("file:goal.png");
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getGoalView() {
		
		return super.getView();
		
	}
}
