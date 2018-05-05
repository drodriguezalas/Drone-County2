package controller;

import java.util.*;

import model.CONSTANTS;
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
}
