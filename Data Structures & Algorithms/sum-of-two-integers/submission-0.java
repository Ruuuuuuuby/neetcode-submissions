class Solution {
    public int getSum(int a, int b){
        while(b != 0){
            int carry = (a & b) << 1;//calculate carry and move it to left.
            a = a ^ b;//without carry
            b = carry;
        }
        return a;

    
        
    }
}
