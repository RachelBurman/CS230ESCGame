package moving;

import java.io.File;

import application.Cell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StraightLineEnemy extends NonTargetingEnemy {
	int frontX;
	int frontY;

	public StraightLineEnemy(String name, Cell[][] mapActual, int[] info) {
		super(name,mapActual, info);
		this.xLocation = info[0];
		this.yLocation = info[1];
		File file = new File("./src/StraightEnemy.png");
	  Image image = new Image(file.toURI().toString());
	  //"https://www.tynker.com/projects/images/11c17d23871d29107e27a3dd350096500389fc83/green-stickman---pick.png
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
		
		// TODO Auto-generated constructor stub
	}
	//Method for Enemy to move Y Coords
	public void moveY(int xLocation,int yLocation, char facing) {
		if (mapActual[xLocation][yLocation-1].getEnemyPass()==false && facing== 'u') {
			this.facing = 'd';
		} else if (mapActual[xLocation][yLocation+1].getEnemyPass()==false && facing =='d') {
			this.facing = 'u';
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
			if (mapActual[xLocation+1][yLocation].getEnemyPass()==false) {
				this.facing = 'l';
			}
			
		} else if (facing =='l') {
			if (mapActual[xLocation-1][yLocation].getEnemyPass()==false) {
				this.facing = 'r';
			}
		}
		if (this.facing=='r') {
			this.xLocation = xLocation+1;
		} else if (this.facing=='l') {
			this.xLocation = xLocation-1;
		} 
	}

}

