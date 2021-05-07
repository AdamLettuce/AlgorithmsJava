package datastructures.trees;

public class AVLTree {
    private static class AVLNode {
        int value;
        int height;
        AVLNode left;
        AVLNode right;


        public AVLNode(int value) {
            this.value = value;
        }
    }

    private AVLNode root;
    private int count = 0;

    public void insert(int value) {
        root = insert(root, value);
        ++count;
    }

    private AVLNode insert(AVLNode node, int value) {
        if (node == null) {
            return new AVLNode(value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        }
        if (value > node.value) {
            node.right = insert(node.right, value);
        }
        node.height = calculateHeight(node);

        return balance(node);
    }

    private AVLNode balance(AVLNode node) {
        if (isLeftHeavey(node)) {
            int balanceFactorLeftChild = balanceFactor(node.left);
            if (balanceFactorLeftChild > 0) {
                return rotateRight(node);
            } else if (balanceFactorLeftChild < 0) {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        } else if (isRightHeavy(node)) {
            int balanceFactorRightChild = balanceFactor(node.right);
            if (balanceFactorRightChild < 0) {
                return rotateLeft(node);
            } else if (balanceFactorRightChild > 0) {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }
        return node;
    }

    private AVLNode rotateRight(AVLNode node) {
        AVLNode leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        node.height = calculateHeight(node);
        return leftChild;
    }

    private AVLNode rotateLeft(AVLNode node) {
        AVLNode rightChild = node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        node.height = calculateHeight(node);
        return rightChild;
    }

    private int calculateHeight(AVLNode node) {
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    private boolean isLeftHeavey(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private int height(AVLNode node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    //exercises
    private boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(AVLNode node) {
        if(node==null) {
            return true;
        }
        return Math.abs(balanceFactor(node)) <=1
                && isBalanced(node.left)
                && isBalanced(node.right);
    }

    private boolean isPerfect() {
        if (root == null) {
            return true;
        }
        return isPerfect(root);
    }

    private boolean isPerfect(AVLNode node) {
        int height = calculateHeight(node);
        return Math.pow(2, height + 1) - 1 == count;
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(20);//         20 - this would be root of not AVL tree....
        tree.insert(10);//    10        30
        tree.insert(15);//       15         40
        tree.insert(30);//                      50
        tree.insert(40);//                          51
        tree.insert(50);//
        tree.insert(51);//
        System.out.println(tree.isBalanced());
        System.out.println(tree.isPerfect());
        System.out.println();
    }

}
