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
	
	public void generateTrips(int roadWidth, int roadHigh, int tripQuantity ) {
		int droneQuantityX = roadWidth / DRONE_WIDTH;
		int droneQuantityY = roadHigh  / DRONE_HIGH;
		int droneQuantityPerTrip = droneQuantityX * droneQuantityY;
		
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(controller.getGraphGenerator().getGraph());
		
		while(tripQuantity >= droneQuantityPerTrip) {
			List<Vertex> vertexes = controller.getGraphGenerator().getGraph().getVertexes(); 
			Collections.shuffle(vertexes);
			Vertex source = vertexes.get(0);
			Vertex destination = vertexes.get(1);
			
			ArrayList<Vertex> tripVertexes= convertToArrayList(dijkstra.calculateRoad(source, destination));
			ArrayList<Edge> tripEdges = controller.getGraphGenerator().getGraph().findEdgesForVertexList(tripVertexes);
			Trip trip = new Trip(tripVertexes, tripEdges, droneQuantityPerTrip);
			this.tripList.add(trip);
			
			tripQuantity -= droneQuantityPerTrip;
		}
		if (tripQuantity < 0) {
			
		}
	}
	
	public ArrayList<Vertex> convertToArrayList(LinkedList pList){
		ArrayList<Vertex> vertexes = new ArrayList<>(pList);
		return vertexes;
	}
	
}
