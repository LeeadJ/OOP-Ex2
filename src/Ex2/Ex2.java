package Ex2;

import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import api.EdgeData;
import api.NodeData;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Iterator;

/**
 * This class is the main class for Ex2.Ex2 - your implementation will be tested using this class.
 */
public class Ex2 {
    /**
     * This static function will be used to test your implementation
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static DirectedWeightedGraph getGraph(String json_file) throws IOException, ParseException {
        DirectedWeightedGraph ans = null;
        // ****** Add your code here ******
        ans = new DWG(json_file);
        // ********************************
        return ans;
    }
    /**
     * This static function will be used to test your implementation
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static DirectedWeightedGraphAlgorithms getGraphAlgo(String json_file) throws IOException, ParseException {
        DirectedWeightedGraphAlgorithms ans = null;
        // ****** Add your code here ******
        ans = new DWGalgo();
        ans.load(json_file);
        // ********************************
        return ans;
    }
    /**
     * This static function will run your GUI using the json file.
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     *
     */
    public static void runGUI(String json_file) throws IOException, ParseException {
        DirectedWeightedGraphAlgorithms alg = getGraphAlgo(json_file);
        // ****** Add your code here ******
        Window window = new Window(alg);
        // ********************************
    }

    public static void main(String[] args) throws IOException, ParseException {
        String g1 = "C:\\Users\\Leead\\IdeaProjects\\OOP-Ex2\\G1.json";
        String g2 = "C:\\Users\\Leead\\IdeaProjects\\OOP-Ex2\\G2.json";
        String g3 = "C:\\Users\\Leead\\IdeaProjects\\OOP-Ex2\\G3.json";

        DirectedWeightedGraphAlgorithms test = getGraphAlgo(g3);
        System.out.println(test.center());
        System.out.println();
        System.out.println(test.isConnected());
//        Iterator<NodeData> it1 = getGraphAlgo(g3).getGraph().nodeIter();
//        while(it1.hasNext()){
//            NodeData n = it1.next();
//            System.out.println("\t\tKey: "+n.getKey()+"\n");
//            Iterator<EdgeData> itr = getGraphAlgo(g3).getGraph().edgeIter(n.getKey());
//            while(itr.hasNext()){
//                EdgeData e = itr.next();
//                System.out.println(e);
//            }
//        }


    }
}