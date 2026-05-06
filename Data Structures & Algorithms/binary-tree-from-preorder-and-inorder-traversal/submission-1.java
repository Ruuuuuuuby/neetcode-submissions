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
    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder == null || inorder == null || preorder.length != inorder.length){
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    public TreeNode helper(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, HashMap<Integer, Integer> map){
        if(preR < preL || inR < inL){
            return null;
        }
        int rootVal = preorder[preL];
        int rootInd = map.get(rootVal);
        int leftSize = rootInd - inL;
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, preL + 1, preL + leftSize, inorder, inL, rootInd - 1, map);
        root.right = helper(preorder, preL + leftSize + 1, preR, inorder, rootInd + 1, inR, map);
        return root;
    }
}
