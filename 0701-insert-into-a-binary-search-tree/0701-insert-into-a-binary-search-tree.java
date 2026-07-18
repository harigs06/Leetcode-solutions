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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        TreeNode keyNode = new TreeNode(val);
        if(root == null) return keyNode;
        TreeNode dummy = root;
        TreeNode dummy2 = null;
        while(dummy != null){
            dummy2 = dummy;

            if(dummy.val < val){
                dummy = dummy.right;
            }else{
                dummy = dummy.left;
            }
        }

        if(dummy2.val < val){
            dummy2.right = keyNode;
        }else{
            dummy2.left = keyNode;
        }

        return root;
    }
}