package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Edge;
import model.Graph;
import model.Vertex;

public class GraphGenerator {
	private Graph graph;
    //private final List<Vertex> nodes;
    //private final List<Edge> edges;
	
	public GraphGenerator(int pStationsQuantity) {
		//this.nodes = new ArrayList<Vertex>();
        //this.edges = new ArrayList<Edge>();
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
	
	/*
	public void generatorEdge(int quantity){// las lineas 36,37,42,43 las meti para hacer el grafo bidireccional
		Edge lane;
		List<Vertex> vertexes = this.graph.getVertexes();
		Collections.shuffle(vertexes);
		for(int indexEdge = 0; indexEdge < graph.getVertexes().size(); indexEdge++ ) {
			int weigth = (int)Math.floor(Math.random()*(50)+50);
			lane = new Edge(vertexes.get(indexEdge), vertexes.get(indexEdge+1), weigth);
			this.edges.add(lane);
			lane = new Edge(vertexes.get(indexEdge+1), vertexes.get(indexEdge), weigth);
			this.edges.add(lane);
			graph.addSentinelValue(vertexes.get(indexEdge).getId(), indexEdge+1);
			graph.addSentinelValue(indexEdge+1, vertexes.get(indexEdge).getId());
		}
		generatorEdge1(quantity-2);
	}
	*/
	
	// Hay que probrar este codigo
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
				List<Integer> listaDistances = graph.getDistances().get(vertexes.get(indexVertexes).getId());
				int index = listaDistances.indexOf(Collections.min(listaDistances));
				if (vertexes.get(index).getCounterEdge()<quantity) 
				{
					graph.addEdge(vertexes.get(indexVertexes), vertexes.get(countEdges),0);
				} 
				else 
				{
					graph.addSentinelValue(vertexes.get(indexVertexes).getId(), index);
					graph.addSentinelValue(index, vertexes.get(indexVertexes).getId());					
				}
			}
		}
		
	}

	public Graph getGraph() {
		return graph;
	}

	public List<Vertex> getNodes() {
		return nodes;
	}

	public List<Edge> getEdges() {
		return edges;
	}
	
	
}