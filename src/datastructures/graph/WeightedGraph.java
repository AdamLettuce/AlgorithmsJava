package datastructures.graph;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class WeightedGraph {

    private Map<String, Node> nodes = new HashMap<>();

    void addNode(String label) {
        nodes.putIfAbsent(label, new Node(label));
    }

    void addEdge(String first, String second, int weight) {
        Node node1 = nodes.get(second);
        throwExceptionIfNull(node1);

        Node node2 = nodes.get(first);
        throwExceptionIfNull(node2);

        node1.addEdge(node2, weight);
        node2.addEdge(node1, weight);
    }

    public void print() {
        nodes.values().forEach(System.out::println);
    }

    public Path getShortestPath(String from, String to) {
        Node fromNode = nodes.get(from);
        throwExceptionIfNull(fromNode);

        Node toNode = nodes.get(to);
        throwExceptionIfNull(toNode);

        Map<Node, Integer> distances = buildDistancesMap(fromNode);
        Map<Node, Node> previousNodes = new HashMap<>();

        Set<Node> visited = new HashSet<>();
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(
                Comparator.comparingInt(ne -> ne.priority)
        );
        queue.add(new NodeEntry(fromNode, 0));

        while (!queue.isEmpty()) {
            Node current = queue.remove().node;
            visited.add(current);

            for (Edge edge : current.getEdges()) {
                if (visited.contains(edge.toNode())) {
                    continue;
                }

                int newDistance = distances.get(current) + edge.weight();
                if (newDistance < distances.get(edge.toNode())) {
                    distances.replace(edge.toNode(), newDistance);
                    previousNodes.put(edge.toNode(), current);
                    queue.add(new NodeEntry(edge.toNode(), newDistance));
                }
            }
        }

        return buildPath(toNode, previousNodes);
    }

    private Map<Node, Integer> buildDistancesMap(Node fromNode) {
        Map<Node, Integer> distances = new HashMap<>();
        for (Node node : nodes.values())
            distances.put(node, Integer.MAX_VALUE);
        distances.replace(fromNode, 0);
        return distances;
    }

    private void throwExceptionIfNull(Node fromNode) {
        if (fromNode == null) {
            throw new IllegalArgumentException();
        }
    }

    private Path buildPath(Node toNode, Map<Node, Node> previousNodes) {
        Stack<Node> stack = new Stack<>();
        stack.push(toNode);
        Node previous = previousNodes.get(toNode);

        while (previous != null) {
            stack.push(previous);
            previous = previousNodes.get(previous);
        }

        Path result = new Path();
        while (!stack.isEmpty()) {
            result.add(stack.pop().label());
        }
        return result;
    }


    public boolean hasCycle() {
        Set<Node> visited = new HashSet<>();
        for(Node node: nodes.values()) {
            if(!visited.contains(node) && hasCycle(node,null,visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(Node node, Node parent, Set<Node> visited) {
        visited.add(node);
        for(Edge edge: node.getEdges()) {
            if(edge.toNode().equals(parent)) {
                continue;
            }
            if(visited.contains(edge.toNode()) || hasCycle(edge.toNode(),node,visited)) {
                return true;
            }
        }
        return false;
    }

    public WeightedGraph minimumSpanningTree() {
        WeightedGraph graph = new WeightedGraph();
        Queue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(Edge::weight));

        Node startNode = nodes.values().iterator().next();
        while(graph.nodes.size() < nodes.size()) {
            graph.addNode(startNode.label());
            for(Edge edge: startNode.getEdges()) {
                if(!graph.contains(edge.toNode())) {
                    edges.add(edge);
                }
            }

            Edge minimumEdge = edges.remove();
            if(graph.contains(minimumEdge.toNode())) {
                minimumEdge = edges.remove();
            }

            graph.addNode(minimumEdge.toNode().label());
            graph.addEdge(minimumEdge.fromNode().label(), minimumEdge.toNode().label(), minimumEdge.weight());

            startNode = minimumEdge.toNode();

        }
        return graph;
    }

    private boolean contains(Node toNode) {
        return nodes.containsKey(toNode.label());
    }

    private class NodeEntry {
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    @Override
    public String toString() {
        return nodes.values().stream().map(n->n.label()+": "+n.getEdges()
        ).collect(Collectors.joining("\n"));
    }
}

class Node {
    private String label;
    private Set<Edge> edges = new HashSet<>();

    public Node(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return label().equals(node.label());
    }

    @Override
    public int hashCode() {
        return Objects.hash(label());
    }

    @Override
    public String toString() {
        String edges = this.edges.stream()
                .map(Edge::toString)
                .collect(Collectors.joining(", "));
        return label + (edges.isEmpty() ? "" : " is connected to " + edges);
    }

    public void addEdge(Node to, int weight) {
        edges.add(new Edge(this, to, weight));
    }

    public Set<Edge> getEdges() {
        return Collections.unmodifiableSet(edges);
    }


}

class Edge {
    private final Node from;
    private final Node to;
    private final int weight;

    public Edge(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "[" + from.label() + "->" + to.label() + "," + weight + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return weight == edge.weight && from.equals(edge.from) && to.equals(edge.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, weight);
    }

    public Node toNode() {
        //TODO: immutable
        return to;
    }

    public int weight() {
        return weight;
    }

    public Node fromNode() {
        //TODO: immputable
        return from;
    }
}
/*
    public WeightedGraph minimumSpanningTree() {
        WeightedGraph graph = new WeightedGraph();
//        for(Node node: nodes.values()) {
//            graph.addNode(node.getLabel());
//        }

        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::weight));

        Set<Node> notVisited = new HashSet<>(nodes.values());
        Set<Node> visited = new HashSet<>();

        while (graph.nodes.values().size() < nodes.values().size()) {
            for (Node node : nodes.values()) {
                graph.addNode(node.getLabel());
                for (Edge edge : node.getEdges()) {
                    if (!visited.contains(edge.toNode())) {
                        graph.addNode(edge.toNode().getLabel());
                        queue.add(edge);
//                        visited.add(edge.toNode());
                    }
                }
                Edge minimum = queue.remove();
//                Edge minimum = queue.remove();
//                while (!queue.isEmpty() && visited.contains(minimum.toNode())) {
//                    minimum = queue.remove();
//                }

                graph.addEdge(minimum.getFromNode().getLabel(), minimum.toNode().getLabel(), minimum.weight());
            }
        }

        return graph;
    }
 */