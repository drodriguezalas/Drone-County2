package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public abstract class Algorithm implements CONSTANTS{

	protected ArrayList<Trip> tripList;
	protected int totalTime;
	protected Hashtable<Integer, ArrayList<Trip>> simulatorTimeline;
	protected Hashtable<Integer, ArrayList<Integer>> idTimeline;
	protected Hashtable<Trip, ArrayList<Integer>> tripHash;
	
	//Constructor
	public Algorithm(ArrayList<Trip> pTripList, int pTotalTime) {
		tripList = pTripList;
		totalTime = pTotalTime;
		idTimeline = createIdTimeline(pTotalTime);
		tripHash = new Hashtable<Trip, ArrayList<Integer>>();
	}
	
	//Método que retorna la linea del tiempo con sus respctivos viajes
	//Es el metodo que requiere el simulador para comenzar a correr
	public abstract void generateSimulatorTimeline();
	
	//Metodo que genera un hash para la escogencia de slots
	//Cada algoritmo lo impolementa a su manera
	public abstract Hashtable<Trip, ArrayList<Integer>> generateHashTiming(ArrayList<Trip> pTripList);
	
	//Metodo que calcula el tiempo de llegada de los viajes 
	public ArrayList<Integer> calculateArrivalTime(Trip pTrip){
		ArrayList<Integer> timeList = new ArrayList<Integer>();
		ArrayList<Edge> roads = pTrip.getRoads();
		for (int edgeIndex = 0; edgeIndex <= roads.size(); edgeIndex ++) {
			//Regla de tres para calcular el tiempo desde un nodo a otro
			int time = (6000 * roads.get(edgeIndex).getWeight()) / 120; //Lo calculo en min por ahora
			timeList.add(time);
		}
		//Añade lo que dura subiendo al primer viaje
		//ya que solo este necesita subir
		//Calcular la funcion f(x) respecto al volumen
		timeList.set(0, timeList.get(0) + 2); //1.5 ----> 2
		return timeList;
	}
	
	//Metodo que verifica si un viaje puede salir en determinado slot
	//Retorna false si no puede hacerlo
	//True si puede hacerlo
	public boolean checkTripTime(Trip pTrip, Hashtable<Integer, ArrayList<Integer>> pIdTimeline, Integer pSlot) {
		if (!(pIdTimeline.get(pSlot).contains(pTrip.getTravel().get(0).getId()))) {	
			for (int indexTripTime = 0; indexTripTime < pTrip.getTimeList().size(); indexTripTime++) {
				pSlot = pSlot + pTrip.getTimeList().get(indexTripTime);
				if (pIdTimeline.get(pSlot).contains(pTrip.getTravel().get(indexTripTime).getId())) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	//Metodo que crea la linea de tiempo
	public Hashtable<Integer, ArrayList<Trip>> createHashTimeline(int pTotalTime) {
		Hashtable<Integer, ArrayList<Trip>> hash = new Hashtable<Integer, ArrayList<Trip>>();
		for (int i = 0; i < pTotalTime; i++) {
			ArrayList<Trip> array = new ArrayList<Trip>();
			hash.put(i, array);
		}
		return hash;
	}
	
	//Metodo que crea una linea de tiempo adaptada de enteros
	//Guarda (Slot, ID de los vertices)
	public Hashtable<Integer, ArrayList<Integer>> createIdTimeline(int pTotalTime){ //Recibe en milisegundos por ahora
		Hashtable<Integer, ArrayList<Integer>> hash = new Hashtable<Integer, ArrayList<Integer>>();
		for (int i = 0; i <= pTotalTime; i++) {
			ArrayList<Integer> tempRoads = new ArrayList<Integer>(); 
			hash.put(i, tempRoads);
		}
		return hash;
	}
	
	//-----------------------------Getters & Setters----------------------------------
	public ArrayList<Trip> getTripList() {
		return tripList;
	}

	public void setTripList(ArrayList<Trip> pTripList) {
		this.tripList = pTripList;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int pTotalTime) {
		this.totalTime = pTotalTime;
	}

	public Hashtable<Integer, ArrayList<Trip>> getSimulatorTimeline() {
		return simulatorTimeline;
	}
	
	
}
