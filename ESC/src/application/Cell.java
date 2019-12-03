package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cell {
	String name;
	Image cellImage;
	ImageView cellView;
	final int CELL_SIZE= 50;
	int xCoordinate;
	int yCoordinate;
	boolean playerPass;
	boolean enemyPass;
	
	public Cell(String name, boolean playerPass, boolean enemyPass, int xCoordinate, int yCoordinate ) {
		this.name = name;
		this.playerPass = playerPass;
		this.enemyPass = enemyPass;
	    Image image = new Image("https://www.colorcombos.com/images/colors/999999.png");
		this.cellImage = image;
		this.cellView = new ImageView(cellImage);
		this.cellView.setFitHeight(CELL_SIZE);
		this.cellView.setFitWidth(CELL_SIZE);
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
	
	public void setCellImage(Image cellImage) {
		this.cellImage = cellImage;
	}

	public void setCellView(ImageView cellView) {
		this.cellView = cellView;
	}

	public Image getImage( ) {
		return this.cellImage;
	}
	public ImageView getView( ) {
		return this.cellView;
	}
	
	public boolean getPlayerPass () {
		return this.playerPass;
	}
	public boolean getEnemyPass () {
		return this.enemyPass;
	}

	public int getCELL_SIZE() {
		return CELL_SIZE;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}
	
}
