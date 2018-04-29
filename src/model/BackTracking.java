package model;
/*
 * @autor Yelson
 */

import java.util.ArrayList;

public class BackTracking extends Algorithm {
	
	private Timeline arrivalTimeline;
	
	public BackTracking(ArrayList<Trip> pTripList, int pTotalTime) {
		super(pTripList, pTotalTime);
		this.arrivalTimeline = new Timeline(pTotalTime);
		
	}
	
	
	//Metodo que verifica si un viaje puede llegar en cierto momento
	public boolean verificateArrive(Trip pTrip, ArrayList<Integer> pArriveTimes) {
		for(int i = 0; i <= pArriveTimes.size(); i++) {
/*			if(arrivalTimeline.getHashmap().get(i)) { //hay que acceder al hashmap
*				
*/			}
		}
	}
	
	public void generateTimeline() {
		//Va a recorrer todos los eventos y los agruega dependiendo del tiempo
		while (!tripList.isEmpty()) {
			Trip tempTrip = tripList.get(0);
		}
	}	
}
