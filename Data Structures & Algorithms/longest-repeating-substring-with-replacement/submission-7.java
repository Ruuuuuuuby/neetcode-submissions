class Solution{
    public int characterReplacement(String s, int k){
        int maxCount = 0;
        int longest = 0;
        int left = 0;
        int[] count = new int[26];
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            count[c - 'A']++;
            maxCount = Math.max(maxCount, count[c - 'A']);
            while(right - left + 1 - maxCount > k){
                count[s.charAt(left) - 'A']--;
                left++;
            }
            longest = Math.max(longest, right -left + 1);
        }
        return longest;
    }
}

