package application;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Water extends Cell {

	public Water(String name,int xCoordinate, int yCoordinate) {
		super(name,xCoordinate, yCoordinate);
		// TODO Auto-generated constructor stub
		this.playerPass = false;
		this.enemyPass = false;
		super.cellImage = new Image("file:water.jpg");
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getWaterView() {
		
		return super.getView();
		
	}

}
