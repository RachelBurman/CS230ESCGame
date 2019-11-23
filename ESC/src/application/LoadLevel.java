package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadLevel {
	public static char[][] loadLevel(String file) {
	/// public static Cell[][] loadLevel(String file) {
		try
		{
			File f = new File(file);
			Scanner in = new Scanner(f);
			int x = in.nextInt();
			int y = in.nextInt();
			//Cell[][] level = new Cell[][];
			char[][] level = new char[x][y];
			in.nextLine();
			for (int i = 0; i<x; i++) {
				String s = in.nextLine();
				for (int o = 0; o<y; o++) {
					//if (s.charAt(o) == '#') {
					//	level[i][o] = Wall;
					//} else if (s.charAt(o) == ' ') {
					//	level[i][o] = Ground;
					//} else if (s.charAt(o) == 'G') {
					//	level[i][o] = Goal;
					//} else if (s.charAt(o) == 'W') {
					//	level[i][o] = Water;
					//} else if (s.charAt(o) == 'P') {
					//	level[i][o] = Flippers;
					//} else if (s.charAt(o) == 'F') {
					//	level[i][o] = Fire;
					//} else if (s.charAt(o) == 'B') {
					//	level[i][o] = Boots;
					//} else if (s.charAt(o) == 'S') {
					//	level[i][o] = Start;
					//} else if (s.charAt(o) == 'T') {
					//	level[i][o] = Token;
					level[i][o]=s.charAt(o);
				}
			}
			//while (in.hasNextLine()) {
			//This is where the more specified Cells and enemies will go	
			//}
			in.close();
			return level;
		} 
		catch (FileNotFoundException exception) 
		{
			System.out.println("ERROR: Level File does not exist.");
			return null;
		}
	}
}
