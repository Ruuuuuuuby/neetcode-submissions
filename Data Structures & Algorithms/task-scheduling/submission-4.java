class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char c : tasks) {
            counts[c - 'A']++;
        }

        Arrays.sort(counts);
        int maxFreq = counts[25];
        int maxCount = 1;
        for (int i = 24; i >= 0; i--) {
            if (counts[i] == maxFreq) maxCount++;
            else break;
        }
        // 关键公式
        return Math.max((maxFreq - 1) * (n + 1) + maxCount, tasks.length);
    }
}