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
        for(HashMap<Integer, EdgeData> map : edgeMap.values()){

        }
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        return null;
    }

    @Override
    public NodeData removeNode(int key) {
        NodeData temp = new GNode(this.nodeMap.get(key).getKey(), this.nodeMap.get(key).getLocation());
        this.nodeMap.remove(key);
        for(NodeData g : this.nodeMap.values()){
            for(Edge e : g.edgeMap.values()){
                if(e.getDest() == key){
                    g.edgeMap.remove(key);
                }
            }
        }

        return temp;
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
