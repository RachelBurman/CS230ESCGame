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

/**
 * MenuController.java
 * @version 3.5.0
 * @author Maciej Brzyski 986076
 */

/**
 * This class controls the menu, and all the actions that
 * can be done within it
 */

public class MenuController {
    private final String PROFILES_FILE = "./Profiles.txt";
    @FXML private Label testLabel;
    @FXML private Label profileNameLabel;
    @FXML private Label errorMessage;
    @FXML private Label questionLabel;
    @FXML private Label messageOfTheDayLabel;
    @FXML private Label leaderboardLabel;
    @FXML private Label firstTimeLabel;
    @FXML private Label secondTimeLabel;
    @FXML private Label thirdTimeLabel;
    @FXML private Button playButton;
    @FXML private Button createButton;
    @FXML private Button yesButton;
    @FXML private Button noButton;
    @FXML private Button profile1Button;
    @FXML private Button profile2Button;
    @FXML private Button profile3Button;
    @FXML private Button profile4Button;
    @FXML private Button profile5Button;
    @FXML private Button createProfileButton;
    @FXML private Button leaderboardLevel1Button;
    @FXML private Button leaderboardLevel2Button;
    @FXML private Button leaderboardLevel3Button;
    @FXML private Button leaderboardLevel4Button;
    @FXML private Button leaderboardLevel5Button;
    @FXML private Button leaderboardButton;
    @FXML private Button backButton;
    @FXML private MenuButton profilesMenu;
    @FXML private MenuButton levelSelectMenu;
    @FXML private MenuItem profile1MenuItem;
    @FXML private MenuItem profile2MenuItem;
    @FXML private MenuItem profile3MenuItem;
    @FXML private MenuItem profile4MenuItem;
    @FXML private MenuItem profile5MenuItem;
    @FXML private MenuItem level1MenuItem;
    @FXML private MenuItem level2MenuItem;
    @FXML private MenuItem level3MenuItem;
    @FXML private MenuItem level4MenuItem;
    @FXML private MenuItem level5MenuItem;
    @FXML private TextField profileNameBox;

    /**
     * Runs when the menu is opened.
     * Gets profiles from the Profiles.txt.
     * Displays the message of the day.
     */
    @FXML
    private void initialize() {
        String s = "";
        profile1MenuItem.setVisible(false);
        profile2MenuItem.setVisible(false);
        profile3MenuItem.setVisible(false);
        profile4MenuItem.setVisible(false);
        profile5MenuItem.setVisible(false);
        getProfiles();
        messageOfTheDayLabel.setText(getMessage());
    }

    /**
     * Runs the game when the play button is pressed.
     * Chooses the level based on what the user selected.
     * @param event playButton pressed.
     */
    @FXML
    private void handleStartButtonAction(ActionEvent event) {
        Game game = new Game();
        String name = "";
        String s = "./test.txt";
        switch (profilesMenu.getText()) {
        case "Profile 1":
            name = profile1MenuItem.getText();
            break;
        case "Profile 2":
        	name = profile2MenuItem.getText();
            break;
        case "Profile 3":
        	name = profile3MenuItem.getText();
            break;
        case "Profile 4":
        	name = profile4MenuItem.getText();
            break;
        case "Profile 5":
        	name = profile5MenuItem.getText();;
            break;
        default:
            break;
    }
        switch (levelSelectMenu.getText()) {
            case "1":
                s = "./lvl1.txt";
                break;
            case "2":
                s = "./lvl2.txt";
                break;
            case "3":
                s = "./lvl3.txt";
                break;
            case "4":
                s = "./lvl4.txt";
                break;
            case "5":
                s = "./lvl5.txt";
                break;
            default:
                break;
        }
        game.start(s, profilesMenu.getText(), name);
        playButton.setVisible(false);
        levelSelectMenu.setText("Level");
        levelSelectMenu.setVisible(false);
        profilesMenu.setText("Profiles");
        profilesMenu.setVisible(false);
    }

    /**
     * Takes the user to the create profile section.
     * @param event createProfileButton pressed.
     */
    @FXML
    private void handleProfileButtonAction(ActionEvent event) {
        leaderboardButton.setVisible(false);
        levelSelectMenu.setVisible(false);
        playButton.setVisible(false);
        createProfileButton.setVisible(false);
        profilesMenu.setVisible(false);
        createButton.setVisible(true);
        profileNameBox.setVisible(true);
        profileNameLabel.setVisible(true);
    }

    /**
     * Creates a profile if there are slots free,
     * otherwise displays a replace a profile section.
     * @param event createButton pressed.
     */
    @FXML
    private void handleCreateButtonAction(ActionEvent event) {
        if (!profile1MenuItem.isVisible()) {
            try {
                File outputFile = new File(PROFILES_FILE);
                PrintWriter out = null;
                out = new PrintWriter(outputFile);
                out.println(profileNameBox.getText());
                out.println("");
                out.println("");
                out.println("");
                out.println("");
                out.println("1");
                out.close();
            } catch (FileNotFoundException e) {
                System.out.println("ERROR: Level File does not exist");
            }
            profile1MenuItem.setText(profileNameBox.getText());
            profile1MenuItem.setVisible(true);
            profileNameBox.setText("");
            createButton.setVisible(false);
            profileNameBox.setVisible(false);
            profileNameLabel.setVisible(false);
            createProfileButton.setVisible(true);
            profilesMenu.setVisible(true);
            leaderboardButton.setVisible(true);
        } else if (!profile2MenuItem.isVisible()) {
            String profile1Name = "";
            String profile1Level = "";
            try {
                File f = new File(PROFILES_FILE);
                Scanner in = new Scanner(f);
                profile1Name = in .nextLine(); in .nextLine(); in .nextLine(); in .nextLine(); in .nextLine();
                profile1Level = in .nextLine();
            } catch (FileNotFoundException exception) {
                System.out.println("ERROR: Level File does not exist.");
            }
            try {
                File outputFile = new File(PROFILES_FILE);
                PrintWriter out = null;
                out = new PrintWriter(outputFile);
                out.println(profile1Name);
                out.println(profileNameBox.getText());
                out.println("");
                out.println("");
                out.println("");
                out.println(profile1Level);
                out.println("1");
                out.close();
            } catch (FileNotFoundException e) {
                System.out.println("ERROR: Level File does not exist");
            }
            profile2MenuItem.setText(profileNameBox.getText());
            profile2MenuItem.setVisible(true);
            profileNameBox.setText("");
            createButton.setVisible(false);
            profileNameBox.setVisible(false);
            profileNameLabel.setVisible(false);
            createProfileButton.setVisible(true);
            profilesMenu.setVisible(true);
            leaderboardButton.setVisible(true);
        } else if (!profile3MenuItem.isVisible()) {
            String profile1Name = "";
            String profile1Level = "";
            String profile2Name = "";
            String profile2Level = "";
            try {
                File f = new File(PROFILES_FILE);
                Scanner in = new Scanner(f);
                profile1Name = in .nextLine();
                profile2Name = in .nextLine(); in .nextLine(); in .nextLine(); in .nextLine();
                profile1Level = in .nextLine();
                profile2Level = in .nextLine();
            } catch (FileNotFoundException exception) {
                System.out.println("ERROR: Level File does not exist.");
            }
            try {
                File outputFile = new File(PROFILES_FILE);
                PrintWriter out = null;
                out = new PrintWriter(outputFile);
                out.println(profile1Name);
                out.println(profile2Name);
                out.println(profileNameBox.getText());
                out.println("");
                out.println("");
                out.println(profile1Level);
                out.println(profile2Level);
                out.println("1");
                out.close();
            } catch (FileNotFoundException e) {
                System.out.println("ERROR: Level File does not exist");
            }
            profile3MenuItem.setText(profileNameBox.getText());
            profile3MenuItem.setVisible(true);
            profileNameBox.setText("");
            createButton.setVisible(false);
            profileNameBox.setVisible(false);
            profileNameLabel.setVisible(false);
            createProfileButton.setVisible(true);
            profilesMenu.setVisible(true);
            leaderboardButton.setVisible(true);
        } else if (!profile4MenuItem.isVisible()) {
            String profile1Name = "";
            String profile1Level = "";
            String profile2Name = "";
            String profile2Level = "";
            String profile3Name = "";
            String profile3Level = "";
            try {
                File f = new File(PROFILES_FILE);
                Scanner in = new Scanner(f);
                profile1Name = in .nextLine();
                profile2Name = in .nextLine();
                profile3Name = in .nextLine(); in .nextLine(); in .nextLine();
                profile1Level = in .nextLine();
                profile2Level = in .nextLine();
                profile3Level = in .nextLine();
            } catch (FileNotFoundException exception) {
                System.out.println("ERROR: Level File does not exist.");
            }
            try {
                File outputFile = new File(PROFILES_FILE);
                PrintWriter out = null;
                out = new PrintWriter(outputFile);
                out.println(profile1Name);
                out.println(profile2Name);
                out.println(profile3Name);
                out.println(profileNameBox.getText());
                out.println("");
                out.println(profile1Level);
                out.println(profile2Level);
                out.println(profile3Level);
                out.println("1");
                out.close();
            } catch (FileNotFoundException e) {
                System.out.println("ERROR: Level File does not exist");
            }
            profile4MenuItem.setText(profileNameBox.getText());
            profile4MenuItem.setVisible(true);
            profileNameBox.setText("");
            createButton.setVisible(false);
            profileNameBox.setVisible(false);
            profileNameLabel.setVisible(false);
            createProfileButton.setVisible(true);
            profilesMenu.setVisible(true);
            leaderboardButton.setVisible(true);
        } else if (!profile5MenuItem.isVisible()) {
            String profile1Name = "";
            String profile1Level = "";
            String profile2Name = "";
            String profile2Level = "";
            String profile3Name = "";
            String profile3Level = "";
            String profile4Name = "";
            String profile4Level = "";
            try {
                File f = new File(PROFILES_FILE);
                Scanner in = new Scanner(f);
                profile1Name = in .nextLine();
                profile2Name = in .nextLine();
                profile3Name = in .nextLine();
                profile4Name = in .nextLine(); in .nextLine();
                profile1Level = in .nextLine();
                profile2Level = in .nextLine();
                profile3Level = in .nextLine();
                profile4Level = in .nextLine();
            } catch (FileNotFoundException exception) {
                System.out.println("ERROR: Level File does not exist.");
            }
            try {
                File outputFile = new File(PROFILES_FILE);
                PrintWriter out = null;
                out = new PrintWriter(outputFile);
                out.println(profile1Name);
                out.println(profile2Name);
                out.println(profile3Name);
                out.println(profile4Name);
                out.println(profileNameBox.getText());
                out.println(profile1Level);
                out.println(profile2Level);
                out.println(profile3Level);
                out.println(profile4Level);
                out.println("1");
                out.close();
            } catch (FileNotFoundException e) {
                System.out.println("ERROR: Level File does not exist");
            }
            profile5MenuItem.setText(profileNameBox.getText());
            profile5MenuItem.setVisible(true);
            profileNameBox.setText("");
            createButton.setVisible(false);
            profileNameBox.setVisible(false);
            profileNameLabel.setVisible(false);
            createProfileButton.setVisible(true);
            profilesMenu.setVisible(true);
            leaderboardButton.setVisible(true);
        } else {
            errorMessage.setVisible(true);
            yesButton.setVisible(true);
            noButton.setVisible(true);
        }
    }

    /**
     * Goes back to the menu without changing any profiles.
     * @param event noButton pressed.
     */
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
        leaderboardButton.setVisible(true);
    }

    /**
     * Asks the user which profile to replace, and presents him options.
     * @param event yesButton pressed.
     */
    @FXML
    private void handleYesButtonAction(ActionEvent event) {
        questionLabel.setVisible(true);
        profile1Button.setVisible(true);
        profile2Button.setVisible(true);
        profile3Button.setVisible(true);
        profile4Button.setVisible(true);
        profile5Button.setVisible(true);
    }

    /**
     * Replaces Profile 1 with the new profile.
     * Goes back to the menu.
     * @param event profile1Button pressed.
     */
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
            File f = new File(PROFILES_FILE);
            Scanner in = new Scanner(f); in .nextLine();
            profile2Name = in .nextLine();
            profile3Name = in .nextLine();
            profile4Name = in .nextLine();
            profile5Name = in .nextLine(); in .nextLine();
            profile2Level = in .nextLine();
            profile3Level = in .nextLine();
            profile4Level = in .nextLine();
            profile5Level = in .nextLine();
        } catch (FileNotFoundException exception) {
            System.out.println("ERROR: Level File does not exist.");
        }

        try {
            File outputFile = new File(PROFILES_FILE);
            PrintWriter out = null;
            out = new PrintWriter(outputFile);
            out.println(profileNameBox.getText());
            out.println(profile2Name);
            out.println(profile3Name);
            out.println(profile4Name);
            out.println(profile5Name);
            out.println("1");
            out.println(profile2Level);
            out.println(profile3Level);
            out.println(profile4Level);
            out.println(profile5Level);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Level File does not exist");
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
        leaderboardButton.setVisible(true);
    }

    /**
     * Replaces Profile 2 with the new profile.
     * Goes back to the menu.
     * @param event profile2Button pressed.
     */
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
            File f = new File(PROFILES_FILE);
            Scanner in = new Scanner(f);
            profile1Name = in .nextLine(); in .nextLine();
            profile3Name = in .nextLine();
            profile4Name = in .nextLine();
            profile5Name = in .nextLine();
            profile1Level = in .nextLine(); in .nextLine();
            profile3Level = in .nextLine();
            profile4Level = in .nextLine();
            profile5Level = in .nextLine();
        } catch (FileNotFoundException exception) {
            System.out.println("ERROR: Level File does not exist.");
        }

        try {
            File outputFile = new File(PROFILES_FILE);
            PrintWriter out = null;
            out = new PrintWriter(outputFile);
            out.println(profile1Name);
            out.println(profileNameBox.getText());
            out.println(profile3Name);
            out.println(profile4Name);
            out.println(profile5Name);
            out.println(profile1Level);
            out.println("1");
            out.println(profile3Level);
            out.println(profile4Level);
            out.println(profile5Level);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Level File does not exist");
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
        leaderboardButton.setVisible(true);
    }

    /**
     * Replaces Profile 3 with the new profile.
     * Goes back to the menu.
     * @param event profile3Button pressed.
     */
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
            File f = new File(PROFILES_FILE);
            Scanner in = new Scanner(f);
            profile1Name = in .nextLine();
            profile2Name = in .nextLine(); in .nextLine();
            profile4Name = in .nextLine();
            profile5Name = in .nextLine();
            profile1Level = in .nextLine();
            profile2Level = in .nextLine(); in .nextLine();
            profile4Level = in .nextLine();
            profile5Level = in .nextLine();
        } catch (FileNotFoundException exception) {
            System.out.println("ERROR: Level File does not exist.");
        }

        try {
            File outputFile = new File(PROFILES_FILE);
            PrintWriter out = null;
            out = new PrintWriter(outputFile);
            out.println(profile1Name);
            out.println(profile2Name);
            out.println(profileNameBox.getText());
            out.println(profile4Name);
            out.println(profile5Name);
            out.println(profile1Level);
            out.println(profile2Level);
            out.println("1");
            out.println(profile4Level);
            out.println(profile5Level);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Level File does not exist");
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
        leaderboardButton.setVisible(true);
    }

    /**
     * Replaces Profile 4 with the new profile.
     * Goes back to the menu.
     * @param event profile4Button pressed.
     */
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
            File f = new File(PROFILES_FILE);
            Scanner in = new Scanner(f);
            profile1Name = in .nextLine();
            profile2Name = in .nextLine();
            profile3Name = in .nextLine(); in .nextLine();
            profile5Name = in .nextLine();
            profile1Level = in .nextLine();
            profile2Level = in .nextLine();
            profile3Level = in .nextLine(); in .nextLine();
            profile5Level = in .nextLine();
        } catch (FileNotFoundException exception) {
            System.out.println("ERROR: Level File does not exist.");
        }

        try {
            File outputFile = new File(PROFILES_FILE);
            PrintWriter out = null;
            out = new PrintWriter(outputFile);
            out.println(profile1Name);
            out.println(profile2Name);
            out.println(profile3Name);
            out.println(profileNameBox.getText());
            out.println(profile5Name);
            out.println(profile1Level);
            out.println(profile2Level);
            out.println(profile3Level);
            out.println("1");
            out.println(profile5Level);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Level File does not exist");
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
        leaderboardButton.setVisible(true);
    }

    /**
     * Replaces Profile 5 with the new profile.
     * Goes back to the menu.
     * @param event profile5Button pressed.
     */
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
            File f = new File(PROFILES_FILE);
            Scanner in = new Scanner(f);
            profile1Name = in .nextLine();
            profile2Name = in .nextLine();
            profile3Name = in .nextLine();
            profile4Name = in .nextLine(); in .nextLine();
            profile1Level = in .nextLine();
            profile2Level = in .nextLine();
            profile3Level = in .nextLine();
            profile4Level = in .nextLine();
        } catch (FileNotFoundException exception) {
            System.out.println("ERROR: Level File does not exist.");
        }

        try {
            File outputFile = new File(PROFILES_FILE);
            PrintWriter out = null;
            out = new PrintWriter(outputFile);
            out.println(profile1Name);
            out.println(profile2Name);
            out.println(profile3Name);
            out.println(profile4Name);
            out.println(profileNameBox.getText());
            out.println(profile1Level);
            out.println(profile2Level);
            out.println(profile3Level);
            out.println(profile4Level);
            out.println("1");
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Level File does not exist");
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
        leaderboardButton.setVisible(true);
    }

    /**
     * Displays the levels menu with all levels avaliable, because the user selected guest.
     * @param event guestMenuItem selected.
     */
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

    /**
     * Displays the levels menu with the levels avaliable to the 1st Profile. 
     * @param event profile1MenuItem selected.
     */
    @FXML
    private void profile1Selected(ActionEvent event) {
        profilesMenu.setText("Profile 1");
        levelSelectMenu.setVisible(true);
        level1MenuItem.setVisible(false);
        level2MenuItem.setVisible(false);
        level3MenuItem.setVisible(false);
        level4MenuItem.setVisible(false);
        level5MenuItem.setVisible(false);
        try {
            File f = new File(PROFILES_FILE);
            Scanner in = new Scanner(f);
            in .nextLine();
            in .nextLine();
            in .nextLine();
            in .nextLine();
            in .nextLine();
            int level = in .nextInt();
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

    /**
     * Displays the levels menu with the levels avaliable to the 2nd Profile. 
     * @param event profile2MenuItem selected.
     */
    @FXML
    private void profile2Selected(ActionEvent event) {
        profilesMenu.setText("Profile 2");
        levelSelectMenu.setVisible(true);
        level1MenuItem.setVisible(false);
        level2MenuItem.setVisible(false);
        level3MenuItem.setVisible(false);
        level4MenuItem.setVisible(false);
        level5MenuItem.setVisible(false);
        try {
            File f = new File(PROFILES_FILE);
            Scanner in = new Scanner(f);
            in .nextLine();
            in .nextLine();
            in .nextLine();
            in .nextLine();
            in .nextLine();
            in .nextLine();
            int level = in .nextInt();
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

    /**
     * Displays the levels menu with the levels avaliable to the 3rd Profile. 
     * @param event profile3MenuItem selected.
     */
    @FXML
    private void profile3Selected(ActionEvent event) {
        profilesMenu.setText("Profile 3");
        levelSelectMenu.setVisible(true);
        level1MenuItem.setVisible(false);
        level2MenuItem.setVisible(false);
        level3MenuItem.setVisible(false);
        level4MenuItem.setVisible(false);
        level5MenuItem.setVisible(false);
        try {
            File f = new File(PROFILES_FILE);
            Scanner in = new Scanner(f);
            in .nextLine();
            in .nextLine();
            in .nextLine();
            in .nextLine();
            in .nextLine();
            in .nextLine();
            in .nextLine();
            int level = in .nextInt();
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

    /**
     * Displays the levels menu with the levels avaliable to the 4th Profile. 
     * @param event profile4MenuItem selected.
     */
    @FXML
    private void profile4Selected(ActionEvent event) {
        profilesMenu.setText("Profile 4");
        levelSelectMenu.setVisible(true);
        level1MenuItem.setVisible(false);
        level2MenuItem.setVisible(false);
        level3MenuItem.setVisible(false);
        level4MenuItem.setVisible(false);
        level5MenuItem.setVisible(false);
        try {
            File f = new File(PROFILES_FILE);
            Scanner in = new Scanner(f);
            in .nextLine();
            in .nextLine();
            in .nextLine();
            in .nextLine();
            in .nextLine();
            in .nextLine();
            in .nextLine();
            in .nextLine();
            int level = in .nextInt();
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

    /**
     * Displays the levels menu with the levels avaliable to the 5th Profile. 
     * @param event profile5MenuItem selected.
     */
    @FXML
    private void profile5Selected(ActionEvent event) {
        profilesMenu.setText("Profile 5");
        levelSelectMenu.setVisible(true);
        level1MenuItem.setVisible(false);
        level2MenuItem.setVisible(false);
        level3MenuItem.setVisible(false);
        level4MenuItem.setVisible(false);
        level5MenuItem.setVisible(false);
        try {
            File f = new File(PROFILES_FILE);
            Scanner in = new Scanner(f);
            in .nextLine();
            in .nextLine();
            in .nextLine();
            in .nextLine();
            in .nextLine();
            in .nextLine();
            in .nextLine();
            in .nextLine();
            in .nextLine();
            int level = in .nextInt();
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

    /**
     * Changes the text in levelsMenu to "1" and makes the play button visible.
     * @param event level1MenuItem selected.
     */
    @FXML
    private void level1Selected(ActionEvent event) {
        levelSelectMenu.setText("1");
        playButton.setVisible(true);
    }
    
    /**
     * Changes the text in levelsMenu to "2" and makes the play button visible.
     * @param event level2MenuItem selected.
     */
    @FXML
    private void level2Selected(ActionEvent event) {
        levelSelectMenu.setText("2");
        playButton.setVisible(true);
    }
    
    /**
     * Changes the text in levelsMenu to "3" and makes the play button visible.
     * @param event level3MenuItem selected.
     */
    @FXML
    private void level3Selected(ActionEvent event) {
        levelSelectMenu.setText("3");
        playButton.setVisible(true);
    }
    
    /**
     * Changes the text in levelsMenu to "4" and makes the play button visible.
     * @param event level4MenuItem selected.
     */
    @FXML
    private void level4Selected(ActionEvent event) {
        levelSelectMenu.setText("4");
        playButton.setVisible(true);
    }
    
    /**
     * Changes the text in levelsMenu to "5" and makes the play button visible.
     * @param event level5MenuItem selected.
     */
    @FXML
    private void level5Selected(ActionEvent event) {
        levelSelectMenu.setText("5");
        playButton.setVisible(true);
    }

    /**
     * Displays the leaderboard menu.
     * @param event leaderboardButton pressed.
     */
    @FXML
    private void handleLeaderboardButtonAction(ActionEvent event) {
        profilesMenu.setVisible(false);
        levelSelectMenu.setVisible(false);
        playButton.setVisible(false);
        createProfileButton.setVisible(false);
        leaderboardButton.setVisible(false);
        leaderboardLabel.setVisible(true);
        leaderboardLevel1Button.setVisible(true);
        leaderboardLevel2Button.setVisible(true);
        leaderboardLevel3Button.setVisible(true);
        leaderboardLevel4Button.setVisible(true);
        leaderboardLevel5Button.setVisible(true);
    }

    /**
     * Displays the level 1 leaderboard.
     * @param event leaderboardLevel1Button pressed.
     */
    @FXML
    private void handleLevel1LeaderboardAction(ActionEvent event) {
        leaderboardLabel.setText("Level 1 best times:");
        leaderboardLevel1Button.setVisible(false);
        leaderboardLevel2Button.setVisible(false);
        leaderboardLevel3Button.setVisible(false);
        leaderboardLevel4Button.setVisible(false);
        leaderboardLevel5Button.setVisible(false);
        firstTimeLabel.setVisible(true);
        String[] bestTimes = Leaderboard.getLeaderboard("lvl1");
        firstTimeLabel.setText("1:" + bestTimes[0]);
        secondTimeLabel.setVisible(true);
        secondTimeLabel.setText("2:" + bestTimes[1]);
        thirdTimeLabel.setVisible(true);
        thirdTimeLabel.setText("3:" + bestTimes[2]);
        backButton.setVisible(true);
    }

    /**
     * Displays the level 2 leaderboard.
     * @param event leaderboardLevel2Button pressed.
     */
    @FXML
    private void handleLevel2LeaderboardAction(ActionEvent event) {
        leaderboardLabel.setText("Level 2 best times:");
        leaderboardLevel1Button.setVisible(false);
        leaderboardLevel2Button.setVisible(false);
        leaderboardLevel3Button.setVisible(false);
        leaderboardLevel4Button.setVisible(false);
        leaderboardLevel5Button.setVisible(false);
        firstTimeLabel.setVisible(true);
        String[] bestTimes = Leaderboard.getLeaderboard("lvl2");
        firstTimeLabel.setText("1:" + bestTimes[0]);
        secondTimeLabel.setVisible(true);
        secondTimeLabel.setText("2:" + bestTimes[1]);
        thirdTimeLabel.setVisible(true);
        thirdTimeLabel.setText("3:" + bestTimes[2]);
        backButton.setVisible(true);
    }

    /**
     * Displays the level 3 leaderboard.
     * @param event leaderboardLevel3Button pressed.
     */
    @FXML
    private void handleLevel3LeaderboardAction(ActionEvent event) {
        leaderboardLabel.setText("Level 3 best times:");
        leaderboardLevel1Button.setVisible(false);
        leaderboardLevel2Button.setVisible(false);
        leaderboardLevel3Button.setVisible(false);
        leaderboardLevel4Button.setVisible(false);
        leaderboardLevel5Button.setVisible(false);
        firstTimeLabel.setVisible(true);
        String[] bestTimes = Leaderboard.getLeaderboard("lvl3");
        firstTimeLabel.setText("1:" + bestTimes[0]);
        secondTimeLabel.setVisible(true);
        secondTimeLabel.setText("2:" + bestTimes[1]);
        thirdTimeLabel.setVisible(true);
        thirdTimeLabel.setText("3:" + bestTimes[2]);
        backButton.setVisible(true);
    }

    /**
     * Displays the level 4 leaderboard.
     * @param event leaderboardLevel4Button pressed.
     */
    @FXML
    private void handleLevel4LeaderboardAction(ActionEvent event) {
        leaderboardLabel.setText("Level 4 best times:");
        leaderboardLevel1Button.setVisible(false);
        leaderboardLevel2Button.setVisible(false);
        leaderboardLevel3Button.setVisible(false);
        leaderboardLevel4Button.setVisible(false);
        leaderboardLevel5Button.setVisible(false);
        firstTimeLabel.setVisible(true);
        String[] bestTimes = Leaderboard.getLeaderboard("lvl4");
        firstTimeLabel.setText("1:" + bestTimes[0]);
        secondTimeLabel.setVisible(true);
        secondTimeLabel.setText("2:" + bestTimes[1]);
        thirdTimeLabel.setVisible(true);
        thirdTimeLabel.setText("3:" + bestTimes[2]);
        backButton.setVisible(true);
    }

    /**
     * Displays the level 5 leaderboard.
     * @param event leaderboardLevel5Button pressed.
     */
    @FXML
    private void handleLevel5LeaderboardAction(ActionEvent event) {
        leaderboardLabel.setText("Level 5 best times:");
        leaderboardLevel1Button.setVisible(false);
        leaderboardLevel2Button.setVisible(false);
        leaderboardLevel3Button.setVisible(false);
        leaderboardLevel4Button.setVisible(false);
        leaderboardLevel5Button.setVisible(false);
        firstTimeLabel.setVisible(true);
        String[] bestTimes = Leaderboard.getLeaderboard("lvl5");
        firstTimeLabel.setText("1:" + bestTimes[0]);
        secondTimeLabel.setVisible(true);
        secondTimeLabel.setText("2:" + bestTimes[1]);
        thirdTimeLabel.setVisible(true);
        thirdTimeLabel.setText("3:" + bestTimes[2]);
        backButton.setVisible(true);
    }

    /**
     * Goes back from the leaderboard menu to the menu.
     * @param event backButton pressed.
     */
    @FXML
    private void handleBackButtonAction(ActionEvent event) {
        backButton.setVisible(false);
        leaderboardLabel.setText("Select Level");
        leaderboardLabel.setVisible(false);
        firstTimeLabel.setVisible(false);
        secondTimeLabel.setVisible(false);
        thirdTimeLabel.setVisible(false);
        profilesMenu.setVisible(true);
        profilesMenu.setText("Profiles");
        leaderboardButton.setVisible(true);
        createProfileButton.setVisible(true);
    }

    /**
     * Gets a String from a website.
     * @param urlToRead the website to get the String from.
     * @return the String from the website.
     * @throws Exception all exceptions really.
     */
    private String getHTML(String urlToRead) throws Exception {
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

    /**
     * Gets the message of the day using the algorithm specified.
     * @return the message of the day.
     */
    private String getMessage() {
        URL url = null;
        HttpURLConnection con = null;
        String s = "";
        try {
            s = getHTML("http://cswebcat.swan.ac.uk/puzzle");
        } catch (Exception exception) {

        }

        String sr = "";
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if ((i) % 2 == 0) {
                if ((int) letter == 90) {
                    letter = 'A';
                } else {
                    letter = (char)((int) letter + 1);
                }
                sr = sr + letter;
            } else {
                if ((int) letter == 65) {
                    letter = 'Z';
                } else {
                    letter = (char)((int) letter - 1);
                }
                sr = sr + letter;
            }
        }
        String result = "";
        try {
            result = getHTML("http://cswebcat.swan.ac.uk/message?solution=" + sr);
        } catch (Exception exception) {}
        return result;
    }
    
    /**
     * Gets profiles from a text file. 
     * Displays them as MenuItems in the profilesMenu.
     */
    private void getProfiles() {
    	String line = "";
    	try {
            File f = new File(PROFILES_FILE);
            Scanner in = new Scanner(f);
            if ( in .hasNextLine()) {
                line = in .nextLine();
                if (!(line.equals(""))) {
                    profile1MenuItem.setText(line);
                    profile1MenuItem.setVisible(true);
                }
            }
            if ( in .hasNextLine()) {
            	line = in .nextLine();
                if (!(line.equals(""))) {
                	profile2MenuItem.setText(line);
                    profile2MenuItem.setVisible(true);
                }
            }
            if ( in .hasNextLine()) {
            	line = in .nextLine();
                if (!(line.equals(""))) {
                	profile3MenuItem.setText(line);
                    profile3MenuItem.setVisible(true);
                }
            }
            if ( in .hasNextLine()) {
            	line = in .nextLine();
                if (!(line.equals(""))) {
                	profile4MenuItem.setText(line);
                    profile4MenuItem.setVisible(true);
                }
            }
            if ( in .hasNextLine()) {
            	line = in .nextLine();
                if (!(line.equals(""))) {
                	profile5MenuItem.setText(line);
                    profile5MenuItem.setVisible(true);
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println("ERROR: File not found");
        }
    }
}
