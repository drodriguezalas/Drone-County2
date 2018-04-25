package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import model.*;

public class DivideConquer {
	private Graph graph;
	private ArrayList<Vertex> estations;
	private ArrayList<Edge> lanes;
	private Timeline timeline;
	
	public DivideConquer()
	{
		estations = new ArrayList<>();
		lanes = new ArrayList<>();
		graph = new Graph(estations, lanes);
		timeline = new Timeline();
	}
	
	private void runSimulation1()
	{
		//6 vertexes, 1000 from 0 to 3, 1000 from 3 to 6
		//Prueba
		Vertex N0 = new Vertex(0,0,0);
        Vertex N1 = new Vertex(1,1,1);
        Vertex N2 = new Vertex(2,2,2);
        Vertex N3 = new Vertex(3,3,3);
        Vertex N4 = new Vertex(4,4,4);
        Vertex N5 = new Vertex(5,5,5);
        Vertex N6 = new Vertex(6,6,6);
        
        estations.add(N0);
        estations.add(N1);
        estations.add(N2);
        estations.add(N3);
        estations.add(N4);
        estations.add(N5);
        estations.add(N6);
        
        addLane(0, 6, 1);
        addLane(0, 1, 1);
        addLane(1, 0, 1);
        addLane(1, 2, 1);
        addLane(2, 1, 1);
        addLane(2, 3, 1);
        addLane(3, 2, 1);
        addLane(3, 4, 1);
        addLane(4, 3, 1);
        addLane(4, 5, 1);
        addLane(5, 4, 1);
        addLane(5, 6, 1);
        addLane(6, 5, 1);
        addLane(6, 1, 1);
        
        addPath(0, 3, 1000);
//        addPath(3, 6, 1000);
        
        ArrayList<LinkedList<Vertex>> allPaths = new ArrayList<>();
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        for(Vertex vertex : estations)
        {
        	if(!vertex.getDestinations().isEmpty() && !vertex.getGroups().isEmpty())
        	{
        		for(Vertex destination : vertex.getDestinations())
        		{
        			dijkstra.execute(vertex);
        			allPaths.add(dijkstra.getPath(destination));
        		}
        	}
        }   
        
        divide(allPaths, timeline);
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
		Timeline headTimeline = new Timeline();
		Timeline tailTimeline = new Timeline();
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
	
	public void conquer(ArrayList<LinkedList<Vertex>> pHead, ArrayList<LinkedList<Vertex>> pTail, Timeline pTimeline)
	{
		if(pTail == null)
		{
			LinkedList path = pHead.get(0);
			while(path.size() > 0)
			{
				Vertex vertex = (Vertex) path.removeFirst();
				if(!pTimeline.getHashmap().containsKey(0))
				{
					System.out.println("Prueba  " + vertex.getId());
				}
			}
		}
	}
	
	public void mergeTimeline(Timeline pHeadTimeline, Timeline pTailTimeline, Timeline pNewTimeline)
	{
		
	}
	
	private void addPath(int pSource, int pDestination, int pDrones)
	{
		Vertex source = getVertexById(pSource, estations);
		Vertex destination = getVertexById(pDestination, estations);
		source.addDestination(destination, pDrones);
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
	    
	    private void addLane(int source, int destination, int duration) {
	        Edge lane = new Edge(getVertexById(source, estations), getVertexById(destination, estations), duration );
	        lanes.add(lane);
	    }
	
	public static void main(String[] args)
	{
		DivideConquer simulation = new DivideConquer();
		simulation.runSimulation1();
		
		List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1,2));
		int middle = numbers.size()/2;
		List<Integer> head = numbers.subList(0, middle);
		List<Integer> tail = numbers.subList(middle, numbers.size());
		System.out.println(head);
		System.out.println(tail);
	}
}
