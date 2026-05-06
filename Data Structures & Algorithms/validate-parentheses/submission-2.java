

class Solution{
    public boolean isValid(String s){
        if(s == null || s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '[' || c == '(' || c == '{'){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                if((c == ')' && stack.pop() != '(') || (c == '}' && stack.pop() != '{') || (c == ']' && stack.pop() != '[')){
                    return false;
                }   
                //不能把pop写在前面
            }
        }
        return stack.isEmpty();
    }
}
