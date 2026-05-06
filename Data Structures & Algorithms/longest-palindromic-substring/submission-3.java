// class Solution {
//     public String longestPalindrome(String s) {
//         int n = s.length();
//         boolean[][] dp = new boolean[n][n];
//         for(int i = 0; i < n; i++){
//             dp[i][i] = true;
//         }
//         int start = 0;
//         int maxLen = 1;
//         for(int j = 1; j < n; j++){//或者是j从0 - n-1，i从0到<=j
//             for(int i = 0; i < j; i++){
//                 if(s.charAt(i) == s.charAt(j)){
//                     if(j - i < 3){
//                         dp[i][j] = true;
//                     }
//                     else{
//                         dp[i][j] = dp[i + 1][j - 1];
//                     }
//                 }else{
//                     dp[i][j] = false;
//                 }
//                 if(dp[i][j] == true && j - i + 1 > maxLen){
//                     maxLen = j - i + 1;
//                     start = i;
//                 } 
//             }
//         }
//         return s.substring(start, start + maxLen);
//     }
// }

class Solution{
    public String longestPalindrome(String s){
        if(s == null || s.length() == 0){
            return "";
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // for(int i = 0; i < n; i++){
        //     dp[i][i] = true;
        // }
        int maxLen = 1;
        int start = 0;
        // for(int j = 1; j < n; j++){
        //     for(int i = 0; i < j; i++){
        //         if(s.charAt(i) == s.charAt(j)){
        //             if(j - i < 3){
        //                 dp[i][j] = true;
        //             }else{
        //                 dp[i][j] = dp[i + 1][j - 1];
        //             }
        //         }else{
        //             dp[i][j] = false;
        //         }
        //         if(dp[i][j] && j - i + 1 > maxLen){
        //             maxLen = j - i + 1;
        //             start = i;
        //         }
        //     }
        // }
        for(int j = 0; j < n; j++){//j写在外层保证[i+1][j-1]已经被遍历过
            for(int i = 0; i <= j; i++){
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    if(dp[i][j] && j - i + 1 > maxLen){
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
