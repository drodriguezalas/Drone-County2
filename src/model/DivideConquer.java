package model;

import java.util.ArrayList;
import java.util.Hashtable;

public class DivideConquer extends Algorithm{
	public static final int PULSE = 2;
	
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
			if(this.tripBlocks.isEmpty())
			{
				ArrayList<Trip> fistTripList = new ArrayList<>();
				fistTripList.add(trip);
				this.tripBlocks.add(tripList);
			}
			else
			{
				boolean tripFound = false;
				for(ArrayList<Trip> tripBlock : this.tripBlocks)
				{
					if(tripBlock.get(0).equals(trip))
					{
						tripFound = true;
						tripBlock.add(trip);
					}
				}
				if(!tripFound)
				{
					ArrayList<Trip> newTripList = new ArrayList<>();
					newTripList.add(trip);
					this.tripBlocks.add(newTripList);
				}
			}
		}
	}

	private void conquer(ArrayList<Trip> pBlock) 
	{				
		if(this.simulatorTimeline.isEmpty())
		{
			writeBlockAtTime(0, pBlock);
		}
		else
		{
			Integer newMoment = 0;
			for(Integer keyMoment : this.simulatorTimeline.keySet())
			{
				boolean collisionFound = false;
				for(Trip trip : this.simulatorTimeline.get(keyMoment))
				{
					if(checkCollision(trip, pBlock.get(0)))
					{
						collisionFound = true;
					}
				}
				if(!collisionFound)
				{
					writeBlockAtTime(keyMoment, pBlock);
					return;
				}
				newMoment = keyMoment + PULSE;
			}
			writeBlockAtTime(newMoment, pBlock);
		}
	}
	
	public boolean checkCollision(Trip pTrip1, Trip pTrip2)
	{
		for(Vertex vertex1 : pTrip1.getTravel())
		{
			for(Vertex vertex2 : pTrip2.getTravel())
			{
				if(vertex1.equals(vertex2))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public void writeBlockAtTime(Integer pStartTime, ArrayList<Trip> pTripBlock)
	{
		for(Trip trip : pTripBlock)
		{
			if(this.simulatorTimeline.containsKey(pStartTime))
			{
				ArrayList<Trip> value = this.simulatorTimeline.get(pStartTime);
				value.add(trip);
				pStartTime = pStartTime + PULSE;
			}
			else
			{
				ArrayList<Trip> value = new ArrayList<>();
				value.add(trip);
				this.simulatorTimeline.put(pStartTime, value);
				pStartTime = pStartTime + PULSE;
			}
		}
	}		
			
	@Override
	public void generateSimulatorTimeline(ArrayList<Trip> pTripList) {
		divide();
		for(ArrayList<Trip> tripBlock : this.tripBlocks)
		{
			this.conquer(tripBlock);
		}
	}

	@Override
	public Hashtable<Trip, ArrayList<Integer>> generateHashTiming(ArrayList<Trip> pTripList) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args)
	{
		
	}

}