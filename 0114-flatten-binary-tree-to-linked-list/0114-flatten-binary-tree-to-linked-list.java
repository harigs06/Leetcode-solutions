/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;

        List<TreeNode> traversal = new ArrayList<>();
        preorder(root , traversal);

        root.left = null;
        for(int i = 1; i < traversal.size() ; i++){
            TreeNode node = traversal.get(i);
            node.left = null;
            root.right = traversal.get(i);
            root = root.right;
        }
       
    }

    void preorder(TreeNode root , List<TreeNode> traversal){
        if(root == null) return ;

        traversal.add(root);
        preorder(root.left,traversal);
        preorder(root.right,traversal);

    }
}