class Solution{
    //only " " == space, can do connection later, ' ' cannot
    public boolean checkInclusion(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        if(m > n || m == 0 || n == 0){
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i = 0; i < m; i++){
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(count1, count2)){
            return true;
        }
        for(int j = m; j < n; j++){
            count2[s2.charAt(j) - 'a']++;
            count2[s2.charAt(j- m) - 'a']--;
            if(Arrays.equals(count1, count2)){
                return true;
            }
        }
        return false;
    }
}