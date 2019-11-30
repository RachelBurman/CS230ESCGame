package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
			
			for (int i = 0; i<y; i++) {
				
				for (int o = 0; o<x; o++) {
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
