package application;

public class Enemy extends Movables {
	int playerXLocation;
	int playerYLocation;

	public Enemy(int currentXLocation, int currentYLocation, int playerXLocation, int playerYLocation) {
		super(currentXLocation, currentYLocation);
		this.playerXLocation = playerXLocation;
		this.playerYLocation = playerYLocation;
		// TODO Auto-generated constructor stub
	}
	
	

}
