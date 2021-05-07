package datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {

    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return label.equals(node.label);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<Node, List<Node>> vertices = new HashMap<>();

    void addNode(String label) {
        if (label == null) {
            throw new IllegalArgumentException("Node must have label.");
        }
        vertices.putIfAbsent(new Node(label), new ArrayList<>());
    }

    void removeNode(String label) {
        Node nodeToRemove = new Node(label);
        vertices.forEach((node, neighbours) -> neighbours.removeIf(neighbour -> neighbour.equals(nodeToRemove)));
        vertices.remove(nodeToRemove);
    }

    void addEdge(String from, String to) {
        getNeighbours(from).add(getNodeByName(to));
    }

    void removeEdge(String from, String to) {
        getNeighbours(from).remove(getNodeByName(to));
    }

    void print() {
        vertices.entrySet().stream()
                .filter(v -> !v.getValue().isEmpty())
                .forEach(v -> System.out.println(v.getKey().label + " is connected with " + v.getValue()));
    }

    private Node getNodeByName(String to) {
        Optional<Node> toNodeFromGraph = vertices.keySet().stream().filter(n -> n.equals(new Node(to))).findFirst();
        if (!toNodeFromGraph.isPresent()) {
            throw new IllegalArgumentException("To node not found.");
        }
        return toNodeFromGraph.get();
    }

    private List<Node> getNeighbours(String from) {
        List<Node> fromNodeNeighbours = vertices.get(new Node(from));
        if (fromNodeNeighbours == null) {
            throw new IllegalArgumentException("From node not found.");
        }
        return fromNodeNeighbours;
    }

    public void traverseDepthFirst(String label) {
        Node node = new Node(label);
        if(!vertices.containsKey(node)) {
            return;
        }
        traverseDepthFirstIterative(node);
    }

    public void traverseBreadthFirst(String label) {
        Node node = new Node(label);
        if(!vertices.containsKey(node)) {
            return;
        }
        traverseBreadthFirstIterative(node);
    }

    private void traverseDepthFirstRecursive(Node node, Set<Node> visited) {
        System.out.println(node.label);
        visited.add(node);
        List<Node> neighbours = vertices.get(node);
        if(neighbours==null) {
            return;
        }
        neighbours.stream()
                .filter(v -> !visited.contains(v))
                .forEach(v -> traverseDepthFirstRecursive(v, visited));
    }

    private void traverseDepthFirstIterative(Node node) {
        Set<Node> visited = new HashSet<>();
        Stack<Node> nodesToVisit = new Stack<>();
        nodesToVisit.add(node);
        while(!nodesToVisit.isEmpty()) {
            Node node1 = nodesToVisit.pop();
            if(visited.contains(node1)) {
                continue;
            }

            System.out.println(node1.label);
            visited.add(node1);
            List<Node> neighbours = vertices.get(node1);
            if(neighbours!=null) {
                for(Node neighbour: neighbours) {
                    if(!visited.contains(neighbour)) {
                        nodesToVisit.push(neighbour);
                    }
                }
            }
        }

    }

    private void traverseBreadthFirstIterative(Node node) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> nodesToVisit = new LinkedList<>();
        nodesToVisit.add(node);
        while(!nodesToVisit.isEmpty()) {
            Node node1 = nodesToVisit.poll();
            if(visited.contains(node1)) {
                continue;
            }

            System.out.println(node1.label);
            visited.add(node1);
            List<Node> neighbours = vertices.get(node1);
            if(neighbours!=null) {
                for(Node neighbour: neighbours) {
                    if(!visited.contains(neighbour)) {
                        nodesToVisit.add(neighbour);
                    }
                }
            }
        }
    }


    private static void topologicalSortDemo() {
        Graph g = new Graph();
        g.addNode("A");
        g.addNode("B");
        g.addNode("C");
        g.addNode("D");
        g.addNode("E");
        g.addEdge("A","B");
        g.addEdge("A","C");
        g.addEdge("B","D");
        g.addEdge("C","D");
        g.addEdge("D","E");
        System.out.println(g.topologicalSort());
    }

    private List<String> topologicalSort() {
        Stack<Node> reverseResult = new Stack<>();
        Set<Node> visited = new HashSet<>();
        for(Node node: vertices.keySet()) {
            topologicalSort(node,reverseResult,visited);
        }
        return stackToList(reverseResult);
    }

    private void topologicalSort(Node node, Stack<Node> reveresResult, Set<Node> visited) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        List<Node> children = vertices.get(node);
        children.forEach(child->topologicalSort(child,reveresResult,visited));
        reveresResult.push(node);

    }

    private List<String> stackToList(Stack<Node> in) {
        List<String> out = new ArrayList<>();
        while(!in.isEmpty()) {
            out.add(in.pop().label);
        }
        return out;
    }

    public static void main(String[] args) {
//        myTests();
//        graphTraversal();
//        topologicalSortDemo();
         hasCycleDemo();
    }

    private static void hasCycleDemo() {
        Graph g = new Graph();
        g.addNode("A");
        g.addNode("B");
        g.addNode("C");
        g.addNode("D");
        g.addNode("E");
        g.addNode("F");

        g.addEdge("A","B");
        g.addEdge("A","B");
        g.addEdge("B","C");
        g.addEdge("B","D");
        g.addEdge("E","D");
        g.addEdge("E","C");
        g.addEdge("E","F");

        System.out.println(g.hasCycle());
    }

    private boolean hasCycle() {
        Set<Node> all = vertices.keySet();

        HashSet<Node> visiting = new HashSet<>();
        HashSet<Node> visited = new HashSet<>();
        for(Node current: all) {
            if(hasCycle(current, visiting, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(Node node, HashSet<Node> visiting, HashSet<Node> visited) {
        visiting.add(node);

        for (Node child: vertices.get(node)) {
            if(visited.contains(child)) {
                continue;
            }
            if(visiting.contains(child)) {
                return true;
            }
            if(hasCycle(child, visiting, visited)) {
                return true;
            }
        }
        visiting.remove(node);
        visited.add(node);
        return false;
    }

    private static void graphTraversal() {
        Graph g = new Graph();
        g.addNode("A");
        g.addNode("B");
        g.addNode("C");
        g.addNode("D");

        g.addEdge("A","B");
        g.addEdge("A","C");
        g.addEdge("B","D");
        g.addEdge("D","C");
//        g.addEdge("D","A");//adds cycle to graph

//        g.traverseDepthFirst("A");//preorder: A B D C; postorder: C D B A
//        g.traverseBreadthFirst("A");
    }

    private static void myTests() {
        Graph g = new Graph();
        g.addNode("A");
        g.addNode("B");
        g.addNode("C");
        g.addNode("D");
        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "A");
//        g.print();
//        System.out.println("Remove node C");
//        g.removeNode("C");
//        g.print();
//        System.out.println("Remove edge from A to B");
//        g.removeEdge("A", "B");
//        g.print();

        g.traverseDepthFirst("A");
        System.out.println();
        g.traverseDepthFirst("B");
        g.traverseDepthFirst("C");
        g.traverseDepthFirst("D");
        g.traverseDepthFirst("F");
    }
}
