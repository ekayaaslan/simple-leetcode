// https://leetcode.com/problems/kth-smallest-element-in-a-bst
// LC230. Kth Smallest Element in a BST
// Linear time, linear extra-space.
class KthSmallestElementInABST {
    int size(TreeNode root) {
        if (root == null) { return 0; }
        return size(root.left) + 1 + size(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        int leftSize = size(root.left);
        if (leftSize == k-1) {
            return root.val;
        }
        if (leftSize < k-1) {
            return kthSmallest(root.right, k-leftSize-1);
        }
        return kthSmallest(root.left, k);
    }
}
