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

	}
	public void move() {
		this.distanceXToPlayer = getDistanceXToPlayer(playerx, xLocation);
		this.distanceYToPlayer = getDistanceYToPlayer(playery, yLocation);
		if (this.distanceXToPlayer >0) {
			moveRight();
		} else if (this.distanceXToPlayer <0) {
			moveLeft();
		} else if (this.distanceYToPlayer >0) {
			moveDown();
		} else if (this.distanceXToPlayer <0) {
			moveUp();
		} 
	}

	//Method for Enemy to move Y Coords
		

	}
