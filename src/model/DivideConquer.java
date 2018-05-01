package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import model.*;

public class DivideConquer extends Algorithm {
	private Graph graph;
	private ArrayList<Vertex> estations;
	private ArrayList<Edge> lanes;
	private Timeline timeline;
	
	public DivideConquer(ArrayList<Trip> pTripList, int pTotalTime)
	{
		super(pTripList, pTotalTime);
		estations = new ArrayList<>();
		lanes = new ArrayList<>();
		graph = new Graph(estations, lanes);
		timeline = new Timeline(pTotalTime);
	}		
	
	private void divide(ArrayList<LinkedList<Vertex>> pPaths, Timeline pTimeline)
	{
//		if(pPaths.size() == 1)
//		{
//			conquer(pPaths, null, pTimeline);
//			return;
//		}
//		int middle = pPaths.size() / 2;
//		ArrayList<LinkedList<Vertex>> head = new ArrayList<LinkedList<Vertex>>(pPaths.subList(0, middle));
//		ArrayList<LinkedList<Vertex>> tail= new ArrayList<LinkedList<Vertex>>(pPaths.subList(middle, pPaths.size()));
//		Timeline headTimeline = new Timeline();
//		Timeline tailTimeline = new Timeline();
//		if(pPaths.size() > 2)
//		{			
//			divide(head, headTimeline);
//			divide(tail, tailTimeline);
//			mergeTimeline(headTimeline, tailTimeline, pTimeline);
//		}
//		else if(pPaths.size() == 2)
//		{
//			conquer(head, tail, pTimeline);
//		}
	}
	
	public void conquer(ArrayList<LinkedList<Vertex>> pHead, ArrayList<LinkedList<Vertex>> pTail, Timeline pTimeline)
	{
		
	}
	
	public int getWeight(Vertex pSource, Vertex pDestination)
	{
		for(Edge edge : lanes)
		{
			if(edge.getSource().equals(pSource) && edge.getDestination().equals(pDestination))
			{
				return edge.getWeight();
			}
		}
		return 0;
	}
	
	public void mergeTimeline(Timeline pHeadTimeline, Timeline pTailTimeline, Timeline pNewTimeline)
	{
		
	}		
	
	 private Vertex getVertexById(int pId, List<Vertex> pVertices)
	    {
	        for(Vertex vertex : pVertices)
	        {
	            if(vertex.getId() == pId)
	            {
	                return vertex;
	            }
	        }
	        return null;
	    }
	    
	 private void addLane(int source, int destination, int duration) 
	 {
		 Edge lane = new Edge(getVertexById(source, estations), getVertexById(destination, estations), duration );
	     lanes.add(lane);
	 }
		
	
	public static void main(String[] args)
	{
		
	}

	@Override
	public void generateTimeline() {
		// TODO Auto-generated method stub
		
	}
}
