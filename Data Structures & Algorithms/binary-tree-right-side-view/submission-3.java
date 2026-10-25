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


//queue法也可以 只存size-1的值
// class Solution{
//     public List<Integer> rightSideView(TreeNode root){
//         List<Integer> res = new ArrayList<>();
//         dfs(root, 0, res);
//         return res;
//     }
//     public void dfs(TreeNode root, int depth, List<Integer> res){
//         if(root == null){
//             return;
//         }
//         if(depth == res.size()){
//             res.add(root.val);
//         }
//         dfs(root.right, depth + 1, res);//先走右边 保证第一个值就是最右
//         dfs(root.left, depth + 1,res);
//     }
// }

class Solution{
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
                if(i == size - 1){
                    res.add(node.val);
                }
            }
        }
        return res;
    //     dfs(res, root, 0);
    //     return res;
    // }
    // public void dfs(List<Integer> res, TreeNode root, int depth){
    //     if(root == null){
    //         return;
    //     }
    //     if(depth == res.size()){
    //         res.add(root.val);
    //     }
    //     dfs(res, root.right, depth + 1);
    //     dfs(res, root.left, depth + 1);
    }
}
