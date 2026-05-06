class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][2];//必须有dimension声明
        }
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        res.add(intervals[0]);
        
        for(int i = 1; i< intervals.length; i++){
            int[] last = res.get(res.size() - 1);
            int[] cur = intervals[i];
            if(last[1] >= cur[0]){
                last[1] = Math.max(last[1], cur[1]);
            }else{
                res.add(cur);
            }

        }
        return res.toArray(new int[res.size()][]);
    }
}
