//Eric Jaison 
//Netflix Backend
//Java
//Dr. Doderer
//Sept 28, 2022

//NetflixInShow

package netflixroster;

// Assigning variables  
public class NetflixShow {
	private String showWeek;
	private String showCategory;
	private int showweeklyRank; 	
	private String showTitles;	 		
	private String showseasonTitle;			
	private double showweeklyhoursViewed;		
	private int showcummulativeRanks;	

	//default constructor
	public NetflixShow() {
		showWeek = "";
		showCategory = "";
		showweeklyRank = 0;
		showTitles = ""; 
		showseasonTitle = "";
		showweeklyhoursViewed = 0;
		showcummulativeRanks = 0;

	}
	//constructor specifically for remove method
	public NetflixShow(String titles) {
		showWeek = "";
		showCategory = "";
		showweeklyRank = 0;
		showTitles = "titles"; 
		showseasonTitle = "";
		showweeklyhoursViewed = 0;
		showcummulativeRanks = 0;
	}
	//Constructor to read from file
	public NetflixShow(String name, String category, int rank, String titles, String seasontitle, double hourswatched, int totalranks) {
		showWeek = "name";
		showCategory = "category";
		showweeklyRank = rank;
		showTitles = "titles"; 
		showseasonTitle = "seasontitle";
		showweeklyhoursViewed = hourswatched;
		showcummulativeRanks = totalranks;
	}

	//starting getters and setters
	public String getShowWeek() {
		return showWeek;
	}
	public void setShowWeek(String showWeek) {
		this.showWeek = showWeek;
	}
	public String getShowCategory() {
		return showCategory;
	}
	public void setShowCategory(String showCategory) {
		this.showCategory = showCategory;
	}
	public int getShowweeklyRank() {
		return showweeklyRank;
	}
	public void setShowweeklyRank(int showweeklyRank) {
		this.showweeklyRank = showweeklyRank;
	}
	public String getShowTitles() {
		return showTitles;
	}
	public void setShowTitles(String showTitles) {
		this.showTitles = showTitles;
	}
	public String getShowseasonTitle() {
		return showseasonTitle;
	}
	public void setShowseasonTitle(String showseasonTitle) {
		this.showseasonTitle = showseasonTitle;
	}
	public double getShowweeklyhoursViewed() {
		return showweeklyhoursViewed;
	}
	public void setShowweeklyhoursViewed(double showweeklyhoursViewed) {
		this.showweeklyhoursViewed = showweeklyhoursViewed;
	}
	public int getShowcummulativeRanks() {
		return showcummulativeRanks;
	}
	public void setShowcummulativeRanks(int showcummulativeRanks) {
		this.showcummulativeRanks = showcummulativeRanks;
	}
	//ending getters and setters

	// return with a toString method
	public String toString() {

		String toReturn = "week: " + getShowWeek() + " category: " + getShowCategory() + " " + "weekly rank: " + 
				getShowweeklyRank() + " show titles " + getShowTitles() + " season title " + getShowseasonTitle() +
				" weekly hours viewed " + getShowweeklyhoursViewed() + " cumulative weeks in top 10 " + getShowcummulativeRanks();
		return toReturn;
	}

	//method to allow removeShow to remove a show
	public boolean equals(Object o) {
		return ((NetflixShow)o).getShowTitles() == this.showseasonTitle;
	}
	//return true or false if the show equals with the week
	public boolean equals (NetflixShow noy) {
		if (noy.showWeek.equals(showWeek) 
				&& noy.showTitles.equals(showTitles))
			return true;
		return false;
	}
	// compare the ranks if weekly rank is greater than cummulative rank 
	public int compareTo(NetflixShow gel) {
		if (showWeek.compareTo(gel.getShowWeek()) < 0){
			return -1;
		}
		if (showWeek.compareTo(gel.getShowWeek()) > 0){
			return 1;
		}
		if (showTitles.compareTo(gel.getShowTitles()) < 0){
			return -1;
		}
		if (showTitles.compareTo(gel.getShowTitles()) > 0){
			return 1;
		}		
		return 0;
	}

}
