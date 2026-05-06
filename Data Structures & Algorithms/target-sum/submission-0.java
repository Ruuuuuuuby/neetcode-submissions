class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        if((sum + target ) % 2 != 0 || sum < Math.abs(target)){
            return 0;
        }
        int t = (sum + target) / 2;
        int n = nums.length;
        int[] dp = new int[t + 1];//should be target + 1 before
        dp[0] = 1;
        for(int num : nums){
            for(int i = t; i >= num; i--){
                dp[i] = dp[i] + dp[i - num];
            }

        }
        return dp[t];
        
        
    }
}
