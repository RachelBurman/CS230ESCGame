package application;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TokenDoor extends Cell {
	int tokensNeeded;

	public TokenDoor(String name, int xCoordinate, int yCoordinate) {
		super(name, xCoordinate, yCoordinate);
		this.playerPass = false;
		this.enemyPass = false;
		System.out.println(name);
		File file = null; 
		if (name.equals("token door")) {
			file = new File("ESC/src/TokenDoor.jpg");
			tokensNeeded = 1;
		} else if (name.equals("2 door")) {
			file = new File("ESC/src/Tokendoor2.jpg");
			tokensNeeded = 2;
		} else if (name.equals("3 door")) {
			file = new File("ESC/src/Tokendoor3.jpg");
			tokensNeeded = 3;
		}
		Image cellImage = new Image(file.toURI().toString());
		super.cellView = new ImageView(cellImage);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		
	}
	public ImageView getTokenDoorView() {
		
		return super.getView();
		
	}

}
