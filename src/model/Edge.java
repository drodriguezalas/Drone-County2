package model;

/**
 *
 * @author Dani
 */
public class Edge {
    private Vertex source;
    private Vertex destination;
    private int weight;

    public Edge(Vertex source, Vertex destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex getDestination() {
        return destination;
    }

    public Vertex getSource() {
        return source;
    }
    public int getWeight() {
        return weight;
    }
    
    public void setWeight(int pWeight) 
    {
    	this.weight = pWeight;
    }

    @Override
    public String toString() {
        return source + " " + destination;
    }
}
