package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedReader;


public class FileLoader2 {
	@SuppressWarnings("resource")
	public static void loadLevel(String file) throws FileNotFoundException {
		File f = new File(file);
		Scanner in = null;
		char[][] level = new char[10][10];
		BufferedReader text = new BufferedReader(new FileReader("testmap.txt"));
		//check file exists
		try {
			in = new Scanner(text);
		}
		finally {
			System.out.println("Error: File not Found");
			System.exit(0);
		}


		String line = in.nextLine();
		int y = 0;
		while(in.hasNextLine())
		{
			Scanner readLine = new Scanner(line);
			makeLine(line,y,level);
			line = in.nextLine();
		}			
			
	}
	
	public static void makeLine(String in, int y, char[][] a) {
		for(int x = 0; x < in.length(); x++) {
			char cell = in.charAt(x);
			switch(cell) {
			case '#':
				a[y][x] = '#';
				break;
			case ' ':
				a[y][x] = ' ';
				break;
			case 'G':
				a[y][x] = 'G';
				break;
			case 'W':
				a[y][x] = 'W';
				break;
			case 'P':
				a[y][x] = 'P';
				break;
			case 'F':
				a[y][x] = 'F';
				break;
			case 'B':
				a[y][x] = 'B';
				break;
			case 'S':
				a[y][x] = 'S';
				break;
			case 'T':
				a[y][x] = 'T';
				break;
			}
		}
	}	

		
	public static void main(String[] args) {
		//System.out.println(loadLevel());
	}
}
