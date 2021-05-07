package datastructures.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by adam on 25/03/2018.
 */
public class Dijsktra {

    public static void main(String[] args) {

        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("start", new HashMap<>());
        graph.get("start").put("a", 6);
        graph.get("start").put("b", 2);

        graph.put("a", new HashMap<>());
        graph.get("a").put("meta", 1);

        graph.put("b", new HashMap<>());
        graph.get("b").put("a", 3);
        graph.get("b").put("meta", 5);

        graph.put("meta", new HashMap<>());

        Map<String, Integer> costs = new HashMap<>();
        costs.put("a", 6);
        costs.put("b", 2);
        costs.put("meta", Integer.MAX_VALUE);

        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("meta", null);

        Set<String> processed = new HashSet<>();

        Map.Entry<String, Integer> node = find_lowest_cost_node(costs, processed);
        while (node != null) {
            Integer cost = costs.get(node.getKey());
            Map<String, Integer> neighbours = graph.get(node.getKey());
            for (String n : neighbours.keySet()) {
                Integer new_cost = cost + neighbours.get(n);
                if (costs.get(n) > new_cost) {
                    costs.put(n, new_cost);
                    parents.put(n, node.getKey());
                }
            }
            processed.add(node.getKey());
            node = find_lowest_cost_node(costs, processed);
        }


        System.out.println("Costs");
        for (Map.Entry<String, Integer> cost : costs.entrySet()) {
            System.out.println(cost);
        }

        System.out.println("Parents");
        for (Map.Entry<String, String> parent : parents.entrySet()) {
            System.out.println(parent);
        }

    }

    private static Map.Entry<String, Integer> find_lowest_cost_node(Map<String, Integer> costs, Set<String> processed) {
        Integer lowest_cost = Integer.MAX_VALUE;
        Map.Entry<String, Integer> lowest_cost_node = null;
        for (Map.Entry<String, Integer> node : costs.entrySet()) {
            Integer cost = node.getValue();
            if (cost < lowest_cost && !processed.contains(node.getKey())) {
                lowest_cost = cost;
                lowest_cost_node = node;
            }
        }
        return lowest_cost_node;
    }
}