class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);//便于后续去重！！！！！
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates, target, path, res, 0);
        return res;
    }
    public void dfs(int[] candidates, int target, List<Integer> path, List<List<Integer>> res, int idx){
        
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(target < 0){
            return;
        }
        if(target > 0){
            for(int i = idx; i < candidates.length; i++){
                if(i > idx && candidates[i] == candidates[i - 1]){
                continue;
                }
                path.add(candidates[i]);
                dfs(candidates, target - candidates[i], path, res, i + 1);
                path.remove(path.size()-1);
            }
            
        }
        
    }

}
