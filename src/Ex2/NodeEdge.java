package Ex2;

import api.EdgeData;

public class NodeEdge implements EdgeData {
    private final int src;
    private final int dest;
    private final double weight;
    private String info;
    private int tag;

    /** Constructors */
    public NodeEdge(int Src, double Weight, int Dest){
        this.src = Src;
        this.weight = Weight;
        this. dest = Dest;


    }
    // Copy:
    public NodeEdge(NodeEdge other){
        this.src = other.src;
        this.weight = other.weight;
        this.dest = other.dest;
        this.info = other.info;
        this.tag = other.tag;
    }

    @Override
    public int getSrc() {
        return this.src;
    }

    @Override
    public int getDest() {
        return this.dest;
    }

    @Override
    public double getWeight() {
        return this.weight;
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
