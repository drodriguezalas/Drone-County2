package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public abstract class Algorithm {

	protected ArrayList<Trip> tripList;
	protected int totalTime;
	protected Timeline timeline;
	
	//Constructor
	public Algorithm(ArrayList<Trip> pTripList, int pTotalTime) {
		tripList = pTripList;
		totalTime = pTotalTime;
		timeline = new Timeline();
	}
	
	//Método que se crea en las clases hijo
	public abstract void calculateTripTiming();
	public abstract void generateTimeline();

	
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