package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Cell {

	Image cellImage;
	ImageView cellImage2;
	
	public Cell(String cellImageLocation) {
		//Pane pane = new HBox(15);
		this.cellImage = new Image(cellImageLocation);
		this.cellImage2 = new ImageView(cellImage);
		this.cellImage2.setFitHeight(32);
		this.cellImage2.setFitWidth(32);
		//pane.getChildren().add(cellImage2);
	}
	
	public ImageView getCellImage() {
		
		return this.cellImage2;
		
	}
}
