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
    }
    
    public ArrayList<Integer> getParesOrdenados() {
		return paresOrdenados;
	}

	public Graph() {
        this.vertexes = new ArrayList<Vertex>();
        this.edges = new ArrayList<Edge>();
        this.distances = new Hashtable<Integer, List<VertexDistance>>();    	
        Collections.addAll(paresOrdenados, 67,47,34,37,83,66,81,34,93,37,81,56,51,97,94,89,87,59,24,87,11,47,66,93,79,56,98,42,67,72,75,21,25,28,64,84,29,65,74,19,23,69,72,24,91,72,56,28,59,98,21,77,37,53,58,54,18,12,43,86,11,91,25,23,28,97,46,38,12,88,56,59,55,94,18,23,43,55,16,64,48,74,53,16,12,93,91,36);
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
				if (i != j) {
					int distance = calculate(vertexes.get(i).getPosX(), vertexes.get(i).getPosY(), vertexes.get(j).getPosX(), vertexes.get(j).getPosY());
					vertexDistance = new VertexDistance(vertexes.get(j), distance);
					this.distances.get(vertexes.get(i).getId()).add(vertexDistance);
					vertexDistance = new VertexDistance(vertexes.get(i), distance);
					this.distances.get(vertexes.get(j).getId()).add(vertexDistance);
				}
    		}
    		mergeSort(distances.get(vertexes.get(i).getId()));
    	}
    }
    
    public int calculate(int posX1, int posY1, int posX2, int posY2) {
    	int posX = posX1-posX2;
    	int posY = posY1-posY2;
    	double distance = Math.sqrt(posX*posX + posY*posY);
    	return (int)distance;
    }
    
	public ArrayList<Edge> findEdgesForVertexList(ArrayList<Vertex> pVertexes){
		ArrayList<Edge> edgesList = new ArrayList<>();
		for (int indexVertex = 0; indexVertex < pVertexes.size()-1; indexVertex++) {
			Vertex origin = pVertexes.get(indexVertex);
			Vertex destination = pVertexes.get(indexVertex + 1);
			Edge edge = searchEdge(origin, destination);
			edgesList.add(edge);
		}
		return edgesList;
	}
	
	public Edge searchEdge(Vertex pOrigin, Vertex pDestination) {
		Edge edge;
		List<Edge> edgesList = this.edges;
		for (int indexEdge = 0; indexEdge < edgesList.size(); indexEdge++) {
			if(pOrigin == edgesList.get(indexEdge).getSource() && pDestination == edgesList.get(indexEdge).getDestination()) {
				edge = edgesList.get(indexEdge);
				return edge;
			}
			else {			
			}
		}
		return null;
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
    			distances.get(pSource.getId()).remove(0);
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
    
    public void mergeSort(final List<VertexDistance> pList) {
		if (pList.size() != 1) {
			final List<VertexDistance> left = new ArrayList<VertexDistance>();
            final List<VertexDistance> right = new ArrayList<VertexDistance>();
            boolean logicalSwitch = true;
            while (!pList.isEmpty()) {
                if (logicalSwitch) {
                    left.add(pList.remove(0));
                } else {
                    right.add(pList.remove(0));
                }
                logicalSwitch = !logicalSwitch;
            }
            mergeSort(left);
            mergeSort(right);
            pList.addAll(merge(left, right));
        }
	}
	
	private List<VertexDistance> merge(final List<VertexDistance> pLeft, final List<VertexDistance> pRight) {
        final List<VertexDistance> merged = new ArrayList<>();
        while (!pLeft.isEmpty() && !pRight.isEmpty()) {
            if (pLeft.get(0).getDistance().compareTo(pRight.get(0).getDistance()) <= 0) {
                merged.add(pLeft.remove(0));
            } else {
                merged.add(pRight.remove(0));
            }
        }
        merged.addAll(pLeft);
        merged.addAll(pRight);
        return merged;
    }

}

