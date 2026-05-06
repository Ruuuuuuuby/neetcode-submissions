

class Solution{
    public int lengthOfLongestSubstring(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int left = 0;
        int length = 0;
        int n = s.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int right = 0; right < n; right++){
            char c = s.charAt(right);
            if(hm.containsKey(c)){
                left = Math.max(left, hm.get(c) + 1);
            }
            hm.put(c, right);
            length = Math.max(length, right - left + 1);
        }
        return length;
    }
}
