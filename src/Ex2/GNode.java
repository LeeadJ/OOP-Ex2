package Ex2;

import api.GeoLocation;
import api.NodeData;

public class GNode implements NodeData {
    private final int id;
    private GeoLocation pos;
    private double weight;
    private String info;
    private int tag;


    // constructor for GraphNode
    public GNode(int id, GeoLocation g){
        this.id = id;
        this.pos = g;
    }

    // copy constructor
    public GNode(GNode other){
        this.id = other.getId();
        this.pos = other.getPos();
        this.weight = other.getWeight();
        this.info = other.getInfo();
        this.tag = other.getTag();

    }


    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public GeoLocation getPos() {
        return this.pos;
    }

    @Override
    public void setPos(GeoLocation p) {
        this.pos = p;
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

    public String toString(){
        return "Key: "+this.id +".\nLocation: "+this.pos.toString()+".";
    }
}
