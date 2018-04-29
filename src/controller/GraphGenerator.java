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
	
	
	public void generatorVertex(int quantityVertex){
		Vertex newVertix;
		for (int indexVertex = 0; indexVertex < quantityVertex; indexVertex++) {
			newVertix = new Vertex(indexVertex, indexVertex, indexVertex);  // los parametros 2-3 son las posiciones de los pixeles
			graph.addVertex(newVertix);
		}
	}
	
	public void generatorEdge1(int quantity) {
		Edge lane;
		List<Vertex> vertexes = this.graph.getVertexes();
		List<Vertex> sinArcos = new ArrayList<Vertex>();
		sinArcos.addAll(vertexes);
		
		for(int indexVertexes = 0; indexVertexes < vertexes.size(); indexVertexes++ )
		{
			vertexes.remove(vertexes.get(indexVertexes));
			for (int countQuantity=0; countQuantity<quantity; countQuantity++) { 
				if (sinArcos.size()>0) {
					Collections.shuffle(sinArcos);
					graph.addEdge(vertexes.get(indexVertexes), sinArcos.get(0), 0);	
				} else {
					break;
				}
			}
		}	
		for(int indexVertexes = 0; indexVertexes < vertexes.size(); indexVertexes++ )
		{
			int countEdges = vertexes.get(indexVertexes).getCounterEdge();
			for (; countEdges<=quantity; countEdges++) {
				List<VertexDistance> listaDistances = graph.getDistances().get(vertexes.get(indexVertexes).getId());
				//int index = listaDistances.indexOf(Collections.min(listaDistances));
				if (vertexes.get(index).getCounterEdge()<quantity) 
				{
					graph.addEdge(vertexes.get(indexVertexes), vertexes.get(countEdges),0);
				} 
				else 
				{
					//graph.addSentinelValue(vertexes.get(indexVertexes).getId(), index);
					//graph.addSentinelValue(index, vertexes.get(indexVertexes).getId());					
				}
			}
		}
		
	}

	public Graph getGraph() {
		return graph;
	}
		
}