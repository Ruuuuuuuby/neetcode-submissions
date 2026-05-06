// class Solution {//选右端点小的，尽量塞下更多区间，删除更少区间
//     public int eraseOverlapIntervals(int[][] intervals) {
//         Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
//         int count = 1;// 不重叠区间数
//         int end = intervals[0][1];
//         for(int i = 1; i < intervals.length; i++){
//             if(intervals[i][0] >= end){
//                 count++;
//                 end = intervals[i][1];
//             }
//         }
//         return intervals.length - count;
//     }
// }

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 1;
        int[] end = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= end[1]){
                count++;
                end[1] = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}
