package NeetCode.TwoPointers.Easy;


public class MergeSortedArray{
    //Brute force: Insertion sort type shifting
    //TC: O(m*n);
    //SC: O(1);
    public static void mergeI(int[] nums1, int m, int[] nums2, int n) {
            int p1 = 0;

            if(n == 0){
                return;
            }

            while(p1<m ){
                if(nums1[p1]<=nums2[0]){
                    p1++;
                }else{
                    int temp = nums1[p1];
                    nums1[p1] = nums2[0];
                    nums2[0] = temp;


                    int i = 1;

                    while(i<n && nums2[i]<nums2[i-1]){
                        int temp1 = nums2[i];
                        nums2[i] = nums2[i-1];
                        nums2[i-1] = temp1;

                        i++;
                    }
                }
            }


            while(p1<m+n){
                nums1[p1]=nums2[p1-m];
                p1++;
            }
    }


    //Optimal approach
    //TC: O(m+n);
    //SC: O(1)
    public static void mergeII(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m + n - 1;
            int p2 = m - 1;
            int p3 = n - 1;

            while(p2>=0 && p3 >=0 ){
                nums1[p1--] = nums1[p2] > nums2[p3] ? nums1[p2--] : nums2[p3--];
            }


            while(p3>=0){
                nums1[p1--] = nums2[p3--];
            }

    }
}
