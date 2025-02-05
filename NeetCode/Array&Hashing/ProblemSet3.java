import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProblemSet3 {

    //Problem 1: Two sum

    /*
     * Method 1: Brute force
     * TC O(N^2)
     * SC O(1)
     */
    public int[] twoSumI(int[] nums,int sum){
        for(int i=0;i<nums.length;i++){
            int tempSum=sum-nums[i];

            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==tempSum){
                int[] arr={i,j};
                return arr;
                }
            }
        }

        return null;
    }


/*
 * Method 2: Optimal approach
 * TC O(N)
 * SC O(N)
 */
    public int[] twoSumII(int[] nums,int sum){
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int tempSum=sum-nums[i];

            if(map.containsKey(tempSum)){
                int[] arr= {map.get(tempSum),i};
                return arr;
            }

            map.put(nums[i], i);
        }

        return null;
    }



    //Problem 2: Longest common prefix

    /*
     * Method 1: Brute force
     * TC: O(nlogn + n * k) where k is the length of the smallest word in the array
     * SC: O(2k) for stringbuilder and character array and O(logn) which is the auxillary space for tim sort in java
     * SC: O(k + logn)
     */

     public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs,(a,b)->{
            int len1=a.length();
            int len2=b.length();

            if(len1>len2)
                return 1;
            else
                return -1;
        });

        char[] result=strs[0].toCharArray();

        for(int i=1;i<strs.length;i++){
            String s=strs[i];

            for(int j=0;j<s.length() && j<result.length;j++){
                if(s.charAt(j)!=result[j]){
                    result[j]=' ';
                    break;
                }
            }
        }

        StringBuilder res=new StringBuilder();

        int i=0;
        while(i<result.length && result[i]!=' '){
            res.append(result[i]);
            i++;
        }

        return res.toString();


     }

}