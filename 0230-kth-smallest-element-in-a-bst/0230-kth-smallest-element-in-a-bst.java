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

    public int kthSmallest(TreeNode root, int k) {

        TreeNode curr= root;
        int cnt = 0 ;
        while(curr != null){
            if(curr.left == null){
                if(cnt == k-1)return curr.val;
                cnt ++;

                curr = curr.right;
            }else{
                TreeNode pre = curr.left;
                while(pre.right != null && pre.right != curr){
                    pre = pre.right;
                }

                if(pre.right == null){
                    pre.right = curr;
                    curr = curr.left;
                }else{
                    pre.right = null;
                    if(cnt == k-1)return curr.val;
                    cnt ++;
                    curr = curr.right;
                }
            }

        }
            return -1;

    }

   
}