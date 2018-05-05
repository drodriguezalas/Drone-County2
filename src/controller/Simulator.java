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
	Controller controller;

	public Simulator(Hashtable<Integer, ArrayList<Trip>> pTimeline, int pSlotTimmer) {
		this.timeLine = pTimeline;
		this.slotTimmer = pSlotTimmer;
		stationController = new StationController();
		stationController.generateStations(controller.getGraphGenerator().getGraph());
	}	
	
	public void executeTrips(List<Trip> pList) {
		if (!pList.isEmpty()) {
			for (int indexTrip = 0; indexTrip < pList.size(); indexTrip++) {
				this.stationController.actualizeStations(pList.get(indexTrip));
			}	
		}
	}
	
	public void run() {
		for (Integer indexTimeline = 1; indexTimeline < timeLine.size(); indexTimeline++) {
			try {
				if (!timeLine.get(indexTimeline).isEmpty()) {
					executeTrips(timeLine.get(indexTimeline));
					sleep(slotTimmer);
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public StationController getStationController() {
		return stationController;
	}
}
