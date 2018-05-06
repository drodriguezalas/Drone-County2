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
			int time = (6000 * roads.get(edgeIndex).getWeight()) / 120; 
			timeList.add(time);
		}
		timeList.set(0, timeList.get(0) + 2);
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o == this)
		{
			return true;
		}
		if(!(o instanceof Trip))
		{
			return false;
		}
		
		Trip trip = (Trip) o;
		if(trip.travel.size() != this.travel.size())
		{
			return false;
		}
		for(int vertexIndex = 0; vertexIndex < this.travel.size(); vertexIndex++)
		{
			if(this.travel.get(vertexIndex).getId() != trip.travel.get(vertexIndex).getId())
			{
				return false;
			}
		}
		
		return true;		
	}
	
	//Imprimir el recorrido
	public void printRoad() {
		System.out.print("[");
		System.out.print(this.travel.get(0).getId());
		for (int i = 1; i < this.travel.size(); i++) {
			System.out.print("-");
			System.out.print(this.travel.get(i).getId());
		}
		System.out.print("]");
	}
	
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