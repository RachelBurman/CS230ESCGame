import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
import javafx.scene.Parent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.net.*;

public class MenuTest {
	@FXML private Label resultBox;
	@FXML private Button playButton;
	@FXML private MenuButton profilesMenu;
	@FXML private MenuItem profile1;
	@FXML private MenuItem profile2;
	@FXML private TextField profileNameBox;
	@FXML private Label profileNameLabel;
	@FXML private Button createButton;
	@FXML private Label errorMessage;
	@FXML private Button yesButton;
	@FXML private Button noButton;
	@FXML private Label questionLabel;
	@FXML private Button profile1Button;
	@FXML private Button profile2Button;
  @FXML private Button createProfileButton;
	@FXML private MenuButton levelSelect;
	@FXML private MenuItem level1;
	@FXML private MenuItem level2;
	@FXML private MenuItem level3;
	@FXML private MenuItem level4;
	@FXML private MenuItem level5;
	@FXML private Label messageOfTheDay;

	@FXML
	private void initialize() {
		try {
			File f = new File("Profiles.txt");
			Scanner in = new Scanner(f);
			if(in.hasNextLine()) {
				profile1.setText(in.nextLine());
				profile1.setVisible(true);
				if(in.hasNextLine()) {
					profile2.setText(in.nextLine());
					profile2.setVisible(true);
				}
			}
		}
		catch (FileNotFoundException exception)
		{
			System.out.println("ERROR: Level File does not exist.");
		}
		messageOfTheDay.setText(getMessage());
	}

	@FXML
	private void handleStartButton(ActionEvent event) {
        		resultBox.setText("Pressed");
	}

	@FXML
	private void paneKeyPressed(KeyEvent event) {
        		switch (event.getCode()) {

		    case RIGHT:
		    	// Right key was pressed. So move the player right by one cell.
	        	resultBox.setText("Right");
	        	break;
		    case LEFT:
		    	// Right key was pressed. So move the player right by one cell.
	        	resultBox.setText("Left");
	        	break;
		    case UP:
		    	// Right key was pressed. So move the player right by one cell.
	        	resultBox.setText("Up");
	        	break;
		    case DOWN:
		    	// Right key was pressed. So move the player right by one cell.
	        	resultBox.setText("Down");
	        	break;
	        default:
	        	// Do nothing
	        	break;
		}
		event.consume();
	}

	@FXML
	private void handleProfileButton(ActionEvent event) {
		levelSelect.setVisible(false);
		playButton.setVisible(false);
		createProfileButton.setVisible(false);
		profilesMenu.setVisible(false);
		createButton.setVisible(true);
		profileNameBox.setVisible(true);
		profileNameLabel.setVisible(true);
		/*Parent root;
        try {
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Profile.fxml"));
						root = fxmlLoader.load();
						Stage stage = new Stage();
            stage.setTitle("Profile Creation");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            //((Node)(event.getSource())).getScene().getWindow().hide();
					} catch(Exception e) {
						e.printStackTrace();
					}
					*/
			/*try {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Profile.fxml"));
		    	Pane root1 = (Pane) fxmlLoader.load();
					Stage stage = new Stage();
					//Pane root1 = (Pane)FXMLLoader.load(getClass().getResource("/Profile.fxml"));
					//Scene scene = new Scene(root1,707,483);

		    	//stage.initModality(Modality.APPLICATION_MODAL);
		    	//stage.initStyle(StageStyle.UNDECORATED);
		    	stage.setTitle("Profile Creation");
		    	stage.setScene(new Scene(root1));
		    	stage.show();
				} catch(Exception e) {
					e.printStackTrace();
				}
				*/
	}

	@FXML
	private void createButtonPressed(ActionEvent event) {
					if(!profile1.isVisible())
					{
        		profile1.setText(profileNameBox.getText());
						profile1.setVisible(true);
						profileNameBox.setText("");
						createButton.setVisible(false);
						profileNameBox.setVisible(false);
						profileNameLabel.setVisible(false);
						createProfileButton.setVisible(true);
						level1.setVisible(true);
					} else if (!profile2.isVisible())
					{
						profile2.setText(profileNameBox.getText());
						profile2.setVisible(true);
						profileNameBox.setText("");
						createButton.setVisible(false);
						profileNameBox.setVisible(false);
						profileNameLabel.setVisible(false);
						createProfileButton.setVisible(true);
						profilesMenu.setVisible(true);
						level1.setVisible(true);
					} else {
						errorMessage.setVisible(true);
						yesButton.setVisible(true);
						noButton.setVisible(true);
					}
	}

	@FXML
	private void handleNoButton(ActionEvent event) {
		profileNameBox.setText("");
		createButton.setVisible(false);
		profileNameBox.setVisible(false);
		profileNameLabel.setVisible(false);
		errorMessage.setVisible(false);
		yesButton.setVisible(false);
		noButton.setVisible(false);
		createProfileButton.setVisible(true);
		profilesMenu.setVisible(true);
	}

	@FXML
	private void handleYesButton(ActionEvent event) {
		questionLabel.setVisible(true);
		profile1Button.setVisible(true);
		profile2Button.setVisible(true);
	}

	@FXML
	private void handleProfile1Button(ActionEvent event) {
		profile1.setText(profileNameBox.getText());
		profileNameBox.setText("");
		profileNameBox.setText("");
		createButton.setVisible(false);
		profileNameBox.setVisible(false);
		profileNameLabel.setVisible(false);
		errorMessage.setVisible(false);
		yesButton.setVisible(false);
		noButton.setVisible(false);
		questionLabel.setVisible(false);
		profile1Button.setVisible(false);
		profile2Button.setVisible(false);
		createProfileButton.setVisible(true);
		profilesMenu.setVisible(true);
		level1.setVisible(true);
	}

	@FXML
	private void handleProfile2Button(ActionEvent event) {
		profile2.setText(profileNameBox.getText());
		profileNameBox.setText("");
		createButton.setVisible(false);
		profileNameBox.setVisible(false);
		profileNameLabel.setVisible(false);
		errorMessage.setVisible(false);
		yesButton.setVisible(false);
		noButton.setVisible(false);
		questionLabel.setVisible(false);
		profile1Button.setVisible(false);
		profile2Button.setVisible(false);
		createProfileButton.setVisible(true);
		profilesMenu.setVisible(true);
		level1.setVisible(true);
	}

	@FXML
	private void guestSelected(ActionEvent event) {
		profilesMenu.setText("Guest");
		levelSelect.setVisible(true);
		level1.setVisible(true);
		level2.setVisible(true);
		level3.setVisible(true);
		level4.setVisible(true);
		level5.setVisible(true);
	}

	@FXML
	private void profile1Selected(ActionEvent event) {
		profilesMenu.setText(profile1.getText());
		levelSelect.setVisible(true);
		level1.setVisible(false);
		level2.setVisible(false);
		level3.setVisible(false);
		level4.setVisible(false);
		level5.setVisible(false);
		try {
			File f = new File("Profiles.txt");
			Scanner in = new Scanner(f);
			in.nextLine();
			in.nextLine();
			int level = in.nextInt();
			if (level == 1) {
				level1.setVisible(true);
			} else if (level == 2) {
				level1.setVisible(true);
				level2.setVisible(true);
			} else if (level == 3) {
				level1.setVisible(true);
				level2.setVisible(true);
				level3.setVisible(true);
			} else if (level == 4) {
				level1.setVisible(true);
				level2.setVisible(true);
				level3.setVisible(true);
				level4.setVisible(true);
			} else {
				level1.setVisible(true);
				level2.setVisible(true);
				level3.setVisible(true);
				level4.setVisible(true);
				level5.setVisible(true);
			}
		}
		catch (FileNotFoundException exception)
		{
			System.out.println("ERROR: Level File does not exist.");
		}
	}

	@FXML
	private void profile2Selected(ActionEvent event) {
		profilesMenu.setText(profile2.getText());
		levelSelect.setVisible(true);
		level1.setVisible(false);
		level2.setVisible(false);
		level3.setVisible(false);
		level4.setVisible(false);
		level5.setVisible(false);
		try {
			File f = new File("Profiles.txt");
			Scanner in = new Scanner(f);
			in.nextLine();
			in.nextLine();
			in.nextLine();
			int level = in.nextInt();
			if (level == 1) {
				level1.setVisible(true);
			} else if (level == 2) {
				level1.setVisible(true);
				level2.setVisible(true);
			} else if (level == 3) {
				level1.setVisible(true);
				level2.setVisible(true);
				level3.setVisible(true);
			} else if (level == 4) {
				level1.setVisible(true);
				level2.setVisible(true);
				level3.setVisible(true);
				level4.setVisible(true);
			} else {
				level1.setVisible(true);
				level2.setVisible(true);
				level3.setVisible(true);
				level4.setVisible(true);
				level5.setVisible(true);
			}
		}
		catch (FileNotFoundException exception)
		{
			System.out.println("ERROR: Level File does not exist.");
		}
	}

	@FXML
	private void profilesPressed(ActionEvent event) {
        		resultBox.setText("Pressed");
	}

	@FXML
	private void level1Selected(ActionEvent event) {
		levelSelect.setText("1");
		playButton.setVisible(true);
	}
	@FXML
	private void level2Selected(ActionEvent event) {
		levelSelect.setText("2");
		playButton.setVisible(true);
	}
	@FXML
	private void level3Selected(ActionEvent event) {
		levelSelect.setText("3");
		playButton.setVisible(true);
	}
	@FXML
	private void level4Selected(ActionEvent event) {
		levelSelect.setText("4");
		playButton.setVisible(true);
	}
	@FXML
	private void level5Selected(ActionEvent event) {
		levelSelect.setText("5");
		playButton.setVisible(true);
	}

	public String getHTML(String urlToRead) throws Exception {
	    StringBuilder result = new StringBuilder();
	    URL url = new URL(urlToRead);
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    String line;
	    while ((line = rd.readLine()) != null) {
	       result.append(line);
	    }
	    rd.close();
	    return result.toString();
	 }

	 public String getMessage()
	 {
		 URL url = null;
		HttpURLConnection con = null;
		String s = "";
		try {
			s = getHTML("http://cswebcat.swan.ac.uk/puzzle");
		} catch (Exception exception) {

		}

		String sr = "";
		for (int i = 0; i<s.length();i++)
		{
			char letter = s.charAt(i);
			if ((i)%2 == 0)
			{
				if ((int)letter == 90)
				{
					letter = 'A';
				}
				else
				{
					letter = (char)((int)letter + 1);
				}
				sr = sr + letter;
			}
			else
			{
				if ((int)letter == 65)
				{
					letter = 'Z';
				}
				else
				{
					letter = (char)((int)letter - 1);
				}
				sr = sr + letter;
			}
		}
		String result = "";
		try {
			result =getHTML("http://cswebcat.swan.ac.uk/message?solution=" + sr);
		} catch (Exception exception) {
		}
		return result;
	 }
}
