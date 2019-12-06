package moving;

import java.io.File;

import application.Cell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import moving.NonTargetingEnemy;


public class WallFollowingEnemy extends NonTargetingEnemy {


	public WallFollowingEnemy(String name,Cell[][] mapActual, int[] info) {
		super(name, mapActual, info);
		this.xLocation = info[0];
		this.yLocation = info[1];

		File file = new File("./src/StraightEnemy.png");
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

		
		if (leftOfEnemyIsGround == false && upOfEnemyIsGround == true) {
			//System.out.println("WALL UP");
			this.facing = 'u';
		} else if (upOfEnemyIsGround == false && rightOfEnemyIsGround == true){
			//System.out.println("WALL RIGHT");
			this.facing = 'r';
			moveX(this.xLocation,this.yLocation,this.facing);
		} else if (rightOfEnemyIsGround == false && downOfEnemyIsGround == true) {
			//System.out.println("WALL DOWN");

			this.facing = 'd';
		} else if (downOfEnemyIsGround == false && leftOfEnemyIsGround == true) {
			//System.out.println("WALL LEFT MOVE Y");

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
					this.yLocation--;
					//System.out.println("OO WALL Y Location:" + this.yLocation);

				} else {
					this.facing = 'r';

				}

			}
		} else if (this.facing == 'd') {
			if(rightOfEnemyIsGround == false) {
				if (downOfEnemyIsGround = true) {
					this.yLocation++;
					//System.out.println("OOO WALL Y Location:" + this.yLocation);

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



		if (leftOfEnemyIsGround == false && upOfEnemyIsGround == true) {
			System.out.println("WALL UP MOVE X");
			this.facing = 'u';
			
			moveY(this.xLocation,this.yLocation,this.facing);

		} else if (upOfEnemyIsGround == false && rightOfEnemyIsGround == true){
			//System.out.println("WALL RIGHT MOVE X");

			this.facing = 'r';
		} else if (rightOfEnemyIsGround == false && downOfEnemyIsGround == true) {
			//System.out.println("WALL DOWN MOVE X");

			this.facing = 'd';
			
			moveY(this.xLocation,this.yLocation,this.facing);

		} else if (downOfEnemyIsGround == false && leftOfEnemyIsGround == true) {
			//System.out.println("WALL LEFT MOVE X");

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
					this.xLocation--;
					//System.out.println("OOO WALL X Location:" + this.xLocation);
				} else {
					this.facing = 'u';
				}

			}
		} else if (this.facing == 'r') {
			if(upOfEnemyIsGround == false) {
				if (rightOfEnemyIsGround == true) {
					this.xLocation++;
					//System.out.println(this.xLocation);
					//System.out.println("OOOO WALL X Location:" + this.xLocation);

				} else {
					this.facing = 'd';

				}
			}
		}

	}
}