package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphGenerator {
	private Graph graph;
    private final List<Vertex> nodes;
    private final List<Edge> edges;
	
	public GraphGenerator() {
		this.nodes = new ArrayList<Vertex>();
        this.edges = new ArrayList<Edge>();
		this.graph = new Graph(nodes, edges);
	}
	
	public void generatorVertex(int quantityVertex){
		Vertex newVertix;
		for (int indexVertex = 0; indexVertex < quantityVertex; indexVertex++) {
			newVertix = new Vertex(indexVertex, indexVertex, indexVertex);  // los parametros 2-3 son las posiciones de los pixeles
			this.nodes.add(newVertix);
		}
	}
	
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
	
	
	// Hay que probrar este codigo
	public void generatorEdge1(int quantity) {
		Edge lane;
		List<Vertex> vertexes = this.graph.getVertexes();
		for (int indexEdge = 0; indexEdge< quantity; indexEdge++) {
			Collections.shuffle(vertexes);
			for(int indexVertexes = 0; indexVertexes < graph.getVertexes().size(); indexVertexes++ ) {
				if (vertexes.get(indexVertexes).getCounterEdge() < indexEdge+2){
					for( int k=0 ; k < 5; k++){ 	// este for puede cambiar 
						List<Integer> listaDistances = graph.getDistances().get(vertexes.get(indexVertexes).getId());
						int index = listaDistances.indexOf(Collections.min(listaDistances));
						if (vertexes.get(index).getCounterEdge() < indexEdge+2) {
							int weigth = (int)Math.floor(Math.random()*(50)+50);
							lane = new Edge(vertexes.get(indexVertexes), vertexes.get(index), weigth);
							this.edges.add(lane);
							lane = new Edge(vertexes.get(indexVertexes), vertexes.get(index), weigth);
							this.edges.add(lane);
							graph.addSentinelValue(vertexes.get(indexVertexes).getId(), index);
							graph.addSentinelValue(index, vertexes.get(indexVertexes).getId());
							break;
							}
						else {
							graph.addSentinelValue(indexVertexes, index);
							}
					}	
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