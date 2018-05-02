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
	
	
	//Metodo que verifica si un viaje puede llegar en cierto momento
	public boolean verificateArrive(Trip pTrip, ArrayList<Integer> pArriveTimes) {
		for(int i = 0; i <= pArriveTimes.size(); i++) {
/*			if(arrivalTimeline.getHashmap().get(i)) { //hay que acceder al hashmap
*				
*/			}
		return false;
	}
	
	public void generateTimeline() {
		//Va a recorrer todos los eventos y los agruega dependiendo del tiempo
		while (!tripList.isEmpty()) {
			Trip tempTrip = tripList.get(0);
		}
	}
	
	public void generateHashTiming(ArrayList<Trip> pTripList) {
		Hashtable<Trip, ArrayList<Integer>> hash = new Hashtable<Trip, ArrayList<Integer>>();
		for (int indexTrip = 0; indexTrip < pTripList.size(); indexTrip++){
			Trip actualTrip = pTripList.get(indexTrip);
				for(int startTime = 1; startTime < timeline.getHash().size(); startTime++){
				if (checkTripTime(actualTrip, timeline, startTime)){
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
}
