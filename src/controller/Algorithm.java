package controller;

import model.Trip;
import java.util.ArrayList;
import model.Timeline;

public abstract class Algorithm {

	protected ArrayList<Trip> tripList;
	protected int totalTime;
	protected Timeline timeline;

	
	//Constructor
	public Algorithm(ArrayList<Trip> pTripList, int pTotalTime) {
		tripList = pTripList;
		totalTime = pTotalTime;
		//2 dura subiendo por ejemplo
		//Debe guardarse en una interface de constantes constante
		timeline = new Timeline(pTotalTime, 2);
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
