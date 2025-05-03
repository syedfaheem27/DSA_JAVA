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

    //Optimal
    //TC:O(N)
    //SC:O(1)
    public static void rotateArray(int[] nums,int k){
        int n = nums.length;
         k = k % n;

        for(int i=0,j=n-k-1,l=n-k,m=n-1;i<j || l<m; i++,j--,l++,m--){
            if(i<j){
                int temp1 = nums[i];
                nums[i] = nums[j];
                nums[j] = temp1;
            }

            if(l<m){
                int temp2 = nums[l];
                nums[l] = nums[m];
                nums[m] = temp2;
            }
        }

        for(int i=0,j=n-1;i<j;i++,j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }
}
