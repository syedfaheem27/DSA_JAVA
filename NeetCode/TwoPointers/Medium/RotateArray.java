package NeetCode.TwoPointers.Medium;

// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
//k = 5, [3,4,5,6,7,1,2]


public class RotateArray {
    //Brute force
    //TC: O(N)
    //SC: O(N)
    public static void rotateBruteForce(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];

        k = k % n;
        int j=0;


        for(int i=n-k;i<n;i++,j++){
            result[j] = nums[i];
        }

        for(int i=0;i<n-k;i++,j++){
            result[j] = nums[i];
        }

        for(int i=0;i<n;i++){
            nums[i] = result[i];
        }
    }

    // public static
}
