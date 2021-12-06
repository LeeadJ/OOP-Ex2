package Ex2;

import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import api.NodeData;

import java.util.Iterator;
import java.util.List;

public class DWGalgo implements DirectedWeightedGraphAlgorithms {
    DirectedWeightedGraph graph;


    @Override
    public void init(DirectedWeightedGraph g) {
        this.graph = g;
    }

    @Override
    public DirectedWeightedGraph getGraph() {
        return this.graph;
    }

    @Override
    // testing pull with leead
    public DirectedWeightedGraph copy() {
        DirectedWeightedGraph copy = new DWG();

        while(this.graph.nodeIter().hasNext()) {
            copy.addNode(this.graph.nodeIter().next());
        }
        while(this.graph.edgeIter().hasNext()) {
            copy.connect(this.graph.edgeIter().next().getSrc(), this.graph.edgeIter().next().getDest(), this.graph.edgeIter().next().getWeight());
        }
        return copy;
    }


    @Override
    public boolean isConnected() {
       return true;
        }



    @Override
    public double shortestPathDist(int src, int dest) {
        return find_shortestPathDist(src, dest, this.graph);
    }

    /** This function receives the src, dest and graph. It returns the shortest path between src and dest nodes.
     * Return: Double. */
    private double find_shortestPathDist(int src, int dest, DirectedWeightedGraph graph) {
        //finding the highest Node ID.
        int i, j, k;
        int max_id = 0;
        Iterator<NodeData> itr = graph.nodeIter();
        while (itr.hasNext()) {
            NodeData temp = itr.next();
            if (temp.getKey() > max_id)
                max_id = temp.getKey();
        }
        max_id += 1;

        //initializing the matrix:
        Iterator<NodeData> itr2 = graph.nodeIter();
        double[][] node_matrix = new double[max_id][max_id];
        for (i = 0; i < max_id; i++) {
            for (j = 0; j < max_id; j++) {
                //initializing the indexes that edges don't exist with MAX:
                if (graph.getEdge(i, j) == null && i != j) {
                    node_matrix[i][j] = 0.0;
                    continue;
                }
                //initializing the main diagonal with zeros:
                if (i == j) { // same node.
                    node_matrix[i][j] = 0.0;
                    continue;
                }
                //else the edge exists,  initialize the index with its weight.
                node_matrix[i][j] = graph.getEdge(i, j).getWeight();
            }
        }
        return warshall(src, dest, node_matrix);
    }

    /** This is the Floyed Warshall Algorith, function. It calculates the shortest path between two indexes.
     * Return: Double. */
    private double warshall(int src, int dest, double[][] node_matrix) {
        int len = node_matrix.length;
        for(int k=0; k<len; k++)
            for(int i=0; i<len; i++)
                for(int j=0; j<len; j++)
                    if(node_matrix[i][k] > 0.0 && node_matrix[k][j] > 0.0 && node_matrix[i][j] > 0.0)
                        if(node_matrix[i][k] + node_matrix[k][j] < node_matrix[i][j])
                            node_matrix[i][j] = node_matrix[i][k] + node_matrix[k][j];
        return node_matrix[src][dest];
    }


    @Override
        public List<NodeData> shortestPath ( int src, int dest){
            return null;
        }

        @Override
        public NodeData center () {
            return null;
        }

        @Override
        public List<NodeData> tsp (List < NodeData > cities) {
            return null;
        }

        @Override
        public boolean save (String file){
            return false;
        }

        @Override
        public boolean load (String file){
            return false;
        }


    }
