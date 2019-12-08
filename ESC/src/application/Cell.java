package application;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
* This class makes a cell which is an item that contains all the information for 1 tile.
* @author Group 31 
* @version 3.0
*/
public class Cell {
	//protected as the subclasses of cell require to use these variables.
	protected String name;
	protected Image cellImage;
	protected ImageView cellView;
	protected final int CELL_SIZE= 70;
	protected int xCoordinate;
	protected int yCoordinate;
	protected boolean playerPass;
	protected boolean enemyPass;
	protected int linkX;
	protected int linkY;
	
        /**
        * Creates a default cell at point with X, Y Coordinates and it's name
        * 
        */
	public Cell(String name, int xCoordinate, int yCoordinate ) {
		
		//sets default properties of a cell
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
        * gets the x coordinate of a link of a teleporter
        * @return the links x coordinate
        */
	public int getLinkX() {
		
		return linkX;
		
	}

        /**
        * Sets the x coordinate of a link of a teleporter
        * @param linkX integer x coordinate value of a teleporter
        */
	public void setLinkX(int linkX) {
		
		this.linkX = linkX;
		
	}

        /**
        * gets the y coordinate of a link of a teleporter
        * @return the links y coordinate
        */
	public int getLinkY() {
		
		return linkY;
		
	}

        /**
        * Sets the y coordinate of a link of a teleporter
         @param linkY integer y coordinate value of a teleporter
        */
	public void setLinkY(int linkY) {
		
		this.linkY = linkY;
		
	}

		/**
        * Sets the cell image
        * @param cellImage a compiled image class type to be displayed
        */
	public void setCellImage(Image cellImage) {
		
		this.cellImage = cellImage;
		
	}

        /**
        * Sets the cell view imageviewer
        * @param cellView a compiled image view class type to be displayed
        */
	public void setCellView(ImageView cellView) {
		
		this.cellView = cellView;
		
	}

        /**
        * Gets the private cell image image class type variable
        * @return cellImage a image class with an image already attatched
        */
	public Image getImage( ) {
		
		return this.cellImage;
		
	}
        
        /**
        * Gets the cell view image view class type variable
        * @returns cellView a image view class with an image already attatched
        */
	public ImageView getView( ) {
		
		return this.cellView;
		
	}
	
        /**
        * Gets the check to see if a player can enter a cell
        */
	public boolean getPlayerPass () {
		
		return this.playerPass;
		
	}
        
        /**
        * Gets the check to see if an enemy can enter a cell
        */
	public boolean getEnemyPass () {
		
		return this.enemyPass;
		
	}

        /**
        * Gets the standard cell size of a cell
        * @return CELL_SIZE the size of a cell in pixels
        */
	public int getCELL_SIZE() {
		
		return CELL_SIZE;
		
	}

        /**
        * Gets the x coordinate of a cell
        * @return xCoordinate the x coordinate of a cell
        */
	public int getxCoordinate() {
		
		return xCoordinate;
		
	}

        /**
        * Gets the y coordinate of a cell
        * @return yCoordinate the y coordinate of a cell
        */
	public int getyCoordinate() {
		
		return yCoordinate;
		
	}

        /**
        * Gets the name of a cell. Used to identify a cell type
        * @return name the name entered when the cell was created
        */
	public String getName() {
		
		return name;
		
	}
	
        /**
        * Sets the player pass to equal true
        */
	public void changePlayerPass() {
		
		this.playerPass = true;
		
	}
        /**
        * Sets the enemy pass to equal true
        */
	public void changeEnemyPass() {
		
		this.enemyPass = true;
		
		
	}
	
}
