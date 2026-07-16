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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer , Integer> map = new HashMap<>();

        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i] , i);
        }

        return buildTreee(inorder , 0 , inorder.length-1 , postorder , 0 , postorder.length -1 , map);
        
    }

    TreeNode buildTreee(int[] inorder , int ins , int ine , int[] postorder , int poss , int pose , Map<Integer , Integer> map){
        if(poss > pose || ins > ine) return null;

        TreeNode root = new TreeNode(postorder[pose]);

        int rootnum = map.get(root.val);
        int numsleft = rootnum-ins;

        root.left = buildTreee(inorder , ins , rootnum-1 , postorder , poss , poss+numsleft-1 , map);


        root.right = buildTreee(inorder , rootnum+1 , ine , postorder , poss+numsleft , pose-1 , map);

        return root;
    }
}