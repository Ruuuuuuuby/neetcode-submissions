// class Solution{
//     public int[] twoSum(int[] nums, int target){
//         HashMap<Integer, Integer> hs = new HashMap<>();
//         for(int i = 0; i < nums.length; i++){
//             int diff = target - nums[i];
//             if(hs.containsKey(diff)){
//                 int j = hs.get(diff);
//                 return new int[]{j, i};
//             }
//             hs.put(nums[i], i);
//         }
//         return new int[0];
//     }     
// }

class Solution{
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                int j = map.get(diff);
                return new int[]{j, i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
