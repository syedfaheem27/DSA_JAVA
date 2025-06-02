package NeetCode.Stack.medium;

import java.util.Arrays;
import java.util.Stack;

// Input: temperatures = [73,74,75,71,69,72,76,73]
// Output: [1,1,4,2,1,1,0,0]


//TODO: Brute force implementation
public class DailyTemperatures {
     public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;

        int[] result = new int[n];
        Arrays.fill(result, 0);

       for(int i=0;i<n;i++){
        if(stack.isEmpty()){
            stack.push(i);
            continue;
        }

        int topIdx = stack.peek();
        int prevHighestTemp = temperatures[topIdx];

        if(prevHighestTemp > temperatures[i]){
            stack.push(i);
        }else{
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int idx = stack.pop();
                result[idx]=i-idx;
            }
            stack.push(i);
        }
       }





       return result;
    }
}
