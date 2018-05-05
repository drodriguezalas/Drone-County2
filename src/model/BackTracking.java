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
	
	public void generateSimulatorTimeline() {
		Hashtable<Integer, ArrayList<Trip>> finalTimeline = createHashTimeline(this.totalTime);
		System.out.println("Cantidad Viajes: " + this.tripList.size());
		for (int indexTrip = 0; indexTrip < this.tripList.size(); indexTrip++){
			Trip actualTrip = this.tripList.get(indexTrip);
			for (Integer startTime = 1; startTime < finalTimeline.size(); startTime++) {
				if (checkTripTime(actualTrip, startTime)) {
					finalTimeline.get(startTime).add(actualTrip);
					break;
				}
			}
//			int slot;
//			slot = tripHash.get(actualTrip).get(0);
//			tripHash.get(actualTrip).remove(0);
//			finalTimeline.get(slot).add(actualTrip);
			
		}
		this.simulatorTimeline = finalTimeline;
	}
/*
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
*/
	public void imprimir() {
		Hashtable<Integer, ArrayList<Trip>> l = this.simulatorTimeline;
		System.out.println("Timeline:");
		for (Integer i = 0; i<l.size(); i++) {
			System.out.print(i+"-");
			for (int k = 0; k < l.get(i).size(); k++) {
				l.get(i).get(k).printRoad();
			}
			System.out.println("");
		}
	}

}
