package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * TextFile Structure
 * First 2 Lines is size of map
 * Second 2 is Player start location
 * third 3 StraightLineEnemy location followed by 1,2,3,4 as up,down,right,left
 *
 */
/**
 * This class contains all attributes and behaviours of Level Loader.
 *
 * @author Group 31
 * @version 3.0
 */
public class LevelLoader {

	/**
	 * Method to get size of map.
	 *
	 * @param file Level file
	 * @return array with dimensions of map in X and Y
	 */
	public static int[] getSize(String file) {

		try {
			File f = new File(file);
			Scanner in = new Scanner(f);

			int[] size = new int[2];
			int x = in.nextInt();
			int y = in.nextInt();
			size[0] = x;
			size[1] = y;

			in.close();

			return size;

		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
			return null;
		}

	}

	/**
	 * Method to get Player start location in X and Y coordinates.
	 *
	 * @param file Level file
	 * @return array with player start location , X and Y.
	 */
	public static int[] getPlayerStart(String file) {

		try {
			File f = new File(file);
			Scanner in = new Scanner(f);
			int[] start = new int[2];
			in.nextLine();
			in.nextLine();
			int x = in.nextInt();
			int y = in.nextInt();
			start[0] = x;
			start[1] = y;
			in.close();
			return start;
		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
			return null;
		}

	}

	/**
	 * Method to get Straight Line enemy information.
	 *
	 * @param file Level file
	 * @return array with Straight Enemy information
	 */
	public static int[] getStraightEnemy(String file) {

		try {
			File f = new File(file);
			Scanner in = new Scanner(f);

			for (int i = 0; i < 4; i++) {
				in.nextLine();
			}

			int[] info = new int[3];
			int x = in.nextInt();// get startX
			int y = in.nextInt();// get startY
			int z = in.nextInt();// get directionfacing
			// z is either 1,2,3,4 up =1, down = 2, right = 3, left = 4
			info[0] = x;
			info[1] = y;
			info[2] = z;

			in.close();

			return info;

		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
			return null;
		}

	}

	/**
	 * Method to get information about the wall following enemy.
	 *
	 * @param file Level file
	 * @return Wall Following enemy information in an array
	 */
	public static int[] getWallFollowingEnemy(String file) {

		try {
			File f = new File(file);
			Scanner in = new Scanner(f);

			for (int i = 0; i < 7; i++) {
				in.nextLine();
			}

			int[] info = new int[3];
			int x = in.nextInt();// get startX
			int y = in.nextInt();// get startY
			int z = in.nextInt();// get directionfacing
			info[0] = x;
			info[1] = y;
			info[2] = z;

			in.close();

			return info;

		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
			return null;
		}

	}

	/**
	 * Method to get Dumb enemy information.
	 *
	 * @param file Level file.
	 * @return array wth dumb enemy information
	 */
	public static int[] getDumbEnemy(String file) {

		try {
			File f = new File(file);
			Scanner in = new Scanner(f);

			for (int i = 0; i < 10; i++) {
				in.nextLine();
			}

			int[] info = new int[2];
			info[0] = in.nextInt();
			info[1] = in.nextInt();

			in.close();

			return info;

		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
			return null;
		}

	}

	/**
	 * Get Teleporter link information
	 *
	 * @param file Level file
	 * @return teleporter link information in an array
	 */
	public static int[] getTeleporter(String file) {

		try {
			File f = new File(file);
			Scanner in = new Scanner(f);

			for (int i = 0; i < 12; i++) {
				in.nextLine();
			}

			int[] info = new int[4];
			info[0] = in.nextInt();
			info[1] = in.nextInt();
			info[2] = in.nextInt();
			info[3] = in.nextInt();

			in.close();

			return info;

		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
			return null;
		}

	}

	// Load file
	/**
	 * Load the level into an Array for the map.
	 * @param file Level file.
	 * @return 2D Cell array
	 */
	public static Cell[][] loadLevel(String file) {

		try {
			File f = new File(file);
			Scanner in = new Scanner(f);

			int x = in.nextInt();
			int y = in.nextInt();

			for (int i = 0; i < 15; i++) {
				in.nextLine();
			}

			Cell[][] level = new Cell[x][y];
			for (int newY = 0; newY < y; newY++) {
				String s = in.nextLine();
				for (int newX = 0; newX < x; newX++) {
					if (s.charAt(newX) == '#') {
						level[newX][newY] = new Wall("wall", newX, newY);
					} else if (s.charAt(newX) == 'G') {
						level[newX][newY] = new Goal("goal", newX, newY);
					} else if (s.charAt(newX) == 'W') {
						level[newX][newY] = new Water("water", newX, newY);
					} else if (s.charAt(newX) == 'F') {
						level[newX][newY] = new Fire("fire", newX, newY);
					} else if (s.charAt(newX) == 'R') {
						level[newX][newY] = new Door("red door", newX, newY);
					} else if (s.charAt(newX) == 'B') {
						level[newX][newY] = new Door("blue door", newX, newY);
					} else if (s.charAt(newX) == 'D') {
						level[newX][newY] = new Door("green door", newX, newY);
					} else if (s.charAt(newX) == 'A') {
						level[newX][newY] = new Key("red", newX, newY);
					} else if (s.charAt(newX) == 'C') {
						level[newX][newY] = new Key("blue", newX, newY);
					} else if (s.charAt(newX) == 'E') {
						level[newX][newY] = new Key("green", newX, newY);
					} else if (s.charAt(newX) == 'H') {
						level[newX][newY] = new Boot("boots", newX, newY);
					} else if (s.charAt(newX) == 'I') {
						level[newX][newY] = new Flipper("flippers", newX, newY);
					} else if (s.charAt(newX) == 'T') {
						level[newX][newY] = new Token("token", newX, newY);
					} else if (s.charAt(newX) == '2') {
						level[newX][newY] = new TokenDoor("2 door", newX, newY);
					} else if (s.charAt(newX) == '3') {
						level[newX][newY] = new TokenDoor("3 door", newX, newY);
					} else if (s.charAt(newX) == 'U') {
						level[newX][newY] = new TokenDoor("token door", newX, newY);
					} else if (s.charAt(newX) == 'S') {
						level[newX][newY] = new Teleporter("teleporter", newX, newY, file);
						// Add new Cells here, new Cells created through this
						// A redKey, B bluedoor, C bluekey, D greendoor, E greenkey, F fire, G goal, H
						// Boots, I Flipper, R redDoor,
						// T Token, U Token Door, W Water, Cell , # Wall, S teleporter // 2 TokenDoor2,
						// 3 TokenDoor3,
					} else if (s.charAt(newX) == ' ') {
						level[newX][newY] = new Cell("Cell", newX, newY);

					}

				}

			}

			in.close();

			return level;

		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
			return null;
		}

	}

}
