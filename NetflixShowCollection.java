//Eric Jaison 
//Netflix Backend
//Java
//Dr. Doderer
//Sept 28, 2022

//NetflixShowCollection

package netflixroster;


import java.io.BufferedReader;
import java.io.BufferedWriter;
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

	//adds show to the end of the arraylist
	public void addProduct(NetflixShow p) {
		netflixshow.add(p);
	}

	//takes in an ID as a parameter and removes the object from the collection
	public boolean removeProduct(int id) {
		return netflixshow.remove(new NetflixShow(id));

	}
}

