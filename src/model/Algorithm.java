package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public abstract class Algorithm implements CONSTANTS{

	protected ArrayList<Trip> tripList;
	protected int totalTime;
	protected Timeline timeline;
	
	//Constructor
	public Algorithm(ArrayList<Trip> pTripList, int pTotalTime) {
		tripList = pTripList;
		totalTime = pTotalTime;
		timeline = new Timeline(pTotalTime);
	}
	
	//Método que se crea en las clases hijo
	public abstract void generateTimeline();
	
	public ArrayList<Integer> calculateArrivalTime(Trip pTrip){
		ArrayList<Integer> timeList = new ArrayList<Integer>();
		ArrayList<Edge> roads = pTrip.getRoads();
		
		for (int edgeIndex = 0; edgeIndex <= roads.size(); edgeIndex ++) {
			//Regla de tres para calcular el tiempo desde un nodo a otro
			//Lo calculo en mSec por ahora
			int time = (6000 * roads.get(edgeIndex).getWeight()) / 120; 
			timeList.add(time);
		}
		
		//Añade lo que dura subiendo al primer viaje
		//ya que solo este necesita subir
		timeList.set(0, timeList.get(0) + 2); //1.5 ----> 2
		return timeList;
	}
	
	public void generateHashTiming(ArrayList<Trip> pTripList) {
		Hashtable<Trip, ArrayList<Integer>> hash = new Hashtable<Trip, ArrayList<Integer>>();
		for (int indexTrip = 0; indexTrip < pTripList.size(); indexTrip++) {
			for(int startTime = 1; startTime < timeline.getHashmap().size(); startTime++){
				if (checkTripTime()) {
					if (hash.containsKey(pTripList)){
						hash.get(pTripList.get(indexTrip)).add(startTime);
					}else {
						ArrayList<Integer> timeList = new ArrayList<>();
						timeList.add(startTime);
						hash.put(pTripList.get(indexTrip), timeList);
					}
				}
			}
		}
		//
	}
	
	public boolean checkTripTime() {
		return true; 
	}
	
	//-----------------------------Getters & Setters----------------------------------
	public ArrayList<Trip> getTripList() {
		return tripList;
	}

	public void setTripList(ArrayList<Trip> pTripList) {
		this.tripList = pTripList;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int pTotalTime) {
		this.totalTime = pTotalTime;
	}
	
	
}
