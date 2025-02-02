import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution{
    /*
     * Time complexity: O(n)
     * Space complexity: O(2n)=>O(n)
     */
    public int[] concatenationI(int[] nums){
        int len=nums.length;
        int[] result=new int[2*len];

        for(int i=0;i<2*len;i++){
            result[i]=i>=len?nums[i-len]:nums[i];
        }

        return result;
    }

    /*
     * A slightly efficient way although the time complexity and the
     * space complexity will remain same
     * Getting rid of conditional checks plus iterating over the array only
     * an n number of times
     */
    public int[] concatenationII(int[] nums){
        int len=nums.length;
        int[] result=new int[2*len];

        for(int i=0;i<len;i++){
            result[i]=nums[i];
            result[i+len]=nums[i];
            //Here since we are accessing the nums[i] twice, the access
            // will be faster because it might make use of the cache
        }

        return result;
    }


    ////////////////////////////////////////////////

/*
 * Method 1: Brute force
 * TC O(n^2)
 * SC O(1)
 */
    public boolean hasDuplicateI(int[] nums){
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(num==nums[j])
                    return true;
            }
        }

        return false;
    }


    /*
     * Method 2: Using sorting
     * TC: O(n*log(n))
     * SC: O(1)
     * Although we will be sorting the array in-place but it's not a good practice to modify
     * the input
     */

     public boolean hasDuplicateII(int[] nums){
      Arrays.sort(nums);

      for(int i=1;i<nums.length;i++){
        if(nums[i]==nums[i-1])
            return true;
      }

      return false;
    }



    /*
     * Method 3: Using a set
     * Create a set and insert the array and compare the length of the set with the array length
     * TC: O(n)
     * SC: O(n)
     */
public boolean hasDuplicateIII(int[] nums){
    Set<Number> set = new HashSet<>();

    for(int i=0;i<nums.length;i++){
        set.add(nums[i]);
    }

    return set.size()!=nums.length;
}

 }