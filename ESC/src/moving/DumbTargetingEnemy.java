package moving;

import java.io.File;

import application.Cell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DumbTargetingEnemy extends TargetingEnemy {
	
	public DumbTargetingEnemy(String name, Cell[][] mapActual, int[] info) {
		super(name, mapActual, info);
		// TODO Auto-generated constructor stub
		this.xLocation = info[0];
		this.yLocation = info[1];
		this.playerx = super.xLocation;
		this.playery= super.yLocation;

		File file = new File("ESC/src/Dumb.png");
	  Image image = new Image(file.toURI().toString());
		this.EnemyImg = image;
		this.EnemyView = new ImageView(this.EnemyImg);
		
		this.EnemyView.setFitHeight(CELL_SIZE);
		this.EnemyView.setFitWidth(CELL_SIZE);
		// info[3] is either 1,2,3,4 up =1, down = 2, right = 3, left = 4

	}
	
	public void move() {
		this.distanceXToPlayer = getDistanceXToPlayer();
		this.distanceYToPlayer = getDistanceYToPlayer();
		if (this.distanceYToPlayer <0) {
			moveUp();
		} else if (this.distanceYToPlayer >0) {
			moveDown();
		} else if (this.distanceXToPlayer >0) {
			moveRight();
		} else if (this.distanceXToPlayer <0) {
			moveLeft();
		} 
	}

	//Method for Enemy to move Y Coords
		

}

