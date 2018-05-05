package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import model.*;

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
	public void generateSimulatorTimeline(ArrayList<Trip> pTripList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hashtable<Trip, ArrayList<Integer>> generateHashTiming(ArrayList<Trip> pTripList) {
		// TODO Auto-generated method stub
		return null;
	}

}