package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Timeline {
	private HashMap<Integer, ArrayList<Trip>> hashmap;
	
	public Timeline(int totalTime, int tripTime)
	{
		this.hashmap = new HashMap<>();
		for (int i = 0; i <= totalTime; i+= tripTime) {
			//Hacerle un add al hash
		}
	}
	
	public  HashMap<Integer, ArrayList<Trip>> getHashmap()
	{
		return this.hashmap;
	}

}
