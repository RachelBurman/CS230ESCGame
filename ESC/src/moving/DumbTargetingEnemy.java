package moving;

public class DumbTargetingEnemy extends TargetingEnemy {

	public DumbTargetingEnemy(int currentXLocation, int currentYLocation, String enemyName, int playerXLocation,
			int playerYLocation) {
		super(currentXLocation, currentYLocation, enemyName, playerXLocation, playerYLocation);
		// TODO Auto-generated constructor stub
	}
	private int[] move(int playerXLocation, int playerYLocation, int currentXLocation, int currentYLocation) {
		int totalXMovement = playerXLocation-currentXLocation;
		int totalYMovement = playerYLocation- currentYLocation;
		int[] newLocation = new int[2] ;
		if (totalXMovement>0) {
			currentXLocation = moveX(totalXMovement, totalXMovement);
		} else if (totalYMovement <0) {
			currentYLocation = moveX(totalYMovement, totalYMovement);
		}
		newLocation[1] = currentXLocation;
		newLocation[2] = currentYLocation;
		return newLocation;
		
	}
	
	public int moveX(int currentXLocation, int totalXMovement) {
		if (totalXMovement>1) {
			currentXLocation= currentXLocation+1;
		} else if ( totalXMovement<1) {
			currentXLocation= currentXLocation-1;
		}
		return currentXLocation;
	}
	
	public int moveY(int currentYLocation, int totalYMovement) {
		if ( totalYMovement>1) {
			currentYLocation= currentYLocation+1;
		} else if ( totalYMovement<1) {
			currentYLocation= currentYLocation-1;
		}
		return currentYLocation;
		
	}
	

}
