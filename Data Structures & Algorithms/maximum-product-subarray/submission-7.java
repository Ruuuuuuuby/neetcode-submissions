// class Solution {//temp!!!!
//     public int maxProduct(int[] nums) {
//         int n = nums.length;
//         int maxP = nums[0];
//         int minP = nums[0];
//         int res = nums[0];
//         for(int i = 1; i < n; i++){
//             int tempMax = maxP;
//             int tempMin = minP;
//             maxP = Math.max(nums[i], Math.max(tempMin * nums[i], tempMax * nums[i]));
//             minP = Math.min(nums[i], Math.min(tempMin * nums[i], tempMax * nums[i]));
//             res = Math.max(res, maxP);
//         }
//         return res;
        
//     }
// }

class Solution{
    public int maxProduct(int[] nums){
        int n = nums.length;
        int[] maxDp = new int[n];
        int[] minDp = new int[n];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        int res = nums[0];
        for(int i = 1; i < n; i++){
            maxDp[i] = Math.max(nums[i], Math.max(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]));
            minDp[i] = Math.min(nums[i], Math.min(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]));
            res = Math.max(maxDp[i], res);
        }
        return res;
    }
}
