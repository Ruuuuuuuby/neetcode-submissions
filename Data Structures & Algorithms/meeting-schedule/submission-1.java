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
        intervals.sort((a, b) -> a.start - b.start);
        int end = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i).start < end){
                return false;
            }else{
                end = intervals.get(i).end;
            }
        }
        return true;

    }
}

