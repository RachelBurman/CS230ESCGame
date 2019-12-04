package moving;

public abstract class NonTargetingEnemy extends Enemy {
	protected char facing;

	public NonTargetingEnemy(String name, int[] location) {
		super(name, location);
		
		// TODO Auto-generated constructor stub
	}

	public char getFacing() {
		return facing;
	}

	public void setFacing(char facing) {
		this.facing = facing;
	}

}
