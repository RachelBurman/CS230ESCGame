package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import moving.DumbTargetingEnemy;
import moving.Player;
import moving.StraightLineEnemy;

public class Game {
	private int windowWidth;
	private int windowHeight;
	private Stage primaryStage;
	GridPane grid;
	BorderPane root;
	private Scene scene;
	private String startFile;
	
	
	public  Game(Stage primaryStage, int windowWidth, int windowHeight, String startFile) {
		this.primaryStage = primaryStage;
		this.windowHeight = windowHeight;
		this.windowWidth = windowWidth;
		this.startFile = startFile;

	}
	
	public void startGame() {
		MapManager.sharedMapManager().setMap(new Map(startFile));
		scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> processKeyEvent(event, grid));
		drawGame(grid);
		try {
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	// Register an event handler for key presses

public HBox makeHBox() {
	HBox box = new HBox();
	Label label = new Label(startFile);
	box.getChildren().add(label);
	return box;

}

public GridPane drawGame(GridPane grid) {
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
	// System.out.println(" My X is" + playerXLocation+ " My Y is" +
	// playerYLocation);
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
	 * for (int y = 0; y < actualMap.getMapHeight(); y++) { for (int x = 0; x <
	 * actualMap.getMapLength(); x++) { // Add new types of cells here
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

public void processKeyEvent(KeyEvent event, GridPane grid) {
	Map map = MapManager.sharedMapManager().getMap();
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
		// openDoor(player, actualMap, player.getxLocation(), player.getyLocation() -
		// 1);
		map.openDoor(currentX, currentY - 1);
		map.getPlayer1().moveUp();
		map.doAction();
		// player.moveUp();

		break;
	case DOWN:
		// Down key was pressed. So move the player down by one cell.
		// openDoor(player, actualMap, player.getxLocation(), player.getyLocation() +
		// 1);
		map.openDoor(currentX, currentY + 1);
		map.getPlayer1().moveDown();
		map.doAction();
		// player.moveDown();

		break;

	default:
		// Do nothing
		break;
	}

	map.StraightLineMove();
	map.DumbMove();
	map.WallFollowMove();
	loseGame(grid);

	event.consume();
}

public void loseGame(GridPane grid) {
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

	drawGame(grid);

}

public void restart() {
	Map newMap = new Map(startFile);
	MapManager.sharedMapManager().setMap(newMap);
	}

}

