package bmps.com.trees;

public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(6);

        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(1);

        System.out.println(invertTree(root));

        /*
        expected
        TreeNode{val=4,
                    left = TreeNode{val=7,
                                        left=TreeNode{val=9, left=null, right=null},
                                        right=TreeNode{val=6, left=null, right=null}},
                    right= TreeNode{val=2,
                                        left=TreeNode{val=3, left=null, right=null},
                                        right=TreeNode{val=1, left=null, right=null}}}
         */

    }

    private static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
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
}

