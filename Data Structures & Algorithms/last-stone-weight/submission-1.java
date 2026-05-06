class Solution {
    public int lastStoneWeight(int[] stones) {
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int s : stones){
            maxHeap.add(s);
        }
        while(maxHeap.size() > 1){
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if(first > second){
                maxHeap.add(first - second);
            }
        }
        return (maxHeap.isEmpty()) ? 0 : maxHeap.peek();
        
    }
}
