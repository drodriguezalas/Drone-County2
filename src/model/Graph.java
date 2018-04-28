package model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Dani
 */
public class Graph {
    private final List<Vertex> vertexes;
    private final List<Edge> edges;
    private Hashtable<Integer, List<Integer>> distances;
    
    public Graph(List<Vertex> vertexes, List<Edge> edges) {
        this.vertexes = vertexes;
        this.edges = edges;
        this.distances = new Hashtable<Integer, List<Integer>>();
        for (int quantityVertexes = 0; quantityVertexes < vertexes.size(); quantityVertexes++) {
        	List<Integer> listDistance = new ArrayList<>();
        	insertDistance(vertexes.get(quantityVertexes).getId(), listDistance);
        }
    }
    
    public void insertDistance(int vertex, List<Integer> listDistance) {
    	distances.put(vertex, listDistance);
    }
    	
    public Hashtable<Integer, List<Integer>> getDistances(){
    	return distances;
    }
    
    public void calculateDistante() {
    	for (int i = 0; i < vertexes.size(); i++) {
    		for (int j = i; j < vertexes.size(); j++) {
				if (i == j) {
					this.distances.get(vertexes.get(i).getId()).add(Integer.MAX_VALUE);
				}
				else{
					int distance = calcular(vertexes.get(i).getPosX(), vertexes.get(i).getPosY(), vertexes.get(j).getPosX(), vertexes.get(j).getPosY());
					this.distances.get(vertexes.get(i).getId()).add(distance);
					this.distances.get(vertexes.get(j).getId()).add(distance);
				}
    		}
    	}
    }
    
    public void addSentinelValue(int key, int index) {
    	this.distances.get(key).set(index, Integer.MAX_VALUE);
    }

    public int calcular(int posX1, int posY1, int posX2, int posY2) {
    	int posX = posX1-posX2;
    	int posY = posY1-posY2;
    	double distance = Math.sqrt(posX*posX + posY*posY);
    	return (int)distance;
    }
    
    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public List<Edge> getEdges() {
        return edges;
    }
    
    public int getQuantityEdge(int num) {
    	return vertexes.get(num).getCounterEdge();
    }
}

