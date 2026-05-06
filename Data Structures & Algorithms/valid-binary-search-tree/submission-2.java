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

// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return dfs(root, null, null);
        
//     }
//     public boolean dfs(TreeNode node, Integer min, Integer max){
//         if(node == null){
//             return true;
//         }
//         if((min != null && node.val <= min) || (max != null && node.val >= max)){
//             return false;
//         }
//         return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
//     }


// }

//O(N)每个节点访问一次， O(H)递归栈，H为树高
//min node.val max
// class Solution{
//     public boolean isValidBST(TreeNode root){
//         return dfs(root, null, null);
//     }
//     public boolean dfs(TreeNode root, Integer min, Integer max){
//         if(root == null){
//             return true;
//         }
//         if((min != null && root.val <= min) || (max != null && root.val >= max)){
//             return false;
//         }
//         return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
//     }
// }//Integer可以为Null




class Solution{
    public boolean isValidBST(TreeNode root){
        return dfs(root, null, null);
    }
    public boolean dfs(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }
        if((min != null && root.val <= min) || (max != null && root.val >= max)){
            return false;
        }
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
}
