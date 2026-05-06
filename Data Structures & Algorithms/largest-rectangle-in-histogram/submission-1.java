
class Solution{
    public int largestRectangleArea(int[] heights){
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= heights.length; i++){
            int curHeight = (i == heights.length ? 0 : heights[i]);
            while(!stack.isEmpty() && curHeight < heights[stack.peek()]){
                int index = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int curArea = heights[index] * width;
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        return maxArea;
    }
}