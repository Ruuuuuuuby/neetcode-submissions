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



class Solution{
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root){
        getDepth(root);
        return maxDiameter;
    }
    public int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        int depth = Math.max(leftDepth, rightDepth) + 1;
        return depth;
    }
}



