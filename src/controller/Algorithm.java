package controller;

import model.Trip;
import java.util.ArrayList;

public abstract class Algorithm {

	protected ArrayList<Trip> tripList;
	protected int totalTime;
	//Nose como guardar la linea del tiempo
	
	//Constructor
	public Algorithm(ArrayList<Trip> pTripList, int pTotalTime) {
		tripList = pTripList;
		totalTime = pTotalTime;
	}
	
	//Método que se crea en las clases hijo
	public abstract void calculateTripTiming();

	
	//-----------------------------Getters & Setters----------------------------------
	public ArrayList<Trip> getTripList() {
		return tripList;
	}

	public void setTripList(ArrayList<Trip> tripList) {
		this.tripList = tripList;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	
	
}
