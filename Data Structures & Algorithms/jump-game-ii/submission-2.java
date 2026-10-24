// class Solution {
//     public int jump(int[] nums) {
//         int end = 0;
//         int farthest = 0;
//         int jumps = 0;
//         for(int i = 0; i < nums.length - 1; i++){//length - 1！！
//             farthest = Math.max(farthest, i + nums[i]);
//             if(i == end){
//                 jumps++;//因为最后一格不需要考虑跳出去了就
//                 end = farthest;
//             }
//         }
//         return jumps;
//     }
// }
class Solution{
    public int jump(int[] nums){
        int curEnd = 0;
        int times = 0;
        int maxReach = 0;
        for(int i = 0; i < nums.length - 1; i++){
            maxReach = Math.max(maxReach, i + nums[i]);
            if(i == curEnd){
                times++;
                curEnd = maxReach;
            }
        }
        return times;
    }
}