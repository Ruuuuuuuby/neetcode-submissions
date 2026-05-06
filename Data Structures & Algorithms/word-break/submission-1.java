// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         int n = s.length();
//         boolean[] dp = new boolean[n + 1];//dp[i] means the first n chars can be segmented or not
//         dp[0] = true;//!!!!!!
//         HashSet<String> hs = new HashSet<>(wordDict);
//         for(int i = 1; i <= n; i++){
//             for(int j = 0; j < i; j++){
//                 if(dp[j] && hs.contains(s.substring(j, i))){
//                     dp[i] = true;
//                     break;//just need to find one

//                 }
//             }
//         }
//         return dp[n];
//     }
// }

class Solution{
    public boolean wordBreak(String s, List<String> wordDict){
        int n = s.length();
        HashSet<String> hs = new HashSet<>(wordDict);
        if(n == 0){
            return true;
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int j = 1; j <= n; j++){
            for(int i = 0; i < j; i++){
                if(dp[i] && hs.contains(s.substring(i, j))){
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[n];

    }
}
