class Solution {
    public double myPow(double x, int n) {
        long N = n;//指数，防止溢出
        double res = 1;
        if(N < 0){
            N = -N;
            x = 1 / x;
        }
        while(N != 0){
            if((N & 1) == 1){
                res *= x;
            }
            x *= x;
            N >>= 1; 
        }
        return res;  
    }
}
