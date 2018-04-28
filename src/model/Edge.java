package model;

/**
 *
 * @author Dani
 */
public class Edge {
    private Vertex source;
    private Vertex destination;
    private int weight;

    public Edge(Vertex pSource, Vertex pDestination, int pWeight) {
        this.source = pSource;
        this.destination = pDestination;
        this.weight = pWeight;
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
