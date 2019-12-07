package application;

import java.awt.Label;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LevelChangeWindow {

	public static void display(String fileName) {
		Stage popupwindow = new Stage();

		popupwindow.initModality(Modality.APPLICATION_MODAL);
		String level = fileName;
		level.replaceAll("[^0-9.]", "");
		popupwindow.setTitle("Well done!");

		Label label1 = new Label("You have completed level" + level + "!");

		Button button1 = new Button("Continue");

		button1.setOnAction(e -> {
			popupwindow.close();
		});

		VBox layout = new VBox(10);

		layout.getChildren().add( button1);

		layout.setAlignment(Pos.CENTER);

		Scene scene1 = new Scene(layout, 200, 150);

		popupwindow.setScene(scene1);

		popupwindow.showAndWait();

	}

}

