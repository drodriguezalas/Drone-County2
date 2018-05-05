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
	private StationController stationController;
	
	public Simulator(Hashtable<Integer, ArrayList<Trip>> pTimeline, int pSlotTimmer) {
		this.timeLine = pTimeline;
		this.slotTimmer = pSlotTimmer;
	}
	
	public void run() {
		for (int indexTimeline = 1; indexTimeline < timeLine.size(); indexTimeline++) {
			try {
				System.out.println("Tiene " + timeLine.get(indexTimeline).size() + " viajes");
				if (timeLine.get(indexTimeline) != null) {
					executeTrips(timeLine.get(indexTimeline));
					sleep(slotTimmer);
				}
			}catch (Exception e){
				
			}
		}
	}
	
	public void executeTrips(ArrayList<Trip> pList) {
		for (int indexTrip = 0; indexTrip < pList.size(); indexTrip++) {
			this.stationController.actualizeStations(pList.get(indexTrip));
		}
	}
	
	
}
