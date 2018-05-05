package controller;

import java.util.*;
import model.DijkstraAlgorithm;
import model.CONSTANTS;
import model.Trip;
import model.Vertex;
import model.Edge;


public class TripsGenerator implements CONSTANTS{
	
	private ArrayList<Trip> tripList;
	private Controller controller;
	
	public TripsGenerator() {
		tripList = new ArrayList<Trip>();
		controller = Controller.getInstance();
	}
	
	public void generateTrips(int pRoadWidth, int pRoadHigh, int pTripQuantity ) {
		int droneQuantityX = pRoadWidth / DRONE_WIDTH;
		int droneQuantityY = pRoadHigh  / DRONE_HIGH;
		int droneQuantityPerTrip = droneQuantityX * droneQuantityY;
		
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(controller.getGraphGenerator().getGraph());
		
		while(pTripQuantity >= droneQuantityPerTrip) {
			generateTrips_aux(droneQuantityPerTrip, dijkstra);
			pTripQuantity -= droneQuantityPerTrip;
		}
		if (pTripQuantity > 0) {
			generateTrips_aux(pTripQuantity, dijkstra);
		}
	}
	
	public void generateTrips_aux(int pDroneQuantityPerTrip, DijkstraAlgorithm pDijkstra) {
		List<Vertex> vertexes = controller.getGraphGenerator().getGraph().getVertexes(); 
		Collections.shuffle(vertexes);
		Vertex source = vertexes.get(0);
		Vertex destination = vertexes.get(1);
		
		ArrayList<Vertex> tripVertexes= convertToArrayList(pDijkstra.calculateRoad(source, destination));
		ArrayList<Edge> tripEdges = controller.getGraphGenerator().getGraph().findEdgesForVertexList(tripVertexes);
		Trip trip = new Trip(tripVertexes, tripEdges, pDroneQuantityPerTrip);
		this.tripList.add(trip);
	}
	
	public ArrayList<Trip> getTripList() {
		return tripList;
	}

	public void setTripList(ArrayList<Trip> tripList) {
		this.tripList = tripList;
	}

	public ArrayList<Vertex> convertToArrayList(LinkedList pList){
		ArrayList<Vertex> vertexes = new ArrayList<>(pList);
		return vertexes;
	}
	
}
