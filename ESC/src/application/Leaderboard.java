package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Leaderboard {

    /**
    * Gets the current leaderboards from the given leaderboards text file and outputs it in a formatted sentence.
    * @param levelName the name of a level you wish to checks leaderboard.
    * @return an array of seconds it took a player to complete a level and their user name.
    */
	public static String[] getLeaderboard(String levelName) {
		
		String[] timesTaken = {"","",""};
		
		try {
			//opens the leaderboard file for a given level
			File f = new File("ESC/" + levelName + "leaderboard.txt");
			Scanner in = new Scanner(f);
			String timeTaken;
			String userName;
			
			//gets the data out of the file and outputs it to a string output
			for (int i=0;i<3;i++) {
				timeTaken = in.nextLine();
				userName = in.nextLine();
				timesTaken[i] = (userName + " took " + timeTaken + " seconds.");
			}

			in.close();
			
		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
		}
		
		return timesTaken;
		
	}
	
        /**
        * Gets the current leaderboard data.
        * @param levelName the name of a level you wish to checks leaderboard.
        * @retun a 2d array of each record in the leaderboard.
        */
	public static String[][] getCurrentRecords(String levelName) {
		
		try {
			//opens the leaderboard file for a given level
			File f = new File("ESC/" + levelName + "leaderboard.txt");
			Scanner in = new Scanner(f);
			String timeTaken;
			String userName;
			
			String[][] records = {{"","",""},{"","",""}};
			
			//retrieves the data out of the leaderboard text file and outputs into a format the program can
			//carry out comparisons on the data
			for (int i=0;i<3;i++) {	
				timeTaken = in.next();
				userName = in.next();
				
				//0 being the time of a given i
				//1 being the user name of a given i
				records[0][i] = timeTaken;
				records[1][i] = userName;
			}
			
			in.close();
			
			return records;

		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
			return null;
		}
		
	}
	
        /**
        * checks if a new user attempt at a level deserves to be on the leaderboard.
        * @param levelName the name of a level which has been comepleted.
        * @param timeTakenNew the time it took the user to complete said level.
        * @param userNameNew the user name of the player who completed said level.
        */
	public static void checkNewLevelComplete(String levelName, int timeTakenNew, String userNameNew) {
		
		try {
			//opens the leaderboard file for a given level
			File f = new File("ESC/" + levelName + "leaderboard.txt");
			Scanner in = new Scanner(f);
			
			int timeTaken;
			String userName;
			//flag is used to see if a record has taken the place of another in the leaderboards
			boolean flag = false;
			
			//gets the current leaderboards from the file
			String[][] recordsOld = getCurrentRecords(levelName);
			String[][] recordsNew = {{"","",""},{"","",""}};
			
			//compares every record in the leaderboard file against the new time to enter
			for (int i=0;i<3;i++) {
				timeTaken = in.nextInt();
				userName = in.next();
				
				if (flag == false) {
					if (Integer.parseInt(recordsOld[0][i]) > timeTakenNew) {
						//a record has taken the place of one in the leaderboard text file
						flag = true;
					
						recordsNew[0][i] = Integer.toString(timeTakenNew);
						recordsNew[1][i] = userNameNew;
				
					} else {
						//if no change in the leaderboards
						recordsNew[0][i] = recordsOld[0][i];
						recordsNew[1][i] = recordsOld[1][i];
						
					}
				} else {
					//if a record is now on the leaderboard and taking the place of other records
					recordsNew[0][i] = recordsOld[0][i-1];
					recordsNew[1][i] = recordsOld[1][i-1];
				}
					
			}
			
			//to write to the leaderboard file
			try {
			FileWriter writer = new FileWriter("ESC/" + levelName + "leaderboard.txt");
			
			//compiles the data to be written to the text file
			String outputContent = "";
			for (int i=0;i<3;i++) {
				if (outputContent.equals("")) {
					outputContent = recordsNew[0][i] + System.lineSeparator() + recordsNew[1][i];
					
				} else {
					outputContent = outputContent + System.lineSeparator() + recordsNew[0][i] + System.lineSeparator() + recordsNew[1][i];
				}
				
			}
			
			writer.write(outputContent);
			writer.close();
			} catch (IOException exception) {
				System.out.println("ERROR: Level File does not exist.");
			}		
					
			in.close();
		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
		}
		
	}
	
}
