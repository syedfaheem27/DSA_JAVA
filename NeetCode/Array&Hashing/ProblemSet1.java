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
 }