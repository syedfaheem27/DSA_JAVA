package NeetCode.SlidingWindow.Medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    //TC: O(N)
    //SC: O(N)
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int maxLen = 0;

        Set<Character> set = new HashSet<>();

        int p1 = 0;
        int k = p1;

        for(;k<n;k++){
            Character ch = s.charAt(k);
            if(set.contains(ch)){
                break;
            }
            set.add(ch);
            maxLen = Math.max(set.size(),maxLen);
        }



        while(k<n){
            while(p1<=k && set.contains(s.charAt(k))){
                set.remove(s.charAt(p1++));
                maxLen = Math.max(maxLen,set.size());
            }

            set.add(s.charAt(k));
            maxLen = Math.max(maxLen,set.size());
            k++;
        }




        return maxLen;
    }


    //cleaner but with the same TC
    public int lengthOfLongestSubstringI(String s) {
        int n = s.length();

        int maxLen = 0;

        int left = 0;
        int right = 0;

        Set<Character> set = new HashSet<>();


        while(right<n){
            if(set.contains(s.charAt(right))){
                set.remove(s.charAt(left++));
            }else{
                set.add(s.charAt(right++));
                maxLen = Math.max(maxLen,set.size());
            }
        }



        return maxLen;


    }

}
