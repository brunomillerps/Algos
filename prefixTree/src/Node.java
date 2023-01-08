package prefixTree.src;

import java.util.HashMap;
import java.util.Map;

class Node {
    private Map<Character, Node> children = new HashMap<>();
    private boolean endOfWord;
    private final char character;
    
    public Node(Map<Character, Node> children, boolean endOfWord, char character) {
        this.children = children;
        this.endOfWord = endOfWord;
        this.character = character;
    }

    public Node(char character) {
        this.character = character;
    }
    
    public char getCharacter() {
        return character;
    }
    public Map<Character, Node> getChildren() {
        return children;
    }
    public void setChildren(Map<Character, Node> children) {
        this.children = children;
    }
    public boolean isEndOfWord() {
        return endOfWord;
    }
    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}
