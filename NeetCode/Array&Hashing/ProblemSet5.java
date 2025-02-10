public class ProblemSet5 {
    //Problem 1: Sort colors

    //Brute force : Count number of zeroes and ones and then insert the same amount

    /*
     * Method 1: Placing 0 and 1 at its right position would mean 2 gets to its right position
     * TC O(N)
     * SC O(1)
     */
    public void sortColorsI(int[] nums) {
        int i=0;

        //zero put in place
        for(int j=0;j<nums.length && i<nums.length;j++){
            if(nums[j]==0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
            }
        }

        //one put in place and we will automatically take care of the rest
        for(int j=i;j<nums.length && i<nums.length;j++){
            if(nums[j]==1){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
            }
        }

    }
}
