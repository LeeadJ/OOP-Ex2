package Ex2;

import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import api.EdgeData;
import api.NodeData;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.*;

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
        // testing leead commit is gay
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
        return find_shortestPathDist(src, dest, this.graph);
    }

    /** This function receives the src, dest and graph. It returns the shortest path between src and dest nodes.
     * Return: Double. */
    private double find_shortestPathDist(int src, int dest, DirectedWeightedGraph graph) {
        double[][] node_matrix = matrix_initializer(graph);
        System.out.println("Starting array: "+Arrays.deepToString(node_matrix));
        int[][] stam = next_matrix_initializer(node_matrix);
        warshall(node_matrix, stam);
        System.out.println("Final array: "+Arrays.deepToString(node_matrix));
        return node_matrix[src][dest];
    }

    /** This is the Floyd Warshall Algorithm, function. It calculates the shortest path between two indexes.
     * Return: VOID. */
    private void warshall(double[][] node_matrix, int[][] next_matrix) {
        int len = node_matrix.length;
        for (int k = 0; k < len; k++)
            for (int i = 0; i < len; i++)
                for (int j = 0; j < len; j++) {
                    if (node_matrix[i][k] == -1.0 || node_matrix[k][j] == -1.0)
                        continue;
                    if (node_matrix[i][j] > node_matrix[i][k] + node_matrix[k][j]) {
                        node_matrix[i][j] = node_matrix[i][k] + node_matrix[k][j];
                        next_matrix[i][j] = next_matrix[i][k];
                    }
                }
    }


    @Override
    public List<NodeData> shortestPath ( int src, int dest){
        double[][] node_matrix = matrix_initializer(this.graph);
        int[][] next_matrix = next_matrix_initializer(node_matrix);
        warshall(node_matrix, next_matrix);
        ArrayList<NodeData> ans = constructPath(src, dest, next_matrix, this.graph);
        printPath(ans);
        return  ans;
    }
    /** Next Matrix initializer*/
    public static int[][] next_matrix_initializer(double[][] node_matrix){
        int len = node_matrix.length;
        int[][] next_matrix = new int[len][len];
        for(int i=0; i<len; i++) {
            for (int j = 0; j < len; j++) {
                if(node_matrix[i][j] == -1.0)
                    next_matrix[i][j] = -1;
                else
                    next_matrix[i][j] = j;
            }
        }
        return  next_matrix;
    }
    /** Function construct the shortest path between u and v*/
    public static ArrayList<NodeData> constructPath(int u, int v, int[][] next_matrix, DirectedWeightedGraph graph) {
        // If there's no path between
        // node u and v, simply return
        // an empty array
        if (next_matrix[u][v] == -1)
            return null;

        // Storing the path in a vector
        Vector<Integer> path = new Vector<Integer>();
        path.add(u);

        while (u != v)
        {
            u = next_matrix[u][v];
            path.add(u);
        }
        ArrayList<NodeData> arr = new ArrayList<>();
        for(int i : path)
            arr.add(graph.getNode(i));
        return arr;
    }
    /** Matrix initializer */
    public static double[][] matrix_initializer(DirectedWeightedGraph graph){
        //finding the highest Node ID.
        int i, j;
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
                //if the nodes don't exist, initialize with -1.0
                try{
                    if(graph.getNode(i)==null || graph.getNode(j)==null){
                        node_matrix[i][j] = -99.0;
                        continue;
                    }
                }
                catch (NullPointerException e){
                    node_matrix[i][j] = -99.0;
                    continue;
                }
                //initializing the main diagonal with zeros:
                if (i == j) { // same node.
                    node_matrix[i][j] = 0.0;
                    continue;
                }
                //initializing the indexes that edges don't exist with -1.0:
                try {
                    if (graph.getEdge(i, j) == null && graph.getNode(i)!=null && graph.getNode(j)!=null) {
                        node_matrix[i][j] = Double.MAX_VALUE;
                        continue;
                    }
                }
                catch (NullPointerException d){
                    node_matrix[i][j] = Double.MAX_VALUE;
                    continue;
                }
                //else the edge exists,  initialize the index with its weight.
                node_matrix[i][j] = graph.getEdge(i, j).getWeight();
            }
        }
        return node_matrix;
    }


    /** Prints the shortest path */
    public static void printPath(ArrayList<NodeData> path) {
        int n = path.size();
        System.out.print("The Shortest path: ");
        for(int i = 0; i < n - 1; i++)
            System.out.print(path.get(i).getKey() + " -> ");
        System.out.print(path.get(n - 1).getKey() + "\n");
    }



    @Override
    public NodeData center () {
        int node_id=0;
        double min_distance = Double.MAX_VALUE;

        //looping through the nodes in the graph using the iterator.
        Iterator<NodeData> itr1 = graph.nodeIter();
        while(itr1.hasNext()){
            //initializing the first node.
            NodeData curr = itr1.next();
            double curr_min_dist = Double.MAX_VALUE;
            Iterator<NodeData> itr2 = graph.nodeIter();
            while(itr2.hasNext()){
                NodeData n = itr2.next();
                //if the iterator is pointing at the same node, continue to the next.
                if(n.getKey()==curr.getKey())
                    continue;
                //check if the distance is the lowest for the current node.
                if(curr.getLocation().distance(n.getLocation()) < curr_min_dist)
                    curr_min_dist = curr.getLocation().distance(n.getLocation());
            }
            if(curr_min_dist < min_distance){
                min_distance = curr_min_dist;
                node_id = curr.getKey();
            }
        }
        return this.graph.getNode(node_id);
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
        try{
            DirectedWeightedGraph graph = new DWG(file);
            DirectedWeightedGraphAlgorithms test = new DWGalgo();
            test.init(graph);
            return true;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            e.printStackTrace();
            return false;
        }
    }
}