
// class Solution{
//     public int maxArea(int[] heights){
//         int left = 0;
//         int right = heights.length - 1;
//         int maxArea = 0;
//         while(left < right){
//             int height = Math.min(heights[left], heights[right]);
//             int area = (right - left) * height;
//             maxArea = Math.max(area, maxArea);
//             if(heights[left] < heights[right]){
//                 left++;
//             }else{
//                 right--;
//             }
//         }
//         return maxArea;
//     }
// }

class Solution{
    public int maxArea(int[] heights){
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;
        int height = 0;
        while(left < right){
            height = Math.min(heights[left], heights[right]);
            maxArea = Math.max(maxArea, height * (right - left));
            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}