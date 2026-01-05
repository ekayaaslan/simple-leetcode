// https://leetcode.com/problems/validate-binary-search-tree
// LC98. Validate Binary Search Tree
// Linear time, linear extra-space.
class ValidateBinarySearchTree {
    boolean isValidBSTOnRange(TreeNode node, int start, int end) {
        if (node.val < start || node.val > end) { return false; }
        if (node.left != null) {
            if (node.val == Integer.MIN_VALUE) { return false; }
            if (!isValidBSTOnRange(node.left, start, node.val-1)) {
                return false;
            }
        }
        if (node.right != null) { 
            if (node.val == Integer.MAX_VALUE) { return false; }
            if (!isValidBSTOnRange(node.right, node.val+1, end)) {
                return false;
            }
        }
        return true;
    }
    public boolean isValidBST(TreeNode root) {
        if (root == null) { return true; }
        return isValidBSTOnRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
