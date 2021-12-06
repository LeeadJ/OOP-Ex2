package Testing;

import Ex2.*;
import api.DirectedWeightedGraph;
import api.EdgeData;
import api.NodeData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DWGalgoTest {

    Point3D p1 = new Point3D(35.19589389346247,32.10152879327731,0.0);
    Point3D p2 = new Point3D(35.20319591121872,32.10318254621849,0.0);
    Point3D p3 = new Point3D(35.20752617756255,32.1025646605042,0.0);
    Point3D p4 = new Point3D(35.21007339305892,32.10107446554622,0.0);
    Point3D p5 = new Point3D(35.21310882485876,32.104636394957986,0.0);

    NodeData a = new GNode(0, p1);
    NodeData b = new GNode(1, p2);
    NodeData c = new GNode(2, p3);
    NodeData d = new GNode(4, p4);
    NodeData e = new GNode(4, p5);

    EdgeData e1 = new Edge(0,1.0, 3);
    EdgeData e2 = new Edge(0,2.0, 2);
    EdgeData e3 = new Edge(0,2.0, 1);
    EdgeData e4 = new Edge(0,2.0, 4);
    EdgeData e5 = new Edge(1,3.5, 2);
    EdgeData e6 = new Edge(1,3.5, 3);
    EdgeData e7 = new Edge(1,3.5, 4);
    EdgeData e8 = new Edge(1,3.5, 0);




    @Test
    void init() {
    }

    @Test
    void getGraph() {
    }

    @Test
    void copy() {
        DirectedWeightedGraph g = new DWG();
        DWGalgo test = new DWGalgo();
        test.init(g);
        test.getGraph().addNode(a);
        test.getGraph().addNode(b);
        test.getGraph().connect(0,1,1.0);
        test.getGraph().connect(1,0,1.0);
        DirectedWeightedGraph copyG = test.copy();
        assertEquals(test.getGraph().getNode(0), a);
        assertFalse(copyG.getNode(0) ==  a);
        assertEquals(copyG.getNode(0).getKey(), a.getKey());
        assertEquals(copyG.getEdge(0,1).getSrc(), test.getGraph().getEdge(0,1).getSrc());

    }

    @Test
    void isConnected() {
        DirectedWeightedGraph g = new DWG();
        DWGalgo test = new DWGalgo();
        test.init(g);
        test.getGraph().addNode(a);
        test.getGraph().addNode(b);
        test.getGraph().connect(0,1,1.0);
        test.getGraph().connect(1,0,1.0);
        assertTrue(test.isConnected());
        DirectedWeightedGraph g1 = new DWG();
        DWGalgo test1 = new DWGalgo();
        test1.init(g1);
        test1.getGraph().addNode(a);
        test1.getGraph().addNode(b);
        test1.getGraph().addNode(c);
        test1.getGraph().connect(0,1,1.0);
        test1.getGraph().connect(1,0,1.0);
        test1.getGraph().connect(2,0,1.0);
        assertFalse(test1.isConnected());
    }

    @Test
    void DFS() {
    }

    @Test
    void shortestPathDist() {
        DirectedWeightedGraph g = new DWG();
        DWGalgo test = new DWGalgo();
        test.init(g);
        test.getGraph().addNode(a);
        test.getGraph().addNode(b);
        test.getGraph().addNode(c);
        test.getGraph().addNode(d);
        test.getGraph().connect(0, 1,3.0);
        test.getGraph().connect(0, 4, 7.0);
        test.getGraph().connect(1, 0, 8.0);
        test.getGraph().connect(1, 2,2.0);
        test.getGraph().connect(2, 4,1.0);
        test.getGraph().connect(4, 0,2.0);
        test.getGraph().connect(2, 0,5.0);
        assertEquals(3.0, test.shortestPathDist(1,4));

    }

    @Test
    void shortestPath() {
    }

    @Test
    void center() {
        Point3D p1 = new Point3D(0.0,0.0,0.0);
        Point3D p2 = new Point3D(3.0,8.0,10.0);
        Point3D p3 = new Point3D(3.0,8.0,7.0);
        Point3D p4 = new Point3D(3.0,8.0,0.0);
        NodeData a = new GNode(0, p1);
        NodeData b = new GNode(1, p2);
        NodeData c = new GNode(2, p3);
        NodeData d = new GNode(4, p4);
        DirectedWeightedGraph g = new DWG();
        DWGalgo test = new DWGalgo();
        test.init(g);
        test.getGraph().addNode(a);
        test.getGraph().addNode(b);
        test.getGraph().addNode(c);
        test.getGraph().addNode(d);
        NodeData n = test.center();
        assertEquals(n.getKey(), b.getKey());
    }

    @Test
    void tsp() {
    }

    @Test
    void save() {
    }

    @Test
    void load() {
    }
}