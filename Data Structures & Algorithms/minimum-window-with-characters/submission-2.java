class Solution{
    public String minWindow(String s, String t){
        int m = s.length();
        int n = t.length();
        if(m < n || m == 0 || n == 0){
            return "";
        }

        HashMap<Character, Integer> t1 = new HashMap<>();
        for(char c : t.toCharArray()){
            t1.put(c, t1.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> s1 = new HashMap<>();

        int minLength = Integer.MAX_VALUE;
        int valid = 0; 
        int left = 0;
        int right = 0;
        int start = 0;
        int required = t1.size();

        while(right < m){
            char c = s.charAt(right);
            s1.put(c, s1.getOrDefault(c, 0) + 1);

            if(s1.containsKey(c) && s1.get(c) == t1.get(c)){
                valid++;
            }

            while(valid == required && left <= right){
                char leftChar = s.charAt(left);
                if(right - left + 1 < minLength){
                    minLength = right - left + 1;
                    start = left;
                }
                s1.put(leftChar, s1.get(leftChar) - 1);
                if(t1.containsKey(leftChar) && t1.get(leftChar) > s1.get(leftChar)){
                    valid--;
                }
                left++;
            }
            right++; 
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
