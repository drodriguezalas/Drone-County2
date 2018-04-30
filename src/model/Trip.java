package model;

import java.util.ArrayList;

public class Trip {
	private ArrayList<Vertex> travel;
	private ArrayList<Edge> roads;
	private int droneQuantity;
	
	//Constructor
	public Trip(ArrayList<Vertex> pTravel, ArrayList<Edge> pRoads, int pDrones) {
		travel = pTravel;
		roads = pRoads;
		droneQuantity = pDrones;
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
	
	
}
