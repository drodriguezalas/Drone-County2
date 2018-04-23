package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Timeline {
	private HashMap<Integer, ArrayList<Vertex>> hashmap;
	
	public Timeline()
	{
		this.hashmap = new HashMap<>();
	}
	
	public  HashMap<Integer, ArrayList<Vertex>> getHashmap()
	{
		return this.hashmap;
	}

}
