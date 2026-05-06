class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            hs.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(hs.containsKey(diff) && hs.get(diff) != i){
                res[0] = i;
                res[1] = hs.get(diff);
                break;
            }
        }
        return res; 
    }
}
