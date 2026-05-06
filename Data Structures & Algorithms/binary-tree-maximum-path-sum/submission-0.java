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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        calculate(root);
        return maxSum;
        
    }
    public int calculate(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftGain = Math.max(calculate(root.left), 0);
        int rightGain = Math.max(calculate(root.right), 0);
        int lmr = root.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, lmr);
        return root.val + Math.max(leftGain, rightGain);


    }
}
