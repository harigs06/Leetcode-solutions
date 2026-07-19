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

    List<Integer> inorder = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        traversal(root);
        return inorder.get(k-1);
    }

    void traversal(TreeNode root){
        if(root == null) return;

        traversal(root.left);
        inorder.add(root.val);
        traversal(root.right);
    }
}