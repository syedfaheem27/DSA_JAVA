package NeetCode.Stack.easy;

import java.util.Stack;

public class BaseBallGame{
    public int calPoints(String[] operations) {
        Stack<Integer> result = new Stack<>();

        for(String ch: operations){
            int stackSize = result.size();
            if(ch.equals("D")){
                if(stackSize>=1){
                    int val1 = result.peek();
                    result.push(2*val1);
                }
            }else if (ch.equals("+")){
                if(stackSize>=2){
                    int val1= result.pop();
                    int val2 = result.peek();

                    int sum = val1+val2;
                    result.push(val1);
                    result.push(sum);
                }
            }else if(ch.equals("C")){
                if(!result.isEmpty()){
                    result.pop();
                }
            }else{
                int val = Integer.parseInt(ch);
                result.push(val);
            }
        }

        int sum=0;
        while(!result.isEmpty()){
            sum+=(Integer)result.pop();
        }

        return sum;

    }


}