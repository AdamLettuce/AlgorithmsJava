package datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adam on 27/05/2018.
 */
public class DepthStack {
    public static void main(String[] args) {



    }

    private static Map<Integer, List<Integer>> buildGraph(int verticesCount, int[][] a ) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < verticesCount; i++) {
            graph.put(i,new ArrayList<>());
        }


        return graph;
    }
}
