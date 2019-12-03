package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Door extends Cell {

	public Door(String name, boolean playerPass, boolean enemyPass, int xCoordinate, int yCoordinate) {
		super(name, playerPass, enemyPass, xCoordinate, yCoordinate);
		this.name = name;
		Image image = null;;
		this.playerPass = playerPass;
		this.enemyPass = enemyPass;
		if (name.equalsIgnoreCase("red door")) {
			 image = new Image("https://windowsupplydirectltd.co.uk/wp-content/uploads/2017/10/TR04-Cezanne-signal-red.jpg");
		} else if (name.equalsIgnoreCase("blue door")) {
			image = new Image ("https://cdn.shopify.com/s/files/1/2467/9369/products/il_fullxfull.1326590766_j4vi_2048x.jpg?v=1527481196");
		} else if (name.equalsIgnoreCase("green door")) {
			image = new Image ("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSNF92OFFw8iuImZBFQFEUWlg9ziGNTQQL5eIDah_lhz5oV19W4");
		}
	    
		this.cellImage = image;
		this.cellView = new ImageView(cellImage);
		this.cellView.setFitHeight(CELL_SIZE);
		this.cellView.setFitWidth(CELL_SIZE);
		// TODO Auto-generated constructor stub
	}

}