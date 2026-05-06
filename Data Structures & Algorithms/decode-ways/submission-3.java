// class Solution {
//     public int numDecodings(String s) {
//         int n = s.length();
//         if(n == 0){
//             return 0;
//         }
//         int[] dp = new int[n + 1];
//         dp[0] = 1;//代表前i个字符有几种组合方式
//         if (s.charAt(0) == '0'){
//             return 0;
//         }
//         for(int i = 1; i <= n; i++){
//             if(s.charAt(i - 1) != '0'){
//                 dp[i] += dp[i - 1];
//             }
//             if(i >= 2){
//                 int two = Integer.parseInt(s.substring(i - 2, i));
//                 if(two >= 10 && two <= 26){
//                     dp[i] += dp[i - 2];
//                 }
//             }
//         }
//         return dp[n];
//     }
// }
class Solution{
    public int numDecodings(String s){
        int n = s.length();
        int[] dp = new int[n + 1];
        if(n == 0){
            return 0;
        }
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            if(s.charAt(i - 1) != '0'){
                dp[i] += dp[i - 1];
            }
            if(i >= 2){
                int two = Integer.parseInt(s.substring(i - 2, i));
                if(10 <= two && two <= 26){
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[n];
    }
}
