package NeetCode.Stack.easy;

import java.util.Stack;

public class ValidParanthesis {
    //Optimal: TC - O(N)
    //SC - O(N)
    public boolean isValidI(String s) {
        int n = s.length();

        Stack<Character> stack = new Stack<>();

        for(int i =0;i<n;i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }

            char topCh=stack.peek();
            char stringChar = s.charAt(i);

            if((topCh=='(' && stringChar==')')
            || (topCh == '{' && stringChar=='}')
            || (topCh=='[' && stringChar == ']')
            ){
                stack.pop();
            }else{
                stack.push(stringChar);
            }
        }
        return stack.isEmpty();
    }


    //Early returns
    public boolean isValidII(String s){
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(stack.isEmpty() && (ch==')' || ch=='}' || ch==']')){
                return false;
            }

            if(stack.isEmpty()) {
                stack.push(ch);
                continue;
            }

            char topCh=stack.peek();

            if((topCh=='(' && ch==')')
            || (topCh == '{' && ch=='}')
            || (topCh=='[' && ch == ']')
            ){
                stack.pop();
            }else{
                stack.push(ch);
            }

        }

        return stack.isEmpty();
    }


}
