package _LongestConsecutiveSequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


//way1: Sort and find out TC:O(nlogn)
//way2: Find max and min and iterate from min to max
//Although, it is of linear complexity which is O(Range) but it leads to unnecessary iterations

public class main {
    public static int longestConsecutiveI(int[] nums) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;


        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            max=Math.max(max, nums[i]);
            min=Math.min(min, nums[i]);

            int count=map.getOrDefault(nums[i], 0);

            map.put(nums[i], ++count);
        }


        int maxLen=0;

        int i=min;

        while(i<=max){
            if(!map.containsKey(i)){
                i++;
                continue;
            }

            int count=1;

            while(i<=max && map.containsKey(i+1)){
                count+=1;
                i++;
            }

            maxLen=Math.max(count, maxLen);
            i++;
        }

        return maxLen;

    }


    //Optimal: TC:O(n)
    //SC:O(n)

    public static int longestConsecutiveII(int[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();


        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }

        int max=0;
        for(int i=0;i<n;i++){
            int el=nums[i];

            if(!set.contains(el)){
                continue;
            }


            int count=1;
            int forwardCount=1;

            while(set.contains(el+forwardCount)){
                set.remove(el+forwardCount);
                count++;
                forwardCount++;
            }


            int backwardCount=1;

            while(set.contains(el-backwardCount)){
                set.remove(el-backwardCount);
                count++;
                backwardCount++;
            }

            max=Math.max(count,max);
            set.remove(el);
        }


        return max;
    }
}
