package datastructures.tries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieWithHashMap {

    private Node root = new Node(' ');

    public void insert(String word) {
        if (!isValidWord(word)) {
            return;
        }
        Node iterator = root;
        for (char character : word.toLowerCase().toCharArray()) {
            iterator = iterator.insert(character);
        }

        iterator.setEndOfWord(true);
    }

    public void remove(String word) {
        remove(root, word, 0);
    }

    private void remove(Node node, String word, int index) {
        if (index == word.length()) {
            node.setEndOfWord(false);
            return;
        }
        Node childNode = node.getChild(word.charAt(index));
        if (childNode == null) {
            return;
        }

        remove(childNode, word, index + 1);

        if (!childNode.isEndOfWord() && childNode.getChildren().isEmpty()) {
            node.clearChild(word.charAt(index));
        }
    }

    private boolean isValidWord(String word) {
        return word != null && word.trim().length() > 0;
    }

    public boolean contains(String word) {
        if (!isValidWord(word)) {
            return false;
        }
        Node iterator = root;
        char[] characters = word.toCharArray();
        for (int i = 0; i < characters.length; ++i) {
            if (!iterator.contains(characters[i])) {
                return false;
            }
            iterator = iterator.getChild(characters[i]);
        }
        return iterator != null && iterator.isEndOfWord();
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        System.out.print(root.getValue());
        for (Node child : root.getChildren()) {
            traversePreOrder(child);
        }
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        for (Node child : root.getChildren()) {
            traversePostOrder(child);
        }
        System.out.print(root.getValue());
    }

    private List<String> autocomplete(String word) {
        List<String> words = new ArrayList<>();
        if(word == null) {
            return words;
        }

        Node node = root;
        String wordToAutocomplete = "";
        for(char ch: word.toCharArray()) {
            if(node.contains(ch)) {
                wordToAutocomplete += ch;
                node = node.getChild(ch);
            } else {
                node = null;
                break;
            }
        }

        autocomplete(node,wordToAutocomplete,words);

        return words;
    }

    private void autocomplete(Node root, String word, List<String> words) {
        if(root==null) {
            return;
        }
        if(root.isEndOfWord()) {
            words.add(word);
        }
        for(Node child: root.getChildren()) {
            autocomplete(child,word+child.getValue(),words);
        }
    }

    public static void main(String[] args) {
        TrieWithHashMap trie = new TrieWithHashMap();
        trie.insert("hello");
        trie.insert("hey");
        trie.insert("hej");
        trie.insert("tree");
        trie.insert("grass");
        trie.insert("green");
        trie.insert("cat");
//        System.out.println(trie.contains("green"));
//        System.out.println(trie.containsRecursive("green"));
//        System.out.println(trie.containsRecursive("greengos"));
//        System.out.println(trie.contains("gre"));
//        System.out.println(trie.contains("grow"));
//        System.out.println(trie.contains(""));
//        System.out.println(trie.contains(null));
//        System.out.println("FINISH part 1");
//        trie.traversePreOrder();
//        System.out.println();
//        trie.traversePostOrder();
//
//        System.out.println();
//        System.out.println(trie.contains("hello"));
//        trie.remove("hello");
//        System.out.println(trie.contains("hello"));
//        System.out.println(trie.contains("hey"));
//        System.out.println(trie.contains("hej"));

//        System.out.println(trie.autocomplete(null));
//        System.out.println(trie.countWords());

    }

    private int countWords() {
        return countWords(root);
    }

    public String longestCommonPrefiX(String first, String second) {
        char[] firstCharacters = first.toCharArray();
        char[] secondCharacters = second.toCharArray();
        Node iterator = root;
        String result = "";

        this.insert(first);
        this.insert(second);
        while (iterator.getChildren().size()==1 && !iterator.isEndOfWord()) {
            Node firstChild = iterator.getChildren().iterator().next();
            result += firstChild.getValue();
            iterator = firstChild;
        }

        return result;
    }

    private int countWords(Node root) {
        if(root.isEndOfWord()) {
            return 1;
        }
        int result = 0;
        for(Node child: root.getChildren()) {
            result += countWords(child);
        }
        return result;
    }

    private boolean containsRecursive(String word) {
        return containsRecursive(root,0,word);
    }

    private boolean containsRecursive(Node root, int i, String word) {
        if(i<word.length() && root.getChild(word.charAt(i))!=null) {
            return containsRecursive(root.getChild(word.charAt(i)),i+1,word);
        }
        return i==word.length() && root.isEndOfWord();
    }

}

class Node {
    private char value;
    private Map<Character, Node> children = new HashMap<>();
    private boolean isEndOfWord;

    public Node(char value) {
        this.value = value;
    }

    public Node insert(Character character) {
        children.putIfAbsent(character, new Node(character));
        return children.get(character);
    }

    public boolean contains(Character character) {
        return children.containsKey(character);
    }

    public char getValue() {
        return value;
    }

    public Collection<Node> getChildren() {
        return children.values();
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

    @Override
    public String toString() {
        return "value=" + value;
    }

    public Node getChild(char character) {
        return children.get(character);
    }

    public void clearChild(char character) {
        children.remove(character);
    }

}


