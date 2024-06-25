package bmps.com.dsa.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LowestCommonAncestorTest {

    @Test
    void lca() {

        LowestCommonAncestor lca = new LowestCommonAncestor();
        var root = lca.buildTree("4 2 3 1 7 6");
        var lcaResult = lca.lca(root, 1, 7);

        assertEquals(4, lcaResult.val);
    }
}