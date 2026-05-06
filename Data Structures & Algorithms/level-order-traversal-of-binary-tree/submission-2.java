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
//     public List<List<Integer>> levelOrder(TreeNode root){
//         List<List<Integer>> res = new ArrayList<>();
//         if(root == null){
//             return res;
//         }
//         Queue<TreeNode> q = new LinkedList<>();//Queue,ArrayQueue
//         q.offer(root);
//         while(!q.isEmpty()){
//             int size = q.size();
//             List<Integer> list = new ArrayList<>();
//             while(size != 0){//得出当前层size
//                 TreeNode node = q.poll();
//                 list.add(node.val);
//                 if(node.left != null){
//                     q.offer(node.left);
//                 }
//                 if(node.right != null){
//                     q.offer(node.right);
//                 }
//                 size--;//-的是node的，size没有实时跟着++，q++了不为空但size的意思是当前层所有个数
//             }
//             res.add(list);     
//         }
//         return res;
//     }
// }


class Solution{
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList();
            while(size != 0){
                TreeNode cur = q.poll();
                list.add(cur.val);
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
                size--;
            }
            res.add(list);
        }
        return res;

    }
}
