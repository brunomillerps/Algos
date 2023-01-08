package prefixTree.src;

public class Main {
    public static void main(String[] args) {
        var trie = new Trie();

        var res = trie
                .insert("life")
                .insert("live")
                .insert("light");

        System.out.println(res.contains("life"));
        System.out.println(res.contains("live"));
        System.out.println(res.contains("lite"));
        
        System.out.println(res.containsPrefix("li"));

    
    }
}
