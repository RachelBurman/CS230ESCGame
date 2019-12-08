package application;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class StateSaver {
	
	public static void stateSave(Map map) {
		int playerX = map.getPlayer1().getxLocation();
		int playerY = map.getPlayer1().getyLocation();
		
		
	}
	
	public static void write() {
		
	}
			  throws IOException {
			    String str = "Hello";
			    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			    writer.write(str);
			     
			    writer.close();
			}

}
