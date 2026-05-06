class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(s, res, path, 0);
        return res;
        
    }

    public void dfs(String s, List<List<String>> res, List<String> path, int idx){
        if(idx == s.length()){
            res.add(new ArrayList<>(path));
        }
        for(int i = idx; i < s.length(); i++){
            if(!isPalindrome(s, idx, i)){
                continue;
            }
            path.add(s.substring(idx, i+1));
            dfs(s, res, path, i+1);
            path.remove(path.size() - 1);
        }
    }

    public boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)){
                return false;
            }
        }
        return true;
    }
}
