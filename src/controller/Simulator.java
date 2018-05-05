package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import model.Trip;
import model.Edge;
import model.Graph;
import model.Vertex;
import model.VertexDistance;

public class Simulator extends Thread{
	
	private Hashtable<Integer, ArrayList<Trip>> timeLine;
	private int slotTimmer;
	
	public Simulator(Hashtable<Integer, ArrayList<Trip>> pTimeline, int pSlotTimmer) {
		this.timeLine = pTimeline;
		this.slotTimmer = pSlotTimmer;
	}
	
	public void run() {
		for (int indexTimeline = 1; indexTimeline < timeLine.size(); indexTimeline++) {
			executeTrips(timeLine.get(indexTimeline));
			sleep(slotTimmer);
		}
	}
	
	public void executeTrips(ArrayList<Trip> pList) {
		
	}
	
}
