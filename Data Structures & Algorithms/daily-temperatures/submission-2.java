

class Solution{
    public int[] dailyTemperatures(int[] temperatures){
        //不按0-n的顺序求res【i】
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int m = stack.pop();
                res[m] = i - m;
            }
            stack.push(i);
        }
        return res;
    }

}