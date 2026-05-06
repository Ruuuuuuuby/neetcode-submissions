

class Solution{
    public String minWindow(String s, String t){
        int m = s.length();
        int n = t.length();
        if(m == 0 || n == 0 || m < n){
            return "";
        }
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int start = 0;
        int left = 0; 
        int minLen = Integer.MAX_VALUE;
        int valid = 0;
        int required = tMap.size();
        HashMap<Character, Integer> sMap = new HashMap<>();
        for(int right = 0; right < m; right++){
            char c = s.charAt(right);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            if(tMap.containsKey(c) && tMap.get(c).intValue() == sMap.get(c).intValue()){
                valid++;
            }
            while(valid == required && left <= right){
                if(minLen > right - left + 1){
                    minLen = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                sMap.put(leftChar, sMap.get(leftChar) - 1);
                if(tMap.containsKey(leftChar) && tMap.get(leftChar).intValue() > sMap.get(leftChar).intValue()){
                    valid--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
