package controller;

import java.util.ArrayList;
import model.Trip;
import model.Edge;


public class Probabilist extends Algorithm{
	
	public Probabilist(ArrayList<Trip> pTripList, int pTotalTime) {
		super(pTripList, pTotalTime);
		
	}
	
	public void calculateTripTiming() {
		ArrayList<Integer> arrivalTime;
		while (tripList.size() > 0 ) {
			if (tripList.get(1).getDroneQuantity() > 0) { // 0 = widthTrack
				arrivalTime = calculateArrivalTime(tripList.get(1));
				generateTimeTravel(tripList.get(1), arrivalTime);
				//tripList.get(1).getDroneQuantity() - widthTrack
			}
		}
	}
	
	public ArrayList<Integer> calculateArrivalTime(Trip trip){
		ArrayList<Integer> timeList = new ArrayList<Integer>();
		ArrayList<Edge> roads = trip.getRoads();
		for (int edgeIndex = 0; edgeIndex <= roads.size(); edgeIndex ++) {
			//Regla de tres para calcular el tiempo desde un nodo a otro
			int time = (6000 * roads.get(edgeIndex).getWeight()) / 120; //Lo calculo en min por ahora
			timeList.add(time);
		}
		//A�ade lo que dura subiendo al primer viaje
		//ya que solo este necesita subir
		timeList.set(0, timeList.get(0) + 2); //1.5 ----> 2
		return timeList;
	}
	
	public void generateTimeTravel(Trip trip, ArrayList<Integer> time) {
		int startTime = (int)Math.floor(Math.random()*(1)+(tripList.size())); //restarle la suma total del viaje 
		if (checkTimeTravel(trip, time, startTime)) {
			
		}
		else {
			generateTimeTravel(trip, time);
		}
	}
	
	public boolean checkTimeTravel(Trip trip, ArrayList<Integer> time, int num) {
		
		for (int indexTrip = 0; indexTrip < trip.getTravel().size(); indexTrip++){
			// if timeList.get(num) 
			return false;
		}
		return true;
	}
	
	public void generateTimeline() {
		//Por cada milisegundo va a ir agregando al timeline
		//eventos de manera que coordine los viajes
		for (int milSec = 0; milSec <= totalTime; milSec++) {
			//En el momento en que un viaje sirva lo agrega
			//hacer funcion calcular cuando va a llegar a cierto lugar
		}		
	}
}
