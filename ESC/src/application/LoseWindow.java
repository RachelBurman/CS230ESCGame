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
 * This class contains all attributes and behaviours of LoseWindow.
 * @author Group 31
 * @version 3.0
 */
public class LoseWindow {
	
	
	/**
	 * Make a window to display a message when the game is won
	 * @param the stage you want to change
	 */
	public static void display(Stage gameStage) {
		Stage popupwindow = new Stage();

		popupwindow.initModality(Modality.APPLICATION_MODAL);
		popupwindow.setTitle("You died!!!");

		Label label1 = new Label("Try again!!!");

		Button button1 = new Button("Return to level");
		Button button2 = new Button("Return to menu");

		button1.setOnAction(e -> {
			popupwindow.close();
		});
		button2.setOnAction(e -> {
			popupwindow.close();
			gameStage.close();
		});

		VBox layout = new VBox(10);

		layout.getChildren().add( button1);

		layout.setAlignment(Pos.CENTER);

		Scene scene1 = new Scene(layout, 200, 150);

		popupwindow.setScene(scene1);
		playFail();
		popupwindow.showAndWait();

	}
	
	/**
	 * Plays music when lose.
	 */
	private static void playFail() {
		String musicFileLocation = "./src/fail.mp3";     

		Media doorSound = new Media(new File(musicFileLocation).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(doorSound);
		
		mediaPlayer.play();
	}

}
