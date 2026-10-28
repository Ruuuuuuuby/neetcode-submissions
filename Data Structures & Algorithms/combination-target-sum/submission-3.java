// class Solution {
//     public List<List<Integer>> combinationSum(int[] nums, int target) {
//         List<List<Integer>> res = new ArrayList<>();
//         List<Integer> path = new ArrayList<>();
//         dfs(nums, target, res, path, 0);
//         return res;
        
//     }
    
//     public void dfs(int[] nums, int target, List<List<Integer>> res, List<Integer> path, int idx){
//         if(target == 0){
//             res.add(new ArrayList<>(path));
//             return;
//         }
//         if(target < 0){
//             return;
//         }
//         for(int i = idx; i < nums.length; i++){//path add/remove
//             path.add(nums[i]);
//             dfs(nums, target - nums[i], res, path, i);
//             path.remove(path.size() - 1);
//         }
//     }
// }

//如果不提前剪枝(break when nums[i] > left)就不用arrays.sort()

class Solution{
    public List<List<Integer>> combinationSum(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);//！！！！！！！
        dfs(nums, target, path, res, 0);
        return res;
    }
    public void dfs(int[] nums, int left, List<Integer> path, List<List<Integer>> res, int idx){
        if(left == 0){
            res.add(new ArrayList<>(path));
            return;//more efficient
        }
        if(left < 0){
            return;//不sort不能提前break就必须在dfs里处理left<0的情况
        }
        for(int i = idx; i < nums.length; i++){
            if(nums[i] > left){
                break;
            }//提前剪枝不会有dfs后target<0情况了
            path.add(nums[i]);
            dfs(nums, left - nums[i], path, res, i);//用i是因为可以重复用一个element
            path.remove(path.size() - 1);
        }
    }
}

