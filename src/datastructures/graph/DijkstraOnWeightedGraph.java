package datastructures.graph;

public class DijkstraOnWeightedGraph {
    public static void main(String[] args) {
//        System.out.println(createGraph().getShortestPath("A","E"));
//        System.out.println(createMediumGraph().getShortestPath("A","J"));
//        cycleDemo();

        WeightedGraph graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        graph.addEdge("A","B",3);
        graph.addEdge("A","C",1);
        graph.addEdge("C","B",2);
        graph.addEdge("C","D",5);
        graph.addEdge("B","D",4);

        graph.addEdge("C","E",1);
        graph.addEdge("D","E",2);

        WeightedGraph minimumSpanningTree = graph.minimumSpanningTree();
        System.out.println(minimumSpanningTree);
    }

    private static void cycleDemo() {
        WeightedGraph graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");

        graph.addEdge("A","B",1);
//        graph.addEdge("B","C",1);
//        graph.addEdge("C","A",1);

        System.out.println(graph.hasCycle());
    }


    private static WeightedGraph createGraph() {
        WeightedGraph graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        graph.addEdge("A","B", 3);
        graph.addEdge("A","D", 2);
        graph.addEdge("A","C", 4);
        graph.addEdge("C","D", 1);
        graph.addEdge("B","D", 6);
        graph.addEdge("B","E", 1);
        graph.addEdge("D","E", 5);

        return graph;
    }

    private static WeightedGraph createMediumGraph() {
        WeightedGraph graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
        graph.addNode("G");
        graph.addNode("H");
        graph.addNode("I");
        graph.addNode("J");

        graph.addEdge("A","B", 2);
        graph.addEdge("A","C", 8);
        graph.addEdge("A","D", 4);
        graph.addEdge("B","C", 3);
        graph.addEdge("B","E", 1);
        graph.addEdge("B","F", 2);
        graph.addEdge("C","D", 5);
        graph.addEdge("C","E", 7);
        graph.addEdge("C","F", 1);
        graph.addEdge("C","G", 10);
        graph.addEdge("D","F", 7);
        graph.addEdge("D","G", 2);
        graph.addEdge("E","F", 9);
        graph.addEdge("E","I", 7);
        graph.addEdge("E","H", 3);
        graph.addEdge("F","H", 2);
        graph.addEdge("F","I", 11);
        graph.addEdge("F","J", 3);
        graph.addEdge("F","G", 4);
        graph.addEdge("G","I", 8);
        graph.addEdge("G","J", 5);
        graph.addEdge("H","I", 2);
        graph.addEdge("H","J", 1);

        return graph;
    }
}