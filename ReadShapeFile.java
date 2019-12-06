
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author you
 *
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {

	// TODO: You will likely need to write four methods here. One method to
	// construct each shape
	// given the Scanner passed as a parameter. I would suggest static
	// methods in this case.

	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * 
	 * @param in the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue<ClosedShape> readDataFile(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();

		// read in the shape files and place them on the Queue

		// Right now, returning an empty Queue. You need to change this.

		while (in.hasNextLine()) {
			String shape = in.next();
			if (shape.equals("circle")) {
				shapeQueue.enqueue(readCircle(in));
			} else if (shape.equals("oval")) {
				shapeQueue.enqueue(readOval(in));
			} else if (shape.equals("square")) {
				shapeQueue.enqueue(readSquare(in));
			} else if (shape.equals("rect")) {
				shapeQueue.enqueue(readRect(in));
			} else if (shape.equals("text")) {
				shapeQueue.enqueue(readText(in));
			}

		}
		in.close();
		return shapeQueue;
	}

	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename) {
		// HINT: You might want to open a file here.
		Scanner in = null; // null is not sensible. Please change
		File inputFile = new File(filename);
		try {
			in = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open " + filename);
			System.exit(0);
		}
		return ReadShapeFile.readDataFile(in);

	}

	/**
	 * Method to read in the components to make a Circle and store them as different
	 * variables. Also prints out the shape to check if it reads correctly.
	 * 
	 * @param in the scanner of the file
	 * @return the circle shape instance
	 *
	 */

	public static Circle readCircle(Scanner in) {

		int px = in.nextInt();
		int py = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean filled = in.nextBoolean();
		int diameter = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		Color colour = Color.rgb(r, g, b);
		int insertionTime = in.nextInt();
		Circle circle1 = new Circle(insertionTime, px, py, vx, vy, diameter, colour, filled);

		System.out.println(circle1);
		return (circle1);

	}

	/**
	 * Method to read in the components to make an Oval and store them as different
	 * variables. Also prints out the shape to check if it reads correctly.
	 * 
	 * @param in the scanner of the file
	 * @return the oval shape instance
	 *
	 */

	public static Oval readOval(Scanner in) {

		int px = in.nextInt();
		int py = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean filled = in.nextBoolean();
		int width = in.nextInt();
		int height = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		Color colour = Color.rgb(r, g, b);
		int insertionTime = in.nextInt();
		Oval oval1 = new Oval(insertionTime, px, py, vx, vy, width, height, colour, filled);

		System.out.print(oval1);
		return (oval1);
	}

	/**
	 * Method to read in the components to make a Square and store them as different
	 * variables. Also prints out the shape to check if it reads correctly.
	 * 
	 * @param in the scanner of the file
	 * @return the square shape instance
	 *
	 */

	public static Square readSquare(Scanner in) {

		int px = in.nextInt();
		int py = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean filled = in.nextBoolean();
		int side = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		Color colour = Color.rgb(r, g, b);
		int insertionTime = in.nextInt();
		Square square1 = new Square(insertionTime, px, py, vx, vy, side, colour, filled);

		System.out.print(square1);
		return (square1);
	}

	/**
	 * Method to read in the components to make a Rectangle and store them as
	 * different variables. Also prints out the shape to check if it reads
	 * correctly.
	 * 
	 * @param in the scanner of the file
	 * @return the rectangle shape instance
	 *
	 */

	public static Rect readRect(Scanner in) {

		int px = in.nextInt();
		int py = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean filled = in.nextBoolean();
		int width = in.nextInt();
		int height = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		Color colour = Color.rgb(r, g, b);
		int insertionTime = in.nextInt();
		Rect rect1 = new Rect(insertionTime, px, py, vx, vy, width, height, colour, filled);

		System.out.print(rect1);
		return (rect1);
	}

	/**
	 * Method to read in the components to make a text shape and store them as
	 * different variables. Also prints out the shape to check if it reads
	 * correctly.
	 * 
	 * @param in the scanner of the file
	 * @return the text shape instance
	 *
	 */
	public static Text readText(Scanner in) {
		int px = in.nextInt();
		int py = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean filled = in.nextBoolean();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		Color colour = Color.rgb(r, g, b);
		int insertionTime = in.nextInt();
		String text = in.next();
		Text text1 = new Text(insertionTime, px, py, vx, vy, colour, filled, text);

		System.out.println(text1);
		return (text1);

	}

}
