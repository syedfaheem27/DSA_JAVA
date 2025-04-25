package NeetCode.SlidingWindow.Easy;

import java.util.HashSet;
import java.util.Set;


//TC : O(N)
//SC: O(K)
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        int n = Math.min(nums.length, k);


        for(int i = 0;i<n;i++){
            if(set.contains(nums[i])){
                return true;
            }

            set.add(nums[i]);
        }


        for(int i = n; i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }

            set.add(nums[i]);
            set.remove(nums[i-n]);
        }


        return false;


    }
}
