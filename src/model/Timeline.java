package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Timeline {
	private HashMap<Integer, ArrayList<Trip>> hashmap;
	
	public Timeline()
	{
		this.hashmap = new HashMap<>();
	}
	
	public  HashMap<Integer, ArrayList<Trip>> getHashmap()
	{
		return this.hashmap;
	}

}
