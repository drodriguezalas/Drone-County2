package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class DivideConquer extends Algorithm{	

	public DivideConquer(ArrayList<Trip> pTripList, int pTotalTime)
	{
		super(pTripList, pTotalTime);
	}		
	
	private void divide(ArrayList<Trip> pTripList, Timeline pTimeline) 
	{		
		if(pTripList.size() == 1) //Size == 1 case
		{
			//conquer(pTripList, null, pTimeline);
		}
		int middle = pTripList.size() / 2;
		ArrayList<Trip> head = new ArrayList<Trip>(pTripList.subList(0, middle));
		ArrayList<Trip> tail = new ArrayList<Trip>(pTripList.subList(middle, pTripList.size()));
		Timeline headTimeline = new Timeline(this.totalTime);
		Timeline tailTimeline = new Timeline(this.totalTime);
		if(pTripList.size() > 2) //Size > 2 case
		{
			divide(head, headTimeline);
			divide(tail, tailTimeline);
		}
		else if(pTripList.size() == 2) //Size ==2 case
		{
			conquer(head, tail, pTimeline);
		}
	}

	private void conquer(ArrayList<Trip> pHead, ArrayList<Trip> pTail, Timeline pTimeline)
	{
		if(pTail == null)
		{
			writeToTimeLine(pHead.get(0), pTimeline);
		}
	}

	private void writeToTimeLine(Trip pTrip, Timeline pTimeline) 
	{		
		pTrip.calculateArrivalTime();
	}

	private void mergeTimeline(Timeline pHeadTimeline, Timeline pTailTimeline, Timeline pNewTimeline)
	{

	}	
	
	private void sortTrips()
	{
		//TODO
	}
	
	@Override
	public void generateTimeline() 
	{
		divide(this.tripList, this.timeline);
	}

	public static void main(String[] args)
	{		
		List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1,2));
		int middle = numbers.size()/2;
		List<Integer> head = numbers.subList(0, middle);
		List<Integer> tail = numbers.subList(middle, numbers.size());
		System.out.println(head);
		System.out.println(tail);
	}
}
