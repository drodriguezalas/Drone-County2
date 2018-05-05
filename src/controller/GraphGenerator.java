package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Edge;
import model.Graph;
import model.Vertex;
import model.VertexDistance;

public class GraphGenerator {
	private Graph graph;
    
	public GraphGenerator(int pStationsQuantity) {
		this.graph = new Graph();
		generatorVertex(pStationsQuantity);
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
	
	public void generatorVertex(int pQuantityVertex){
		Vertex newVertix;
		for (int indexVertex = 0; indexVertex < pQuantityVertex; indexVertex++) {
			newVertix = new Vertex(indexVertex, graph.getParesOrdenados().get(indexVertex*2), graph.getParesOrdenados().get(indexVertex*2+1));  // los parametros 2-3 son las posiciones de los pixeles
			graph.addVertex(newVertix);
		}
		for (int i = 0; i < graph.getVertexes().size(); i++) {
        	List<VertexDistance> listDistance = new ArrayList<>();
        	graph.insertDistance(graph.getVertexes().get(i).getId(), listDistance);
        }
	}
	
	public void generatorEdge1(int pQuantity) {
		List<Vertex> vertexes = this.graph.getVertexes();
		List<Vertex> sinArcos = new ArrayList<Vertex>();
		sinArcos.addAll(vertexes);
		Collections.shuffle(sinArcos);
		while (sinArcos.size() > 1 )
		//for(int indexVertexes = 0; indexVertexes < vertexes.size(); indexVertexes++ )
		{
			graph.addEdge(sinArcos.get(0), sinArcos.get(1), 0);
			sinArcos.remove(0);
			/*
			vertexes.remove(vertexes.get(indexVertexes));
			for (int countQuantity=0; countQuantity<pQuantity; countQuantity++) { 
				if (sinArcos.size()>0) {
					Collections.shuffle(sinArcos);
					graph.addEdge(vertexes.get(indexVertexes), sinArcos.get(0), 0);	
				} else {
					break;
				}
			}
			*/
		}	
		for(int indexVertexes = 0; indexVertexes < vertexes.size(); indexVertexes++ )
		{
			while (vertexes.get(indexVertexes).getCounterEdge() <= pQuantity) {
				//suponemos que la lista esta ordenada
				List<VertexDistance> listaDistances = graph.getDistances().get(vertexes.get(indexVertexes).getId());
				//int index = listaDistances.indexOf(Collections.min(listaDistances));
				if (listaDistances.get(0).getDistance() < pQuantity) 

				{
					graph.addEdge(vertexes.get(indexVertexes), listaDistances.get(0).getVertex(),0);
				} 
				else 
				{
					listaDistances.remove(0);
				}
			}
		}
		
	}

	public Graph getGraph() {
		return graph;
	}
		
}