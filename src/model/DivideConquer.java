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

	private void divide(ArrayList<LinkedList<Vertex>> pPaths, Timeline pTimeline)
	{
		if(pPaths.size() == 1)
		{
			conquer(pPaths, null, pTimeline);
			return;
		}
		int middle = pPaths.size() / 2;
		ArrayList<LinkedList<Vertex>> head = new ArrayList<LinkedList<Vertex>>(pPaths.subList(0, middle));
		ArrayList<LinkedList<Vertex>> tail= new ArrayList<LinkedList<Vertex>>(pPaths.subList(middle, pPaths.size()));
		Timeline headTimeline = new Timeline(this.totalTime);
		Timeline tailTimeline = new Timeline(this.totalTime);
		if(pPaths.size() > 2)
		{			
			divide(head, headTimeline);
			divide(tail, tailTimeline);
			mergeTimeline(headTimeline, tailTimeline, pTimeline);
		}
		else if(pPaths.size() == 2)
		{
			conquer(head, tail, pTimeline);
		}
	}
	
	private void divide0() {
		// TODO Auto-generated method stub
		
	}

	private void conquer(ArrayList<LinkedList<Vertex>> pHead, ArrayList<LinkedList<Vertex>> pTail, Timeline pTimeline)
	{
		
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
		divide0();
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
