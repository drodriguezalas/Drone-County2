package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Timeline {
	private HashMap<Integer, ArrayList<Trip>> hashmap;
	
	public Timeline(int pTotalTime) //Recibe en milisegundos
	{
		this.hashmap = new HashMap<>();
		for (int i = 0; i <= pTotalTime; i++) {
			ArrayList<Trip> tempRoads = new ArrayList<Trip>(); 
			this.hashmap.put(i, tempRoads);
		}
	}
	
	public  HashMap<Integer, ArrayList<Trip>> getHashmap()
	{
		return this.hashmap;
	}

}