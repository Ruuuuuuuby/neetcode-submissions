class Solution {//dp[i][j]表示开区间(i, j)之间（不含i和j）气球全部戳完能获得的最大分数
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for(int i = 1; i <= n; i++){
            arr[i] = nums[i - 1];
        }
        int[][] dp = new int[n + 2][n + 2];
        for(int len = 2; len <= n + 1; len++){//len = right - left
        //dp[1][2]中什么也没有其实 左右开区间
            for(int left = 0; left + len <= n + 1; left++){//left + len <= n + 1要把len给带上
                int right = left + len;
                for(int k = left + 1; k < right; k++){
                    dp[left][right] = Math.max(dp[left][right], dp[left][k] + arr[left] * arr[k] * arr[right] + dp[k][right]);
                    //arr[k - 1] * arr[k] * arr[k + 1] nonono , it changes all the time

                }
            }

        }
        return dp[0][n + 1];
    }
}
