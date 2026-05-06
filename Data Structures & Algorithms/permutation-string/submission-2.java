
class Solution{
    public boolean checkInclusion(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        if(m > n){
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(char c : s1.toCharArray()){
            count1[c - 'a']++;
        }
        for(int i = 0; i < n; i++){
            count2[s2.charAt(i) - 'a']++;
            if(i >= m){
                count2[s2.charAt(i - m) - 'a']--;
            }
            if(i >= m - 1){
                if(match(count1, count2)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean match(int[] c1, int[] c2){
        for(int i = 0; i < c1.length; i++){
            if(c1[i] != c2[i]){
                return false;
            }
        }
        return true;
    }
}
