package Ex2;

import api.GeoLocation;
import api.NodeData;

import java.util.HashMap;

public class GraphNode implements NodeData {
    private final int key;
    private GeoLocation location;
    private double weight;
    private String info;
    private int tag;
    public HashMap<Integer, NodeEdge> edgeMap = new HashMap<>();

    // contructor for GraphNode
    public GraphNode(int key, GeoLocation g){
        this.key = key;
        this.location = g;
    }

    // copy constructor
    public GraphNode(GraphNode other){
        this.key = other.key;
        this.location = other.location;
    }



    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public GeoLocation getLocation() {
        return this.location;
    }

    @Override
    public void setLocation(GeoLocation p) {
        this.location = p;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double w) {
        this.weight = w;
    }

    @Override
    public String getInfo() {
        return this.info;
    }

    @Override
    public void setInfo(String s) {
        this.info = s;
    }

    @Override
    public int getTag() {
        return this.tag;
    }

    @Override
    public void setTag(int t) {
        this.tag = t;
    }
}
