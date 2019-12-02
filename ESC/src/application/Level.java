package application;
import application.Cell;
import application.LoadLevel;
public class Level {
	Cell[][] level;
	
	public Level (String File) {
		Cell[][] level = LoadLevel.loadLevel(File);
	}
}
