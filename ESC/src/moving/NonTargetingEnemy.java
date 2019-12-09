package moving;

import application.Cell;

/**
 * This class represents all attributes and behaviours of a Non-Targeting Enemy.
 * 
 * @author Group 31
 * @version 3.0
 */
public abstract class NonTargetingEnemy extends Enemy {

	/**
	 * Constructor of Non-Targeting Enemy.
	 * 
	 * @param name      The name of Non-Targeting Enemy.
	 * @param mapActual The map of the Non-Targeting Enemy.
	 * @param location  The array containing location information.
	 */
	public NonTargetingEnemy(String name, Cell[][] mapActual, int[] location) {
		super(name, mapActual, location);
	}

	/**
	 * Getter method for where the enemy is facing.
	 * 
	 * @return The direction the enemy is facing.
	 */
	public char getFacing() {
		return facing;
	}

	/**
	 * Setter method for where the enemy is facing.
	 * 
	 * @param facing The direction enemy is facing.
	 */
	public void setFacing(char facing) {
		this.facing = facing;
	}

}
