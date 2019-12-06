package moving;

import java.io.File;

import application.Cell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import moving.NonTargetingEnemy;

/*
 * Problem: Checks left first instead of the last direction it faces
 */

public class WallFollowingEnemy extends NonTargetingEnemy {


	public WallFollowingEnemy(String name,Cell[][] mapActual, int[] info) {
		super(name, mapActual, info);
		this.xLocation = info[0];
		this.yLocation = info[1];

		File file = new File("./src/WallFollowing.png");
		Image image = new Image(file.toURI().toString());

		this.EnemyImg = image;
		this.EnemyView = new ImageView(this.EnemyImg);
		//this.EnemyView.setFitHeight(CELL_SIZE); (needs to be in different package)
		//this.EnemyView.setFitWidth(CELL_SIZE);
		this.EnemyView.setFitHeight(32);
		this.EnemyView.setFitWidth(32);


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

		boolean leftOfEnemyIsGround = mapActual[xLocation-1][yLocation].getEnemyPass();
		boolean rightOfEnemyIsGround = mapActual[xLocation+1][yLocation].getEnemyPass();
		boolean downOfEnemyIsGround = mapActual[xLocation][yLocation+1].getEnemyPass();
		boolean upOfEnemyIsGround = mapActual[xLocation][yLocation-1].getEnemyPass();

		boolean rightUpOfEnemyIsGround = mapActual[xLocation+1][yLocation-1].getEnemyPass(); // Top Wall
		boolean downRightOfEnemyIsGround = mapActual[xLocation+1][yLocation+1].getEnemyPass(); // Right Wall
		boolean leftDownOfEnemyIsGround = mapActual[xLocation-1][yLocation+1].getEnemyPass(); // Bottom Wall
		boolean upLeftOfEnemyIsGround = mapActual[xLocation-1][yLocation-1].getEnemyPass(); // Left Wall
		
		if (leftOfEnemyIsGround == false && (upOfEnemyIsGround == true || upLeftOfEnemyIsGround == true)) {
			System.out.println("Y Left is Wall, Up is Ground");
			this.facing = 'u';
		} else if (upOfEnemyIsGround == false && (rightOfEnemyIsGround == true || rightUpOfEnemyIsGround == true)){
			System.out.println("Y Up is Wall, Right is Ground");
			this.facing = 'r';
			moveX(this.xLocation,this.yLocation,this.facing); //Move right


		} else if (rightOfEnemyIsGround == false && (downOfEnemyIsGround == true || downRightOfEnemyIsGround == true)) {
			System.out.println("Y Right is Wall, Down is Ground");

			this.facing = 'd';
		} else if (downOfEnemyIsGround == false && (leftOfEnemyIsGround == true || leftDownOfEnemyIsGround == true)) {
			System.out.println("Y Down is Wall, Left is Ground");

			this.facing = 'l';

			moveX(this.xLocation,this.yLocation,this.facing);

		} else {

		}

		/*
		 * For when there are no walls surrounding wall enemy
		 */
		if (leftOfEnemyIsGround == true) {
			if (rightOfEnemyIsGround == true) {
				if (upOfEnemyIsGround == true) {
					if (downOfEnemyIsGround == true) {

						if (this.facing=='u') {
							this.yLocation = yLocation-1;
						} else if (this.facing=='d') {
							this.yLocation = yLocation+1;
							//System.out.println("O WALL Y Location:" + this.yLocation);

						} 

					}
				}
			}
		}



		if(this.facing == 'u') {
			if(leftOfEnemyIsGround == false) {
				if (upOfEnemyIsGround == true) {	
					
					if(upLeftOfEnemyIsGround == true) {		
						this.yLocation--;
						this.xLocation--;
						
						this.facing = 'd';
					} else {
						this.yLocation--;
						//System.out.println("OO WALL Y Location:" + this.yLocation);
					}
				} else {
					this.facing = 'l';

				}

			}
		} else if (this.facing == 'd') {
			if(rightOfEnemyIsGround == false) {
				if (downOfEnemyIsGround = true) {
					//System.out.println("OOO WALL Y Location:" + this.yLocation);

					if(downRightOfEnemyIsGround == true) {		
						this.yLocation++;
						this.xLocation++;
						
						this.facing = 'r';
					} else {
						this.yLocation++;
						//System.out.println("OO WALL Y Location:" + this.yLocation);
					}
				} else {
					this.facing = 'l';

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
		

	if (leftOfEnemyIsGround == false && (upOfEnemyIsGround == true || upLeftOfEnemyIsGround == true)) {
			System.out.println("Y Left is Wall, Up is Ground");
			this.facing = 'u';
			
			moveY(this.xLocation,this.yLocation,this.facing);

		} else if (upOfEnemyIsGround == false && (rightOfEnemyIsGround == true || rightUpOfEnemyIsGround == true)){
			System.out.println("Y Up is Wall, Right is Ground");
			this.facing = 'r';


		} else if (rightOfEnemyIsGround == false && (downOfEnemyIsGround == true || downRightOfEnemyIsGround == true)) {
			System.out.println("Y Right is Wall, Down is Ground");

			this.facing = 'd';
			
			moveY(this.xLocation,this.yLocation,this.facing);

		} else if (downOfEnemyIsGround == false && (leftOfEnemyIsGround == true || leftDownOfEnemyIsGround == true)) {
			System.out.println("Y Down is Wall, Left is Ground");

			this.facing = 'l';


		} else {

		}

		/*
		 * For when no walls surround wall enemy
		 */
		if (leftOfEnemyIsGround == true) {
			if (rightOfEnemyIsGround == true) {
				if (upOfEnemyIsGround == true) {
					if (downOfEnemyIsGround == true) {

						if (this.facing=='r') {
							this.xLocation = xLocation+1;
							//System.out.println("O WALL X Location:" + this.xLocation);

						} else if (this.facing=='l') {
							this.xLocation = xLocation-1;
							//System.out.println("OO WALL X Location:" + this.xLocation);

						} 

					}
				}
			}
		}


		if(this.facing == 'l') {
			if(downOfEnemyIsGround == false) {

				if (leftOfEnemyIsGround == true) {
					//System.out.println("OOO WALL X Location:" + this.xLocation);
					
					if(leftDownOfEnemyIsGround == true) {		
						this.xLocation--;
						this.yLocation++;
						
						
						this.facing = 'd';
					} else {
						this.xLocation--;
						//System.out.println("OO WALL Y Location:" + this.yLocation);
					}
				} else {
					this.facing = 'u';
				}

			}
		} else if (this.facing == 'r') {
			if(upOfEnemyIsGround == false) {
				if (rightOfEnemyIsGround == true) {
					//System.out.println("OOOO WALL X Location:" + this.xLocation);

					if(rightUpOfEnemyIsGround == true) {		
						this.xLocation++;
						this.yLocation--;

						
						this.facing = 'u';
					} else {
						this.xLocation++;
						//System.out.println("OO WALL Y Location:" + this.yLocation);
					}
				} else {
					this.facing = 'd';

				}
			}
		}

	}
}