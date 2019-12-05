package moving;

import application.Cell;

public abstract class TargetingEnemy extends Enemy {
	
	int playerx;
	int playery;
	int distanceXToPlayer;
	int distanceYToPlayer;

	public TargetingEnemy(String name, Cell[][] mapActual, int[] location) {
		super(name, mapActual, location);
		// TODO Auto-generated constructor stub
	}
	
	//Method to measure how far in X direction the player is to the enemy
	public int getDistanceXToPlayer () {
			return this.distanceXToPlayer= playerx - xLocation;
		}

	public int getDistanceYToPlayer () {
			return this.distanceYToPlayer= playery - yLocation;
		}

	public int getPlayerx() {
		return playerx;
	}

	public void setPlayerx(int playerx) {
		this.playerx = playerx;
	}

	public int getPlayery() {
		return playery;
	}

	public void setPlayery(int playery) {
		this.playery = playery;
	}
	

}
