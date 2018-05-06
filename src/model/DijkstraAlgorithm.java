package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Dani
 */
public class DijkstraAlgorithm {
    private final List<Vertex> nodes;
    private final List<Edge> edges;
    private Set<Vertex> settledNodes;
    private Set<Vertex> unSettledNodes;
    private Map<Vertex, Vertex> predecessors;
    private Map<Vertex, Integer> distance;

    public DijkstraAlgorithm(Graph pGraph) {
        this.nodes = new ArrayList<Vertex>(pGraph.getVertexes());
        this.edges = new ArrayList<Edge>(pGraph.getEdges());
    }

    public void execute(Vertex pSource) {
        settledNodes = new HashSet<Vertex>();
        unSettledNodes = new HashSet<Vertex>();
        distance = new HashMap<Vertex, Integer>();
        predecessors = new HashMap<Vertex, Vertex>();
        distance.put(pSource, 0);
        unSettledNodes.add(pSource);
        while (unSettledNodes.size() > 0) {
            Vertex node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(Vertex pNode) {
        List<Vertex> adjacentNodes = getNeighbors(pNode);
        for (Vertex target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(pNode)
                    + getDistance(pNode, target)) {
                distance.put(target, getShortestDistance(pNode)
                        + getDistance(pNode, target));
                predecessors.put(target, pNode);
                unSettledNodes.add(target);
            }
        }

    }

    private int getDistance(Vertex pNode, Vertex pTarget) {
        for (Edge edge : edges) {
            if (edge.getSource().equals(pNode) && edge.getDestination().equals(pTarget)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<Vertex> getNeighbors(Vertex pNode) {
        List<Vertex> neighbors = new ArrayList<Vertex>();
        for (Edge edge : edges) {
            if (edge.getSource().equals(pNode)
                    && !isSettled(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private Vertex getMinimum(Set<Vertex> pVertexes) {
        Vertex minimum = null;
        for (Vertex vertex : pVertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(Vertex pVertex) {
        return settledNodes.contains(pVertex);
    }

    private int getShortestDistance(Vertex pDestination) {
        Integer d = distance.get(pDestination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    public LinkedList<Vertex> getPath(Vertex pTarget) {
        LinkedList<Vertex> path = new LinkedList<Vertex>();
        Vertex step = pTarget;
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        Collections.reverse(path);
        return path;
    }
    
    public LinkedList<Vertex> calculateRoad(Vertex pOrigin, Vertex pDestination){
    	execute(pOrigin);
    	LinkedList<Vertex> road = getPath(pDestination);
    	return road;
    }
}
