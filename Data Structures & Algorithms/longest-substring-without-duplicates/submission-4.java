

class Solution{//abba
    public int lengthOfLongestSubstring(String s){
        if(s == null || s.length() == 0){
            return 0;
        }        
        HashMap<Character, Integer> hm = new HashMap<>();
        int longest = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            if(hm.containsKey(c)){
                left = Math.max(left, hm.get(c) + 1);
            }
            hm.put(c, right);
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
        
    }
}
