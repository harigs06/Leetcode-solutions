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
    public int countNodes(TreeNode root) {

        if(root == null) return 0;

        int lefth = leftheight(root);
        int righth = rightheight(root);

        if(lefth == righth){
            return ((int)(Math.pow(2,lefth)))-1;
        }
        
        return countNodes(root.left)+countNodes(root.right)+1;
    }

    int leftheight(TreeNode node){
        if(node == null) return 0;

        return 1 + leftheight(node.left);
    }

        int rightheight(TreeNode node){
        if(node == null) return 0;

        return 1 + rightheight(node.right);
    }
}