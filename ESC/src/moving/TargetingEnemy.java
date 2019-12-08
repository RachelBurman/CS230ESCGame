package moving;

import application.Cell;

/**
 * This class represents all attributes and behaviours of a Targeting Enemy.
 * @author Group 31
 * @version 3.0
 */
public abstract class TargetingEnemy extends Enemy {
	int playerx;
	int playery;
	int distanceXToPlayer;
	int distanceYToPlayer;

	/**
	 * Constructor of Targeting Enemy.
	 * @param name The name of enemy.
	 * @param mapActual The map of Targeting Enemy.
	 * @param location The array containing location information.
	 */
	public TargetingEnemy(String name, Cell[][] mapActual, int[] location) {
		super(name, mapActual, location);
	}

	/**
	 * Method that calculates how far horizontally player is from enemy itself.
	 * @return The horizontal distance from player.
	 */
	public int getDistanceXToPlayer () {
		return this.distanceXToPlayer = playerx - xLocation;
	}

	/**
	 * Method that calculates how far vertically player is from enemy itself.
	 * @return The vertical distance from player.
	 */
	public int getDistanceYToPlayer () {
		return this.distanceYToPlayer = playery - yLocation;
	}

	/**
	 * Getter method for player x coordinate in relation to enemy.
	 * @return Player x coordinate in relation to enemy.
	 */
	public int getPlayerx() {
		return playerx;
	}

	/**
	 * Setter method for player x coordinate in relation to enemy.
	 * @param playerx The player coordinate in relation to enemy.
	 */
	public void setPlayerx(int playerx) {
		this.playerx = playerx;
	}

	/**
	 * Getter method for player y coordinate in relation to enemy.
	 * @return The player y coordinate in relation to enemy.
	 */
	public int getPlayery() {
		return playery;
	}

	/**
	 * Setter method for player y coordinate in relation to enemy.
	 * @param The player y coordinate in relation to enemy.
	 */
	public void setPlayery(int playery) {
		this.playery = playery;
	}
}
