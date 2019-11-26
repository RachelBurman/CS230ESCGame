package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Water extends Cell{

	public Water() {
            super.setImage("https://www.bhp.com/-/media/images/2018-water-report/180828_wr2018cover.jpg?mh=844&h=844&w=1500&la=en&hash=16406F779CD04F31FE68780D8A645746DB1A5A0C");
	}
	
	public ImageView getWaterImage() {
		
		return super.getCellImage();
		
	}
}
