package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Timeline {
	private Hashtable<Integer, ArrayList<Integer>> hash;
	
	public Timeline(int pTotalTime) //Recibe en milisegundos
	{
		this.hash = new Hashtable<Integer, ArrayList<Integer>>();
		for (int i = 0; i <= pTotalTime; i++) {
			ArrayList<Integer> tempRoads = new ArrayList<Integer>(); 
			this.hash.put(i, tempRoads);
		}
	}
	
	public  Hashtable<Integer, ArrayList<Integer>> getHash()
	{
		return this.hash;
	}

}