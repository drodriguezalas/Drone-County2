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
		{
			graph.addEdge(sinArcos.get(0), sinArcos.get(1), graph.calculate(sinArcos.get(0).getPosX(), 
			sinArcos.get(0).getPosY(), sinArcos.get(1).getPosX(), sinArcos.get(1).getPosY()));
			sinArcos.remove(0);
		}
		for(int indexVertexes = 0; indexVertexes < vertexes.size(); indexVertexes++ )
		{
			while (vertexes.get(indexVertexes).getCounterEdge() < pQuantity) {
				List<VertexDistance> listaDistances = graph.getDistances().get(vertexes.get(indexVertexes).getId());
				if (listaDistances.size() > 0) {
					if (listaDistances.get(0).getVertex().getCounterEdge() < pQuantity) 
					{
						graph.addEdge(vertexes.get(indexVertexes), listaDistances.get(0).getVertex(), listaDistances.get(0).getDistance());	
					} 
					else 
					{
						listaDistances.remove(0);
					}
				}
				else break;
			}
		}
	}

	public Graph getGraph() {
		return graph;
	}
		
}