// class Solution {
//     public int[][] kClosest(int[][] points, int k) {
//         //maxHeap can obtain k smallest nums
//         //minHeap can obtains kth largest num
//         PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]));
//         for(int[] point : points){
//             maxHeap.add(point);
//             if(maxHeap.size() > k){
//                 maxHeap.poll();
//             }
//         }
//         int[][] res = new int[k][2];
//         for(int i = 0; i < k; i++){
//             res[i] = maxHeap.poll();
//         }
//         return res;
//     }
// }
class Solution{
    public int[][] kClosest(int[][] points, int k){
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> distance(b) - distance(a));
        for(int[] point : points){
            maxHeap.offer(point);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++){
            res[i] = maxHeap.poll();
        }
        return res;
    }

    public int distance(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}