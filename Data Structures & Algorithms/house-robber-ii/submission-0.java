class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        return Math.max(robRange(nums, 0, n - 2), (robRange(nums, 1, n - 1)));
    }

    public int robRange(int[] nums, int start, int end){
        int prev = 0; 
        int curr = 0;
        for(int i  = start; i <= end; i++){
            int temp = curr;
            curr = Math.max(curr, prev + nums[i]);
            prev = temp;
        }
        return curr;
    }
}
