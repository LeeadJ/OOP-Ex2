package Ex2;

import api.DirectedWeightedGraph;
import api.EdgeData;
import api.NodeData;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DWG implements DirectedWeightedGraph {
    public HashMap<Integer, NodeData> nodeMap;
    public HashMap<Integer, HashMap<Integer, EdgeData>> edgeMap;

    public DWG(){
        this.nodeMap = new HashMap<>();
        this.edgeMap = new HashMap<>();
    }


    @Override
    public NodeData getNode(int key) {
        return this.nodeMap.get(key);
    }

    @Override
    public EdgeData getEdge(int src, int dest) {
        return this.edgeMap.get(src).get(dest);
    }

    @Override
    public void addNode(NodeData n) {
        this.nodeMap.put(n.getKey(), n);

    }

    @Override
    public void connect(int src, int dest, double w) {
        EdgeData temp = new Edge(src, w, dest);
        this.edgeMap.get(src).put(dest, temp);
    }
    //////////////////////////////////ADD EXCEPTIONS///////////////////////////////////////////////////

    @Override
    public Iterator<NodeData> nodeIter() {
        return this.nodeMap.values().iterator();
    }

    @Override
    public Iterator<EdgeData> edgeIter() {
        HashMap<Integer, EdgeData> new_map = new HashMap<>();
        for(HashMap<Integer, EdgeData> map : this.edgeMap.values())
            for(EdgeData edge : map.values())
                new_map.put(edge.getDest(), edge);
        return new_map.values().iterator();
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        return this.edgeMap.get(node_id).values().iterator();
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
        int counter = 0;
        for(HashMap<Integer, EdgeData> map : this.edgeMap.values())
            counter += map.size();
        return counter;
    }

    @Override
    public int getMC() {
        return 0;
    }
}
