class Solution {
    public int numDistinct(String s, String t) {//dp[i][j] 表示：s的前i个字符，有多少种删除方式可以拼出t的前j个字符。
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            dp[i][0] = 1;//前m个字符要删为0个字符只有删光1种方式
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];  
    }
}
