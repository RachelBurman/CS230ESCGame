package moving;

import java.io.File;

import application.Cell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class represents all attributes and behaviours of a DumbTargeting Enemy.
 * 
 * @author Group 31
 * @version 3.0
 */
public class DumbTargetingEnemy extends TargetingEnemy {

	/**
	 * The constructor of DumbTargetingEnemy. Sets attributes based on information
	 * read from file.
	 * 
	 * @param name      The name of the the enemy type.
	 * @param mapActual The map associated with WallFollowing Enemy.
	 * @param info      The array containing information on positioning and
	 *                  direction of enemy.
	 */
	public DumbTargetingEnemy(String name, Cell[][] mapActual, int[] info) {
		super(name, mapActual, info);
		this.xLocation = info[0];
		this.yLocation = info[1];
		this.playerx = super.xLocation;
		this.playery = super.yLocation;

		File file = new File("./src/Dumb.png");
		Image image = new Image(file.toURI().toString());
		this.EnemyImg = image;
		this.EnemyView = new ImageView(this.EnemyImg);

		this.EnemyView.setFitHeight(CELL_SIZE);
		this.EnemyView.setFitWidth(CELL_SIZE);

	}

	/**
	 * Method that moves enemy based on positioning of player.
	 */
	public void move() {
		this.distanceXToPlayer = getDistanceXToPlayer();
		this.distanceYToPlayer = getDistanceYToPlayer();
		if (this.distanceYToPlayer < 0) {
			moveUp();
		} else if (this.distanceYToPlayer > 0) {
			moveDown();
		} else if (this.distanceXToPlayer > 0) {
			moveRight();
		} else if (this.distanceXToPlayer < 0) {
			moveLeft();
		}
	}
}
