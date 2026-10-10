// /**
//  * Definition of Interval:
//  * public class Interval {
//  *     public int start, end;
//  *     public Interval(int start, int end) {
//  *         this.start = start;
//  *         this.end = end;
//  *     }
//  * }
//  */

// class Solution {//list.start   intervals.sort
//     public boolean canAttendMeetings(List<Interval> intervals) {
//         if(intervals.size() == 0){
//             return true;
//         }
//         intervals.sort((a, b) -> a.start - b.start);
//         for(int i = 1; i < intervals.size(); i++){
//             if(intervals.get(i).start < intervals.get(i - 1).end){
//                 return false;
//             }
//         }
//         return true;
//     }
// }
class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() == 0){
            return true;
        }
        //if intervals is a int[][]
        // Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        //arrays doesn't have sort method

        // if intervals is List<int[]?
        // intervals.sort((a, b) -> Integer.compare(a[0], b[0]));比较安全
        //也可以intervals.sort((a, b) -> a[0] - b[0]);可能整数溢出
        
        // intervals.sort((a, b) -> a.start - b.start);//interval is object type here
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i).start < intervals.get(i - 1).end){
                return false;
            }
        }
        return true;
    }
}

