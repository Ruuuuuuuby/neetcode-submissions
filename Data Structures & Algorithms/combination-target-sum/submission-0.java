class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, target, res, path, 0);
        return res;
        
    }
    
    public void dfs(int[] nums, int target, List<List<Integer>> res, List<Integer> path, int idx){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = idx; i < nums.length; i++){//path add/remove
            path.add(nums[i]);
            dfs(nums, target - nums[i], res, path, i);
            path.remove(path.size() - 1);
        }
        
    }
}
