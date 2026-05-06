class Solution{//list用size
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        return dfs(nums, res, path, 0);

    }

    public List<List<Integer>> dfs(int[] nums, List<List<Integer>> res, List<Integer> path, int idx){
        res.add(new ArrayList<>(path));
        for(int i = idx; i < nums.length; i++){
            path.add(nums[i]);
            dfs(nums, res, path, i+1);
            path.remove(path.size() - 1);
        }
        return res;
    }
}