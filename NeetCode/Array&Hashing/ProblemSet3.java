import java.util.HashMap;
import java.util.Map;

public class ProblemSet3 {

    //Problem 1: Two sum

    /*
     * Method 1: Brute force
     * TC O(N^2)
     * SC O(1)
     */
    public int[] twoSum(int[] nums,int sum){
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