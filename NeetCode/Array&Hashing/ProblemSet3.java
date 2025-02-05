import java.util.HashMap;
import java.util.Map;

public class ProblemSet3 {

    //Problem 1: Two sum

    /*
     * Method 1: Brute force
     * TC O(N^2)
     * SC O(1)
     */
    public int[] twoSumI(int[] nums,int sum){
        for(int i=0;i<nums.length;i++){
            int tempSum=sum-nums[i];

            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==tempSum){
                int[] arr={i,j};
                return arr;
                }
            }
        }

        return null;
    }


/*
 * Method 2: Optimal approach
 * TC O(N)
 * SC O(N)
 */
    public int[] twoSumII(int[] nums,int sum){
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int tempSum=sum-nums[i];

            if(map.containsKey(tempSum)){
                int[] arr= {map.get(tempSum),i};
                return arr;
            }

            map.put(nums[i], i);
        }

        return null;
    }


}