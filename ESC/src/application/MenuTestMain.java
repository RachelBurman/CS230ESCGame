package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MenuTestMain extends Application {

	public void start(Stage primaryStage) {
		try {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("Menu.fxml"));
			Scene scene = new Scene(root,707,483);
			primaryStage.setScene(scene);
			primaryStage.setTitle("E.S.C");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
