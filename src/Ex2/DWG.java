package Ex2;

import api.DirectedWeightedGraph;
import api.EdgeData;
import api.NodeData;

import java.util.HashMap;
import java.util.Iterator;

public class DWG implements DirectedWeightedGraph {
    public HashMap<Integer, GNode> nodeMap = new HashMap<>();

    public DWG(){
        this.nodeMap = new HashMap<>();
    }


    @Override
    public NodeData getNode(int key) {
        return this.nodeMap.get(key);
    }

    @Override
    public EdgeData getEdge(int src, int dest) {
        return this.nodeMap.get(src).edgeMap.get(dest);
    }

    @Override
    public void addNode(NodeData n) {
        GNode temp = new GNode(n.getKey(), n.getLocation());
        this.nodeMap.put(temp.getKey(), temp);

    }

    @Override
    public void connect(int src, int dest, double w) {
        Edge temp = new Edge(src, w, dest);

    }

    @Override
    public Iterator<NodeData> nodeIter() {
        return null;
    }

    @Override
    public Iterator<EdgeData> edgeIter() {
        return null;
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        return null;
    }

    @Override
    public NodeData removeNode(int key) {
        return null;
    }

    @Override
    public EdgeData removeEdge(int src, int dest) {
        return null;
    }

    @Override
    public int nodeSize() {
        return 0;
    }

    @Override
    public int edgeSize() {
        return 0;
    }

    @Override
    public int getMC() {
        return 0;
    }
}
