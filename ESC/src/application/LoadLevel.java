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
						level[i][o] = new Wall("https://images.unsplash.com/photo-1520758594221-872948699332?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
					} else if (s.charAt(o) == ' ') {
						level[i][o] = new Ground("https://www.colorcombos.com/images/colors/999999.png");
					} else if (s.charAt(o) == 'G') {
						//level[i][o] = new Goal("gate.png");
						level[i][o] = new Ground("https://www.colorcombos.com/images/colors/999999.png");
					} else if (s.charAt(o) == 'W') {
						level[i][o] = new Water("https://www.bhp.com/-/media/images/2018-water-report/180828_wr2018cover.jpg?mh=844&h=844&w=1500&la=en&hash=16406F779CD04F31FE68780D8A645746DB1A5A0C");
					} else if (s.charAt(o) == 'P') {
						level[i][o] = new Flipper("https://cdn5.vectorstock.com/i/1000x1000/81/84/blue-flippers-icon-icon-cartoon-vector-13848184.jpg");
					} else if (s.charAt(o) == 'F') {
						level[i][o] = new Fire("https://png.pngtree.com/png-clipart/20190918/ourmid/pngtree-flaming-fire-3406488-png-image_1737532.jpg");
					} else if (s.charAt(o) == 'B') {
						level[i][o] = new Boot("http://pngimg.com/uploads/boots/boots_PNG7801.png");
					} else if (s.charAt(o) == 'S') {
						//level[i][o] = new Start();
						level[i][o] = new Player("https://1001freedownloads.s3.amazonaws.com/vector/thumb/74889/1367934593.png", o, i);
						//level[i][o] = new Ground("https://www.colorcombos.com/images/colors/999999.png");
					} else if (s.charAt(o) == 'T') {
						level[i][o] = new Token("https://img.pngio.com/token-png-1-png-image-token-png-300_277.png");
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
