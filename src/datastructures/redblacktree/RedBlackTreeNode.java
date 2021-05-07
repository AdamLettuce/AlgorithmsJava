package datastructures.redblacktree;

public class RedBlackTreeNode {
    private RedBlackTreeNode left;
    private RedBlackTreeNode right;
    private boolean color;
    private int key;
    private String value;

    RedBlackTreeNode(int key, String value) {
        this.key = key;
        this.value = value;
    }

    RedBlackTreeNode rotateLeft(RedBlackTreeNode h) {
        RedBlackTreeNode x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = true;
        return x;
    }

    RedBlackTreeNode rotateRight(RedBlackTreeNode h) {
        RedBlackTreeNode x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = true;
        return x;
    }
}
