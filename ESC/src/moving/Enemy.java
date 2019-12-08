package moving;

import application.Cell;
import application.Map;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class represents all attributes and behaviours of Enemy.
 * @author Group 31
 * @version 3.0
 */
public abstract class Enemy extends Movable {
	protected Image EnemyImg;
	protected ImageView EnemyView;

	/**
	 * Constructor of Enemy cell.
	 * @param name The name of the the enemy type.
	 * @param mapActual The map associated with WallFollowing Enemy.
	 * @param location The coordinates of the enemy.
	 */
	public Enemy(String name, Cell[][] mapActual, int[] location) {
		super(name, mapActual);
		super.xLocation = location[0];
		super.yLocation = location[1];

	}

	/**
	 * Method that checks whether it is valid for enemy to move to certain cell.
	 * @param xLocation The current x coordinate of Enemy position.
	 * @param yLocation The current y coordinate of Enemy position.
	 * @param newXLocation The x coordinate Enemy could move to.
	 * @param newYLocation The y coordinate Enemy could move to.
	 * @param map The map of the enemy.
	 * @return Return True if it is valid to move to new position.
	 */
	protected boolean validMove(int xLocation, int yLocation, int newXLocation, int newYLocation, Map map) {
		if (map.getCell(newXLocation, newYLocation).getEnemyPass()) {
			return true;
			
		} else {
			return false;
	
		}
	}

	/**
	 * Getter method for acquiring Enemy Image.
	 * @return Image of Enemy.
	 */
	public Image getEnemyImg() {
		return this.EnemyImg;
	}

	/**
	 * Getter method for acquiring Enemy Image View.
	 * @return Image View of Enemy.
	 */
	public ImageView getEnemyView() {
		return this.EnemyView;
	}
}