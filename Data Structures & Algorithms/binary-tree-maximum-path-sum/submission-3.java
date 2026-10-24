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



// class Solution{
//     int maxSum = Integer.MIN_VALUE;
//     public int maxPathSum(TreeNode root){
//         calculate(root);
//         return maxSum;
//     }

//     public int calculate(TreeNode root){//单边最大贡献值
//         if(root == null){
//             return 0;
//         }
//         int leftGain = Math.max(0, calculate(root.left));
//         int rightGain = Math.max(0, calculate(root.right));
//         maxSum = Math.max(maxSum, leftGain + root.val + rightGain);
//         return Math.max(leftGain, rightGain) + root.val;   
//     }
// }


// class Solution{
//     int maxLength = Integer.MIN_VALUE;
//     public int maxPathSum(TreeNode root){
//         calculate(root);
//         return maxLength;
//     }
//     public int calculate(TreeNode root){
//         if(root == null){
//             return 0;
//         }
//         int leftGain = Math.max(0, calculate(root.left));
//         int rightGain = Math.max(0, calculate(root.right));
//         maxLength = Math.max(maxLength, leftGain + rightGain + root.val);
//         return Math.max(leftGain, rightGain) + root.val;
//     }
    
// }


class Solution{
    int maxLen = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        dfs(root);
        return maxLen;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftGain = Math.max(0, dfs(root.left));
        int rightGain = Math.max(0, dfs(root.right));
        maxLen = Math.max(maxLen, root.val + leftGain + rightGain);
        return root.val + Math.max(leftGain, rightGain);//作为dfs的return只能选一边 不然会有支路（想走完就要重复走某个node）
    }
}
