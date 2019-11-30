package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class Main extends Application {

	private static final int WINDOW_WIDTH = 1200;
	private static final int WINDOW_HEIGHT = 800;

	public void start(Stage primaryStage) {
		try {
			
			Cell[][] level = LoadLevel.loadLevel("resources/test.txt");
			
			int y = level.length;
			int x = LoadLevel.getWidth("resources/test.txt");
			
			GridPane panes = new GridPane();
            panes.setVgap(1);
            panes.setHgap(1);
            
            int playerX = 0;
            int playerY = 0;
			
			for (int i = 0; i<y; i++) {
				
				for (int o = 0; o<x; o++) {
					
					if (level[i][o] instanceof Player) {
						playerX = o;
						playerY = i;
						System.out.println(playerX);
						System.out.println(playerY);
					}
					
					//panes.add(level[i][o].getCellImage(),o,i);
				}
				
			}
			
			int scopeXmin;
			int scopeXmax;
			int scopeYmin;
			int scopeYmax;
			
			if (playerX - 3 < 0) {
				scopeXmin = 0;
			} else {
				scopeXmin = playerX - 3;
			}
			if (playerX + 4 > x) {
				scopeXmax = x;
			} else {
				scopeXmax = playerX + 4;
			}
			if (playerY - 3 < 0) {
				scopeYmin = 0;
			} else {
				scopeYmin = playerY - 3;
			}
			if (playerY + 4 > y) {
				//System.out.println(playerY);
				//System.out.println(y);
				scopeYmax = y;
				//System.out.println(scopeYmax);
			} else {
				scopeYmax = playerY + 4;
				System.out.println(scopeYmax);
			}
			
			for (int i = scopeYmin; i<scopeYmax; i++) {
				for (int o = scopeXmin; o<scopeXmax; o++) {
					panes.add(level[i][o].getCellImage(),o,i);
				}
			}
				
				
			
			
			
			Pane rootPane = new Pane();
            rootPane.getChildren().addAll(panes);
			
			Scene scene = new Scene(rootPane,WINDOW_WIDTH,WINDOW_HEIGHT);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
                  
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
