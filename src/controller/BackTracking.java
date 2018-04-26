package controller;
/*
 * @autor Yelson
 */

import java.util.ArrayList;

import model.Trip;

public class BackTracking extends Algorithm {
	
	public BackTracking(ArrayList<Trip> pTripList, int pTotalTime) {
		super(pTripList, pTotalTime);
	}
	
	public void calculateTripTiming() {
		//Por cada milisegundo va a ir agregando al timeline
		//eventos de manera que coordine los viajes
		for (int milSec = 0; milSec <= totalTime; milSec++) {
			//En el momento en que un viaje sirva lo agrega
			//hacer funcion calcular cuando va a llegar a cierto lugar
		}
	}
}
