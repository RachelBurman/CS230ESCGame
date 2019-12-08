package moving;

import java.io.File;

import application.Cell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import moving.NonTargetingEnemy;


/**
 * This class represents all attributes and behaviours of a WallFollowing Enemy.
 * @author Group 31
 * @version 3.0
 */
public class WallFollowingEnemy extends NonTargetingEnemy {

	/**
     * The constructor of WallFollowingEnemy. 
     * Sets attributes based on information read from file.
	 * @param name The name of the the enemy type.
	 * @param mapActual The map associated with WallFollowing Enemy.
	 * @param info The array containing information on positioning and direction of enemy.
	 */
	public WallFollowingEnemy(String name, Cell[][] mapActual, int[] info) {
		super(name, mapActual, info);
		this.xLocation = info[0];
		this.yLocation = info[1];

		/*
		 * Setting Wall Following Enemy's image information
		 */
		File file = new File("./src/WallFollowing.png");
		Image image = new Image(file.toURI().toString());

		this.EnemyImg = image;
		this.EnemyView = new ImageView(this.EnemyImg);

		this.EnemyView.setFitHeight(CELL_SIZE);
		this.EnemyView.setFitWidth(CELL_SIZE);


		/*
		 * Checking for which direction enemy will initially face
		 * info[2] is either: 1,2,3 or 4 
		 * up = 1, down = 2, right = 3, left = 4
		 */
		switch (info[2]) {
		case 1:
			super.facing ='u';
			break;
		case 2:
			super.facing = 'd';
			break;
		case 3:
			super.facing = 'r';
			break;
		case 4:
			super.facing = 'l';
			break;
		default:
			// Do nothing
			break;
		}

	}

	/**
	 * Method that checks enemy's surroundings and decides whether
	 * to move vertically or not.
	 * @param xLocation The x coordinate of enemy according to its map.
	 * @param yLocation The y coordinate of enemy according to its map.
	 * @param facing The direction enemy is facing prior to moving.
	 */
	public void moveY(int xLocation,int yLocation, char facing) {

		/*
		 *  Variables that help the WallFollowing Enemy decide where it should move.
		 */
		boolean leftOfEnemyIsGround = mapActual[xLocation-1][yLocation].getEnemyPass();
		boolean rightOfEnemyIsGround = mapActual[xLocation+1][yLocation].getEnemyPass();
		boolean downOfEnemyIsGround = mapActual[xLocation][yLocation+1].getEnemyPass();
		boolean upOfEnemyIsGround = mapActual[xLocation][yLocation-1].getEnemyPass();

		/*
		 *  Variables that help WallFollowing Enemy know when to turn a corner.
		 */
		boolean downRightOfEnemyIsGround = mapActual[xLocation+1][yLocation+1].getEnemyPass(); // Right Wall
		boolean upLeftOfEnemyIsGround = mapActual[xLocation-1][yLocation-1].getEnemyPass(); // Left Wall

		/*
		 *  When no walls surround Wall Following Enemy,
		 *  Move towards a wall it's facing.	
		 */		
		if (leftOfEnemyIsGround == true) {
			if (rightOfEnemyIsGround == true) {
				if (upOfEnemyIsGround == true) {
					if (downOfEnemyIsGround == true) {
						if (this.facing == 'u') {
							this.yLocation--;
						} else if (this.facing == 'd') {
							this.yLocation++;
						} 
					}
				}
			}
		}

		//If enemy is facing up, check surrounding cells and move based on this check
		if (this.facing == 'u') {

			if (leftOfEnemyIsGround == false) { 
				if (upOfEnemyIsGround == false) { 
					if (rightOfEnemyIsGround == false) {
						this.facing = 'd';
						moveY(this.xLocation,this.yLocation,this.facing);		

					} else {
						this.facing = 'r';
						moveX(this.xLocation,this.yLocation,this.facing);		
					}
				} else {
					if(upLeftOfEnemyIsGround == true) {		
						this.yLocation--;
						this.xLocation--;

						this.facing = 'l';	

					} else {
						this.yLocation--;
					}
				}
			} else {
				if (upOfEnemyIsGround == false) {
					this.facing = 'r';
					moveX(this.xLocation,this.yLocation,this.facing);

				} else if (rightOfEnemyIsGround == false) {
					this.facing = 'd';
					moveY(this.xLocation,this.yLocation,this.facing);		


				} else if (downOfEnemyIsGround == false) {
					this.facing = 'l';
					moveX(this.xLocation,this.yLocation,this.facing);		
				}
			}

		//If enemy is facing down, check surrounding cells and move based on this check			
		} else if(this.facing == 'd') {

			if (rightOfEnemyIsGround == false) { 
				if (downOfEnemyIsGround == false) {
					if (leftOfEnemyIsGround == false) {
						this.facing = 'u';
						moveY(this.xLocation,this.yLocation,this.facing);		

					} else {
						this.facing = 'l';
						moveX(this.xLocation,this.yLocation,this.facing);		
					}
				} else {
					if(downRightOfEnemyIsGround == true) {	
						this.yLocation++;
						this.xLocation++;

						this.facing = 'r';

					} else {
						this.yLocation++;
					}
				}
			} else {
				if (downOfEnemyIsGround = false) {
					this.facing = 'l';
					moveX(this.xLocation,this.yLocation,this.facing);		


				} else if (leftOfEnemyIsGround = false) {
					this.facing = 'u';
					moveY(this.xLocation,this.yLocation,this.facing);		


				} else if (upOfEnemyIsGround == false) {
					this.facing = 'r';
					moveX(this.xLocation,this.yLocation,this.facing);		

				}
			}
		}
	}

	/**
	 * Method that checks enemy's surroundings and decides whether
	 * to move horizontally or not.
	 * @param xLocation The x coordinate of enemy according to its map.
	 * @param yLocation The y coordinate of enemy according to its map.
	 * @param facing The direction enemy is facing prior to moving.
	 */
	public void moveX(int xLocation, int yLocation, char facing) {

		/*
		 *  Variables that help the WallFollowing Enemy decide where it should move.
		 */
		boolean leftOfEnemyIsGround = mapActual[xLocation-1][yLocation].getEnemyPass();
		boolean rightOfEnemyIsGround = mapActual[xLocation+1][yLocation].getEnemyPass();
		boolean downOfEnemyIsGround = mapActual[xLocation][yLocation+1].getEnemyPass();
		boolean upOfEnemyIsGround = mapActual[xLocation][yLocation-1].getEnemyPass();

		/*
		 *  Variables that help WallFollowing Enemy know when to turn a corner.
		 */
		boolean rightUpOfEnemyIsGround = mapActual[xLocation+1][yLocation-1].getEnemyPass(); // Top Wall
		boolean leftDownOfEnemyIsGround = mapActual[xLocation-1][yLocation+1].getEnemyPass(); // Bottom Wall



		/*
		 *  When no walls surround Wall Following Enemy,
		 *  Move towards a wall it's facing.	
		 */

		if (leftOfEnemyIsGround == true) {
			if (rightOfEnemyIsGround == true) {
				if (upOfEnemyIsGround == true) {
					if (downOfEnemyIsGround == true) {
						if (this.facing=='r') {
							this.xLocation++;

						} else if (this.facing=='l') {
							this.xLocation--;

						} 
					}
				}
			}
		}

		//If enemy is facing left, check surrounding cells and move based on this check
		if(this.facing == 'l') {

			if (downOfEnemyIsGround == false) { 
				if (leftOfEnemyIsGround == false) { 
					if (upOfEnemyIsGround == false) {
						this.facing = 'r';
						moveX(this.xLocation, this.yLocation,this.facing);
					} else {
						this.facing = 'u';
						moveY(this.xLocation,this.yLocation,this.facing);		
					}
				} else {
					if(leftDownOfEnemyIsGround == true) {		
						this.xLocation--;
						this.yLocation++;

						this.facing = 'd';
						
					} else {
						this.xLocation--;
					}
				}
			} else {
				if (leftOfEnemyIsGround == false) {
					this.facing = 'u';
					moveY(this.xLocation,this.yLocation,this.facing);		


				} else if (upOfEnemyIsGround == false) {
					this.facing = 'r';
					moveX(this.xLocation,this.yLocation,this.facing);		


				} else if (rightOfEnemyIsGround == false) {
					this.facing = 'd';
					moveY(this.xLocation,this.yLocation,this.facing);		
				}
			}

		//If enemy is facing right, check surrounding cells and move based on this check
		} else if(this.facing == 'r') {

			if (upOfEnemyIsGround == false) { 
				if (rightOfEnemyIsGround == false) { 
					if (downOfEnemyIsGround == false) {
						this.facing = 'l';
						moveX(this.xLocation,this.yLocation,this.facing);		

					} else {
						this.facing = 'd';
						moveY(this.xLocation,this.yLocation,this.facing);		
					}
				} else {
					if(rightUpOfEnemyIsGround == true) {		
						this.xLocation++;
						this.yLocation--;

						this.facing = 'u';

					} else {
						this.xLocation++;
					}
				}
			} else {

				if (rightOfEnemyIsGround == false) {
					this.facing = 'd';
					moveY(this.xLocation,this.yLocation,this.facing);		

				} else if (downOfEnemyIsGround == false) {
					this.facing = 'l';
					moveY(this.xLocation,this.yLocation,this.facing);		

				} else if (leftOfEnemyIsGround == false) {
					this.facing = 'u';
					moveY(this.xLocation,this.yLocation,this.facing);		

				}
			}
		}
	}
}