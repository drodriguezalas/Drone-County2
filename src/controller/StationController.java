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
