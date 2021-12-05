package Ex2;

import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import api.NodeData;

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
    public DirectedWeightedGraph copy() {
        DirectedWeightedGraph copy = new DWG();
        while(this.graph.nodeIter().hasNext()) {
            copy.addNode(this.graph.nodeIter().next());
        }
        while(this.graph.edgeIter().hasNext()) {
            copy.connect(this.graph.edgeIter().next().getSrc(), this.graph.edgeIter().next().getDest(), this.graph.edgeIter().next().getW());
        }
        return copy;
    }


    @Override
    public boolean isConnected() {
        int nodes = 0;
        while(this.graph.nodeIter().hasNext()){
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
        public static void DFS(DirectedWeightedGraph graph, int v, boolean[] visited)
        {
            visited[v] = true;

            // do for every edge (v, u)
            for (int u: graph.adjList.get(v))
            {
                // `u` is not visited
                if (!visited[u]) {
                    DFS(graph, u, visited);
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
