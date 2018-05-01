package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Dani
 */
public class Graph {
    private List<Vertex> vertexes;
    private List<Edge> edges;
    private Hashtable<Integer, List<VertexDistance>> distances;
    private ArrayList<Integer> paresOrdenados = new ArrayList<Integer>();
    
    
    public Graph(List<Vertex> pVertexes, List<Edge> pEdges) {
        this.vertexes = pVertexes;
        this.edges = pEdges;
        this.distances = new Hashtable<Integer, List<VertexDistance>>();
        for (int quantityVertexes = 0; quantityVertexes < pVertexes.size(); quantityVertexes++) {
        	List<VertexDistance> listDistance = new ArrayList<>();
        	insertDistance(pVertexes.get(quantityVertexes).getId(), listDistance);
        }
       // Collections.addAll(paresOrdenados, 1,2,4,1,5,8,15,7,15,16,);
    }
    
    public Graph() {
        this.vertexes = new ArrayList<Vertex>();
        this.edges = new ArrayList<Edge>();
        this.distances = new Hashtable<Integer, List<VertexDistance>>();    	
    }
    
    public void insertDistance(int pVertex, List<VertexDistance> pListDistance) {
    	distances.put(pVertex, pListDistance);
    }
    	
    public Hashtable<Integer, List<VertexDistance>> getDistances(){
    	return distances;
    }
    
    public void calculateDistante() {
    	VertexDistance vertexDistance;
    	for (int i = 0; i < vertexes.size(); i++) {
    		for (int j = i; j < vertexes.size(); j++) {
				if (i == j) {
					vertexDistance = new VertexDistance(vertexes.get(i), Integer.MAX_VALUE);
					this.distances.get(vertexes.get(i).getId()).add(vertexDistance);
				}
				else{
					int distance = calcular(vertexes.get(i).getPosX(), vertexes.get(i).getPosY(), vertexes.get(j).getPosX(), vertexes.get(j).getPosY());
					vertexDistance = new VertexDistance(vertexes.get(j), distance);
					this.distances.get(vertexes.get(i).getId()).add(vertexDistance);
					vertexDistance = new VertexDistance(vertexes.get(i), distance);
					this.distances.get(vertexes.get(j).getId()).add(vertexDistance);
				}
    		}
    	}
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
    
    public void addVertex(Vertex pVertex)
    {
    	this.vertexes.add(pVertex);
    }
    
    public void addEdge(Vertex pSource, Vertex pDestiny, int pWeigth)
    {
    	boolean exists = false;
    	for(int indexEdges=0; indexEdges<edges.size(); indexEdges++) {
    		if (edges.get(indexEdges).getSource()==pSource && edges.get(indexEdges).getDestination()==pDestiny) {
    			exists = true;
    			break;
    		}
    	}
    	if (!exists) {
	    	edges.add(new Edge(pSource, pDestiny, pWeigth));
	    	edges.add(new Edge(pDestiny, pSource, pWeigth));
	    	pSource.incrementCounterEdge();
	    	pDestiny.incrementCounterEdge();
    	}
    }
    
}

