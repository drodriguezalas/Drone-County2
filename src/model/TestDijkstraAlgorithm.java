package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Dani
 */
public class TestDijkstraAlgorithm {
    private List<Vertex> nodes;
    private List<Edge> edges;

    public TestDijkstraAlgorithm() {
    }        

    
    public void testExcute() {
        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
                
        Vertex N0 = new Vertex(0,0,0);
        Vertex N1 = new Vertex(1,1,1);
        Vertex N2 = new Vertex(2,2,2);
        Vertex N3 = new Vertex(3,3,3);
        Vertex N4 = new Vertex(4,4,4);
        Vertex N5 = new Vertex(5,5,5);
        Vertex N6 = new Vertex(6,6,6);
        
        nodes.add(N0);
        nodes.add(N1);
        nodes.add(N2);
        nodes.add(N3);
        nodes.add(N4);
        nodes.add(N5);
        nodes.add(N6);

        addLane(0, 2, 1);
        addLane(0, 3, 2);
        addLane(1, 5, 3);
        addLane(1, 2, 2);
        addLane(2, 1, 2);
        addLane(2, 4, 3);
        addLane(2, 3, 1);
        addLane(2, 0, 1);
        addLane(3, 2, 1);
        addLane(3, 6, 1);
        addLane(3, 0, 2);
        addLane(4, 5, 2);
        addLane(4, 2, 3);
        addLane(5, 6, 1);
        addLane(5, 4, 2);
        addLane(5, 1, 3);
        addLane(6, 5, 1);
        addLane(6, 3, 1);

        //Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(getVertexById(2, nodes));
        LinkedList<Vertex> path = dijkstra.getPath(getVertexById(6, nodes));
        assertNotNull(path);
        assertTrue(path.size() > 0);


        for (Vertex vertex : path) {
            System.out.println(vertex.getId());
        }
                

    }

    private Vertex getVertexById(int pId, List<Vertex> pVertices)
    {
        for(Vertex vertex : pVertices)
        {
            if(vertex.getId() == pId)
            {
                return vertex;
            }
        }
        return null;
    }
    
    private void addLane(int pSource, int pDestination, int pDuration) {
        Edge lane = new Edge(getVertexById(pSource, nodes), getVertexById(pDestination, nodes), pDuration );
        edges.add(lane);
    }
    
    public static void main(String[] args)
    {
        TestDijkstraAlgorithm test = new TestDijkstraAlgorithm();
        test.testExcute();
    }
}
