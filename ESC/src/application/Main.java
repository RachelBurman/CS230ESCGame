package application;
	
import javafx.application.Application;
import application.Cell;
import javafx.stage.Stage;
import moving.Player;
import moving.StraightLineEnemy;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Main extends Application {
	private static final int WINDOW_WIDTH = 600;
	private static final int WINDOW_HEIGHT = 400;


	public void start(Stage primaryStage) {
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid,WINDOW_WIDTH,WINDOW_HEIGHT);
		Map actualMap = new Map("test.txt");
		//Enemies need to be created here
		Player player = actualMap.getPlayer1();
		player.setMap(actualMap);
		StraightLineEnemy enemy1 = actualMap.getEnemy1();
		enemy1.setMap(actualMap);
		// Register an event handler for key presses
		scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> processKeyEvent(event, actualMap, grid, player,enemy1));
		drawGame(actualMap, grid, player,enemy1);
		try {

	primaryStage.setScene(scene);primaryStage.show();
	}catch(Exception e)
	{
			e.printStackTrace();
		}

	}

	public GridPane drawGame(Map actualMap, GridPane grid, Player player, StraightLineEnemy enemy1) {
		grid.getChildren().clear();
		// Draw Grid using GridPane 
		for (int y = 0; y < actualMap.getMapHeight(); y++) {
			for (int x=0; x <actualMap.getMapLength();x++) {
				// Add new types of cells here
				grid.add(actualMap.getCell(x, y).getView(), x, y);
			}
		}
		grid.add(player.getPlayerView(), player.getxLocation(), player.getyLocation());
		grid.add(enemy1.getEnemyView(), enemy1.getXLocation(), enemy1.getYLocation());
		
		return grid;
	}
	
	public void processKeyEvent(KeyEvent event, Map actualMap, GridPane grid, Player player,StraightLineEnemy enemy1) {
		switch (event.getCode()) {
			
		    case RIGHT:
		    	// Right key was pressed. So move the player right by one cell.
		    	openDoor(player, actualMap,player.getxLocation()+1,player.getyLocation());
	        	player.moveRight();
	        	
	        	break;
		    case LEFT:
		    	// Left key was pressed. So move the player left by one cell.
		    	openDoor(player, actualMap,player.getxLocation()-1,player.getyLocation());
		    	player.moveLeft();
		    	
	        	break;
		    case UP:
		    	// Up key was pressed. So move the player up by one cell.
		    	openDoor(player, actualMap,player.getxLocation(),player.getyLocation()-1);
	        	player.moveUp();
	        	
	        	break;
		    case DOWN:
		    	// Down key was pressed. So move the player down by one cell.
		    	openDoor(player, actualMap,player.getxLocation(),player.getyLocation()+1);
	        	player.moveDown();
	        	
	        	break;	
	        
	        default:
	        	// Do nothing
	        	break;
		}
		
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
		}
		
		
		if (enemy1.getFacing() == 'u' || enemy1.getFacing() == 'd') {
			enemy1.moveY(enemy1.getXLocation(), enemy1.getYLocation(), enemy1.getFacing());
		} else {
			enemy1.moveX(enemy1.getXLocation(), enemy1.getYLocation(), enemy1.getFacing());
		}
		if (player.getXLocation()==enemy1.getXLocation() && player.getYLocation() == enemy1.getYLocation()) {
			System.out.println("Game OVer");
		} else {
			drawGame(actualMap, grid, player,enemy1);
		}
		
		// Redraw game as the player may have moved.
		
		
		// Consume the event. This means we mark it as dealt with. This stops other GUI nodes (buttons etc) responding to it.
		event.consume();
	}
	public void openDoor (Player player, Map actualMap, int nextX, int nextY) {
		
    	if (actualMap.getCell(nextX, nextY).getName().equalsIgnoreCase("red door")) {
    		actualMap.getCell(nextX, nextY).changePlayerPass();
    		actualMap.getCell(nextX, nextY).changeEnemyPass();
    		player.minusRedKey();
    	} else if (actualMap.getCell(nextX, nextY).getName().equalsIgnoreCase("green door")) {
    		actualMap.getCell(nextX, nextY).changePlayerPass();
    		actualMap.getCell(nextX, nextY).changeEnemyPass();
    		player.minusGreenKey();
    	} else if (actualMap.getCell(nextX, nextY).getName().equalsIgnoreCase("blue door")) {
    		actualMap.getCell(nextX, nextY).changePlayerPass();
    		actualMap.getCell(nextX, nextY).changeEnemyPass();
    		player.minusBlueKey();
    	}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
