/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        serializeHelper(root, sb);
        return sb.toString();
    }

    public void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }

        sb.append(node.val+ ",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        int[] idx = {0};
        return deserializeHelper(arr, idx);
    }

    public TreeNode deserializeHelper (String[] data, int[] idx) {
        if (idx[0] >= data.length || data[idx[0]].equals("null")){
            idx[0] ++;
            return null;
        }

        TreeNode node = new TreeNode (Integer.parseInt(data[idx[0]++]));

        node.left = deserializeHelper(data, idx);
        node.right = deserializeHelper(data, idx);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
