package moving;

import java.io.File;

import application.Cell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class represents all attributes and behaviours of a StriaghtLine Enemy.
 * @author Group 31
 * @version 3.0
 */
public class StraightLineEnemy extends NonTargetingEnemy {
	int frontX;
	int frontY;

	/**
	 * Constructor of StraightLine Enemy.
	 * @param name The name of the the enemy type.
	 * @param mapActual The map associated with StraightLine Enemy.
	 * @param info The array containing information on positioning and direction of enemy.
	 */
	public StraightLineEnemy(String name, Cell[][] mapActual, int[] info) {
		super(name,mapActual, info);
		this.xLocation = info[0];
		this.yLocation = info[1];
		File file = new File("./src/StraightEnemy.png");
		Image image = new Image(file.toURI().toString());
		this.EnemyImg = image;
		this.EnemyView = new ImageView(this.EnemyImg);
		this.EnemyView.setFitHeight(CELL_SIZE);
		this.EnemyView.setFitWidth(CELL_SIZE);

		// info[2] is either 1,2,3,4 up =1, down = 2, right = 3, left = 4
		switch (info[2]) {
		case 1:
			super.facing = 'u';
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
	public void moveY(int xLocation, int yLocation, char facing) {
		if (mapActual[xLocation][yLocation-1].getEnemyPass()==false && facing == 'u') {
			this.facing = 'd';
		} else if (mapActual[xLocation][yLocation + 1].getEnemyPass() == false && facing == 'd') {
			this.facing = 'u';
		}
		if (facing == 'u') {
			this.yLocation = yLocation + 1;
		} else if (facing == 'd') {
			this.yLocation = yLocation - 1;
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
		if ( facing == 'r') {
			if (mapActual[xLocation + 1][yLocation].getEnemyPass() == false) {
				this.facing = 'l';
			}

		} else if (facing == 'l') {
			if (mapActual[xLocation - 1][yLocation].getEnemyPass() == false) {
				this.facing = 'r';
			}
		}
		if (this.facing == 'r') {
			this.xLocation = xLocation + 1;
		} else if (this.facing == 'l') {
			this.xLocation = xLocation - 1;
		} 
	}

}

