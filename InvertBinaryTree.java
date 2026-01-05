// https://leetcode.com/problems/invert-binary-tree
// LC226. Invert Binary Tree
// Linear time, linear extra-space.
class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) { return null; }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
