package application;

public class UserProfile {
	private String userName;
	private int levelAchieved;
	private Cell[][] levelWhenSaved;
	
	public UserProfile(String userName) {
		this.userName = userName;
		levelAchieved = 0;
		//or 1 depending on how we decide to do it
		levelWhenSaved = null;
	}
	
	public int getUserLevel() {
		return levelAchieved;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public Cell[][] getLevelWhenSaved() {
		return levelWhenSaved;
	}
	
	
	public void setUserLevel(int level) {
		levelAchieved = level;
	}
}
