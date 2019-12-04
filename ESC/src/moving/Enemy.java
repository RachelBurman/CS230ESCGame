package moving;

import application.Map;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Enemy extends Movable {
	protected Image EnemyImg;
	protected ImageView EnemyView;

	public Enemy(String name, int[] location) {
		super(name);
		super.xLocation = location[0];
		super.yLocation = location[1];
		
		// TODO Auto-generated constructor stub
	}
	protected boolean validMove(int xLocation, int yLocation, int newXLocation, int newYLocation, Map map) {
		if (map.getCell(newXLocation, newYLocation).getEnemyPass()) {
			
			return true;
			} else {
				
				return false;
			}
	}
	public Image getEnemyImg() {
		return this.EnemyImg;
	}

	public ImageView getEnemyView() {
		return this.EnemyView;
	}
	
	

}