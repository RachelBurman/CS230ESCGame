package application;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Water extends Cell {

	public Water(String name, boolean playerPass, boolean enemyPass, int xCoordinate, int yCoordinate) {
		super(name, playerPass, enemyPass, xCoordinate, yCoordinate);
		// TODO Auto-generated constructor stub
		this.playerPass = playerPass;
		this.enemyPass = enemyPass;
		super.cellImage = new Image("https://cdn.cultofmac.com/wp-content/uploads/2018/10/IMG_2651-2.cc38d6cb8edf491d9d4ae92851be67a5-780x585.jpg");
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getWaterView() {
		
		return super.getView();
		
	}

}
