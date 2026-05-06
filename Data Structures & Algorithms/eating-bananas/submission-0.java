class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = max(piles);
        int result = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(canFinish(mid, piles, h)){
                result = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return result;
        
    }
    public int max(int[] piles){
        int max = 0;
        for(int p : piles){
            if(p >= max){
                max = p;
            }
        }
        return max;
    }

    public boolean canFinish(int mid, int[] piles, int h){
        int totalTime = 0; 
        for(int p : piles){
            int curTime = p % mid == 0 ? p / mid : p / mid + 1;
            // int curTime = p + mid - 1 / mid;向上取整
            totalTime += curTime;
        }
        if(h >= totalTime){
            return true;
        }else{
            return false;
        }
    }
}
