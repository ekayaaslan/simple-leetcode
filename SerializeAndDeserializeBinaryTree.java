// https://leetcode.com/problems/serialize-and-deserialize-binary-tree
// LC297. Serialize and Deserialize Binary Tree
// Linear time, quadratic extra-space.
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) { return ""; }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return new String()
            + root.val + ","
            + left.length() + ","
            + right.length() + ":"
            + left + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) { return null; }
        String[] split = data.split(":", 2);
        String header = split[0];
        String children = split[1];
        String[] values = split[0].split(",");
        int val = Integer.parseInt(values[0]);
        int left = Integer.parseInt(values[1]);
        int right = Integer.parseInt(values[2]);
        TreeNode root = new TreeNode(val);
        root.left = deserialize(children.substring(0, left));
        root.right = deserialize(children.substring(left, left+right));
        return root;
    }
}
