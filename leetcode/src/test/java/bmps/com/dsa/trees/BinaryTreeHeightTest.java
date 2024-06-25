package bmps.com.dsa.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeHeightTest {

    @Test
    void getHeight() {
        BinaryTreeHeight binaryTreeHeight = new BinaryTreeHeight();
        var root = binaryTreeHeight.buildTree("3 5 2 1 4 6 7");

        int height = binaryTreeHeight.getHeight(root);
        assertEquals(3, height);
    }

    @Test
    void buildTree() {
        BinaryTreeHeight binaryTreeHeight = new BinaryTreeHeight();

        var root = binaryTreeHeight.buildTree("3 5 2 1 4 6 7");
        assertEquals(3, root.val);
        assertEquals(2, root.left.val);
        assertEquals(1, root.left.left.val);
        assertEquals(5, root.right.val);
        assertEquals(4, root.right.left.val);
        assertEquals(6, root.right.right.val);
        assertEquals(7, root.right.right.right.val);
    }
}