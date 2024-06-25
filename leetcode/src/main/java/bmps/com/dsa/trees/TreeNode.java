package bmps.com.dsa.trees;

public class TreeNode<T> {

    T val;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
