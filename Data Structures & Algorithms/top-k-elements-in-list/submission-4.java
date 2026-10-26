

//Map.Entry<Integer, Integer> : hm.entrySet()
// class Solution{
//     public int[] topKFrequent(int[] nums, int k){
//         HashMap<Integer, Integer> hs = new HashMap<>();
//         for(int n : nums){
//             hs.put(n, hs.getOrDefault(n, 0) + 1);
//         }
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
//         for(Map.Entry<Integer, Integer> e : hs.entrySet()){
//             pq.offer(new int[]{e.getKey(), e.getValue()});
//             if(pq.size() > k){
//                 pq.poll();
//             }
//         }
//         int[] res = new int[k];
//         for(int i = k - 1; i >= 0; i--){
//             res[i] = pq.poll()[0];
//         }
//         return res;
//     }
// }

class Solution{
    public int[] topKFrequent(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            pq.offer(new int[]{e.getKey(), e.getValue()});
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        for(int i = k - 1; i >= 0; i--){
            res[i] = pq.poll()[0];
        }
        return res;
    }
}