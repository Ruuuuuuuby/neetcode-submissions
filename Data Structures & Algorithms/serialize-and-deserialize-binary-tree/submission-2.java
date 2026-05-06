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



class Codec{//append!!!!!!
    public String serialize(TreeNode root){
        if(root == null){
            return "";
        }
        StringBuilder sb= new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null){
                sb.append("null,");
            }else{
                sb.append(cur.val);
                sb.append(",");
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data){
        if(data == "" || data.length() == 0){
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        String[] array = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        q.offer(root);
        int i = 1;
        while(!q.isEmpty()){//i++ no matter what
            TreeNode cur = q.poll();
            if(!array[i].equals("null")){//use equals to compare string
                cur.left = new TreeNode(Integer.parseInt(array[i]));
                
                q.offer(cur.left);
            }
            i++;
            if(!array[i].equals("null")){
                cur.right = new TreeNode(Integer.parseInt(array[i]));
                
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }
}
