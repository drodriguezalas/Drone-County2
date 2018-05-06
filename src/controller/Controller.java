package controller;

import java.util.ArrayList;
import model.BackTracking;
import model.Station;


public class Controller {

	private static Controller controller;
	private static GraphGenerator graphGenerator;
	private static TripsGenerator tripsGenerator;
	private static StationController stationController; 
	
	private Controller() {	
	}
	
	public static Controller getInstance() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	public static void startSimulator() {
    
    	tripsGenerator = new TripsGenerator();
    	
    
    	tripsGenerator.generateTrips(100, 100, 2500);
    	for (int i=0 ; i < tripsGenerator.getTripList().size(); i++) {
    		System.out.print("Viaje " + (i+1) + ": ");
    		for (int j = 0;  j < tripsGenerator.getTripList().get(i).getTravel().size(); j++) {
    			System.out.print(tripsGenerator.getTripList().get(i).getTravel().get(j).getId() + " , " );
    		}
    		System.out.println();
    	}
    	
    	BackTracking backTracking = new BackTracking( tripsGenerator.getTripList(), 500);
    	
    	backTracking.generateSimulatorTimeline();
    	backTracking.imprimir();
    	
    	 Thread simulator = new Simulator(backTracking.getSimulatorTimeline(),2000);
    	 
    	 simulator.start();
    
	}

	public static void createGraphGenerator(int pStationsQuantity) {
		graphGenerator = new GraphGenerator(pStationsQuantity);
	}
	
	public static GraphGenerator getGraphGenerator() {
		return graphGenerator;
	}

	public static void setGraphGenerator(GraphGenerator graphGenerator) {
		Controller.graphGenerator = graphGenerator;
	}
	
	 
}
