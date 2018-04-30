package model;

import java.util.ArrayList;

public class Trip {
	private ArrayList<Vertex> travel;
	private ArrayList<Edge> roads;
	private int droneQuantity;
	private ArrayList<Integer> timeList;
	
	//Constructor
	public Trip(ArrayList<Vertex> pTravel, ArrayList<Edge> pRoads, int pDrones) {
		travel = pTravel;
		roads = pRoads;
		droneQuantity = pDrones;
		timeList = new ArrayList<Integer>();
		
	}
	
	public void calculateArrivalTime(){
		for (int edgeIndex = 0; edgeIndex <= roads.size(); edgeIndex ++) {
			//Regla de tres para calcular el tiempo desde un nodo a otro
			//Lo calculo en mSec por ahora
			int time = (6000 * roads.get(edgeIndex).getWeight()) / 120; 
			timeList.add(time);
		}
		//Añade lo que dura subiendo al primer viaje
		//ya que solo este necesita subir
		timeList.set(0, timeList.get(0) + 2); //1.5 ----> 2
	}
	//-----------------------------Getters & Setters----------------------------------
	
	public ArrayList<Vertex> getTravel() {
		return travel;
	}

	public void setTravel(ArrayList<Vertex> pTravel) {
		this.travel = pTravel;
	}

	public ArrayList<Edge> getRoads() {
		return roads;
	}

	public void setRoads(ArrayList<Edge> pRoads) {
		this.roads = pRoads;
	}

	public int getDroneQuantity() {
		return droneQuantity;
	}

	public void setDroneQuantity(int pDroneQuantity) {
		this.droneQuantity = pDroneQuantity;
	}
	
	public ArrayList<Integer> getTimeList(){
		return timeList;
	}
}
