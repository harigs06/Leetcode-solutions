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

        if(root == null)return "";
        StringBuilder s = new StringBuilder("");

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        

        while(!q.isEmpty()){

            TreeNode current = q.poll();

            if(current != null){
                s.append(current.val).append(",");

                q.offer(current.left);

                q.offer(current.right);
            }else{
                s.append("#,");
            }
        }

        return s.toString();



    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;

        String[] values = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        int i = 1;

        q.offer(root);

        while(!q.isEmpty() && i < values.length){
            TreeNode node = q.poll();

            if(!values[i].equals("#")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(values[i]));
                node.left = leftNode;
                q.offer(node.left);
            }
            i++;
            if(!values[i].equals("#")){
                node.right = new TreeNode(Integer.parseInt(values[i]));
                q.offer(node.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));