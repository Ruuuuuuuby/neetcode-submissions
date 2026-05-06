// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if(n == 1){
//             return nums[0];
//         }
//         int prev1 = nums[0];
//         int prev2 = Math.max(nums[0], nums[1]);
//         for(int i = 2; i < n; i++){
//             int cur = Math.max(prev1 + nums[i], prev2);
//             prev1 = prev2;
//             prev2 = cur;
//         }
//         return prev2;
//     }
// }

class Solution{
    public int rob(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
