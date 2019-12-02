package moving;

import application.Cell;


public class StraightLineEnemy extends NonTargetingEnemy{
	char facing;

	public StraightLineEnemy(int currentXLocation, int currentYLocation, String enemyName, char facing) {
		
		super(currentXLocation, currentYLocation, enemyName);
		this.facing = facing;
		
		// facing is up down left right 
	}
	public int moveY(int currentYLocation,int currentXLocation, char facing) {
		if (currentYLocation == 0) {
			facing = 'd';
		} else if (currentYLocation = level.length) {
			facing = 'u';
		}
		if (facing=='u') {
			currentYLocation = currentYLocation+1;
		} else if (facing=='d') {
			currentYLocation = currentYLocation-1;
		} 
		return currentYLocation;
		
	}
	public int moveX(int currentYLocation, int currentXLocation, char facing) {
		if (currentXLocation == 0) {
			facing = 'l';
		} else if (currentXLocation = level.length) {
			facing = 'r';
		}
		if (facing=='r') {
			currentXLocation = currentXLocation+1;
		} else if (facing=='l') {
			currentXLocation = currentXLocation-1;
		} 
		return currentXLocation;
	}
	

}
