package controller;

public class main {
	
	public static void main(String[] args)
    {
		Controller controller = Controller.getInstance();
		controller.createGraphGenerator(10);
		controller.startSimulator();
    }
}
