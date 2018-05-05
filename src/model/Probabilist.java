package model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

import model.Trip;
import model.Edge;


public class Probabilist extends Algorithm{
	
	public Probabilist(ArrayList<Trip> pTripList, int pTotalTime) {
		super(pTripList, pTotalTime);
	}
	
	public void generateSimulatorTimeline() {
		Hashtable<Integer, ArrayList<Trip>> finalTimeline = createHashTimeline(this.totalTime);
		Hashtable<Trip, ArrayList<Integer>> tripHash = generateHashTiming(this.tripList);
		for (int indexTrip = 0; indexTrip < this.totalTime; indexTrip++) {
			Trip actualTrip = this.tripList.get(indexTrip); 
			int slot;
			Collections.shuffle(tripHash.get(actualTrip));
			slot = tripHash.get(actualTrip).get(0);
			finalTimeline.get(slot).add(actualTrip);
		}
		this.simulatorTimeline = finalTimeline;
	}
	
	public Hashtable<Trip, ArrayList<Integer>> generateHashTiming(ArrayList<Trip> pTripList) {
		Hashtable<Trip, ArrayList<Integer>> hash = new Hashtable<Trip, ArrayList<Integer>>();
		for(int startTime = 1; startTime < idTimeline.size(); startTime++){
			for (int indexTrip = 0; indexTrip < pTripList.size(); indexTrip++) {
				if (checkTripTime(pTripList.get(indexTrip), idTimeline, startTime)) {
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
		return hash;
	}
}
