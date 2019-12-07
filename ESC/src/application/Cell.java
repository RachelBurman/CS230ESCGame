package application;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cell {
	String name;
	Image cellImage;
	ImageView cellView;
	final int CELL_SIZE= 75;
	int xCoordinate;
	int yCoordinate;
	boolean playerPass;
	boolean enemyPass;
	int linkX;
	int linkY;
	
	public Cell(String name, int xCoordinate, int yCoordinate ) {
		this.name = name;
		this.playerPass = true;
		this.enemyPass = true;
		//https://www.colorcombos.com/images/colors/999999.png
		File file = new File("./src/Default.jpg");
		Image image = new Image(file.toURI().toString());
		this.cellImage = image;
		this.cellView = new ImageView(cellImage);
		this.cellView.setFitHeight(CELL_SIZE);
		this.cellView.setFitWidth(CELL_SIZE);
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
	public int getLinkX() {
		return linkX;
	}


	public void setLinkX(int linkX) {
		this.linkX = linkX;
	}


	public int getLinkY() {
		return linkY;
	}


	public void setLinkY(int linkY) {
		this.linkY = linkY;
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


	public String getName() {
		return name;
	}
	
	public void changePlayerPass() {
		this.playerPass = true;
		
	}
	public void changeEnemyPass() {
		this.enemyPass = true;
		
	}
	
}
