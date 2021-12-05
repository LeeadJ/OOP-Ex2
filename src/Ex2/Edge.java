package Ex2;

import api.EdgeData;


import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;

public class Edge implements EdgeData {
    private final int src;
    private final int dest;
    private final double w;
    private String info;
    private int tag;

    /**
     * Constructors
     */
    public Edge(int Src, double w, int Dest) {
        this.src = Src;
        this.w = w;
        this.dest = Dest;


    }

    // Copy:
    public Edge(Edge other) {
        this.src = other.src;
        this.w = other.w;
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
        return this.w;
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

    public String toString() {
        return "Src: " + this.src + ".\nWeight: " + this.w + ".\nDest: " + this.dest + ".";
    }
}


