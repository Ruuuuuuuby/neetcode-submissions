// //psuh pop top getMin

// class MinStack{
//     private Stack<Integer> stack;
//     private Stack<Integer> minStack;

//     public MinStack(){//uppercase
//         stack = new Stack<>();
//         minStack = new Stack<>();
//     }

//     public void push(int val){
//         stack.push(val);
//         if(minStack.isEmpty() || minStack.peek() >= val){
//             minStack.push(val);
//         }else{
//             minStack.push(minStack.peek());
//         }
//     }

//     public void pop(){
//         stack.pop();
//         minStack.pop();
//     }

//     public int top(){
//         return stack.peek();
//     }

//     public int getMin(){
//         return minStack.peek();
//     }
// }


class MinStack{
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // //psuh pop top getMin
    public void push(int val){
        stack.push(val);
        if(!minStack.isEmpty() && minStack.peek() < val){
            minStack.push(minStack.peek());
        }else{
            minStack.push(val);
        }
    }
    public void pop(){
        stack.pop();
        minStack.pop();
    }
    public int top(){
        return stack.peek();
    }
    public int getMin(){
        return minStack.peek();
    }
}
