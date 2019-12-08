package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import moving.Player;
import moving.StraightLineEnemy;
import moving.WallFollowingEnemy;
import moving.DumbTargetingEnemy;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
/**
 * This class is made for the game to actually run.
 * It is also used to set a few of the JavaFX elements.
 * @author Jonathan
 * @version 1.5
 *
 */
public class Game extends Application {

	private static final String PROFILES_FILE = "./Profiles.txt";
	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 600;
	private static final int IMAGE_SIZE = 32;
	private static final Font FONT_SIZE = new Font(18);
	private static String startFile;

	private static long startTime;
	private static String username;
	private static Stage primaryStage;
	private static String profile;
	VBox boxA = new VBox();

	/**
	 * Method to start the actual game with the level and person information.
	 * Also starts the JavaFX elements to display the game.
	 * @param startFile- String of the textfile with the level
	 * @param profile- profile of the person playing
	 * @param username- username of the person playing
	 */
	public void start(String startFile, String profile, String username) {

		this.profile = profile;
		this.username = username;
		this.primaryStage = new Stage();
		this.startFile = startFile;
		
		BorderPane root = new BorderPane();
		GridPane grid = MapManager.sharedMapManager().getGrid();
		root.setCenter(grid);
		grid.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

		MapManager.sharedMapManager().setMap(new Map(this.startFile));
		root.setTop(topGUI());


		// Register an event handler for key presses

		scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> processKeyEvent(event));
		drawGame();
		startTime = System.nanoTime();

		try {
			primaryStage.setScene(scene);
			primaryStage.setTitle("E.S.C");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Start method ended");

	}

	/**
	 * Builds the GUI elements above the game.
	 * Includes number of keys, tokens for the player to see.
	 * @return a vertical box with the elements inside
	 */
	public VBox topGUI() {
		boxA.getChildren().clear();
		HBox first = topGUIA();
		HBox second = topGUIB();
		boxA.getChildren().addAll(first,second);
		return boxA;

	}
	private HBox topGUIA() {
		HBox box1 = new HBox();
		Player player1 = MapManager.sharedMapManager().getMap().getPlayer1();
		Label file = new Label("Current level" +startFile);
		file.setFont(FONT_SIZE);
		Label tokens = new Label("Tokens: " + player1.getTokens());
		tokens.setFont(FONT_SIZE);
		Label red = new Label("Red Keys: " + player1.getRedKey());
		red.setTextFill(Color.web("#FF0000"));
		red.setFont(FONT_SIZE);
		Label green = new Label("Green Keys: " + player1.getGreenKey());
		green.setTextFill(Color.web("#008000"));
		green.setFont(FONT_SIZE);
		Label blue = new Label("Blue Keys: " + player1.getBlueKey());
		blue.setTextFill(Color.web("#0000FF"));
		blue.setFont(FONT_SIZE);
		Button back = new Button("Save & Quit");
		back.setAlignment(Pos.TOP_RIGHT);
		back.setFont(new Font(14));
		back.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	primaryStage.close();
		    }
		});
		box1.getChildren().addAll(file, tokens, red, green, blue,back);
		box1.setSpacing(30);
		return box1;
	}
	private HBox topGUIB() {
		HBox box2 = new HBox();
		box2.getChildren().clear();
		Player player1 =MapManager.sharedMapManager().getMap().getPlayer1();
		File flipperFile = new File("./src/flipper.png");
		Image flipperImage = new Image(flipperFile.toURI().toString());
		ImageView flipperView = new ImageView(flipperImage);
		flipperView.setFitHeight(IMAGE_SIZE);
		flipperView.setFitWidth(IMAGE_SIZE);
		File bootsFile = new File("./src/boot.jpg");
		Image bootsImage = new Image(bootsFile.toURI().toString());
		ImageView bootsView = new ImageView(bootsImage);
		bootsView.setFitHeight(IMAGE_SIZE);
		bootsView.setFitWidth(IMAGE_SIZE);
		Label boot = new Label();
		boot.setText("Boots on");
		boot.setFont(FONT_SIZE);
		Label flipper = new Label();
		flipper.setText("Flipper on");
		flipper.setFont(FONT_SIZE);
		box2.getChildren().add(flipperView);
		box2.getChildren().add(flipper);
		if (player1.getFlippers()==true) {
			flipper.setVisible(true);
		} else {
			flipper.setVisible(false);
		}

		box2.getChildren().add(bootsView);
		box2.getChildren().add(boot);
		if (player1.getBoots()==true) {
			boot.setVisible(true);
		} else {
			boot.setVisible(false);
		}
		box2.setSpacing(30);
		return box2;


	}
	/**
	 * A method to draw the game outfor the user to see
	 * @param the current grid that is showing the game
	 * @return the grid that has the updated information for it to be displayed
	 */
	public GridPane drawGame() {
		GridPane grid = MapManager.sharedMapManager().getGrid();
		grid.getChildren().clear();
		Map map = MapManager.sharedMapManager().getMap();

		int scopeXmin;
		int scopeXmax;
		int scopeYmin;
		int scopeYmax;
		int width = map.getMapLength();
		int height = map.getMapHeight();
		int playerXLocation = map.getPlayer1().getxLocation();
		int playerYLocation = map.getPlayer1().getyLocation();

		if (playerXLocation - 3 < 0) {
			scopeXmin = 0;
		} else {
			scopeXmin = playerXLocation - 3;
		}
		if (playerXLocation + 4 > width) {
			scopeXmax = width;
		} else {
			scopeXmax = playerXLocation + 4;
		}
		if (playerYLocation - 3 < 0) {
			scopeYmin = 0;
		} else {
			scopeYmin = playerYLocation - 3;
		}
		if (playerYLocation + 4 > height) {
			scopeYmax = height;
		} else {
			scopeYmax = playerYLocation + 4;
		}

		for (int newY = scopeYmin; newY < scopeYmax; newY++) {
			for (int NewX = scopeXmin; NewX < scopeXmax; NewX++) {
				grid.add(map.getCell(NewX, newY).getView(), NewX, newY);
			}
		}
		// Draw Grid using GridPane
		/*
		 * for (int y = 0; y < actualMap.getMapHeight(); y++) { for (int x = 0;
		 * x < actualMap.getMapLength(); x++) { // Add new types of cells here
		 * grid.add(actualMap.getCell(x, y).getView(), x, y); } }
		 */
		Player player = map.getPlayer1();
		StraightLineEnemy enemy1 = map.getEnemy1();
		DumbTargetingEnemy enemy2 = map.getDummieAt(0);
		WallFollowingEnemy enemy3 = map.getWallFollowAt(0);

		grid.add(player.getPlayerView(), player.getxLocation(), player.getyLocation());
		if (enemy1.getXLocation() < scopeXmax && enemy1.getXLocation() > scopeXmin) {
			if (enemy1.getYLocation() < scopeYmax && enemy1.getYLocation() > scopeYmin) {
				grid.add(enemy1.getEnemyView(), enemy1.getXLocation(), enemy1.getYLocation());
			}

		}
		if (map.getDummieAt(0).getXLocation() < scopeXmax && map.getDummieAt(0).getXLocation() > scopeXmin) {
			if (map.getDummieAt(0).getYLocation() < scopeYmax && map.getDummieAt(0).getYLocation() > scopeYmin) {
				grid.add(map.getDummieAt(0).getEnemyView(), map.getDummieAt(0).getXLocation(),
						map.getDummieAt(0).getYLocation());
			}

		}

		if (map.getWallFollowAt(0).getXLocation() < scopeXmax && map.getWallFollowAt(0).getXLocation() > scopeXmin) {
			if (map.getWallFollowAt(0).getYLocation() < scopeYmax
					&& map.getWallFollowAt(0).getYLocation() > scopeYmin) {
				grid.add(map.getWallFollowAt(0).getEnemyView(), map.getWallFollowAt(0).getXLocation(),
						map.getWallFollowAt(0).getYLocation());
			}

		}

		return grid;

	}
	/**
	 * Method to detect directional key presses and then use it to move the player around the game.
	 * Then returns he GUI and the grid updated
	 * @param event - the keyboard press
	 */
	public void processKeyEvent(KeyEvent event) {

		Map map = MapManager.sharedMapManager().getMap();
		GridPane grid = MapManager.sharedMapManager().getGrid();
		int currentX = map.getPlayer1().getxLocation();
		int currentY = map.getPlayer1().getyLocation();

		switch (event.getCode()) {

		case RIGHT:
			// Right key was pressed. So move the player right by one cell.
			// openDoor(player, actualMap, player.getxLocation() + 1,
			// player.getyLocation());
			map.openDoor(currentX + 1, currentY);
			map.getPlayer1().moveRight();
			map.doAction();
			// player.moveRight();

			break;
		case LEFT:
			// Left key was pressed. So move the player left by one cell.
			// openDoor(player, actualMap, player.getxLocation() - 1,
			// player.getyLocation());
			map.openDoor(currentX - 1, currentY);
			map.getPlayer1().moveLeft();
			map.doAction();
			// player.moveLeft();

			break;
		case UP:
			// Up key was pressed. So move the player up by one cell.
			// openDoor(player, actualMap, player.getxLocation(),
			// player.getyLocation() - 1);
			map.openDoor(currentX, currentY - 1);
			map.getPlayer1().moveUp();
			map.doAction();
			// player.moveUp();

			break;
		case DOWN:
			// Down key was pressed. So move the player down by one cell.
			// openDoor(player, actualMap, player.getxLocation(),
			// player.getyLocation() + 1);
			map.openDoor(currentX, currentY + 1);
			map.getPlayer1().moveDown();
			map.doAction();
			// player.moveDown();

			break;
		default:
			// Do nothing
			break;
		}
		topGUI();
		loseGame();
		map.StraightLineMove();
		map.DumbMove();
		map.WallFollowMove();
		loseGame();

		event.consume();

	}
	/**
	 * Detects when the player loses the game.
	 * Then restarts the game
	 * @param grid that the player is on 
	 */
	public void loseGame() {
		GridPane grid = MapManager.sharedMapManager().getGrid();
		Map map = MapManager.sharedMapManager().getMap();

		int playerXLocation = map.getPlayer1().getxLocation();
		int playerYLocation = map.getPlayer1().getyLocation();
		int StraightEnemyX = map.getEnemy1().getXLocation();
		int StraightEnemyY = map.getEnemy1().getYLocation();
		int DumbEnemyX = map.getDummieAt(0).getXLocation();
		int DumbEnemyY = map.getDummieAt(0).getYLocation();
		int WallFollowX = map.getWallFollowAt(0).getXLocation();
		int WallFollowY = map.getWallFollowAt(0).getYLocation();

		if (playerXLocation == StraightEnemyX && playerYLocation == StraightEnemyY) {
			System.out.println("Game OVer");
			restart();
		} else if (playerXLocation == StraightEnemyX && playerYLocation == StraightEnemyY) {
			System.out.println("Game OVer");
			restart();
		} else if (playerXLocation == DumbEnemyX && playerYLocation == DumbEnemyY) {
			System.out.println("Game OVer");
			restart();
		} else if (playerXLocation == WallFollowX && playerYLocation == WallFollowY) {
			System.out.println("Game OVer");
			restart();
		} else if (map.getCell(playerXLocation, playerYLocation).getName().equalsIgnoreCase("fire")
				&& map.getPlayer1().getBoots() == false) {
			System.out.println("Game OVer");
			restart();
		} else if (map.getCell(playerXLocation, playerYLocation).getName().equalsIgnoreCase("water")
				&& map.getPlayer1().getFlippers() == false) {
			System.out.println("Game OVer");
			restart();
		}

		upLevel();
		drawGame();

	}
	
	private static void restart() {
		GridPane grid = MapManager.sharedMapManager().getGrid();
		startTime = System.nanoTime();
		grid.getChildren().clear();
		Map newMap = new Map(startFile);
		MapManager.sharedMapManager().setMap(newMap);

	}

	private static void upLevel() {

		int playerX = MapManager.sharedMapManager().getMap().getPlayer1().getxLocation();
		int playerY = MapManager.sharedMapManager().getMap().getPlayer1().getyLocation();
		Cell current = MapManager.sharedMapManager().getMap().getCell(playerX, playerY);
		GridPane grid = MapManager.sharedMapManager().getGrid();
		long endTime = System.nanoTime();
		long duration;
		duration = (endTime - startTime) / 1000000000;

		Map map = MapManager.sharedMapManager().getMap();

		if (current.getName().equalsIgnoreCase("goal")) {
			switch (startFile) {

			case "./lvl1.txt":
				updateProfileLevel(profile);
				LevelChangeWindow.display(startFile);
				Leaderboard.checkNewLevelComplete("lvl1", (int) duration, username);
				startFile = "./lvl2.txt";
				restart();
				break;
			case "./lvl2.txt":
				updateProfileLevel(profile);
				LevelChangeWindow.display(startFile);
				Leaderboard.checkNewLevelComplete("lvl2", (int) duration, username);
				startFile = "./lvl3.txt";
				restart();
				break;
			case "./lvl3.txt":
				updateProfileLevel(profile);
				LevelChangeWindow.display(startFile);
				Leaderboard.checkNewLevelComplete("lvl3", (int) duration, username);
				startFile = "./lvl4.txt";
				restart();
				break;
			case "./lvl4.txt":
				updateProfileLevel(profile);
				LevelChangeWindow.display(startFile);
				Leaderboard.checkNewLevelComplete("lvl4", (int) duration, username);
				startFile = "./lvl5.txt";
				restart();
				break;
			default:
				Leaderboard.checkNewLevelComplete("lvl5", (int) duration, username);
				grid.getChildren().clear();
				WinWindow.display(primaryStage);
				MapManager.sharedMapManager().setMap(null);
				break;
			}

		}

	}

	private static void updateProfileLevel(String user) {

		String line = "";
		int howManyProfiles = 0;
		String profile1Name = "";
		int profile1Level = 0;
		String profile2Name = "";
		int profile2Level = 0;
		String profile3Name = "";
		int profile3Level = 0;
		String profile4Name = "";
		int profile4Level = 0;
		String profile5Name = "";
		int profile5Level = 0;

		try {
			File f = new File(PROFILES_FILE);
			Scanner in = new Scanner(f);
			if (in.hasNextLine()) {
				profile1Name = in.nextLine();
				howManyProfiles++;
			}
			if (in.hasNextLine()) {
				line = in.nextLine();
				if (!(line.equals(""))) {
					profile2Name = line;
					howManyProfiles++;
				}
			}
			if (in.hasNextLine()) {
				line = in.nextLine();
				if (!(line.equals(""))) {
					profile3Name = line;
					howManyProfiles++;
				}
			}
			if (in.hasNextLine()) {
				line = in.nextLine();
				if (!(line.equals(""))) {
					profile4Name = line;
					howManyProfiles++;
				}
			}
			if (in.hasNextLine()) {
				line = in.nextLine();
				if (!(line.equals(""))) {
					profile5Name = line;
					howManyProfiles++;
				}
			}
			if (howManyProfiles > 0) {
				profile1Level = in.nextInt();
				in.nextLine();
			}
			if (howManyProfiles > 1) {
				profile2Level = in.nextInt();
				in.nextLine();
			}
			if (howManyProfiles > 2) {
				profile3Level = in.nextInt();
				in.nextLine();
			}
			if (howManyProfiles > 3) {
				profile4Level = in.nextInt();
				in.nextLine();
			}
			if (howManyProfiles > 4) {
				profile5Level = in.nextInt();
			}
		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
		}

		switch (user) {
		case "Profile 1":
			try {
				File outputFile = new File(PROFILES_FILE);
				PrintWriter out = null;
				out = new PrintWriter(outputFile);
				out.println(profile1Name);
				out.println(profile2Name);
				out.println(profile3Name);
				out.println(profile4Name);
				out.println(profile5Name);
				out.println(profile1Level + 1);
				out.println(profile2Level);
				out.println(profile3Level);
				out.println(profile4Level);
				out.println(profile5Level);
				out.close();
			} catch (FileNotFoundException e) {
				System.out.println("ERROR: Level File does not exist");
			}
			break;
		case "Profile 2":
			try {
				File outputFile = new File(PROFILES_FILE);
				PrintWriter out = null;
				out = new PrintWriter(outputFile);
				out.println(profile1Name);
				out.println(profile2Name);
				out.println(profile3Name);
				out.println(profile4Name);
				out.println(profile5Name);
				out.println(profile1Level);
				out.println(profile2Level + 1);
				out.println(profile3Level);
				out.println(profile4Level);
				out.println(profile5Level);
				out.close();
			} catch (FileNotFoundException e) {
				System.out.println("ERROR: Level File does not exist");
			}
			break;
		case "Profile 3":
			try {
				File outputFile = new File(PROFILES_FILE);
				PrintWriter out = null;
				out = new PrintWriter(outputFile);
				out.println(profile1Name);
				out.println(profile2Name);
				out.println(profile3Name);
				out.println(profile4Name);
				out.println(profile5Name);
				out.println(profile1Level);
				out.println(profile2Level);
				out.println(profile3Level + 1);
				out.println(profile4Level);
				out.println(profile5Level);
				out.close();
			} catch (FileNotFoundException e) {
				System.out.println("ERROR: Level File does not exist");
			}
			break;
		case "Profile 4":
			try {
				File outputFile = new File(PROFILES_FILE);
				PrintWriter out = null;
				out = new PrintWriter(outputFile);
				out.println(profile1Name);
				out.println(profile2Name);
				out.println(profile3Name);
				out.println(profile4Name);
				out.println(profile5Name);
				out.println(profile1Level);
				out.println(profile2Level);
				out.println(profile3Level);
				out.println(profile4Level + 1);
				out.println(profile5Level);
				out.close();
			} catch (FileNotFoundException e) {
				System.out.println("ERROR: Level File does not exist");
			}
			break;
		case "Profile 5":
			try {
				File outputFile = new File(PROFILES_FILE);
				PrintWriter out = null;
				out = new PrintWriter(outputFile);
				out.println(profile1Name);
				out.println(profile2Name);
				out.println(profile3Name);
				out.println(profile4Name);
				out.println(profile5Name);
				out.println(profile1Level);
				out.println(profile2Level);
				out.println(profile3Level);
				out.println(profile4Level);
				out.println(profile5Level + 1);
				out.close();
			} catch (FileNotFoundException e) {
				System.out.println("ERROR: Level File does not exist");
			}
			break;
		default:

			break;
		}

	}
	/**
	 * Returns the gameStage
	 * @return primaryStage
	 */

	public Stage getGameStage() {

		return primaryStage;

	}

	@Override
	public void start(Stage arg0) throws Exception {

		// TODO Auto-generated method stub

	}

}
