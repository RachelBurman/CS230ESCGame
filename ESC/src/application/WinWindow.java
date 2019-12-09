package application;

import java.awt.Label;
import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class contains all attributes and behaviours of WinWindow.
 * @author Group 31
 * @version 3.0 
 */
public class WinWindow {
	
	/**
	 * Make a window to display a message when the game is won
	 * @param the stage you want to change
	 */
	public static void display(Stage gameStage) {
		Stage popupwindow = new Stage();

		popupwindow.initModality(Modality.APPLICATION_MODAL);
		popupwindow.setTitle("Game completed!!!");

		Label label1 = new Label("You have completed the game!!!");

		Button button1 = new Button("Return to main menu");

		button1.setOnAction(e -> {
			popupwindow.close();
			gameStage.close();
		});

		VBox layout = new VBox(10);

		layout.getChildren().add( button1);

		layout.setAlignment(Pos.CENTER);

		Scene scene1 = new Scene(layout, 200, 150);

		popupwindow.setScene(scene1);
		playApplause();
		popupwindow.showAndWait();

	}
	/**
	 * Plays music when win.
	 */
	private static void playApplause() {
		String musicFileLocation = "./src/applause.mp3";     

		Media doorSound = new Media(new File(musicFileLocation).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(doorSound);
		
		mediaPlayer.play();
	}
	
	
	


}
