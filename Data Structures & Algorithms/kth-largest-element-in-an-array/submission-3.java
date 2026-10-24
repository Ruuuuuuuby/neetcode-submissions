class Solution {
    // public int findKthLargest(int[] nums, int k) {
    //     //3 methods
    //     PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
    //     for(int n : nums){
    //         if(minHeap.size() < k){
    //             minHeap.add(n);
                
    //         }else if(n > minHeap.peek()){
    //             minHeap.poll();
    //             minHeap.add(n);
    //         }
    //     }
    //     return minHeap.peek();
    // }
    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //     for(int n : nums){
    //         minHeap.add(n);
    //         if(minHeap.size() > k){
    //             minHeap.poll();
    //         }
    //     }
    //     return minHeap.peek();
    // }
    public int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        for(int n : nums){
            pq.offer(n);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();

    }
}
