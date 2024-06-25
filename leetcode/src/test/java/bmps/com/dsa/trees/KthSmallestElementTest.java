package bmps.com.dsa.trees;

import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthSmallestElementTest {

    @Test
    void kthSmallestElement() {

        KthSmallestElement kthSmallestElement = new KthSmallestElement();
        TreeNode<Integer> root = new TreeNode<>(3);
        root.left = new TreeNode<>(1);
        root.left.right = new TreeNode<>(2);
        root.right = new TreeNode<>(4);


        var res = kthSmallestElement.kthSmallestElement(root, 1);

        assertEquals(1, res);
    }

    @Test
    void kthSmallestElement2() {
        KthSmallestElement kthSmallestElement = new KthSmallestElement();
        TreeNode<Integer> root = new TreeNode<>(5);
        root.right = new TreeNode<>(5);
        root.left = new TreeNode<>(3);
        root.left.right = new TreeNode<>(4);
        root.left.left = new TreeNode<>(2);
        root.left.left.left = new TreeNode<>(1);

        var res = kthSmallestElement.kthSmallestElement(root, 3);

        assertEquals(3, res);
    }


    @Test
    void kthSmallestElement_right_subtree() {
        KthSmallestElement kthSmallestElement = new KthSmallestElement();
        TreeNode<Integer> root = new TreeNode<>(5);
        root.right = new TreeNode<>(7);
        root.left = new TreeNode<>(3);
        root.left.right = new TreeNode<>(1);
        root.left.left = new TreeNode<>(4);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(9);

        var res = kthSmallestElement.kthSmallestElement(root, 6);

        assertEquals(7, res);
    }
}