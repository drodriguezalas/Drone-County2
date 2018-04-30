package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Timeline {
	private Hashtable<Integer, ArrayList<Trip>> hash;
	
	public Timeline(int pTotalTime) //Recibe en milisegundos
	{
		this.hash = new Hashtable<Integer, ArrayList<Trip>>();
		for (int i = 0; i <= pTotalTime; i++) {
			ArrayList<Trip> tempRoads = new ArrayList<Trip>(); 
			this.hash.put(i, tempRoads);
		}
	}
	
	public  Hashtable<Integer, ArrayList<Trip>> getHash()
	{
		return this.hash;
	}

}