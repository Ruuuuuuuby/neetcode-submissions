class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int left = 0;
        int[] countS1 = new int[26];
        int[] countS2 = new int[26];
        for(char c : s1.toCharArray()){
            countS1[c - 'a']++;
        }
        for(char c : s2.substring(0, s1.length()).toCharArray()){
            countS2[c - 'a']++;
        }
        if(match(countS1, countS2)){
            return true;
        }
        for(int i = s1.length(); i < s2.length(); i++){
            countS2[s2.charAt(left) - 'a']--;
            countS2[s2.charAt(i) - 'a']++;
            left++;
            if(match(countS1, countS2)){
                return true;
            }
        }
        return false;
    }

    private boolean match(int[] s1, int[] s2){
        for(int i = 0; i < s1.length; i++){
            if(s1[i] != s2[i]){
                return false;
            }
        }
        return true;
    }
}
