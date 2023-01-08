package prefixTree.src;

import java.util.List;
import java.util.Map;

public class Trie implements Tree {
    private final Node root;

    public Trie() {
        this.root = new Node(' ');
    }

    /*
     * insert -> like
     * 
     * ' '
     */
    @Override
    public Tree insert(String word) {
        Node currNode = root;
        Map<Character, Node> children = root.getChildren();

        for (char c : word.toCharArray()) {
            if (children.containsKey(c)) {
                currNode = children.get(c);
            } else {
                currNode = new Node(c);
                children.put(c, currNode);    
            }
            children = currNode.getChildren();
        }

        currNode.setEndOfWord(true);
        return this;
    }

    @Override
    public boolean contains(String word) {
        var foundWord = search(word);
        return foundWord != null && foundWord.isEndOfWord();
    }

    private Node search(String word) {
        Node currentNode = root;
        Map<Character, Node> children = root.getChildren();

        for (char c : word.toCharArray()) {
            if (!children.containsKey(c)) {
                return null;
            }

            currentNode = children.get(c);
            children = currentNode.getChildren();
        }

        return currentNode;
    }
    @Override
    public boolean containsPrefix(String prefix) {
        var foundWordPrefix = search(prefix);
        return foundWordPrefix != null;
    }

    @Override
    public void delete(String word) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<String> wordsWithPrefix(String prefix) {
        // TODO Auto-generated method stub
        return null;
    }

}
