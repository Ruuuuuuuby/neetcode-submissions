

// class Solution{
//     public int[] maxSlidingWindow(int[] nums, int k){
//         int n = nums.length;
//         Deque<Integer> dq = new ArrayDeque<>();
//         int[] res = new int[n - k + 1];
//         for(int i = 0; i < n ; i++){// 0 - n-1
//             if(!dq.isEmpty() && dq.peekFirst() < i - k + 1){
//                 dq.pollFirst();
//             }
//             while(!dq.isEmpty() && dq.peekLast() < nums[i]){
//                 dq.pollLast();
//             }
//             dq.offerLast(i);
//             if(i >= k - 1){
//                 res[i - k + 1] = nums[dq.peekFirst()];//peek
//             }

//         }
//         return res;
//     }
// }


// poll first if out of window
//poll last if new >= last
//offer new to deque last


class Solution{
    public int[] maxSlidingWindow(int[] nums, int k){
        int n = nums.length;
        int[] res = new int[n - k + 1];
        // queue
        Deque<Integer> dq = new ArrayDeque<>();
        for(int right = 0; right < n; right++){
            while(!dq.isEmpty() && dq.peekFirst() <= right - k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[right]){
                dq.pollLast();
            }
            dq.offerLast(right);
            if(right >= k - 1){
                res[right - k + 1] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}