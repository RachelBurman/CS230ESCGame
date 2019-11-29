package moving;

public abstract class TargetingEnemy extends Enemy {
	int playerXLocation;
	int playerYLocation;

	public TargetingEnemy(int currentXLocation, int currentYLocation, String enemyName, int playerXLocation, int playerYLocation) {
		super(currentXLocation, currentYLocation, enemyName);
		this.playerXLocation = playerXLocation;
		this.playerYLocation = playerYLocation;
		// TODO Auto-generated constructor stub
	}
	


}
