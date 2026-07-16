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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer , Integer> map = new HashMap<>();

        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i] , i);
        }

        return buildTree(preorder , 0 , preorder.length-1, inorder , 0 , inorder.length-1 , map);
        
    }
    TreeNode buildTree(int[] preorder , int prestart , int preend ,int[] inorder , int instart , int inend , Map<Integer , Integer> inmap){

        if(prestart > preend || instart > inend) return null;

        TreeNode root = new TreeNode(preorder[prestart]);

        int innum = inmap.get(root.val);
        int numsleft = innum - instart;


        root.left = buildTree(preorder , prestart+1 , prestart+numsleft , inorder , instart,innum-1 , inmap);
        root.right = buildTree(preorder , prestart+numsleft+1 , preend , inorder , innum+1 , inend , inmap );

        return root;

    }
}