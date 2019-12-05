package application;

import java.awt.TextField;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import moving.Player;
import moving.StraightLineEnemy;
import moving.DumbTargetingEnemy;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 500;

	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		root.setTop(makeHBox());
		GridPane grid = new GridPane();
		root.setCenter(grid);
		grid.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		Map actualMap = new Map("lvl1.txt");
		//StraightLineEnemy enemy1 = actualMap.getEnemy1();

		// Enemies need to be created here
		// Register an event handler for key presses
		scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> processKeyEvent(event, actualMap, grid));
		drawGame(actualMap, grid);
		try {
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public HBox makeHBox() {
		HBox box = new HBox();
		Label label = new Label("test.file");
		box.getChildren().add(label);
		return box;

	}

	public GridPane drawGame(Map actualMap, GridPane grid) {
		grid.getChildren().clear();

		int scopeXmin;
		int scopeXmax;
		int scopeYmin;
		int scopeYmax;
		int width = actualMap.getMapLength();

		int height = actualMap.getMapHeight();
		int playerXLocation = actualMap.getPlayer1().getxLocation();
		int playerYLocation = actualMap.getPlayer1().getyLocation();
		System.out.println(" My X is" + playerXLocation+ " My Y is" + playerYLocation);
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
			//System.out.println(playerY);
			//System.out.println(y);
			scopeYmax = height;
			//System.out.println(scopeYmax);
		} else {
			scopeYmax = playerYLocation + 4;
		}

		for (int newY = scopeYmin; newY<scopeYmax; newY++) {
			for (int NewX = scopeXmin; NewX<scopeXmax; NewX++) {
				grid.add(actualMap.getCell(NewX, newY).getView(), NewX, newY);
			}
		}
		// Draw Grid using GridPane
		/*for (int y = 0; y < actualMap.getMapHeight(); y++) {
			for (int x = 0; x < actualMap.getMapLength(); x++) {
				// Add new types of cells here
				grid.add(actualMap.getCell(x, y).getView(), x, y);
			}
		}
		*/
		Player player = actualMap.getPlayer1();
		StraightLineEnemy enemy1 = actualMap.getEnemy1();
		DumbTargetingEnemy enemy2 = actualMap.getDummieAt(0);
		grid.add(player.getPlayerView(), player.getxLocation(), player.getyLocation());
		if (enemy1.getXLocation()<scopeXmax && enemy1.getXLocation()>scopeXmin) {
			if (enemy1.getYLocation()<scopeYmax && enemy1.getYLocation()>scopeYmin) {
				grid.add(enemy1.getEnemyView(), enemy1.getXLocation(), enemy1.getYLocation());
			}

		}
		if (actualMap.getDummieAt(0).getXLocation()<scopeXmax && actualMap.getDummieAt(0).getXLocation()>scopeXmin) {
			if (actualMap.getDummieAt(0).getYLocation()<scopeYmax && actualMap.getDummieAt(0).getYLocation()>scopeYmin) {
				grid.add(actualMap.getDummieAt(0).getEnemyView(), actualMap.getDummieAt(0).getXLocation(), actualMap.getDummieAt(0).getYLocation());
			}

		}


		return grid;
	}

	public void processKeyEvent(KeyEvent event, Map actualMap, GridPane grid) {
		int currentX =actualMap.getPlayer1().getxLocation();
		int currentY =actualMap.getPlayer1().getyLocation();
		switch (event.getCode()) {

		case RIGHT:
			// Right key was pressed. So move the player right by one cell.
			//openDoor(player, actualMap, player.getxLocation() + 1, player.getyLocation());
			actualMap.openDoor(currentX+1, currentY);
			actualMap.getPlayer1().moveRight();
			actualMap.doAction();
			//player.moveRight();

			break;
		case LEFT:
			// Left key was pressed. So move the player left by one cell.
			//openDoor(player, actualMap, player.getxLocation() - 1, player.getyLocation());
			actualMap.openDoor(currentX-1, currentY);
			actualMap.getPlayer1().moveLeft();
			actualMap.doAction();
			//player.moveLeft();

			break;
		case UP:
			// Up key was pressed. So move the player up by one cell.
			//openDoor(player, actualMap, player.getxLocation(), player.getyLocation() - 1);
			actualMap.openDoor(currentX, currentY-1);
			actualMap.getPlayer1().moveUp();
			actualMap.doAction();
			//player.moveUp();

			break;
		case DOWN:
			// Down key was pressed. So move the player down by one cell.
			//openDoor(player, actualMap, player.getxLocation(), player.getyLocation() + 1);
			actualMap.openDoor(currentX, currentY+1);
			actualMap.getPlayer1().moveDown();
			actualMap.doAction();
			//player.moveDown();

			break;

		default:
			// Do nothing
			break;
		}
		/*
		int LocalXLocation = player.getxLocation();
		int LocalYLocation = player.getyLocation();
		if (actualMap.getCell(LocalXLocation, LocalYLocation).getName().equalsIgnoreCase("red")) {
			actualMap.removeCell(actualMap, player.getxLocation(), player.getyLocation());
			actualMap.addCell(actualMap, player.getxLocation(), player.getyLocation());
			player.addRedKey();
		} else if (actualMap.getCell(LocalXLocation, LocalYLocation).getName().equalsIgnoreCase("blue")) {
			actualMap.removeCell(actualMap, player.getxLocation(), player.getyLocation());
			actualMap.addCell(actualMap, player.getxLocation(), player.getyLocation());
			player.addBlueKey();
		} else if (actualMap.getCell(LocalXLocation, LocalYLocation).getName().equalsIgnoreCase("green")) {
			actualMap.removeCell(actualMap, player.getxLocation(), player.getyLocation());
			actualMap.addCell(actualMap, player.getxLocation(), player.getyLocation());
			player.addGreenKey();
		} else if (actualMap.getCell(LocalXLocation, LocalYLocation).getName().equalsIgnoreCase("boots")) {
			actualMap.removeCell(actualMap, player.getxLocation(), player.getyLocation());
			actualMap.addCell(actualMap, player.getxLocation(), player.getyLocation());
			player.changeBoot();
		} else if (actualMap.getCell(LocalXLocation, LocalYLocation).getName().equalsIgnoreCase("flippers")) {
			actualMap.removeCell(actualMap, player.getxLocation(), player.getyLocation());
			actualMap.addCell(actualMap, player.getxLocation(), player.getyLocation());
			player.changeFlipper();
		} else if (actualMap.getCell(LocalXLocation, LocalYLocation).getName().equalsIgnoreCase("token")) {
			actualMap.removeCell(actualMap, player.getxLocation(), player.getyLocation());
			actualMap.addCell(actualMap, player.getxLocation(), player.getyLocation());
			player.addToken();
		} else if (actualMap.getCell(LocalXLocation, LocalYLocation).getName().equalsIgnoreCase("teleporter")) {
			player.teleport();
		}*/

		/*if (enemy1.getFacing() == 'u' || enemy1.getFacing() == 'd') {
			enemy1.moveY(enemy1.getXLocation(), enemy1.getYLocation(), enemy1.getFacing());
		} else {
			enemy1.moveX(enemy1.getXLocation(), enemy1.getYLocation(), enemy1.getFacing());
		}*/

		/*if (player.getXLocation() == enemy1.getXLocation() && player.getYLocation() == enemy1.getYLocation()) {
			System.out.println("Game OVer");
		} else {
			drawGame(actualMap, grid, player, enemy1);
		}
		*/
		actualMap.StraightLineMove();
		actualMap.DumbMove();
		loseGame(actualMap,grid);

		event.consume();
	}

	public void loseGame (Map actualMap, GridPane grid) {
		int playerXLocation = actualMap.getPlayer1().getxLocation();
		int playerYLocation = actualMap.getPlayer1().getyLocation();
		int StraightEnemyX = actualMap.getEnemy1().getXLocation();
		int StraightEnemyY = actualMap.getEnemy1().getYLocation();
		Map current = actualMap;
		if (playerXLocation== StraightEnemyX && playerYLocation == StraightEnemyY) {
			System.out.println("Game OVer");
			current = new Map("test.txt");
		}

		drawGame(current, grid);

	}

	/*public void openDoor(Player player, Map actualMap, int nextX, int nextY) {

		if (actualMap.getCell(nextX, nextY).getName().equalsIgnoreCase("red door") && player.getRedKey() > 0) {
			actualMap.getCell(nextX, nextY).changePlayerPass();
			actualMap.getCell(nextX, nextY).changeEnemyPass();
			player.minusRedKey();
		} else if (actualMap.getCell(nextX, nextY).getName().equalsIgnoreCase("green door") && player.getGreenKey() > 0) {
			actualMap.getCell(nextX, nextY).changePlayerPass();
			actualMap.getCell(nextX, nextY).changeEnemyPass();
			player.minusGreenKey();
		} else if (actualMap.getCell(nextX, nextY).getName().equalsIgnoreCase("blue door") && player.getBlueKey() > 0) {
			actualMap.getCell(nextX, nextY).changePlayerPass();
			actualMap.getCell(nextX, nextY).changeEnemyPass();
			player.minusBlueKey();
		} else if (actualMap.getCell(nextX, nextY).getName().equalsIgnoreCase("fire") && player.getBoots() == true) {
			actualMap.getCell(nextX, nextY).changePlayerPass();
		} else if (actualMap.getCell(nextX, nextY).getName().equalsIgnoreCase("water")
				&& player.getFlippers() == true) {
			actualMap.getCell(nextX, nextY).changePlayerPass();
		} else if (actualMap.getCell(nextX, nextY).getName().equalsIgnoreCase("token door") && player.getTokens() == 2) {
			actualMap.getCell(nextX, nextY).changePlayerPass();
			actualMap.getCell(nextX, nextY).changeEnemyPass();
			player.takeTokens();
		}
	}*/


	public static void main(String[] args) {
		launch(args);
	}
}
