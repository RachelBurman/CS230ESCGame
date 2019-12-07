package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Leaderboard {

    /*
    * Gets the current leaderboards from the given leaderboards text file and outputs it in a formatted sentence
    * @param levelName the name of a level you wish to checks leaderboard
    * @return an array of seconds it took a player to complete a level and their user name
    */
	public static String[] getLeaderboard(String levelName) {
		
		String[] timesTaken = {"","",""};
		try {
			File f = new File("ESC/" + levelName + "leaderboard.txt");
			Scanner in = new Scanner(f);
			int timeTaken;
			String userName;
			
			for (int i=0;i<3;i++) {
				timeTaken = in.nextInt();
				userName = in.next();
				timesTaken[i] = (userName + " took " + timeTaken + " seconds.");
			}

			in.close();
		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: Level File does not exist.");
		}
		return timesTaken;
		
	}
	
        /*
        * Gets the current leaderboard data
        * @param levelName the name of a level you wish to checks leaderboard
        * @retun a 2d array of each record in the leaderboard
        */
	public static String[][] getCurrentRecords(String levelName) {
		
		try {
			File f = new File("ESC/" + levelName + "leaderboard.txt");
			Scanner in = new Scanner(f);
			String timeTaken;
			String userName;
			
			String[][] records = {{"","",""},{"","",""}};
			
			for (int i=0;i<3;i++) {
				
				timeTaken = in.next();
				userName = in.next();
				
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
	
        /*
        * checks if a new user attempt at a level deserves to be on the leaderboard
        * @param levelName the name of a level which has been comepleted
        * @param timeTakenNew the time it took the user to complete said level
        * @param userNameNew the user name of the player who completed said level
        */
	public static void checkNewLevelComplete(String levelName, int timeTakenNew, String userNameNew) {
		
		try {
			File f = new File("ESC/" + levelName + "leaderboard.txt");
			Scanner in = new Scanner(f);
			int timeTaken;
			String userName;
			boolean flag = false;
			
			String[][] recordsOld = getCurrentRecords(levelName);
			String[][] recordsNew = {{"","",""},{"","",""}};
			
			
			for (int i=0;i<3;i++) {
				timeTaken = in.nextInt();
				userName = in.next();
				//System.out.println(recordsOld[0][i]);
				//System.out.println(timeTakenNew);
				
				if (flag == false) {
					if (Integer.parseInt(recordsOld[0][i]) > timeTakenNew) {

						flag = true;
					
						recordsNew[0][i] = Integer.toString(timeTakenNew);
						recordsNew[1][i] = userNameNew;
						//System.out.println(recordsNew[i][0] + recordsNew[i][1]);
					
					
					} else {
						recordsNew[0][i] = recordsOld[0][i];
						recordsNew[1][i] = recordsOld[1][i];
						//System.out.println(recordsNew[0][i] + recordsNew[1][i]);
					}
				} else {
					//System.out.println(recordsNew[0][i]);
					recordsNew[0][i] = recordsOld[0][i-1];
					recordsNew[1][i] = recordsOld[1][i-1];
				}
				

				
			}
			
			
			try {
			FileWriter writer = new FileWriter("ESC/" + levelName + "leaderboard.txt");
			
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
