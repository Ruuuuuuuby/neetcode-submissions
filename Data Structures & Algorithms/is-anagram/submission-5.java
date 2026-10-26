class Solution{
    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int n : count){
            if(n != 0){
                return false;
            }
        }
        return true;

    }
    //brute force : toCharArray char[] sort and equals
    //time complexity O(nlgn)
    //space complexity n
}