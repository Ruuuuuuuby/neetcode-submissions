

class Solution{
    public int[] topKFrequent(int[] nums, int k){
        HashMap<Integer, Integer> fre = new HashMap<>();
        for(int n : nums){
            fre.put(n, fre.getOrDefault(n, 0) + 1);
        }
        //HashMap
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : fre.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        //PriorityQueue
        int[] res = new int[k];
        for(int i = k-1; i >= 0; i--){
            res[i] = minHeap.poll().getKey();
        }
        return res;

    }
}
