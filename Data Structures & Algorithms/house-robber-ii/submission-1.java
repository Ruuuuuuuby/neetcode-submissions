// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if(n == 0) return 0;
//         if(n == 1){
//             return nums[0];
//         }
//         return Math.max(robRange(nums, 0, n - 2), (robRange(nums, 1, n - 1)));
//     }//either choose the first one or the last one

//     public int robRange(int[] nums, int start, int end){
//         int prev = 0; 
//         int curr = 0;
//         for(int i  = start; i <= end; i++){//update curr and prev
//             int temp = curr;
//             curr = Math.max(curr, prev + nums[i]);
//             prev = temp;
//         }
//         return curr;
//     }
// }

class Solution{
    public int rob(int[] nums){
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return nums[0];
        }
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }
    public int helper(int[] nums, int start, int end){
        int prev = 0;
        int cur = 0;
        for(int i = start; i <= end; i++){
            int temp = cur;
            cur = Math.max(prev + nums[i], cur);
            prev = temp;
        }
        return cur;
    }
}