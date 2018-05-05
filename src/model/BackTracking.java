package model;
/*
 * @autor Yelson
 */

import java.util.ArrayList;
import java.util.Hashtable;

public class BackTracking extends Algorithm {
	
	public BackTracking(ArrayList<Trip> pTripList, int pTotalTime) {
		super(pTripList, pTotalTime);		
	}
	
	public void generateSimulatorTimeline(ArrayList<Trip> pTripList) {
		Hashtable<Integer, ArrayList<Trip>> finalTimeline = createHashTimeline(this.totalTime);
		Hashtable<Trip, ArrayList<Integer>> tripHash = generateHashTiming(pTripList);
		for (int indexTrip = 0; indexTrip < this.totalTime; indexTrip++){
			Trip actualTrip = pTripList.get(indexTrip); 
			int slot;
			slot = tripHash.get(actualTrip).get(0);
			finalTimeline.get(slot).add(actualTrip);
		}
		this.simulatorTimeline = finalTimeline;
	}
	
	public Hashtable<Trip, ArrayList<Integer>> generateHashTiming(ArrayList<Trip> pTripList) {
		Hashtable<Trip, ArrayList<Integer>> hash = new Hashtable<Trip, ArrayList<Integer>>();
		for (int indexTrip = 0; indexTrip < pTripList.size(); indexTrip++){
			Trip actualTrip = pTripList.get(indexTrip);
			for(int startTime = 1; startTime < idTimeline.size(); startTime++){
				if (checkTripTime(actualTrip, idTimeline, startTime)){
					if (hash.containsKey(actualTrip)){
						hash.get(actualTrip).add(startTime);
					}else {
						ArrayList<Integer> timeList = new ArrayList<>();
						timeList.add(startTime);
						hash.put(actualTrip, timeList);
					}
				}
			}
		}
		return hash;
	}

}
