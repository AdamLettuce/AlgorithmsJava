package datastructures.tries;

public class TrieWithArray {
    public static final int ALPHABET_SIZE = 26;

    private Node root = new Node();

    public void insert(String word) {
        if(word==null || word.trim().length() == 0) {
            return;
        }
        Node iterator = root;

        for(char character: word.toLowerCase().toCharArray()) {
            int index = character - 'a';
           if(iterator.children[index]==null) {
                iterator.children[index] = new Node(character);
            }
            iterator = iterator.children[index];
        }

        iterator.isEndOfWord = true;
    }

    class Node {
        private char value;
        private Node[] children = new Node[ALPHABET_SIZE];
        private boolean isEndOfWord;

        public Node() {}

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    public static void main(String[] args) {
        TrieWithArray trie = new TrieWithArray();
        trie.insert("hello");
        trie.insert("hey");
        trie.insert("hej");
        trie.insert("tree");
        trie.insert("grass");
        trie.insert("green");
        System.out.println("FINISH");
    }
}


