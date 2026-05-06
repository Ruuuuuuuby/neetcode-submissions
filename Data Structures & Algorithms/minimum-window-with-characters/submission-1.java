class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length() || s.length() == 0 || t.length() == 0){
            return "";
        }
        int minLength = Integer.MAX_VALUE;
   
        HashMap<Character, Integer> tFre = new HashMap<>();
        for(char c : t.toCharArray()){
            tFre.put(c, tFre.getOrDefault(c, 0) + 1);
        }

        int formed = 0;
        int required = tFre.size();

        int left = 0;
        int right = 0;
        int start = 0;


        HashMap<Character, Integer> sFre = new HashMap<>();
        while(right < s.length()){
            char c = s.charAt(right);
            sFre.put(c, sFre.getOrDefault(c, 0) + 1);
            if(tFre.containsKey(c) && tFre.get(c) == sFre.get(c)){
                formed++;
            }

            while(formed == required && left <= right){
                char leftChar = s.charAt(left);
                if(right - left + 1 < minLength){
                    minLength = right - left + 1;
                    start = left;
                }
                sFre.put(leftChar, sFre.get(leftChar) - 1);
                if(tFre.containsKey(leftChar) && tFre.get(leftChar).intValue() > sFre.get(leftChar).intValue()){
                    formed--;
                }
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);  
    }
}
