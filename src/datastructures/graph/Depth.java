package datastructures.graph;

import java.util.*;

/**
 * Created by adam on 24/03/2018.
 */
public class Depth {

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("ty", Arrays.asList(new String[]{"alicja", "bartek", "cecylia"}));
        graph.put("bartek", Arrays.asList(new String[]{"janusz", "patrycja"}));
        graph.put("alicja", Arrays.asList(new String[]{"patrycja"}));
        graph.put("cecylia", Arrays.asList(new String[]{"tamara", "jarek"}));
        graph.put("janusz", Arrays.asList("Ela", "Madzia", "Łuaksz"));
        graph.put("patrycja", Collections.emptyList());
        graph.put("tamara", Collections.emptyList());
        graph.put("jarek", Collections.emptyList());

        search(graph, "ty");
    }

    public static boolean search(Map<String, List<String>> graph, String name) {
        Deque<String> search_queue = new ArrayDeque<>();
        search_queue.addAll(graph.get(name));
        Set<String> searched = new HashSet<>();
        while (!search_queue.isEmpty()) {
            String person = search_queue.poll();
            if (!searched.contains(person)) {
                if (person_is_seller(person)) {
                    System.out.println(person + " sprzedaje mango!");
                    return true;
                } else {
                    search_queue.addAll(graph.get(person));
                    searched.add(person);
                }
            }
        }
        return false;
    }

    private static boolean person_is_seller(String person) {
        return person.contains("m");
    }
}
