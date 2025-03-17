package Easy.ProblemSet1;

import java.util.Arrays;

public class numIdenticalPairs {
    //Brute force: run nested for loops
    //TC: O(N^2)
    //SC: O(1)


    //TC: O(N)
    //SC: O(N)
    public static int numIdenticalPairsOptimal(int[] nums) {
        int n=nums.length;

        int[] result=new int[n];
        Arrays.fill(result, 0);

        int pairs=0;
        for(int i=0;i<n;i++){
            int index=nums[i]-1;

            pairs+=result[index]*1;
            result[index]++;
        }

        return pairs;
    }
}
