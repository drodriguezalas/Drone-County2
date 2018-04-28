package model;

public class VertexDistance {
	private Vertex vertex;
	private int distance;
	
	public VertexDistance(Vertex pVertex, int pDistance) {
		vertex = pVertex;
		distance = pDistance;
	}

	public Vertex getVertex() {
		return vertex;
	}

	public void setVertex(Vertex vertex) {
		this.vertex = vertex;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}
