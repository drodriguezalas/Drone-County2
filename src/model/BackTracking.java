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
