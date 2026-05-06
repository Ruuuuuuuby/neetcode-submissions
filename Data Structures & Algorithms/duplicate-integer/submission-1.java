

class Solution{
    public boolean hasDuplicate(int[] nums){
        HashSet<Integer> hs = new HashSet<>();
        for(int n : nums){
            if(!hs.add(n)){
                return true;
            }
        }
        return false;
    }
}
