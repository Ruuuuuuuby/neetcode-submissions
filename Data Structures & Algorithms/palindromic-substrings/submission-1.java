// class Solution {
//     public int countSubstrings(String s) {
//         int count = 0;
//         int n = s.length();
//         boolean[][] dp = new boolean[n][n];
//         for(int j = 0; j < n; j++){//j写在外层保证[i+1][j-1]已经被遍历过
//             for(int i = 0; i <= j; i++){
//                 if(s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i+1][j-1])){
//                     dp[i][j] = true;
//                     count++;
//                 }
//             }
//         }
//         return count;   
//     }
// }

class Solution {
    public int countSubstrings(String s) {
        int count = 0; 
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int j = 0; j < n; j++){
            for(int i = 0; i <= j; i++){
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
