//Eric Jaison 
//Netflix Backend
//Java
//Dr. Doderer
//Sept 28, 2022

//Netflix Main/Tester

package netflixroster;

import java.util.ArrayList;
import java.util.Iterator;

public class NetflixMain {

	public static void main(String[] args) {

		NetflixShow netflixshow1 = new NetflixShow();
		NetflixShow netflixshow2 = new NetflixShow("2022-09-04", "Films (English)", 1, "Me Time", "N/A", 56560000, 2);
		NetflixShow netflixshow3 = new NetflixShow("2022-09-04", "Films (English)", 2, "Love in the Villa", "N/A", 41220000 , 1);
		NetflixShow netflixshow4 = new NetflixShow("2022-09-04", "Films (English)", 3, "I Came By", "N/A", 30790000, 1);		
		//testing toString methods of Product.java
		System.out.println(netflixshow1.toString());
		System.out.println(netflixshow2.toString());
		//all good here

		//testing various getters and setters
		netflixshow1.setShowWeek("2022-09-04");
		System.out.println(netflixshow1.getShowWeek());
		netflixshow1.setShowCategory("Films (Non-English)");
		System.out.println(netflixshow1.getShowCategory());
		netflixshow1.setShowweeklyRank(2);
		System.out.println(netflixshow1.getShowTitles());

		//testing addShow method
		System.out.println("adding extra shows");
		NetflixShowCollection collection = new NetflixShowCollection();
		collection.addNetflixShow(netflixshow1);
		collection.addNetflixShow(netflixshow2);
		collection.addNetflixShow(netflixshow3);
		collection.addNetflixShow(netflixshow4);
		System.out.println(collection.toString());
		//all good here

		//testing retrieveShow method
		System.out.println("retrieving");
		System.out.println(collection.retrieveNetflixShow("Me Time"));
		//working

		//testing removeShow method
		System.out.println("removing");
		collection.removeNetflixShow("Me Time");
		System.out.println(collection.toString());
		//all good

		//testing retrieveCollection method
		netflixshow1.setShowTitles("I Love You");
		System.out.println("retrieving collection");
		System.out.println(collection.retrieveCollection("I Love You"));
		//logic error

		//testing showUpdate method
		System.out.println("updating viewers");
		collection.showUpdate("Me Time", 76560000);
		System.out.println(collection.toString());
		//all good

		//testing apply new ranks method
		System.out.println("applying new ranks");
		netflixshow1.setShowcummulativeRanks(3);
		System.out.println(collection.applyRanks(3));
		//works

		//testing showSuggestion
		System.out.println("suggesting a show");
		System.out.println(collection.netflixShowSuggestion("I Came By"));

		//testing the writeFile method
		NetflixShowCollection testRead_File = new NetflixShowCollection("./pointOfSale/data.txt");
		//testRead_File.writeFile(testRead_File.get_fileName());

		// testing the iterator
		System.out.println("\ntesting iterator");
		Iterator<NetflixShow> iter = testRead_File.getIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();

		// testing getCatagories
		System.out.println("\ntesting and getting all the list from the document");
		ArrayList<String> read = testRead_File.getCatagories();
		System.out.println(read);

		testRead_File.writeFile("./pointOfSale/testwrite.txt");
	}

}
