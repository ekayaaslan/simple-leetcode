// https://leetcode.com/problems/maximum-depth-of-binary-tree
// LC104. Maximum Depth of Binary Tree
// Linear time, constant extra-space.
class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) { return 0; }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
