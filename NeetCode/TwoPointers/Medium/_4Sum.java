package NeetCode.TwoPointers.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Backtracking
//TC: O(n^3)
//SC: O()

public class _4Sum {
    public static List<List<Integer>> forSum(int[] nums,int target){
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> quad = new ArrayList<>();

        findKSum(nums, 0, target, 4, result, quad);

        return result;
    }


    private static void findKSum(int[] nums,int start,int target,int k,List<List<Integer>> result,List<Integer> quad){
        if(k==2){
            int end = nums.length-1;

            while(start < end){
                int sum = nums[start] + nums[end];

                if(sum==target){
                    List<Integer> temp = new ArrayList<>(quad);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    result.add(temp);

                    start++;
                    end--;


                    while( start > 0 && start < end && nums[start] == nums[start -1]){
                        start++;
                    }


                    while(end > start && nums[end] == nums[end+1]){
                        end--;
                    }


                }else if(sum > target){
                    end--;
                }else {
                    start++;
                }
            }

        }

        for(int i = start;i<nums.length - k + 1;i++){
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }

            if(start >= nums.length - k + 1){
                break;
            }

            quad.add(nums[i]);
            findKSum(nums, i+1, target - nums[i], k-1, result, quad);
            quad.remove(quad.size()-1);
        }


    }


}
