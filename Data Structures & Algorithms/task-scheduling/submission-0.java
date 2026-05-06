class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char c : tasks){
            count[c - 'A']++;
        }
        Arrays.sort(count);
        int maxFreq = count[25];//频率最高的字母的出现次数
        int maxCount = 1;//有几个这样频率高的字母
        for(int i = 24; i >= 0; i--){
            if(count[i] == maxFreq){
                maxCount++;
            }
        } 
        return Math.max((n + 1) * (maxFreq - 1) + maxCount, tasks.length);
    }
}
