package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


public class Main extends Application {
	private static final int WINDOW_WIDTH = 1200;
	private static final int WINDOW_HEIGHT = 800;
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane pane = new HBox(150);
			CellType test;
			test = new CellType("https://nerdvarsity.files.wordpress.com/2016/06/yellowbx.jpg?w=1108&h=737&crop=1",100.0,100.0);
			pane.getChildren().add(test.getCellImage());
            
			
			BorderPane root = new BorderPane();
			Scene scene = new Scene(pane,WINDOW_WIDTH,WINDOW_HEIGHT);
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
