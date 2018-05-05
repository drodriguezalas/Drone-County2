package controller;

import java.util.*;

import model.CONSTANTS;
import model.DijkstraAlgorithm;
import model.Edge;
import model.Trip;
import model.Vertex;


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
		while(tripQuantity >= droneQuantityPerTrip) {
			List<Vertex> vertexes = Controller.getGraphGenerator().getGraph().getVertexes(); 
			Collections.shuffle(vertexes);
			Vertex source = vertexes.get(0);
			Vertex destination = vertexes.get(1);
			//Llamar al Dijkstra y generar el viaje
			//Para añadir ese viaje a la lista
		}
		//tripList = ....;
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

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public ArrayList<Vertex> convertToArrayList(LinkedList pList){
		ArrayList<Vertex> vertexes = new ArrayList<>(pList);
		return vertexes;
	}
	
}
