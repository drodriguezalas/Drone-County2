package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class DivideConquer extends Algorithm{
	public ArrayList<ArrayList<Trip>> tripBlocks;

	public DivideConquer(ArrayList<Trip> pTripList, int pTotalTime)
	{
		super(pTripList, pTotalTime);
		this.tripBlocks = new ArrayList<>();
	}		
	
	private void divide() 
	{		
		for(Trip trip : this.tripList)
		{
			//MAKE BLOCKS HERE
		}
	}

	private void merge()
	{
		
	}

	private void conquer() 
	{				
		
	}		
	
	private void sortTrips()
	{
		//TODO
	}
	
	@Override
	public void generateTimeline() 
	{
		divide();
	}

	@Override
	public void calculateTripTiming() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args)
	{		
		
	}

}
