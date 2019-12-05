package application;

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
	@FXML private Label testLabel;
	@FXML private Button playButton;
	@FXML private MenuButton profilesMenu;
	@FXML private MenuItem profile1MenuItem;
	@FXML private MenuItem profile2MenuItem;
	@FXML private MenuItem profile3MenuItem;
	@FXML private MenuItem profile4MenuItem;
	@FXML private MenuItem profile5MenuItem;
	@FXML private TextField profileNameBox;
	@FXML private Label profileNameLabel;
	@FXML private Button createButton;
	@FXML private Label errorMessage;
	@FXML private Button yesButton;
	@FXML private Button noButton;
	@FXML private Label questionLabel;
	@FXML private Button profile1Button;
	@FXML private Button profile2Button;
	@FXML private Button profile3Button;
	@FXML private Button profile4Button;
	@FXML private Button profile5Button;
  @FXML private Button createProfileButton;
	@FXML private MenuButton levelSelectMenu;
	@FXML private MenuItem level1MenuItem;
	@FXML private MenuItem level2MenuItem;
	@FXML private MenuItem level3MenuItem;
	@FXML private MenuItem level4MenuItem;
	@FXML private MenuItem level5MenuItem;
	@FXML private Label messageOfTheDayLabel;

	@FXML
	private void initialize() {
		String s = "";
		try {
			File f = new File("Profiles.txt");
			Scanner in = new Scanner(f);
			if(in.hasNextLine()) {
				s = in.nextLine();
				if (!(s.equals(""))) {
					profile1MenuItem.setText(s);
					profile1MenuItem.setVisible(true);
					profile2MenuItem.setVisible(false);
					profile3MenuItem.setVisible(false);
					profile4MenuItem.setVisible(false);
					profile5MenuItem.setVisible(false);
					if(in.hasNextLine()) {
						s = in.nextLine();
						if (!(s.equals(""))) {
							profile2MenuItem.setText(s);
							profile2MenuItem.setVisible(true);
							profile3MenuItem.setVisible(false);
							profile4MenuItem.setVisible(false);
							profile5MenuItem.setVisible(false);
							if(in.hasNextLine()) {
								s = in.nextLine();
								if (!(s.equals(""))) {
									profile3MenuItem.setText(s);
									profile3MenuItem.setVisible(true);
									profile4MenuItem.setVisible(false);
									profile5MenuItem.setVisible(false);
									if(in.hasNextLine()) {
										s = in.nextLine();
										if (!(s.equals(""))) {
											profile4MenuItem.setText(s);
											profile4MenuItem.setVisible(true);
											profile5MenuItem.setVisible(false);
											if(in.hasNextLine()) {
												s = in.nextLine();
												if (!(s.equals(""))) {
													profile5MenuItem.setText(s);
													profile5MenuItem.setVisible(true);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		catch (FileNotFoundException exception)
		{
			System.out.println("ERROR: File not found");
			profile1MenuItem.setVisible(false);
			profile2MenuItem.setVisible(false);
			profile3MenuItem.setVisible(false);
			profile4MenuItem.setVisible(false);
			profile5MenuItem.setVisible(false);
		}
		messageOfTheDayLabel.setText(getMessage());
	}

	@FXML
	private void handleStartButtonAction(ActionEvent event) {
        		testLabel.setText("Pressed");
	}

	@FXML
	private void paneKeyPressed(KeyEvent event) {
        		switch (event.getCode()) {

		    case RIGHT:
		    	// Right key was pressed. So move the player right by one cell.
	        	testLabel.setText("Right");
	        	break;
		    case LEFT:
		    	// Right key was pressed. So move the player right by one cell.
	        	testLabel.setText("Left");
	        	break;
		    case UP:
		    	// Right key was pressed. So move the player right by one cell.
	        	testLabel.setText("Up");
	        	break;
		    case DOWN:
		    	// Right key was pressed. So move the player right by one cell.
	        	testLabel.setText("Down");
	        	break;
	        default:
	        	// Do nothing
	        	break;
		}
		event.consume();
	}

	@FXML
	private void handleProfileButtonAction(ActionEvent event) {
		levelSelectMenu.setVisible(false);
		playButton.setVisible(false);
		createProfileButton.setVisible(false);
		profilesMenu.setVisible(false);
		createButton.setVisible(true);
		profileNameBox.setVisible(true);
		profileNameLabel.setVisible(true);
	}

	@FXML
	private void handleCreateButtonAction(ActionEvent event) {
					if(!profile1MenuItem.isVisible())
					{
						try {
							File outputFile = new File ("Profiles.txt");
							PrintWriter out = null;
							out = new PrintWriter (outputFile);
							out.println (profileNameBox.getText());
							out.println ("");
							out.println ("");
							out.println ("");
							out.println ("");
							out.println ("1");
							out.close ();
						} catch (FileNotFoundException e) {
							System.out.println ("ERROR: Level File does not exist");
						}
        		profile1MenuItem.setText(profileNameBox.getText());
						profile1MenuItem.setVisible(true);
						profileNameBox.setText("");
						createButton.setVisible(false);
						profileNameBox.setVisible(false);
						profileNameLabel.setVisible(false);
						createProfileButton.setVisible(true);
						profilesMenu.setVisible(true);
					} else if (!profile2MenuItem.isVisible())	{
						String profile1Name = "";
						String profile1Level = "";
						try {
							File f = new File("Profiles.txt");
							Scanner in = new Scanner(f);
						 	profile1Name = in.nextLine();
							in.nextLine();
							in.nextLine();
							in.nextLine();
							in.nextLine();
							profile1Level = in.nextLine();
						} catch (FileNotFoundException exception) {
							System.out.println("ERROR: Level File does not exist.");
						}
						try {
							File outputFile = new File ("Profiles.txt");
							PrintWriter out = null;
							out = new PrintWriter (outputFile);
							out.println (profile1Name);
							out.println (profileNameBox.getText());
							out.println ("");
							out.println ("");
							out.println ("");
							out.println (profile1Level);
							out.println ("1");
							out.close ();
						} catch (FileNotFoundException e) {
							System.out.println ("ERROR: Level File does not exist");
						}
						profile2MenuItem.setText(profileNameBox.getText());
						profile2MenuItem.setVisible(true);
						profileNameBox.setText("");
						createButton.setVisible(false);
						profileNameBox.setVisible(false);
						profileNameLabel.setVisible(false);
						createProfileButton.setVisible(true);
						profilesMenu.setVisible(true);
					} else if (!profile3MenuItem.isVisible())	{
							String profile1Name = "";
							String profile1Level = "";
							String profile2Name = "";
							String profile2Level = "";
							try {
								File f = new File("Profiles.txt");
								Scanner in = new Scanner(f);
							 	profile1Name = in.nextLine();
								profile2Name = in.nextLine();
								in.nextLine();
								in.nextLine();
								in.nextLine();
								profile1Level = in.nextLine();
								profile2Level = in.nextLine();
							} catch (FileNotFoundException exception) {
								System.out.println("ERROR: Level File does not exist.");
							}
							try {
								File outputFile = new File ("Profiles.txt");
								PrintWriter out = null;
								out = new PrintWriter (outputFile);
								out.println (profile1Name);
								out.println (profile2Name);
								out.println (profileNameBox.getText());
								out.println ("");
								out.println ("");
								out.println (profile1Level);
								out.println (profile2Level);
								out.println ("1");
								out.close ();
							} catch (FileNotFoundException e) {
								System.out.println ("ERROR: Level File does not exist");
							}
							profile3MenuItem.setText(profileNameBox.getText());
							profile3MenuItem.setVisible(true);
							profileNameBox.setText("");
							createButton.setVisible(false);
							profileNameBox.setVisible(false);
							profileNameLabel.setVisible(false);
							createProfileButton.setVisible(true);
							profilesMenu.setVisible(true);
						} else if (!profile4MenuItem.isVisible())	{
								String profile1Name = "";
								String profile1Level = "";
								String profile2Name = "";
								String profile2Level = "";
								String profile3Name = "";
								String profile3Level = "";
								try {
									File f = new File("Profiles.txt");
									Scanner in = new Scanner(f);
								 	profile1Name = in.nextLine();
									profile2Name = in.nextLine();
									profile3Name = in.nextLine();
									in.nextLine();
									in.nextLine();
									profile1Level = in.nextLine();
									profile2Level = in.nextLine();
									profile3Level = in.nextLine();
								} catch (FileNotFoundException exception) {
									System.out.println("ERROR: Level File does not exist.");
								}
								try {
									File outputFile = new File ("Profiles.txt");
									PrintWriter out = null;
									out = new PrintWriter (outputFile);
									out.println (profile1Name);
									out.println (profile2Name);
									out.println (profile3Name);
									out.println (profileNameBox.getText());
									out.println ("");
									out.println (profile1Level);
									out.println (profile2Level);
									out.println (profile3Level);
									out.println ("1");
									out.close ();
								} catch (FileNotFoundException e) {
									System.out.println ("ERROR: Level File does not exist");
								}
								profile4MenuItem.setText(profileNameBox.getText());
								profile4MenuItem.setVisible(true);
								profileNameBox.setText("");
								createButton.setVisible(false);
								profileNameBox.setVisible(false);
								profileNameLabel.setVisible(false);
								createProfileButton.setVisible(true);
								profilesMenu.setVisible(true);
							} else if (!profile5MenuItem.isVisible())	{
									String profile1Name = "";
									String profile1Level = "";
									String profile2Name = "";
									String profile2Level = "";
									String profile3Name = "";
									String profile3Level = "";
									String profile4Name = "";
									String profile4Level = "";
									try {
										File f = new File("Profiles.txt");
										Scanner in = new Scanner(f);
									 	profile1Name = in.nextLine();
										profile2Name = in.nextLine();
										profile3Name = in.nextLine();
										profile4Name = in.nextLine();
										in.nextLine();
										profile1Level = in.nextLine();
										profile2Level = in.nextLine();
										profile3Level = in.nextLine();
										profile4Level = in.nextLine();
									} catch (FileNotFoundException exception) {
										System.out.println("ERROR: Level File does not exist.");
									}
									try {
										File outputFile = new File ("Profiles.txt");
										PrintWriter out = null;
										out = new PrintWriter (outputFile);
										out.println (profile1Name);
										out.println (profile2Name);
										out.println (profile3Name);
										out.println (profile4Name);
										out.println (profileNameBox.getText());
										out.println (profile1Level);
										out.println (profile2Level);
										out.println (profile3Level);
										out.println (profile4Level);
										out.println ("1");
										out.close ();
									} catch (FileNotFoundException e) {
										System.out.println ("ERROR: Level File does not exist");
									}
									profile5MenuItem.setText(profileNameBox.getText());
									profile5MenuItem.setVisible(true);
									profileNameBox.setText("");
									createButton.setVisible(false);
									profileNameBox.setVisible(false);
									profileNameLabel.setVisible(false);
									createProfileButton.setVisible(true);
									profilesMenu.setVisible(true);
					} else {
						errorMessage.setVisible(true);
						yesButton.setVisible(true);
						noButton.setVisible(true);
					}
	}

	@FXML
	private void handleNoButtonAction(ActionEvent event) {
		profileNameBox.setText("");
		createButton.setVisible(false);
		profileNameBox.setVisible(false);
		profileNameLabel.setVisible(false);
		errorMessage.setVisible(false);
		yesButton.setVisible(false);
		noButton.setVisible(false);
		createProfileButton.setVisible(true);
		profilesMenu.setVisible(true);
		profilesMenu.setText("Profiles");
	}

	@FXML
	private void handleYesButtonAction(ActionEvent event) {
		questionLabel.setVisible(true);
		profile1Button.setVisible(true);
		profile2Button.setVisible(true);
		profile3Button.setVisible(true);
		profile4Button.setVisible(true);
		profile5Button.setVisible(true);
	}

	@FXML
	private void handleProfile1ButtonAction(ActionEvent event) {
		String profile2Name = "";
		String profile2Level = "";
		String profile3Name = "";
		String profile3Level = "";
		String profile4Name = "";
		String profile4Level = "";
		String profile5Name = "";
		String profile5Level = "";
		try {
			File f = new File("Profiles.txt");
			Scanner in = new Scanner(f);
			in.nextLine();
		 	profile2Name = in.nextLine();
			profile3Name = in.nextLine();
			profile4Name = in.nextLine();
			profile5Name = in.nextLine();
			in.nextLine();
			profile2Level = in.nextLine();
			profile3Level = in.nextLine();
			profile4Level = in.nextLine();
			profile5Level = in.nextLine();
		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
		}

		try {
			File outputFile = new File ("Profiles.txt");
			PrintWriter out = null;
			out = new PrintWriter (outputFile);
			out.println (profileNameBox.getText());
			out.println (profile2Name);
			out.println (profile3Name);
			out.println (profile4Name);
			out.println (profile5Name);
			out.println ("1");
			out.println (profile2Level);
			out.println (profile3Level);
			out.println (profile4Level);
			out.println (profile5Level);
			out.close ();
		} catch (FileNotFoundException e) {
			System.out.println ("ERROR: Level File does not exist");
		}
		profile1MenuItem.setText(profileNameBox.getText());
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
		profile3Button.setVisible(false);
		profile4Button.setVisible(false);
		profile5Button.setVisible(false);
		createProfileButton.setVisible(true);
		profilesMenu.setVisible(true);
		profilesMenu.setText("Profiles");
	}

	@FXML
	private void handleProfile2Button(ActionEvent event) {
		String profile1Name = "";
		String profile1Level = "";
		String profile3Name = "";
		String profile3Level = "";
		String profile4Name = "";
		String profile4Level = "";
		String profile5Name = "";
		String profile5Level = "";
		try {
			File f = new File("Profiles.txt");
			Scanner in = new Scanner(f);
		 	profile1Name = in.nextLine();
			in.nextLine();
			profile3Name = in.nextLine();
			profile4Name = in.nextLine();
			profile5Name = in.nextLine();
			profile1Level = in.nextLine();
			in.nextLine();
			profile3Level = in.nextLine();
			profile4Level = in.nextLine();
			profile5Level = in.nextLine();
		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
		}

		try {
			File outputFile = new File ("Profiles.txt");
			PrintWriter out = null;
			out = new PrintWriter (outputFile);
			out.println (profile1Name);
			out.println (profileNameBox.getText());
			out.println (profile3Name);
			out.println (profile4Name);
			out.println (profile5Name);
			out.println (profile1Level);
			out.println ("1");
			out.println (profile3Level);
			out.println (profile4Level);
			out.println (profile5Level);
			out.close ();
		} catch (FileNotFoundException e) {
			System.out.println ("ERROR: Level File does not exist");
		}
		profile2MenuItem.setText(profileNameBox.getText());
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
		profile3Button.setVisible(false);
		profile4Button.setVisible(false);
		profile5Button.setVisible(false);
		createProfileButton.setVisible(true);
		profilesMenu.setVisible(true);
		profilesMenu.setText("Profiles");
	}

	@FXML
	private void handleProfile3Button(ActionEvent event) {
		String profile1Name = "";
		String profile1Level = "";
		String profile2Name = "";
		String profile2Level = "";
		String profile4Name = "";
		String profile4Level = "";
		String profile5Name = "";
		String profile5Level = "";
		try {
			File f = new File("Profiles.txt");
			Scanner in = new Scanner(f);
		 	profile1Name = in.nextLine();
			profile2Name = in.nextLine();
			in.nextLine();
			profile4Name = in.nextLine();
			profile5Name = in.nextLine();
			profile1Level = in.nextLine();
			profile2Level = in.nextLine();
			in.nextLine();
			profile4Level = in.nextLine();
			profile5Level = in.nextLine();
		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
		}

		try {
			File outputFile = new File ("Profiles.txt");
			PrintWriter out = null;
			out = new PrintWriter (outputFile);
			out.println (profile1Name);
			out.println (profile2Name);
			out.println (profileNameBox.getText());
			out.println (profile4Name);
			out.println (profile5Name);
			out.println (profile1Level);
			out.println (profile2Level);
			out.println ("1");
			out.println (profile4Level);
			out.println (profile5Level);
			out.close ();
		} catch (FileNotFoundException e) {
			System.out.println ("ERROR: Level File does not exist");
		}
		profile3MenuItem.setText(profileNameBox.getText());
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
		profile3Button.setVisible(false);
		profile4Button.setVisible(false);
		profile5Button.setVisible(false);
		createProfileButton.setVisible(true);
		profilesMenu.setVisible(true);
		profilesMenu.setText("Profiles");
	}

	@FXML
	private void handleProfile4Button(ActionEvent event) {
		String profile1Name = "";
		String profile1Level = "";
		String profile2Name = "";
		String profile2Level = "";
		String profile3Name = "";
		String profile3Level = "";
		String profile5Name = "";
		String profile5Level = "";
		try {
			File f = new File("Profiles.txt");
			Scanner in = new Scanner(f);
		 	profile1Name = in.nextLine();
			profile2Name = in.nextLine();
			profile3Name = in.nextLine();
			in.nextLine();
			profile5Name = in.nextLine();
			profile1Level = in.nextLine();
			profile2Level = in.nextLine();
			profile3Level = in.nextLine();
			in.nextLine();
			profile5Level = in.nextLine();
		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
		}

		try {
			File outputFile = new File ("Profiles.txt");
			PrintWriter out = null;
			out = new PrintWriter (outputFile);
			out.println (profile1Name);
			out.println (profile2Name);
			out.println (profile3Name);
			out.println (profileNameBox.getText());
			out.println (profile5Name);
			out.println (profile1Level);
			out.println (profile2Level);
			out.println (profile3Level);
			out.println ("1");
			out.println (profile5Level);
			out.close ();
		} catch (FileNotFoundException e) {
			System.out.println ("ERROR: Level File does not exist");
		}
		profile4MenuItem.setText(profileNameBox.getText());
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
		profile3Button.setVisible(false);
		profile4Button.setVisible(false);
		profile5Button.setVisible(false);
		createProfileButton.setVisible(true);
		profilesMenu.setVisible(true);
		profilesMenu.setText("Profiles");
	}

	@FXML
	private void handleProfile5Button(ActionEvent event) {
		String profile1Name = "";
		String profile1Level = "";
		String profile2Name = "";
		String profile2Level = "";
		String profile3Name = "";
		String profile3Level = "";
		String profile4Name = "";
		String profile4Level = "";
		try {
			File f = new File("Profiles.txt");
			Scanner in = new Scanner(f);
		 	profile1Name = in.nextLine();
			profile2Name = in.nextLine();
			profile3Name = in.nextLine();
			profile4Name = in.nextLine();
			in.nextLine();
			profile1Level = in.nextLine();
			profile2Level = in.nextLine();
			profile3Level = in.nextLine();
			profile4Level = in.nextLine();
		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
		}

		try {
			File outputFile = new File ("Profiles.txt");
			PrintWriter out = null;
			out = new PrintWriter (outputFile);
			out.println (profile1Name);
			out.println (profile2Name);
			out.println (profile3Name);
			out.println (profile4Name);
			out.println (profileNameBox.getText());
			out.println (profile1Level);
			out.println (profile2Level);
			out.println (profile3Level);
			out.println (profile4Level);
			out.println ("1");
			out.close ();
		} catch (FileNotFoundException e) {
			System.out.println ("ERROR: Level File does not exist");
		}
		profile5MenuItem.setText(profileNameBox.getText());
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
		profile3Button.setVisible(false);
		profile4Button.setVisible(false);
		profile5Button.setVisible(false);
		createProfileButton.setVisible(true);
		profilesMenu.setVisible(true);
		profilesMenu.setText("Profiles");
	}

	@FXML
	private void guestSelected(ActionEvent event) {
		profilesMenu.setText("Guest");
		levelSelectMenu.setVisible(true);
		level1MenuItem.setVisible(true);
		level2MenuItem.setVisible(true);
		level3MenuItem.setVisible(true);
		level4MenuItem.setVisible(true);
		level5MenuItem.setVisible(true);
	}

	@FXML
	private void profile1Selected(ActionEvent event) {
		profilesMenu.setText(profile1MenuItem.getText());
		levelSelectMenu.setVisible(true);
		level1MenuItem.setVisible(false);
		level2MenuItem.setVisible(false);
		level3MenuItem.setVisible(false);
		level4MenuItem.setVisible(false);
		level5MenuItem.setVisible(false);
		try {
			File f = new File("Profiles.txt");
			Scanner in = new Scanner(f);
			in.nextLine();
			in.nextLine();
			in.nextLine();
			in.nextLine();
			in.nextLine();
			int level = in.nextInt();
			if (level == 1) {
				level1MenuItem.setVisible(true);
			} else if (level == 2) {
				level1MenuItem.setVisible(true);
				level2MenuItem.setVisible(true);
			} else if (level == 3) {
				level1MenuItem.setVisible(true);
				level2MenuItem.setVisible(true);
				level3MenuItem.setVisible(true);
			} else if (level == 4) {
				level1MenuItem.setVisible(true);
				level2MenuItem.setVisible(true);
				level3MenuItem.setVisible(true);
				level4MenuItem.setVisible(true);
			} else {
				level1MenuItem.setVisible(true);
				level2MenuItem.setVisible(true);
				level3MenuItem.setVisible(true);
				level4MenuItem.setVisible(true);
				level5MenuItem.setVisible(true);
			}
		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
		}
	}

	@FXML
	private void profile2Selected(ActionEvent event) {
		profilesMenu.setText(profile2MenuItem.getText());
		levelSelectMenu.setVisible(true);
		level1MenuItem.setVisible(false);
		level2MenuItem.setVisible(false);
		level3MenuItem.setVisible(false);
		level4MenuItem.setVisible(false);
		level5MenuItem.setVisible(false);
		try {
			File f = new File("Profiles.txt");
			Scanner in = new Scanner(f);
			in.nextLine();
			in.nextLine();
			in.nextLine();
			in.nextLine();
			in.nextLine();
			in.nextLine();
			int level = in.nextInt();
			if (level == 1) {
				level1MenuItem.setVisible(true);
			} else if (level == 2) {
				level1MenuItem.setVisible(true);
				level2MenuItem.setVisible(true);
			} else if (level == 3) {
				level1MenuItem.setVisible(true);
				level2MenuItem.setVisible(true);
				level3MenuItem.setVisible(true);
			} else if (level == 4) {
				level1MenuItem.setVisible(true);
				level2MenuItem.setVisible(true);
				level3MenuItem.setVisible(true);
				level4MenuItem.setVisible(true);
			} else {
				level1MenuItem.setVisible(true);
				level2MenuItem.setVisible(true);
				level3MenuItem.setVisible(true);
				level4MenuItem.setVisible(true);
				level5MenuItem.setVisible(true);
			}
		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
		}
	}

	@FXML
	private void profile3Selected(ActionEvent event) {
		profilesMenu.setText(profile3MenuItem.getText());
		levelSelectMenu.setVisible(true);
		level1MenuItem.setVisible(false);
		level2MenuItem.setVisible(false);
		level3MenuItem.setVisible(false);
		level4MenuItem.setVisible(false);
		level5MenuItem.setVisible(false);
		try {
			File f = new File("Profiles.txt");
			Scanner in = new Scanner(f);
			in.nextLine();
			in.nextLine();
			in.nextLine();
			in.nextLine();
			in.nextLine();
			in.nextLine();
			in.nextLine();
			int level = in.nextInt();
			if (level == 1) {
				level1MenuItem.setVisible(true);
			} else if (level == 2) {
				level1MenuItem.setVisible(true);
				level2MenuItem.setVisible(true);
			} else if (level == 3) {
				level1MenuItem.setVisible(true);
				level2MenuItem.setVisible(true);
				level3MenuItem.setVisible(true);
			} else if (level == 4) {
				level1MenuItem.setVisible(true);
				level2MenuItem.setVisible(true);
				level3MenuItem.setVisible(true);
				level4MenuItem.setVisible(true);
			} else {
				level1MenuItem.setVisible(true);
				level2MenuItem.setVisible(true);
				level3MenuItem.setVisible(true);
				level4MenuItem.setVisible(true);
				level5MenuItem.setVisible(true);
			}
		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
		}
	}

	@FXML
	private void profile4Selected(ActionEvent event) {
		profilesMenu.setText(profile4MenuItem.getText());
		levelSelectMenu.setVisible(true);
		level1MenuItem.setVisible(false);
		level2MenuItem.setVisible(false);
		level3MenuItem.setVisible(false);
		level4MenuItem.setVisible(false);
		level5MenuItem.setVisible(false);
		try {
			File f = new File("Profiles.txt");
			Scanner in = new Scanner(f);
			in.nextLine();
			in.nextLine();
			in.nextLine();
			in.nextLine();
			in.nextLine();
			in.nextLine();
			in.nextLine();
			in.nextLine();
			int level = in.nextInt();
			if (level == 1) {
				level1MenuItem.setVisible(true);
			} else if (level == 2) {
				level1MenuItem.setVisible(true);
				level2MenuItem.setVisible(true);
			} else if (level == 3) {
				level1MenuItem.setVisible(true);
				level2MenuItem.setVisible(true);
				level3MenuItem.setVisible(true);
			} else if (level == 4) {
				level1MenuItem.setVisible(true);
				level2MenuItem.setVisible(true);
				level3MenuItem.setVisible(true);
				level4MenuItem.setVisible(true);
			} else {
				level1MenuItem.setVisible(true);
				level2MenuItem.setVisible(true);
				level3MenuItem.setVisible(true);
				level4MenuItem.setVisible(true);
				level5MenuItem.setVisible(true);
			}
		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
		}
	}

	@FXML
	private void profile5Selected(ActionEvent event) {
		profilesMenu.setText(profile5MenuItem.getText());
		levelSelectMenu.setVisible(true);
		level1MenuItem.setVisible(false);
		level2MenuItem.setVisible(false);
		level3MenuItem.setVisible(false);
		level4MenuItem.setVisible(false);
		level5MenuItem.setVisible(false);
		try {
			File f = new File("Profiles.txt");
			Scanner in = new Scanner(f);
			in.nextLine();
			in.nextLine();
			in.nextLine();
			in.nextLine();
			in.nextLine();
			in.nextLine();
			in.nextLine();
			in.nextLine();
			in.nextLine();
			int level = in.nextInt();
			if (level == 1) {
				level1MenuItem.setVisible(true);
			} else if (level == 2) {
				level1MenuItem.setVisible(true);
				level2MenuItem.setVisible(true);
			} else if (level == 3) {
				level1MenuItem.setVisible(true);
				level2MenuItem.setVisible(true);
				level3MenuItem.setVisible(true);
			} else if (level == 4) {
				level1MenuItem.setVisible(true);
				level2MenuItem.setVisible(true);
				level3MenuItem.setVisible(true);
				level4MenuItem.setVisible(true);
			} else {
				level1MenuItem.setVisible(true);
				level2MenuItem.setVisible(true);
				level3MenuItem.setVisible(true);
				level4MenuItem.setVisible(true);
				level5MenuItem.setVisible(true);
			}
		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
		}
	}

	@FXML
	private void level1Selected(ActionEvent event) {
		levelSelectMenu.setText("1");
		playButton.setVisible(true);
	}
	@FXML
	private void level2Selected(ActionEvent event) {
		levelSelectMenu.setText("2");
		playButton.setVisible(true);
	}
	@FXML
	private void level3Selected(ActionEvent event) {
		levelSelectMenu.setText("3");
		playButton.setVisible(true);
	}
	@FXML
	private void level4Selected(ActionEvent event) {
		levelSelectMenu.setText("4");
		playButton.setVisible(true);
	}
	@FXML
	private void level5Selected(ActionEvent event) {
		levelSelectMenu.setText("5");
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
