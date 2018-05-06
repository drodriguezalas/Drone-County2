package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public abstract class Algorithm implements CONSTANTS{

	protected ArrayList<Trip> tripList;
	protected int totalTime;
	protected Hashtable<Integer, ArrayList<Trip>> simulatorTimeline;
	protected Hashtable<Integer, ArrayList<Integer>> idTimeline;
	protected Hashtable<Trip, ArrayList<Integer>> tripHash;
	
	public Algorithm(ArrayList<Trip> pTripList, int pTotalTime) {
		tripList = pTripList;
		totalTime = pTotalTime;
		idTimeline = createIdTimeline(pTotalTime);
		tripHash = new Hashtable<Trip, ArrayList<Integer>>();
	}
	
	public abstract void generateSimulatorTimeline();
	
	public ArrayList<Integer> calculateArrivalTime(Trip pTrip){
		ArrayList<Integer> timeList = new ArrayList<Integer>();
		ArrayList<Edge> roads = pTrip.getRoads();
		for (int edgeIndex = 0; edgeIndex <= roads.size(); edgeIndex ++) {
			int time = (6000 * roads.get(edgeIndex).getWeight()) / 120; 
			timeList.add(time);
		}
		timeList.set(0, timeList.get(0) + 2);
		return timeList;
	}
	
	public boolean checkTripTime(Trip pTrip, Integer pSlot) {
		if ((this.idTimeline.get(pSlot).contains(pTrip.getTravel().get(0).getId()))) {	
			return false;
		}else {
			for (int indexTripTime = 0; indexTripTime < pTrip.getTimeList().size(); indexTripTime++) {
				pSlot = pSlot + pTrip.getTimeList().get(indexTripTime);
				if (this.idTimeline.get(pSlot).contains(pTrip.getTravel().get(indexTripTime+1).getId())) {
					return false;
				}
			}
			insertTripOnIdTimeline(pTrip, pSlot);
			return true;
		}
	}
	
	public void insertTripOnIdTimeline(Trip pTrip, Integer pSlot) {
		this.idTimeline.get(pSlot).add(pTrip.getTravel().get(0).getId());
		for(int indexId = 0; indexId < pTrip.getTimeList().size(); indexId++) {
			pSlot = pSlot + pTrip.getTimeList().get(indexId);
			this.idTimeline.get(pSlot).add(pTrip.getTravel().get(indexId+1).getId());
		}
	}
	
	//Metodo que crea la linea de tiempo
	public Hashtable<Integer, ArrayList<Trip>> createHashTimeline(int pTotalTime) {
		Hashtable<Integer, ArrayList<Trip>> hash = new Hashtable<Integer, ArrayList<Trip>>();
		for (int i = 0; i < pTotalTime; i++) {
			ArrayList<Trip> array = new ArrayList<Trip>();
			hash.put(i, array);
		}
		return hash;
	}
	
	public Hashtable<Integer, ArrayList<Integer>> createIdTimeline(int pTotalTime){ //Recibe en milisegundos por ahora
		Hashtable<Integer, ArrayList<Integer>> hash = new Hashtable<Integer, ArrayList<Integer>>();
		for (int i = 0; i <= pTotalTime; i++) {
			ArrayList<Integer> tempRoads = new ArrayList<Integer>(); 
			hash.put(i, tempRoads);
		}
		return hash;
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

	public Hashtable<Integer, ArrayList<Trip>> getSimulatorTimeline() {
		return simulatorTimeline;
	}
	
	
}
