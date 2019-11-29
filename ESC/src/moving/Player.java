package moving;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Player extends Movable {
	Color colour;
	Image playerImage;

	public Player(int currentXLocation, int currentYLocation,Color colour, Image playerImage) {
		super(currentXLocation, currentYLocation);
		this.colour = colour;
		this.playerImage = playerImage;
		
		// TODO Auto-generated constructor stub
	}

}
