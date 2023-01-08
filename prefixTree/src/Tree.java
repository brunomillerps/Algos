package prefixTree.src;

import java.util.List;

public interface Tree {

    Tree insert(String word);

    boolean contains(String word);

    boolean containsPrefix(String prefix);

    void delete(String word);

    List<String> wordsWithPrefix(String prefix);
}
