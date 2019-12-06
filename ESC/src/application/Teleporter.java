package application;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Teleporter extends Cell {
	int linkX;
	int linkY;
	public Teleporter(String name,int xCoordinate, int yCoordinate, String file) {
		
		super(name, xCoordinate, yCoordinate);
		int info[] =LevelLoader.getTeleporter(file);
		this.playerPass = true;
		this.enemyPass = false;
		File fileA = new File("ESC/src/teleporter.png");
		Image image = new Image(fileA.toURI().toString());
		super.cellView = new ImageView(image);
		super.cellView.setFitHeight(CELL_SIZE);
		super.cellView.setFitWidth(CELL_SIZE);
		//Weird behaviour can't this.LinkX/Y use this, as  Cell [][] cannot access this.linkX/Y as it's superclass
		if (info[0]==xCoordinate && info[1] == yCoordinate) {
			super.linkX = info[2];
			super.linkY = info[3];
			this.linkX = info [2];
			this.linkY = info[3];
		} else {
			super.linkX = info[0];
			super.linkY = info[1];
			this.linkX = info [0];
			this.linkY = info[1];
		}
		// TODO Auto-generated constructor stub
	}
	

}
