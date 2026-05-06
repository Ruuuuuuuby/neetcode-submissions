class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int n : nums){
            hs.add(n);
        }
        int longest = 0;
        for(int n : hs){
            if(!hs.contains(n - 1)){
                int curNum = n;
                int curLength = 1;
                while(hs.contains(curNum + 1)){
                    curNum += 1;
                    curLength += 1;
                }
                longest = Math.max(curLength, longest);
            }
        }
        return longest;     
    }
}
