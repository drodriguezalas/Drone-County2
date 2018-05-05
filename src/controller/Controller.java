package controller;

public class Controller {

	private static Controller controller;
	private static GraphGenerator graphGenerator;
	
	private Controller() {	
	}
	
	public static Controller getInstance() {
		if (controller == null) {
			controller = new Controller();
		}
		graphGenerator = new GraphGenerator(5); //Hay que ver de donde tomar la cantidad de estaciones
		return controller;
	}

	public static GraphGenerator getGraphGenerator() {
		return graphGenerator;
	}

	public static void setGraphGenerator(GraphGenerator graphGenerator) {
		Controller.graphGenerator = graphGenerator;
	}
	
	 
}
