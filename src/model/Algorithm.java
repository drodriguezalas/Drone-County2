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
	
	public void generateHashTiming(ArrayList<Trip> pTripList) {
		Hashtable<Trip, ArrayList<Integer>> hash = new Hashtable<Trip, ArrayList<Integer>>();
		for(int startTime = 1; startTime < timeline.getHash().size(); startTime++){
			for (int indexTrip = 0; indexTrip < pTripList.size(); indexTrip++) {
				if (checkTripTime(pTripList.get(indexTrip), timeline, startTime)) {
					if (hash.containsKey(pTripList.get(indexTrip))){
						hash.get(pTripList.get(indexTrip)).add(startTime);
					}else {
						ArrayList<Integer> timeList = new ArrayList<>();
						timeList.add(startTime);
						hash.put(pTripList.get(indexTrip), timeList);
					}
				}
			}
		}
	}
	
	//Metodo que verifica si un viaje puede salir en determinado slot
	//Retorna false si no puede hacerlo
	//True si puede hacerlo
	public boolean checkTripTime(Trip pTrip, Timeline pTimeline, Integer pSlot) {
		if (!(pTimeline.getHash().get(pSlot).contains(pTrip.getTravel().get(0).getId()))) {	
			for (int indexTripTime = 0; indexTripTime < pTrip.getTimeList().size(); indexTripTime++) {
				pSlot = pSlot + pTrip.getTimeList().get(indexTripTime);
				if (pTimeline.getHash().get(pSlot).contains(pTrip.getTravel().get(indexTripTime).getId())) {
					return false;
				}
			}
			return true;
		}
		return false;
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
