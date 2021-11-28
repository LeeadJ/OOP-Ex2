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
    int MC = 0;

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
        HashMap<Integer, EdgeData> map = new HashMap<>();
        this.edgeMap.put(n.getKey(), map);
        this.MC ++;

    }

    @Override
    public void connect(int src, int dest, double w) {
        try{
            EdgeData temp = new Edge(src, w, dest);
            this.edgeMap.get(src).put(dest, temp);
            this.MC++;
        }
        catch (NullPointerException e){
            System.out.println("The Map doesn't contain the src node!");
        }

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
        NodeData temp = new GNode(this.nodeMap.get(key).getKey(), this.nodeMap.get(key).getLocation());
        this.nodeMap.remove(key);
        for(HashMap<Integer, EdgeData> map : this.edgeMap.values()){
            for(EdgeData e : map.values()){
                if(e.getDest() == key){
                    map.remove(key);
                }
            }
        }
        this.MC++;
        return temp;
    }

    @Override
    public EdgeData removeEdge(int src, int dest) {
        EdgeData temp = new Edge(src, this.edgeMap.get(src).get(dest).getWeight(), dest);
        this.edgeMap.get(src).remove(dest);
        this.MC++;
        return temp;
    }

    @Override
    public int nodeSize() {
        return this.nodeMap.size();
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
        return this.MC;
    }
}
