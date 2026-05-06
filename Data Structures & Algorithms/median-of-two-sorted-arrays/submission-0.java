class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n){
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0; 
        int right = m;
        while(left <= right){
            int i = left + (right - left) / 2;//i为切割线，左边i个数【0，i-1】，右边m-i个【i，m-1】
            int j = (m + n + 1) / 2 - i;//左边==右边or左边多一个

            int left1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];//left1表示左边部分最大值
            int right1 = (i == m) ? Integer.MAX_VALUE : nums1[i];//right1表示右半部分最小值，left1<=right1
            int left2 = (j == 0) ? Integer.MIN_VALUE: nums2[j - 1];
            int right2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if(left1 <= right2 && left2 <= right1){
                if((m + n) % 2 == 0){
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }else{
                    return Math.max(left1, left2);
                }
            }
            else if(left1 > right2){
                right = i - 1;//i为nums1的中间，想i应该怎么移
            }else{
                left = i + 1;
            }
        }
        return -1;
    }
}
