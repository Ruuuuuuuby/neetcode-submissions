class Solution {//deleteCharAt
    String[] map = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }
        StringBuilder path = new StringBuilder();
        dfs(digits, res, path, 0);
        return res;
        
    }
    public void dfs(String digits, List<String> res, StringBuilder path, int idx){
        if(idx == digits.length()){
            res.add(path.toString());
            return;
        }
        String letters = map[digits.charAt(idx) - '0'];
        for(char c : letters.toCharArray()){
            path.append(c);
            dfs(digits, res, path, idx + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
