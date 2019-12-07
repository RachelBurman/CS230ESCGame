package moving;

import java.io.File;

import application.Cell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import moving.NonTargetingEnemy;



public class WallFollowingEnemy extends NonTargetingEnemy {
	//boolean facingWillNotChange = false;

	public WallFollowingEnemy(String name,Cell[][] mapActual, int[] info) {
		super(name, mapActual, info);
		this.xLocation = info[0];
		this.yLocation = info[1];

		File file = new File("./src/WallFollowing.png");
		Image image = new Image(file.toURI().toString());

		this.EnemyImg = image;
		this.EnemyView = new ImageView(this.EnemyImg);

		this.EnemyView.setFitHeight(CELL_SIZE);
		this.EnemyView.setFitWidth(CELL_SIZE);


		// info[2] is either 1,2,3,4 up =1, down = 2, right = 3, left = 4
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

	//Method for Enemy to move Y Coords
	public void moveY(int xLocation,int yLocation, char facing) {

		System.out.println("Before Moving X: " + this.facing);
		System.out.println("X facing is: " + facing);

		boolean leftOfEnemyIsGround = mapActual[xLocation-1][yLocation].getEnemyPass();
		boolean rightOfEnemyIsGround = mapActual[xLocation+1][yLocation].getEnemyPass();
		boolean downOfEnemyIsGround = mapActual[xLocation][yLocation+1].getEnemyPass();
		boolean upOfEnemyIsGround = mapActual[xLocation][yLocation-1].getEnemyPass();

		boolean rightUpOfEnemyIsGround = mapActual[xLocation+1][yLocation-1].getEnemyPass(); // Top Wall
		boolean downRightOfEnemyIsGround = mapActual[xLocation+1][yLocation+1].getEnemyPass(); // Right Wall
		boolean leftDownOfEnemyIsGround = mapActual[xLocation-1][yLocation+1].getEnemyPass(); // Bottom Wall
		boolean upLeftOfEnemyIsGround = mapActual[xLocation-1][yLocation-1].getEnemyPass(); // Left Wall


		if (leftOfEnemyIsGround == true) {
			if (rightOfEnemyIsGround == true) {
				if (upOfEnemyIsGround == true) {
					if (downOfEnemyIsGround == true) {

						if (this.facing=='u') {
							this.yLocation--;
						} else if (this.facing=='d') {
							this.yLocation++;
							//System.out.println("O WALL Y Location:" + this.yLocation);

						} 
					}
				}
			}
		}



		if(this.facing == 'u') {

			if (leftOfEnemyIsGround == false) { 
				if (upOfEnemyIsGround == false) { 
					if (rightOfEnemyIsGround == false) {
						this.facing = 'd';
						//this.yLocation++;
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
						//facingWillNotChange = true;
						//moveX(this.xLocation,this.yLocation,this.facing);		

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
					//this.yLocation++;
					moveY(this.xLocation,this.yLocation,this.facing);		


				} else if (downOfEnemyIsGround == false) {
					this.facing = 'l';
					moveX(this.xLocation,this.yLocation,this.facing);		
				}
			}

		} else if(this.facing == 'd') {

			if (rightOfEnemyIsGround == false) { 
				if (downOfEnemyIsGround == false) {
					if (leftOfEnemyIsGround == false) {
						this.facing = 'u';
						//this.yLocation--;
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
					//this.yLocation--;
					moveY(this.xLocation,this.yLocation,this.facing);		


				} else if (upOfEnemyIsGround == false) {
					this.facing = 'r';
					moveX(this.xLocation,this.yLocation,this.facing);		

				}
			}
		}
	}



	//Method for Enemy to move X Coords
	public void moveX(int xLocation, int yLocation, char facing) {

		boolean leftOfEnemyIsGround = mapActual[xLocation-1][yLocation].getEnemyPass();
		boolean rightOfEnemyIsGround = mapActual[xLocation+1][yLocation].getEnemyPass();
		boolean downOfEnemyIsGround = mapActual[xLocation][yLocation+1].getEnemyPass();
		boolean upOfEnemyIsGround = mapActual[xLocation][yLocation-1].getEnemyPass();

		boolean rightUpOfEnemyIsGround = mapActual[xLocation+1][yLocation-1].getEnemyPass(); // Top Wall
		boolean downRightOfEnemyIsGround = mapActual[xLocation+1][yLocation+1].getEnemyPass(); // Right Wall
		boolean leftDownOfEnemyIsGround = mapActual[xLocation-1][yLocation+1].getEnemyPass(); // Bottom Wall
		boolean upLeftOfEnemyIsGround = mapActual[xLocation-1][yLocation-1].getEnemyPass(); // Left Wall


		/*
		 * For when no walls surround wall enemy
		 */
		if (leftOfEnemyIsGround == true) {
			if (rightOfEnemyIsGround == true) {
				if (upOfEnemyIsGround == true) {
					if (downOfEnemyIsGround == true) {

						if (this.facing=='r') {
							this.xLocation = xLocation+1;

						} else if (this.facing=='l') {
							this.xLocation = xLocation-1;

						} 

					}
				}
			}

		}

		if(this.facing == 'l') {

			if (downOfEnemyIsGround == false) { 
				if (leftOfEnemyIsGround == false) { 
					if (upOfEnemyIsGround == false) {
						this.facing = 'r';
						//this.xLocation++;
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
						//facingWillNotChange = true;
						//moveY(this.xLocation,this.yLocation,this.facing);		

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
					//this.xLocation++;
					moveX(this.xLocation,this.yLocation,this.facing);		


				} else if (rightOfEnemyIsGround == false) {
					this.facing = 'd';
					moveY(this.xLocation,this.yLocation,this.facing);		
				}
			}
		} else if(this.facing == 'r') {

			if (upOfEnemyIsGround == false) { 
				if (rightOfEnemyIsGround == false) { 
					if (downOfEnemyIsGround == false) {
						this.facing = 'l';
						//this.xLocation--;
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
					//this.xLocation--;
					moveY(this.xLocation,this.yLocation,this.facing);		



				} else if (leftOfEnemyIsGround == false) {
					this.facing = 'u';
					moveY(this.xLocation,this.yLocation,this.facing);		

				}
			}
		}
	}
}
