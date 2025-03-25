package NeetCode.TwoPointers.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//[-1,0,1,2,-1,-4]

//[-4,-1,-1,0,1,2]

//Brute force - triple for loop
//TC : O(N^3)
//SC: O(1)

public class    _3Sum{

    //TC: O(N^2)
    //SC: O(1) - if we neglect the space of the result
        public List<List<Integer>> threeSum(int[] nums) {
                List<List<Integer>> result = new ArrayList<>();

                Arrays.sort(nums);

                int n=nums.length;

                for(int i=0;i<n-1;i++){
                    int num=nums[i];

                    int targetSum=-1*num;

                    int start=i+1;
                    int end=n-1;


                    while(start<end){
                        int sum=nums[start]+nums[end];
                        if(sum==targetSum){
                            List<Integer> list=new ArrayList<>();
                            list.add(num);
                            list.add(nums[start]);
                            list.add(nums[end]);

                            result.add(list);

                            start++;
                            end--;

                            while(start<end && nums[start]==nums[start-1]){
                                start++;
                            }

                            while(end>start && nums[end]==nums[end+1]){
                                end--;
                            }

                        }else if(sum>targetSum){
                            end--;
                        }else{
                            start++;
                        }
                    }

                   while(i+1<n && nums[i]==nums[i+1]){
                    i++;
                   }


                }

                return result;
    }
}
