package model;

import java.util.ArrayList;
import java.util.Hashtable;

public class DivideConquer extends Algorithm{
	//
	public static final int PULSE = 2;

	public ArrayList<ArrayList<Trip>> tripBlocks;

	public DivideConquer(ArrayList<Trip> pTripList, int pTotalTime)
	{
		super(pTripList, pTotalTime);
		this.tripBlocks = new ArrayList<>();
	}		

	@Override
	public void generateSimulatorTimeline() {
		divide();
		for(ArrayList<Trip> tripBlock : this.tripBlocks)
		{
			this.conquer(tripBlock);
		}
	}
	
	private void divide() 
	{		
		for(Trip trip : this.tripList)
		{
			if(this.tripBlocks.isEmpty())
			{
				newBlock(trip);
			}
			else
			{				
				if(lookForTripBlock(trip))
				{
					newBlock(trip);
				}
			}
		}
	}		

	public boolean lookForTripBlock(Trip pTrip)
	{
		for(ArrayList<Trip> tripBlock : this.tripBlocks)
		{
			if(tripBlock.get(0).equals(pTrip))
			{				
				tripBlock.add(pTrip);
				return true;
			}
		}
		return false;
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
	
	public void newBlock(Trip pTrip)
	{
		ArrayList<Trip> newTripList = new ArrayList<>();
		newTripList.add(pTrip);
		this.tripBlocks.add(tripList);
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

}