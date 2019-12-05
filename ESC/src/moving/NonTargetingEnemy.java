package moving;

import application.Cell;

public abstract class NonTargetingEnemy extends Enemy {
	protected char facing;

	public NonTargetingEnemy(String name, Cell[][] mapActual, int[] location) {
		super(name, mapActual, location);
		
		// TODO Auto-generated constructor stub
	}

	public char getFacing() {
		return facing;
	}

	public void setFacing(char facing) {
		this.facing = facing;
	}

}
