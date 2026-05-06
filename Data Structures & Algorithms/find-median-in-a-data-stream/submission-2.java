// class MedianFinder {//size() length
//     private PriorityQueue<Integer> left;
//     private PriorityQueue<Integer> right;

//     public MedianFinder() {
//         left = new PriorityQueue<>((a, b) -> b - a);
//         right = new PriorityQueue<>(); 
//     }
    
//     public void addNum(int num) {
//         left.offer(num);
//         right.offer(left.poll());
//         if(right.size() > left.size()){
//             left.offer(right.poll());
//         }  
//     }
    
//     public double findMedian() {
//         if(left.size() > right.size()){
//             return left.peek();
//         }
//         else{
//             return (double) (left.peek() + right.peek()) / 2.0;
//         }
//     }
// }

class MedianFinder{
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public MedianFinder(){
        left = new PriorityQueue<>((a, b) -> b - a);
        right = new PriorityQueue<>();
        
    }

    public void addNum(int num){
        left.offer(num);
        right.offer(left.poll());
        if(right.size() > left.size()){
            left.offer(right.poll());
        }
    }
    public double findMedian(){
        if(left.size() == right.size()){
            return (double)(left.peek() + right.peek()) / 2;
        }else{
            return left.peek();
        }

    }
}
