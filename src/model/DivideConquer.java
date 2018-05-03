package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import model.*;

public class DivideConquer extends Algorithm{

	public DivideConquer(ArrayList<Trip> pTripList, int pTotalTime)
	{
		super(pTripList, pTotalTime);		
	}

	private void divide(ArrayList<LinkedList<Vertex>> pPaths, Timeline pTimeline)
	{

	}

	public void conquer(ArrayList<LinkedList<Vertex>> pHead, ArrayList<LinkedList<Vertex>> pTail, Timeline pTimeline)
	{

	}

	public void mergeTimeline(Timeline pHeadTimeline, Timeline pTailTimeline, Timeline pNewTimeline)
	{

	}
		
	@Override
	public void generateTimeline() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args)
	{
		
	}
}
