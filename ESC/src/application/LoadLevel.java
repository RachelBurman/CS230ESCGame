package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import moving.Player;

public class LoadLevel {
	//public static char[][] loadLevel(String file) {
	public static Cell[][] loadLevel(String file) {
		try
		{
			File f = new File(file);
			Scanner in = new Scanner(f);
			int x = in.nextInt();
			int y = in.nextInt();
			Cell[][] level = new Cell[x][y];
			//char[][] level = new char[x][y];
			in.nextLine();
			for (int i = 0; i<x; i++) {
				String s = in.nextLine();
				for (int o = 0; o<y; o++) {
					if (s.charAt(o) == '#') {
						level[i][o] = new Wall();
					} else if (s.charAt(o) == ' ') {
						level[i][o] = new Ground();
					} else if (s.charAt(o) == 'G') {
						//level[i][o] = new Goal("gate.png");
						level[i][o] = new Ground();
					} else if (s.charAt(o) == 'W') {
						level[i][o] = new Water();
					} else if (s.charAt(o) == 'P') {
						level[i][o] = new Flipper();
					} else if (s.charAt(o) == 'F') {
						level[i][o] = new Fire();
					} else if (s.charAt(o) == 'B') {
						level[i][o] = new Boot();
					} else if (s.charAt(o) == 'S') {
						//level[i][o] = new Start();
						level[i][o] = new Player(o, i);
						//level[i][o] = new Ground();
					} else if (s.charAt(o) == 'T') {
						level[i][o] = new Token();
					}
					//level[i][o]=s.charAt(o)
				}
			}
			while (in.hasNextLine()) {
				
			}
			in.close();
			return level;
		} 
		catch (FileNotFoundException exception) 
		{
			System.out.println("ERROR: Level File does not exist.");
			return null;
		}
	}
	public static int getWidth(String file) {
		try
		{
			File f = new File(file);
			Scanner in = new Scanner(f);
			in.nextInt();
			int y = in.nextInt();
			
			in.close();
			return y;
		} 
		catch (FileNotFoundException exception) 
		{
			System.out.println("ERROR: Level File does not exist.");
			return 0;
		}
	}
}
