package datastructures.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Tree {
    public void swapRoot() {
        int x = root.rightChild.value;
        root.rightChild.value = root.value;
        root.value = x;
    }

    private static class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object other) {
            if(this==other) {
                return true;
            }
            if(!(other instanceof Node)) {
                return false;
            }
            return value == ((Node)other).value;
        }
    }

    private Node root;

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

        public List<Integer> postorderTraversal() {
            List<Integer> r = new ArrayList<>();
            Stack<Node> s = new Stack<>();
            Set<Node> v = new HashSet<>();

            Node n = root;

            while(n!=null || !s.isEmpty()) {
                while(n!=null && !v.contains(n)) { s.push(n); n = n.leftChild; }
                n = s.peek();
                n = n.rightChild;
                if(n!=null) { n =n.rightChild;}
                if(n==null) { n = s.pop(); v.add(n); r.add(n.value);}

            }



            return r;
        }


    public void insert(int value) {
        root = insert(value, root);
//                insertIterative(value,root);
    }

    private Node insert(int value, Node node) {
        if(node==null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.leftChild = insert(value,node.leftChild);
        }
        if (value > node.value) {
            node.rightChild = insert(value,node.rightChild);
        }
        return node;
    }

    private void insertIterative(int value, Node node) {
        if(root==null) {
            root = new Node(value);
            return;
        }

        Node newNode = new Node(value);
        while (true) {
            if (value < node.value && node.leftChild == null) {
                node.leftChild = newNode;
                break;
            }
            if (value < node.value) {
                node = node.leftChild;
            }
            if (value > node.value && node.rightChild == null) {
                node.rightChild = newNode;
                break;
            }
            if (value > node.value) {
                node = node.rightChild;
            }
        }
    }

    public boolean find(int value) {
        return find(value,root);
//        return findIterative(value, root);
    }

    private boolean find(int value, Node node) {
        if (node != null && value < node.value) {
            return find(value, node.leftChild);
        } else if (node != null && value > node.value) {
            return find(value, node.rightChild);
        } else return node != null && value == node.value;
    }

    private boolean findIterative(int value, Node node) {
        while (node != null) {
            if (value < node.value) {
                node = node.leftChild;
            } else if (value > node.value) {
                node = node.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    public void preorder() {
        preorder(root);
    }

    public void preorder(Node node) {
        if(node == null) return;
        System.out.print(node.value+" ");
        preorder(node.leftChild);
        preorder(node.rightChild);
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node node) {
        if(node==null) return;
        inorder(node.leftChild);
        System.out.print(node.value + " ");
        inorder(node.rightChild);
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(Node node) {
        if(node==null) return;
        postorder(node.leftChild);
        postorder(node.rightChild);
        System.out.print(node.value + " ");
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if(node==null) return -1;
        return 1 + Math.max(height(node.leftChild),height(node.rightChild));
    }

    public int min() {
        return min(root);
    }

    private int min(Node node) {
        if(node==null) {
            throw new IllegalArgumentException();
        }
        if(node.rightChild==null && node.leftChild==null) {
            return node.value;
        }
        if(node.rightChild!=null && node.leftChild==null) {
            return Math.min(min(node.rightChild),node.value);
        }
        if(node.rightChild==null) {
            return Math.min(min(node.leftChild),node.value);
        }
        return Math.min(min(node.leftChild),min(node.rightChild));
    }

    public boolean areTheSame(Tree other) {
        if(other==this) {
            return true;
        }
        if(other==null) {
            return false;
        }
        return areTheSame(root,other.root);
    }

    private boolean areTheSame(Node node1, Node node2) {
        if (node1 != null && node2 != null) {
            return areTheSame(node1.leftChild, node2.leftChild)
                    && areTheSame(node1.rightChild, node2.rightChild)
                    && node1.equals(node2);
        }
        return node1==null && node2==null;
    }

    public boolean validate() {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validate(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if(node.value<min || node.value>max) {
            return false;
        }

        return validate(node.leftChild,min,node.value)
                && validate(node.rightChild,node.value,max);
    }


    public List<Integer> getNodesAtDistance(int k) {
        List<Integer> numbers = new ArrayList<>();
        getNodesAtDistance(k,root,numbers);
        return numbers;
    }

    private void getNodesAtDistance(int k, Node node, List<Integer> accumulator) {
        if(node==null) {
            return;
        }
        if(k==0) {
            accumulator.add(node.value);
            return;
        }
        getNodesAtDistance(k-1,node.leftChild, accumulator);
        getNodesAtDistance(k-1,node.rightChild, accumulator);
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if(root==null) {
            return 0;
        }
        return 1 + size(root.leftChild) + size(root.rightChild);
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node root) {
        if(root==null) {
            return 0;
        }
        if(root.leftChild == null && root.rightChild == null) {
            return 1;
        }
        return countLeaves(root.leftChild)+countLeaves(root.rightChild);
    }

    public boolean areSibling(int first, int second) {
        return areSibling(root,first,second);
    }

    private boolean areSibling(Node root, int first, int second) {
        if(root==null || root.leftChild == null || root.rightChild == null) {
            return false;
        }
        if((root.leftChild.value == first && root.rightChild.value == second)
        || (root.leftChild.value == second && root.rightChild.value == first)) {
            return true;
        }
        areSibling(root.leftChild, first, second);
        areSibling(root.rightChild, first, second);
        return false;
    }

    public Integer getAncestor(int x) {
        return getAncestor(root,x);
    }

    private Integer getAncestor(Node node, int x) {
        if(node==null) {
            return null;
        }
        if((node.leftChild != null && node.leftChild.value == x)
        || (node.rightChild != null && node.rightChild.value == x)) {
            return node.value;
        }
        if(node.leftChild!=null) {
            return getAncestor(node.leftChild, x);
        }
        if(node.rightChild!=null) {
            return getAncestor(node.rightChild, x);
        }
        return null;
    }
}
