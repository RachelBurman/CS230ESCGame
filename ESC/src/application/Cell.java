package application;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class contains all attributes and behaviours of Cell.
 * 
 * @author Group 31
 * @version 3.0
 */
public class Cell {
	// protected as the subclasses of cell require to use these variables.
	protected String name;
	protected Image cellImage;
	protected ImageView cellView;
	protected static final int CELL_SIZE = 70;
	protected int xCoordinate;
	protected int yCoordinate;
	protected boolean playerPass;
	protected boolean enemyPass;
	protected int linkX;
	protected int linkY;

	/**
	 * Constructor of Cell class.
	 * 
	 * @param name        The name associated with the cell.
	 * @param xCoordinate The x coordinate of cell.
	 * @param yCoordinate The y coordinate of cell.
	 */
	public Cell(String name, int xCoordinate, int yCoordinate) {

		// sets default properties of a cell
		this.name = name;
		this.playerPass = true;
		this.enemyPass = true;

		File file = new File("./src/Default.jpg");
		Image image = new Image(file.toURI().toString());
		this.cellImage = image;
		this.cellView = new ImageView(cellImage);
		this.cellView.setFitHeight(CELL_SIZE);
		this.cellView.setFitWidth(CELL_SIZE);

		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;

	}

	/**
	 * Gets the x coordinate of a link of a teleporter.
	 * 
	 * @return linkX An x coordinate value of a teleporter.
	 */
	public int getLinkX() {

		return linkX;

	}

	/**
	 * Sets the x coordinate of a link of a teleporter.
	 * 
	 * @param linkX An x coordinate value of a teleporter.
	 */
	public void setLinkX(int linkX) {

		this.linkX = linkX;

	}

	/**
	 * Gets the y coordinate of a link of a teleporter.
	 * 
	 * @return linkY A y coordinate value of a teleporter.
	 */
	public int getLinkY() {

		return linkY;

	}

	/**
	 * Sets the y coordinate of a link of a teleporter.
	 * 
	 * @param linkY A y coordinate value of a teleporter.
	 */
	public void setLinkY(int linkY) {

		this.linkY = linkY;

	}

	/**
	 * Sets the cell Image.
	 * 
	 * @param cellImage An Image of cell.
	 */
	public void setCellImage(Image cellImage) {

		this.cellImage = cellImage;

	}

	/**
	 * Sets the cell Image View.
	 * 
	 * @param cellView An image view with cell image already attached.
	 */
	public void setCellView(ImageView cellView) {

		this.cellView = cellView;

	}

	/**
	 * Gets the image of specific cell.
	 * 
	 * @return cellImage An Image of cell.
	 */
	public Image getImage() {

		return this.cellImage;

	}

	/**
	 * Gets the image view with cell image already attached.
	 * 
	 * @returns cellView An image view with cell image already attached.
	 */
	public ImageView getView() {

		return this.cellView;

	}

	/**
	 * Gets the check to see if a player can enter a cell.
	 * 
	 * @return playerPass Return true if possible for player to move onto cell.
	 */
	public boolean getPlayerPass() {

		return this.playerPass;

	}

	/**
	 * Gets the check to see if an enemy can enter a cell.
	 * 
	 * @return enemyPass Return true if possible for enemy to move onto cell.
	 */
	public boolean getEnemyPass() {

		return this.enemyPass;

	}

	/**
	 * Gets the standard cell size of a cell.
	 * 
	 * @return CELL_SIZE The size of a cell in pixels.
	 */
	public int getCELL_SIZE() {

		return CELL_SIZE;

	}

	/**
	 * Gets the x coordinate of a cell.
	 * 
	 * @return xCoordinate The x coordinate of a cell.
	 */
	public int getxCoordinate() {

		return xCoordinate;

	}

	/**
	 * Gets the y coordinate of a cell.
	 * 
	 * @return yCoordinate The y coordinate of a cell.
	 */
	public int getyCoordinate() {

		return yCoordinate;

	}

	/**
	 * Gets the name of cell for identification of cell.
	 * 
	 * @return name The name associated with the cell.
	 */
	public String getName() {

		return name;

	}

	/**
	 * Method that changes the player pass to equal true.
	 */
	public void changePlayerPass() {

		this.playerPass = true;

	}

	/**
	 * Method that changes the enemy pass to equal true.
	 */
	public void changeEnemyPass() {

		this.enemyPass = true;

	}
}
