package application;

import java.awt.TextField;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import moving.Player;
import moving.StraightLineEnemy;
import moving.WallFollowingEnemy;
import moving.DumbTargetingEnemy;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class Game extends Application {
	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 500;
	static String startFile;
	private static long startTime;

	//public void start(Stage primaryStage) {
  public void start(String startFile) {
	  	Stage primaryStage = new Stage();
	  	this.startFile = startFile;
		BorderPane root = new BorderPane();
		root.setTop(makeHBox());
		GridPane grid = new GridPane();
		root.setCenter(grid);
		grid.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

		MapManager.sharedMapManager().setMap(new Map(this.startFile));
		
		// Register an event handler for key presses
		scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> processKeyEvent(event, grid));	
		drawGame(grid);
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

	public HBox makeHBox() {
		HBox box = new HBox();
		Label label = new Label(startFile);
		box.getChildren().add(label);
		return box;

	}

	public GridPane drawGame( GridPane grid) {
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
		//System.out.println(" My X is" + playerXLocation+ " My Y is" + playerYLocation);
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

		for (int newY = scopeYmin; newY<scopeYmax; newY++) {
			for (int NewX = scopeXmin; NewX<scopeXmax; NewX++) {
				grid.add(map.getCell(NewX, newY).getView(), NewX, newY);
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
		Player player = map.getPlayer1();
		StraightLineEnemy enemy1 = map.getEnemy1();
		DumbTargetingEnemy enemy2 = map.getDummieAt(0);
		
		WallFollowingEnemy enemy3 = map.getWallFollowAt(0);
		
		grid.add(player.getPlayerView(), player.getxLocation(), player.getyLocation());
		if (enemy1.getXLocation()<scopeXmax && enemy1.getXLocation()>scopeXmin) {
			if (enemy1.getYLocation()<scopeYmax && enemy1.getYLocation()>scopeYmin) {
				grid.add(enemy1.getEnemyView(), enemy1.getXLocation(), enemy1.getYLocation());
			}

		}
		if (map.getDummieAt(0).getXLocation()<scopeXmax && map.getDummieAt(0).getXLocation()>scopeXmin) {
			if (map.getDummieAt(0).getYLocation()<scopeYmax && map.getDummieAt(0).getYLocation()>scopeYmin) {
				grid.add(map.getDummieAt(0).getEnemyView(), map.getDummieAt(0).getXLocation(), map.getDummieAt(0).getYLocation());
			}

		}

		if (map.getWallFollowAt(0).getXLocation()<scopeXmax && map.getWallFollowAt(0).getXLocation()>scopeXmin) {
			if (map.getWallFollowAt(0).getYLocation()<scopeYmax && map.getWallFollowAt(0).getYLocation()>scopeYmin) {
				grid.add(map.getWallFollowAt(0).getEnemyView(), map.getWallFollowAt(0).getXLocation(), map.getWallFollowAt(0).getYLocation());
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
			//openDoor(player, actualMap, player.getxLocation() + 1, player.getyLocation());
			map.openDoor(currentX+1, currentY);
			map.getPlayer1().moveRight();
			map.doAction();
			//player.moveRight();

			break;
		case LEFT:
			// Left key was pressed. So move the player left by one cell.
			//openDoor(player, actualMap, player.getxLocation() - 1, player.getyLocation());
			map.openDoor(currentX-1, currentY);
			map.getPlayer1().moveLeft();
			map.doAction();
			//player.moveLeft();

			break;
		case UP:
			// Up key was pressed. So move the player up by one cell.
			//openDoor(player, actualMap, player.getxLocation(), player.getyLocation() - 1);
			map.openDoor(currentX, currentY-1);
			map.getPlayer1().moveUp();
			map.doAction();
			//player.moveUp();

			break;
		case DOWN:
			// Down key was pressed. So move the player down by one cell.
			//openDoor(player, actualMap, player.getxLocation(), player.getyLocation() + 1);
			map.openDoor(currentX, currentY+1);
			map.getPlayer1().moveDown();
			map.doAction();
			//player.moveDown();

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

	public void loseGame ( GridPane grid) {
		Map map = MapManager.sharedMapManager().getMap();
		int playerXLocation = map.getPlayer1().getxLocation();
		int playerYLocation = map.getPlayer1().getyLocation();
		int StraightEnemyX = map.getEnemy1().getXLocation();
		int StraightEnemyY = map.getEnemy1().getYLocation();
		int DumbEnemyX = map.getDummieAt(0).getXLocation();
		int DumbEnemyY = map.getDummieAt(0).getYLocation();
		int WallFollowX = map.getWallFollowAt(0).getXLocation();
		int WallFollowY = map.getWallFollowAt(0).getYLocation();
		if (playerXLocation== StraightEnemyX && playerYLocation == StraightEnemyY) {
			System.out.println("Game OVer");
			restart();
		} else if (playerXLocation== StraightEnemyX && playerYLocation == StraightEnemyY) {
			System.out.println("Game OVer");
			restart();
		} else if (playerXLocation== DumbEnemyX && playerYLocation == DumbEnemyY) {
			System.out.println("Game OVer");
			restart();
		} else if (playerXLocation== WallFollowX && playerYLocation == WallFollowY) {
			System.out.println("Game OVer");
			restart();
		} else if (map.getCell(playerXLocation, playerYLocation).getName().equalsIgnoreCase("fire") && map.getPlayer1().getBoots()==false) {
			System.out.println("Game OVer");
			restart();
		} else if (map.getCell(playerXLocation, playerYLocation).getName().equalsIgnoreCase("water")&& map.getPlayer1().getFlippers()==false) {
			System.out.println("Game OVer");
			restart();
		}
		upLevel();
		drawGame(grid);

	}
	public static void restart() {
		
            startTime = System.nanoTime();
          
            Map newMap = new Map(startFile);	
            MapManager.sharedMapManager().setMap(newMap);
            
	}
	
	public static void upLevel() {
		int playerX = MapManager.sharedMapManager().getMap().getPlayer1().getxLocation();
		int playerY = MapManager.sharedMapManager().getMap().getPlayer1().getyLocation();
		Cell current = MapManager.sharedMapManager().getMap().getCell(playerX, playerY);
                
                long endTime = System.nanoTime();
                long duration;
                duration = (endTime - startTime) / 1000000000;
                
                Map map = MapManager.sharedMapManager().getMap();
                
		if (current.getName().equalsIgnoreCase("goal")){
			switch(startFile) {
			
			case "./lvl1.txt" :
                            Leaderboard.checkNewLevelComplete("lvl1", (int)duration, map.getPlayer1().getName());
				startFile = "./lvl2.txt";
				break;
			case "./lvl2.txt" :
                            Leaderboard.checkNewLevelComplete("lvl2", (int)duration, map.getPlayer1().getName());
				startFile = "./lvl3.txt";
				break;
			case "./lvl3.txt" :
                            Leaderboard.checkNewLevelComplete("lvl3", (int)duration, map.getPlayer1().getName());
				startFile = "./lvl4.txt";
				break;
			case "./lvl4.txt" :
                            Leaderboard.checkNewLevelComplete("lvl4", (int)duration, map.getPlayer1().getName());
				startFile = "./lvl5.txt";
				break;
			default :
                            Leaderboard.checkNewLevelComplete("lvl5", (int)duration, map.getPlayer1().getName());
				break;
			}
			restart();
		}
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

