package moving;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DumbTargettingEnemy extends TargettingEnemy {

	public DumbTargettingEnemy(String name, int[] info) {
		super(name, info);
		// TODO Auto-generated constructor stub
		this.xLocation = info[0];
		this.yLocation = info[1];
		this.playerx = super.xLocation;
		this.playery= super.yLocation;
		this.EnemyImg = new Image("https://imgbin.com/png/BA0Rv63r/police-officer-cartoon-drawing-png");
		this.EnemyView = new ImageView(this.EnemyImg);
		this.EnemyView.setFitHeight(CELL_SIZE);
		this.EnemyView.setFitWidth(CELL_SIZE);
		// info[3] is either 1,2,3,4 up =1, down = 2, right = 3, left = 4
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
	//Method for distance to move the player
		public void playerx (int CurrentxLocation, char facing, int xLocation) {
			if (playerx-CurrentxLocation)
		}

	//Method for Enemy to move Y Coords
		public void moveY(int xLocation,int yLocation, char facing) {
			if (map.getCell(xLocation, yLocation-1).getEnemyPass()==false && facing== 'u') {
				this.facing = 'd';
			} else if (map.getCell(xLocation, yLocation+1).getEnemyPass()==false && facing =='d') {
				this.facing = 'u';
			}
			if (facing=='u') {
				this.yLocation = yLocation-1;
			} else if (facing=='d') {
				this.yLocation = yLocation+1;
			} 
			
		}
		//Method for Enemy to move X Coords
		public void moveX(int xLocation, int yLocation, char facing) {
			if ( facing=='r') {
				if (map.getCell(xLocation+1, yLocation).getEnemyPass()==false) {
					this.facing = 'l';
				}
				
			} else if (facing =='l') {
				if (map.getCell(xLocation-1, yLocation).getEnemyPass()==false) {
					this.facing = 'r';
				}
			}
			if (this.facing=='l') {
				this.xLocation = xLocation+1;
			} else if (this.facing=='l') {
				this.xLocation = xLocation-1;
			} 
		}

	}
