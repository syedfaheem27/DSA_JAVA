package _MajorityElementII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class majorityElementII {

    //Method 1: using a hash map to count the frequencies

    //TC: O(N)
    //SC: O(N)
     public static List<Integer> majorityElement(int[] nums) {
            List<Integer> result=new ArrayList<>();

            int freq=(int)Math.floor(nums.length/3);

            Map<Integer,Integer> frequencyMap=new HashMap<>();
            Set<Integer> numsChecked=new HashSet<>();

            for(int num:nums){
                int val=frequencyMap.getOrDefault(num, 0);

                frequencyMap.put(num, val+1);
            }

            for(int num:nums){
                int val=frequencyMap.get(num);

                if(val>freq && !numsChecked.contains(num)){
                    result.add(num);
                }

                numsChecked.add(num);
            }


            return result;

    }

    public static void main(String[] args) {
        int[] nums={2,3,3};
        majorityElementI(nums);

    }

    //Method 2:
    //TC: O(n*logn)
    //SC: O(1)
    public static List<Integer> majorityElementI(int[] nums) {
        Arrays.sort(nums);


        List<Integer> result=new ArrayList<>();
        int freq=(int)Math.floor(nums.length/3);


        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                count++;
            }else{
                if(count>freq){
                    result.add(nums[i-1]);
                }
                count=1;
            }

        }

        if(count>freq){
            result.add(nums[nums.length-1]);
        }



        return result;

    }
}
