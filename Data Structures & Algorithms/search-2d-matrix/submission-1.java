
class Solution{
    public boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0; 
        int right = m * n - 1;
        if(matrix == null || m == 0 || n == 0){
            return false;
        }
        while(left <= right){
            int mid = left + (right - left) / 2;
            int val = matrix[mid / n][mid % n];
            if(target == val){
                return true;
            }else if(target > val){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
