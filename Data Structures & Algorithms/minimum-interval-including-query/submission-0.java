class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = queries.length;
        int[] res = new int[n];
        int[][] qArr = new int[n][2];

        for(int i = 0; i < n; i++){
            qArr[i][0] = queries[i];
            qArr[i][1] = i;
        }
        Arrays.sort(qArr, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int i = 0;
        for(int[] q : qArr){
            int num = q[0];
            int idx = q[1];
            while(i < intervals.length && num >= intervals[i][0]){
                int l = intervals[i][0];
                int r = intervals[i][1];
                pq.offer(new int[] {r - l + 1, r});
                i++;
            }
            while(!pq.isEmpty() && pq.peek()[1] < num){
                pq.poll();
            }
            res[idx] = pq.isEmpty() ? -1 : pq.peek()[0];
        }
        return res;
    
    }
}
