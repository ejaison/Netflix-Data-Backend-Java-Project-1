//Eric Jaison 
//Netflix Backend
//Java
//Dr. Doderer
//Sept 28, 2022

//NetflixShowCollection

package netflixroster;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;


public class NetflixShowCollection {
	private ArrayList<NetflixShow> netflixshow;
	private Iterator<NetflixShow> iter;
	private String fileName;

	public Iterator<NetflixShow> getIterator () {
		return netflixshow.iterator();
	}

	//default
	public NetflixShowCollection() {
		netflixshow = new ArrayList<NetflixShow>();
		fileName = null;
	}

	public NetflixShowCollection(String fn) {
		netflixshow = new ArrayList<NetflixShow>();
		fileName = fn;
		readFile();
	}
	//returns the private member fileName
	public String get_fileName() {return fileName;}

	//adds show to the end of the list
	public void addNetflixShow(NetflixShow s) {
		netflixshow.add(s);
	}

	//takes in an titles as a parameter and removes the object from the collection
	public boolean removeNetflixShow(String titles) {
		return netflixshow.remove(new NetflixShow(titles));
	}

	//takes in an show titles as a parameter and returns the object
	public NetflixShow retrieveNetflixShow(String titles) {
		iter = netflixshow.iterator();
		while (iter.hasNext()) {
			NetflixShow s = iter.next();
			if (s.getShowTitles() == titles) {
				return s;
			}
		}
		return null;
	}

	public ArrayList<NetflixShow> retrieveCollection(String titles) {
		//collection is used to store similar products based off of the parameter of show titles
		ArrayList<NetflixShow> collection = new ArrayList<NetflixShow>();
		iter = netflixshow.iterator();
		while (iter.hasNext()) {
			NetflixShow s = iter.next();
			//next line checks if the show title is the same as the parameter
			if (s.getShowTitles().equals(titles)) {
				collection.add(s);
			}
		}
		return collection;
	}

	//takes in an titles as a parameter
	public void showUpdate(String titles, double hourswatched) {
		iter = netflixshow.iterator();
		while (iter.hasNext()) {
			NetflixShow s = iter.next();
			if (s.getShowTitles().equals (titles)) {
				if (s.getShowweeklyhoursViewed() >= hourswatched) {
				}
				else {
					System.out.println("Not able to update the show");

				}
			}
		}
	}

	public ArrayList<NetflixShow>netflixShowSuggestion(String category) {
		//collection is used to store similar shows that are same week based of the parameter of category
		ArrayList<NetflixShow> collection = new ArrayList<NetflixShow>();
		iter = netflixshow.iterator();
		while (iter.hasNext()) {
			NetflixShow s = iter.next();
			//checks equivalence of name and category to the parameter of name
			if (s.getShowCategory().contains(category) || s.getShowWeek().contains(category)) {
				collection.add(s);
			}
		}
		return collection;
	}

	public ArrayList<String> getCatagories () {
		//collection is used to store add types of Categories
		ArrayList<String> collection = new ArrayList<String>();
		iter = netflixshow.iterator();
		while (iter.hasNext()) {
			NetflixShow s = iter.next();
			//checks equivalence of name and category to the parameter of name
			if (!collection.contains(s.getShowCategory())) {
				collection.add(s.getShowCategory());
			}
		}
		return collection;		
	}
	//method to read from file
	protected void readFile() {

		BufferedReader lineReader = null;
		try {
			FileReader fr = new FileReader(fileName);
			lineReader = new BufferedReader(fr);
			String line = null;
			while ((line = lineReader.readLine()) != null) {
				String[] tokens = line.split(",");
				addNetflixShow(new NetflixShow(tokens[0], (tokens[1]), Integer.parseInt(tokens[2]), 
						(tokens[3]), (tokens[4]), Double.parseDouble(tokens[6]), Integer.parseInt(tokens[7]));
			}
							//finding any error
		}
		catch (Exception e) {
			System.err.println("there was a problem with the first file reader, try different read type.");
			e.printStackTrace();
			try {
				lineReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(fileName.substring(1))));
				String line = null;
				while ((line = lineReader.readLine()) != null) {
					String[] tokens = line.split(",");

					addNetflixShow(new NetflixShow(tokens[0], (tokens[1]), Integer.parseInt(tokens[2]), 
							(tokens[3]), (tokens[4]), Double.parseDouble(tokens[6]), Integer.parseInt(tokens[7]));

				}
								//finding any error
			}		
			catch (Exception e2) {
				System.err.println("there was a problem with the second file reader, try again.  either no such file or format error");
				e2.printStackTrace();
			} finally {
				if (lineReader != null)
					try {
						lineReader.close();
					} catch (IOException e2) {
						System.err.println("could not close BufferedReader");
					}
			}			
		} finally {
			if (lineReader != null)
				try {
					lineReader.close();
				} catch (IOException e) {
					System.err.println("could not close BufferedReader");
				}
		}
	}

	//method to write contents of shows to a file
	protected void writeFile(String fn) {
		try {
			FileWriter fw = new FileWriter(fn);
			BufferedWriter myOutfile = new BufferedWriter(fw);

			iter = netflixshow.iterator();
			while (iter.hasNext()) {
				NetflixShow s = iter.next();
				//starts to write contents of show to a file
				myOutfile.write(s.getShowWeek()+",");
				myOutfile.write(s.getShowCategory()+",");
				myOutfile.write(s.getShowweeklyRank()+","); 
				myOutfile.write(s.getShowTitles()+",");
				myOutfile.write(s.getShowseasonTitle()+",");
				myOutfile.write(s.getShowweeklyhoursViewed()+",");
				myOutfile.write(s.getShowcummulativeRanks()+"\n");
			}
			myOutfile.flush();
			myOutfile.close();		
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Didn't save to " + fn);
		}
	}
// to string method
	public String toString() {
		String toReturn = "";
		for (int i = 0; i < netflixshow.size(); i++) {
			toReturn += netflixshow.get(i).toString() + "\n";
		}
		return toReturn;
	}

}
