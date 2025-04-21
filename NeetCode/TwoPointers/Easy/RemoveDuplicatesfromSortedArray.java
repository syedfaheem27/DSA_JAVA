package NeetCode.TwoPointers.Easy;


//TC: O(n)
//SC: O(1)
public class RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int toInsertIndex=0;

        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[++toInsertIndex]=nums[i];
            }
        }

        return toInsertIndex+1;

    }
}
