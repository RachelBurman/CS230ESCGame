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
			Pane pane1 = new HBox(1);
                        Pane pane2 = new HBox(1);
			
			CellType test = new CellType("https://nerdvarsity.files.wordpress.com/2016/06/yellowbx.jpg?w=1108&h=737&crop=1");
                        CellType test2 = new CellType("https://nerdvarsity.files.wordpress.com/2016/06/yellowbx.jpg?w=1108&h=737&crop=1");
                        CellType test3 = new CellType("https://nerdvarsity.files.wordpress.com/2016/06/yellowbx.jpg?w=1108&h=737&crop=1");
                        CellType test4 = new CellType("https://nerdvarsity.files.wordpress.com/2016/06/yellowbx.jpg?w=1108&h=737&crop=1");
                        CellType test5 = new CellType("https://nerdvarsity.files.wordpress.com/2016/06/yellowbx.jpg?w=1108&h=737&crop=1");
                        CellType test6 = new CellType("https://nerdvarsity.files.wordpress.com/2016/06/yellowbx.jpg?w=1108&h=737&crop=1");
                        CellType test7 = new CellType("https://nerdvarsity.files.wordpress.com/2016/06/yellowbx.jpg?w=1108&h=737&crop=1");
                        CellType test8 = new CellType("https://nerdvarsity.files.wordpress.com/2016/06/yellowbx.jpg?w=1108&h=737&crop=1");
                        CellType test9 = new CellType("https://nerdvarsity.files.wordpress.com/2016/06/yellowbx.jpg?w=1108&h=737&crop=1");
                        CellType test10 = new CellType("https://nerdvarsity.files.wordpress.com/2016/06/yellowbx.jpg?w=1108&h=737&crop=1");
                        CellType test11 = new CellType("https://nerdvarsity.files.wordpress.com/2016/06/yellowbx.jpg?w=1108&h=737&crop=1");
                        CellType test12 = new CellType("https://nerdvarsity.files.wordpress.com/2016/06/yellowbx.jpg?w=1108&h=737&crop=1");
                        CellType test13 = new CellType("https://nerdvarsity.files.wordpress.com/2016/06/yellowbx.jpg?w=1108&h=737&crop=1");
                        CellType test14 = new CellType("https://nerdvarsity.files.wordpress.com/2016/06/yellowbx.jpg?w=1108&h=737&crop=1");
                        CellType test15 = new CellType("https://nerdvarsity.files.wordpress.com/2016/06/yellowbx.jpg?w=1108&h=737&crop=1");
                        CellType test16 = new CellType("https://nerdvarsity.files.wordpress.com/2016/06/yellowbx.jpg?w=1108&h=737&crop=1");
                        
                        
			pane1.getChildren().addAll(test.getCellImage(),test2.getCellImage(),test3.getCellImage(),test4.getCellImage(),test5.getCellImage(),test6.getCellImage(),test7.getCellImage(),test8.getCellImage());
                        pane2.getChildren().addAll(test9.getCellImage(),test10.getCellImage(),test11.getCellImage(),test12.getCellImage(),test13.getCellImage(),test14.getCellImage(),test15.getCellImage(),test16.getCellImage());
			pane2.setLayoutY(33);
                        Pane rootPane = new Pane();
			rootPane.getChildren().addAll(pane1,pane2);
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
