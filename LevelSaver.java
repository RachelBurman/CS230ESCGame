import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LevelSaver {
	public static void player(String playerName){
		Player player = Map.getPlayerOne();
		Level level = LevelLoader.getPlayerStart();
		Enemy enemy1 = Map.getEnenemyOne();
		Map map = Map.getMapActual();
		int x = player.getCurrentXLocation();
		int y = player.getCurrentYLocation();
		int a = enemy1.getCurrentXLocation();
		int b = enemy1.getCurrentYLocation();
		String playerCoord = x + "," + y;
		String enemyCoord = a + "," + b;
		
		//if file exists rewrite, otherwise make file 
		FileWriter writer = new FileWriter(player + ".txt", false);
		String playerFile = player.toString() + System.lineSeparator() + 
				level.toString + System.lineSeparator() + map.toString() + System.lineSeparator() 
				+ playerCoord + System.lineSeparator() + enemyCoord;
			
			

		
		
		//get the player from game
		//get the level from game
		//get the player time
		//get the player position
		//get the enemy positions
		//get the map position
	
	
	}
}