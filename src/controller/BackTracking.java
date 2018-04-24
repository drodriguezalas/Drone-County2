package controller;
/*
 * @autor Yelson
 */

import java.util.ArrayList;

import model.Trip;
import model.Edge;

public class BackTracking extends Algorithm {
	
	public BackTracking(ArrayList<Trip> pTripList, int pTotalTime) {
		super(pTripList, pTotalTime);
	}
	
	
	
	public ArrayList<Integer> calculateArrivalTime(Trip trip){
		ArrayList<Integer> timeList = new ArrayList<Integer>();
		ArrayList<Edge> roads = trip.getRoads();
		
		for (int edgeIndex = 0; edgeIndex <= roads.size(); edgeIndex ++) {
			//Regla de tres para calcular el tiempo desde un nodo a otro
			//Lo calculo en min por ahora
			int time = (60 * roads.get(edgeIndex).getWeight()) / 120; 
			timeList.add(time);
		}
		
		//Añade lo que dura subiendo al primer viaje
		//ya que solo este necesita subir
		timeList.set(0, timeList.get(0) + 2); //1.5 ----> 2
		return timeList;
	}
	public void calculateTripTiming() {
		
	}
	
	public void generateTimeline() {
		//Va a recorrer todos los eventos y los agruega dependiendo del tiempo
		while (!tripList.isEmpty()) {
			
		}
	}
	
}
