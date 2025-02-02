 class Solution{
    /*
     * Time complexity: O(n)
     * Space complexity: O(2n)=>O(n)
     */
    public int[] concatenation(int[] nums){
        int len=nums.length;
        int[] result=new int[2*len];

        for(int i=0;i<2*len;i++){
            result[i]=i>=len?nums[i-len]:nums[i];
        }

        return result;
    }
 }