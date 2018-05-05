package controller;

import model.BackTracking;

public class Controller {

	private static Controller controller;
	private static GraphGenerator graphGenerator;
	private static TripsGenerator tripsGenerator;
	
	private Controller() {	
	}
	
	public static Controller getInstance() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	public static void startSimulator() {
		
		/* Aqui imprime los vertices 
		for (int i=0 ; i < graphGenerator.getGraph().getVertexes().size(); i++) {
    		String cadena = String.valueOf(graphGenerator.getGraph().getVertexes().get(i).getPosX());
    		String cadena1 = String.valueOf(graphGenerator.getGraph().getVertexes().get(i).getPosY());
    		System.out.println(cadena + ',' + cadena1);
    	}
		*/
    	graphGenerator.getGraph().calculateDistante();
    
    	/*
    	for (int i = 0;  i < graphGenerator.getGraph().getDistances().size(); i++) {
    		graphGenerator.mergeSort(graphGenerator.getGraph().getDistances().get(i));
    	}
    	*/
    	
    	/*
    	for (int i = 0;  i < graphGenerator.getGraph().getDistances().size(); i++) {
    		for (int j = 0;  j < graphGenerator.getGraph().getDistances().get(i).size(); j++) {
    			String cadena = String.valueOf(graphGenerator.getGraph().getDistances().get(i).get(j).getDistance());
    			System.out.print(cadena + "  ");
    	    }
    		System.out.println();
    	}
    	*/
   		
    	graphGenerator.generatorEdge1(3);
    	
    	/* Aqui imprime los arcos
    	for (int i=0 ; i < graphGenerator.getGraph().getEdges().size(); i+=2) {
    		String cadena = String.valueOf(graphGenerator.getGraph().getEdges().get(i).getSource().getId());
    		String cadena1 = String.valueOf(graphGenerator.getGraph().getEdges().get(i).getDestination().getId());
    		System.out.println(cadena + ',' + cadena1);
    	}
    	*/
    
    	tripsGenerator = new TripsGenerator();
    	
    
    	tripsGenerator.generateTrips(5, 5, 250);
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
    	/*
    	for (int i=0 ; i < backTracking.getSimulatorTimeline().size(); i++) {
    		
    		//for (int j = 0;  j < tripsGenerator.getTripList().get(i).getTravel().size(); j++) {
    			//System.out.print(tripsGenerator.getTripList().get(i).getTravel().get(j).getId() + " , " );
    		//}
    		System.out.println( backTracking.getSimulatorTimeline().get(i).size() );
    	}
    	*/
    
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
