package Ex2;

import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import api.EdgeData;
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
        DirectedWeightedGraph copy_graph = new DWG();
        Iterator<NodeData> itr_node = this.graph.nodeIter();
        while(itr_node.hasNext()) {
            NodeData temp_node = new GNode(itr_node.next());
            copy_graph.addNode(temp_node);
        }
        Iterator<EdgeData> itr_edge = this.graph.edgeIter();
        while(itr_edge.hasNext()) {
            EdgeData temp_edge = new Edge(itr_edge.next());
            copy_graph.connect(temp_edge.getSrc(), temp_edge.getDest(), temp_edge.getWeight());
        }
        return copy_graph;
    }


    @Override
    public boolean isConnected() {
        int nodes = 0;
        Iterator<NodeData> itr_node = this.graph.nodeIter();
        while(itr_node.hasNext()){
            itr_node.next();
            nodes++;
        }
        for(int i = 0; i< nodes; i++){
            boolean[] visited = new boolean[nodes];
            DFS(this.graph, i, visited);
            for (boolean b: visited)
            {
                if (!b) {
                    return false;
                }
            }
        }
        return true;
        }

        // Function to perform DFS traversal on the graph on a graph
        public static void DFS(DirectedWeightedGraph graph, int v, boolean[] visited) {
            visited[v] = true;
            Iterator<EdgeData> itr_edge = graph.edgeIter(v);
            while (itr_edge.hasNext()) {
                EdgeData temp_edge = new Edge(itr_edge.next());
                if (!visited[temp_edge.getDest()]) {
                    DFS(graph, temp_edge.getDest(), visited);
                }
            }
        }




    @Override
    public double shortestPathDist(int src, int dest) {
        return 0;
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        return null;
    }

    @Override
    public NodeData center() {
        return null;
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        return null;
    }

    @Override
    public boolean save(String file) {
        return false;
    }

    @Override
    public boolean load(String file) {
        return false;
    }
}
