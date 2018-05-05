package controller;

import java.util.*;

import model.Station;
import model.Graph;
import model.Vertex;
import model.Trip;

public class StationController {
	
	private ArrayList<Station> stations;
	
	public StationController() {
		stations = new ArrayList<>();
	}
	
	public void generateStations(Graph pGraph) {
		List<Vertex> graphVertexes = pGraph.getVertexes();
		for (int indexVertex = 0; indexVertex < graphVertexes.size(); indexVertex++) {
			Station newStation = new Station(graphVertexes.get(indexVertex).getId());
			stations.add(newStation);
		}
	}
	
	public void actualizeStations(Trip pTrip) {
		Station origin = searchStation(pTrip.getTravel().get(0).getId());
		Station destination = searchStation(pTrip.getTravel().get(pTrip.getTravel().size()-1).getId());
		origin.acutalizeSendQuantity(pTrip.getDroneQuantity());
		origin.acutalizeArriveQuantity(pTrip.getDroneQuantity());
		System.out.println("-------------------------------------------------------------");
		System.out.println("Estación: " + origin.getId() + " ha enviado " + pTrip.getDroneQuantity() + " drones");
		System.out.println("Total Enviados: " + origin.getSendQuantity() );
		System.out.println("Total Recibidos: " + origin.getArriveQuantity());
		System.out.println("");
		System.out.println("Estación: " + destination.getId() + " ha recibido " + pTrip.getDroneQuantity() + " drones");
		System.out.println("Total Enviados: " + destination.getSendQuantity() );
		System.out.println("Total Recibidos: " + destination.getArriveQuantity());
		System.out.println("-------------------------------------------------------------");
	}
	
	public Station searchStation(int pId) {
		for (int indexStation = 0; indexStation < this.stations.size(); indexStation++) {
			if (this.stations.get(indexStation).getId() == pId) {
				return this.stations.get(indexStation);
			}
		}
		return null;
	}
}
