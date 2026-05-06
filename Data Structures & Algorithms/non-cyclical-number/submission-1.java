class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while(!seen.contains(n) && n != 1){//不为1且不重复
            seen.add(n);
            n = sumOfNumbers(n);

        }
        return n == 1;
        

        
    }
    public int sumOfNumbers(int n){
        int sum = 0;
        int d = 0;
        while(n != 0){
            d = n % 10;
            sum += d * d;
            n = n / 10;
        }
        return sum;

    }
}
