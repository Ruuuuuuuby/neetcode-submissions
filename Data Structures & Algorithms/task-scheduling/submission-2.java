class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char c : tasks) counts[c - 'A']++;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int cnt : counts) if (cnt > 0) maxHeap.offer(cnt);

        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;
            for (int i = 0; i < cycle; i++) {
                if (!maxHeap.isEmpty()) {
                    int cur = maxHeap.poll();
                    if (cur > 1) temp.add(cur - 1); // 执行一次，还剩多少
                }
                time++;
                if (maxHeap.isEmpty() && temp.isEmpty()) break;
            }
            for (int cnt : temp) maxHeap.offer(cnt);
        }
        return time;
    }
}