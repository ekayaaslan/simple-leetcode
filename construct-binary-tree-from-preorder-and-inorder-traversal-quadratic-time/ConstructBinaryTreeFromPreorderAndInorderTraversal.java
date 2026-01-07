// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
// LC105. Construct Binary Tree From Preorder And Inorder Traversal
// Quadratic time, quadratic extra-space.
class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) { return null; }
        TreeNode root = new TreeNode(preorder[0]);
        for (int k=0; k<n; k++) {
            if (inorder[k] != root.val) { continue; }
            {
                int[] pre = new int[k];
                int[] in = new int[k];
                for (int i=0; i<k; i++) {
                    pre[i] = preorder[i+1];
                    in[i] = inorder[i];
                }
                root.left = buildTree(pre, in);
            }
            {
                int[] pre = new int[n-k-1];
                int[] in = new int[n-k-1];
                for (int i=0; i<n-k-1; i++) {
                    pre[i] = preorder[k+i+1];
                    in[i] = inorder[k+i+1];
                }                
                root.right = buildTree(pre, in);
            }            
            break;
        }
        return root;
    }
}
