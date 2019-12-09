package application;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LevelChangeWindow {
	
	
	/**
	 * Make a window for changing level
	 * @param fileName
	 */
	public static void display(String fileName) {
		Stage popupwindow = new Stage();

		popupwindow.initModality(Modality.APPLICATION_MODAL);
		String level = fileName;
		level.replaceAll("[^0-9.]", "");
		popupwindow.setTitle("Well done!");

		Label label = new Label("You have completed level" + level + "!");

		Button button = new Button("Continue");

		button.setOnAction(e -> {
			popupwindow.close();
		});

		VBox layout = new VBox(10);
		layout.getChildren().addAll(label,button);

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
