package moving;

public abstract class TargettingEnemy extends Enemy {
	
	int playerx;
	int playery;
	int distanceXToPlayer;
	int distanceYToPlayer;

	public TargettingEnemy(String name, int[] location) {
		super(name, location);
		// TODO Auto-generated constructor stub
	}
	
	//Method to measure how far in X direction the player is to the enemy
	public int getDistanceXToPlayer (int playerX, int xLocation) {
			return this.distanceXToPlayer= playerX - xLocation;
		}

	public int getDistanceYToPlayer (int playerY, int yLocation) {
			return this.distanceYToPlayer= playerY - yLocation;
		}

}
