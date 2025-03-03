import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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

     public String longestCommonPrefixI(String[] strs) {
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


     /*
      * Method 2: A better one from the previous one
      * TC O(N*M) where M is the length of the smallest word
      * SC O(K) where K is the length of the first word in the array
      * The algo can't take more space than the length of the smallest word
      * so we can also say that the SC is constant
      */

      public String longestCommonPrefixII(String[] strs) {
        String smallestStr="";

        //N operations
        for(int i=0;i<strs.length;i++){
            if(smallestStr.length() > strs[i].length()){
                smallestStr=strs[i];
            }
        }

        char[] charArr=smallestStr.toCharArray();

        //N * M where M is the length of the smallest word
        for(int i=0;i<strs.length;i++){
            String s=strs[i];

            for(int j=0;j<s.length() && j<charArr.length;j++){
                if(s.charAt(j)!=charArr[j]){
                    charArr[j]=' ';
                    break;
                }
            }
        }

        int i=0;
        String result="";

        //M operations
        while(i<charArr.length && charArr[i]!=' '){
            result+=charArr[i];
            i++;
        }

        return result;

      }


      /*
       * Method 3: A better one than the previous one
       * Although TC is same but it has an early return on finding an empty string and it iterates only once
       * TC: O(N * M) where M is the length of the shortest word
       * SC: O(M)
       */

       public String longestCommonPrefixIII(String[] strs){
        String str=strs[0];

        for(int i=1;i<strs.length;i++){
            String s=strs[i];

            int j=0;

            while(j<str.length() && j<s.length() && s.charAt(j)==str.charAt(j)){
                j++;
            }

            str=str.substring(0, j);
            if(str.length()==0)
                return str;
        }

            return str;
       }

//TODO: Add vertical scanning approach for longest common prefix and understand vertical and horizontal scanning



        //Problem 3: Group anagrams

        //TODO: Add brute force approach

        /*
         * Method 1:
         * TC: O(n*mlogm) where m is the average length of a word in the array
         * SC: O(n)
         */
       public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();

        for(int i=0;i<strs.length;i++){
            String s=strs[i];
            char[] charArr=s.toCharArray();

            Arrays.sort(charArr);
            String temp=Arrays.toString(charArr);

            if(!map.containsKey(temp)){
                List<String> ls=new ArrayList<>();
                ls.add(s);
                map.put(temp,ls);
            }else{
                List<String> ls=map.get(temp);
                ls.add(s);
                map.put(temp, ls);
            }
        }

        List<List<String>> ls=new ArrayList<>(map.values());
        return ls;

    }
}