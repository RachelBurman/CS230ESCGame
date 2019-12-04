package moving;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import moving.NonTargetingEnemy;


public class WallFollowingEnemy extends NonTargetingEnemy {
	

	public WallFollowingEnemy(String name, int[] info) {
		super(name, info);
		this.xLocation = info[0];
		this.yLocation = info[1];

		this.EnemyImg = new Image("https://www.tynker.com/projects/images/11c17d23871d29107e27a3dd350096500389fc83/green-stickman---pick.png");
		this.EnemyView = new ImageView(this.EnemyImg);
		this.EnemyView.setFitHeight(CELL_SIZE);
		this.EnemyView.setFitWidth(CELL_SIZE);
		this.EnemyView.setFitHeight(50);
		this.EnemyView.setFitWidth(50);
		
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
		
		if (map.getCell(xLocation, yLocation+1).getEnemyPass()==false && facing== 'u') {
			this.facing = 'r';			
			moveX(xLocation,yLocation,this.facing);
			
		} else if (map.getCell(xLocation, yLocation-1).getEnemyPass()==false && facing =='d') {
			this.facing = 'l';
			moveX(xLocation,yLocation,this.facing);

		}
		
		if (facing=='u') {
			this.yLocation = yLocation+1;
		} else if (facing=='d') {
			this.yLocation = yLocation-1;
		} 
		
	}

	//Method for Enemy to move X Coords
	public void moveX(int xLocation, int yLocation, char facing) {
		if ( facing=='r') {
			if (map.getCell(xLocation+1, yLocation).getEnemyPass()==false) {
				this.facing = 'd';
				moveY(xLocation,yLocation,this.facing);
			}

		} else if (facing =='l') {
			if (map.getCell(xLocation-1, yLocation).getEnemyPass()==false) {
				this.facing = 'u';
				moveY(xLocation,yLocation,this.facing);
			}
		}
		if (this.facing=='r') {
			this.xLocation = xLocation+1;
		} else if (this.facing=='l') {
			this.xLocation = xLocation-1;
		} 
	}
}

