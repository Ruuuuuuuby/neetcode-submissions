class Solution {//temp!!!!
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxP = nums[0];
        int minP = nums[0];
        int res = nums[0];
        for(int i = 1; i < n; i++){
            int tempMax = maxP;
            int tempMin = minP;
            maxP = Math.max(nums[i], Math.max(tempMin * nums[i], tempMax * nums[i]));
            minP = Math.min(nums[i], Math.min(tempMin * nums[i], tempMax * nums[i]));
            res = Math.max(res, maxP);
        }
        return res;
        
    }
}
