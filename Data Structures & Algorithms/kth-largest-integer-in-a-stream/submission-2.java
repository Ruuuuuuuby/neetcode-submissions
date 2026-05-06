class KthLargest {
    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for(int n : nums){
            add(n);
        }

    }
    
    public int add(int val) {
        if(minHeap.size() < k){
            minHeap.offer(val);
        }else if(minHeap.peek() < val){
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
        //最小堆在添加的过程中一直remove了堆顶最小的值，留下的是k个最大的数字，而堆顶恰好就是第k大的数字
        
    }
}
