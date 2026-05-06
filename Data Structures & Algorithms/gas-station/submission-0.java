class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int curSum = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++){
            int diff = gas[i] - cost[i];
            total += diff;
            curSum += diff;
            if(curSum < 0){
                start = i + 1;
                curSum = 0;
            }
        }
        return total < 0 ? -1 : start;
    }
}
