class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        for(int n : nums){
            minHeap.add(n);
            
        }
        while(minHeap.size() > k){
                minHeap.poll();
            }
        return minHeap.peek();

        
    }
}
