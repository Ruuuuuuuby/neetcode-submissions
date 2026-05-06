class Solution {//minOpen表示最少能有几个左括号（假设*全为右括号）
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0; 
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                minOpen++;
                maxOpen++;
            }else if(s.charAt(i) == ')'){
                minOpen--;
                maxOpen--;
            }else{
                minOpen--;
                maxOpen++;
            }
            if(maxOpen < 0){//右括号实在太多了，全部为左括号结果居然还是-
                return false;
            }
            minOpen = Math.max(0, minOpen);
        }
        return minOpen == 0;
    }
}
