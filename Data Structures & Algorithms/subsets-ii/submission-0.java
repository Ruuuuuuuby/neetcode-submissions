class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, res, path, 0);
        return res;
        
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, int idx){
        res.add(new ArrayList<>(path));
        for(int i = idx; i< nums.length; i++){
            if(i > idx && nums[i] == nums[i - 1]){
                continue;
            }
            path.add(nums[i]);
            dfs(nums, res, path, i + 1);
            path.remove(path.size() - 1);

        }
    }
}
