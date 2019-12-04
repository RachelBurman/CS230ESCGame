package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Wall extends Cell{
	
	public Wall (String name, boolean playerPass,boolean enemyPass, int xCoordinate, int yCoordinate) {
		super(name, playerPass, enemyPass, xCoordinate, yCoordinate);
		this.playerPass = playerPass;
		this.enemyPass = enemyPass;
	    super.cellImage = new Image("https://img.theculturetrip.com/768x432/wp-content/uploads/2018/03/c8dad0.jpg");
	    super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getWallView() {
		
		return super.getView();
		
	}
	

}
