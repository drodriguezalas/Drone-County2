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
		return hash:
	}

}
