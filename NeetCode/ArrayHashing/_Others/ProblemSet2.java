package _Others;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProblemSet2 {
    //Problem 1: Valid Anagram

   /*
    * Method 1:(NOTE) Only valid for strings with alphabets
    * TC - O(2N) ~ O(N)
    * SC - O(1) - creating an array of size 26 always
    */

    public boolean validAnagramI(String str1,String str2){
        if(str1.length()!=str2.length())
            return false;

        int[] occurrences=new int[26];

        for(int i=0;i<str1.length();i++){
            char ch=str1.charAt(i);
            int ascii;
            if(ch>=97){
                ascii=(int) ch -(int)'a';
            }else {
                ascii=(int) ch -(int)'A';
            }



            occurrences[ascii]+=1;
        }

        for(int i=0;i<str2.length();i++){
            char ch=str2.charAt(i);
            int ascii;
            if(ch>=97){
                ascii=(int) ch -(int)'a';
            }else {
                ascii=(int) ch -(int)'A';
            }

            occurrences[ascii]-=1;
            if(occurrences[i]<0)
                return false;
        }

        for(int i=0;i<26;i++){
            if(occurrences[i]!=0)
                return false;
        }



        return true;
    }


    /*
     * Method 2: Sorting the strings and comparing
     * TC : O(NlogN)
     * SC : O(N)
     */
    public boolean validAnagramII(String str1,String str2){


    if(str1.length()!=str2.length())
        return false;

    String[] str1Arr=str1.split("");
    String[] str2Arr=str2.split("");


    Arrays.sort(str1Arr);
    Arrays.sort(str2Arr);

    for(int i=0;i<str1Arr.length;i++){

        if(!str1Arr[i].equals(str2Arr[i]))
            return false;

    }
        return true;

}


    /*
     * Method 2: Sorting the strings and comparing
     * using in-built methods
     * TC : O(NlogN)
     * SC : O(N)
     */
    public boolean validAnagramIII(String str1,String str2){
        if(str1.length()!=str2.length())
            return false;

        char[] ch1=str1.toCharArray();
        char[] ch2=str2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);


        for(int i=0;i<ch1.length;i++){
            if(ch1[i]!=ch2[i])
                return false;
        }

        return true;
    }


    /*
     * Method 3: Storing the count of characters in a hash map
     * TC: O(N)
     * SC: O(N)
     */
    public boolean validAnagramIV(String str1,String str2){
        if(str1.length()!=str2.length())
            return false;

        Map<Character,Integer> map=new HashMap<>();

        for(int i=0;i<str1.length();i++){
            char ch=str1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(int i=0;i<str2.length();i++){
            char ch=str2.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)-1);

            if(map.get(ch)<0){
                return false;
            }
        }

        return true;
    }



    //Problem 2:Replace Elements with Greatest Element on Right Side

    /*
     * Method 1: Brute force approach
     * TC O(N^2)
     * SC O(1)
     */

     public int[] replaceElementsI(int[] arr){
        if(arr.length==1)
            return arr;

        for(int i=0;i<arr.length-1;i++){
            int greatestToRight=arr[i+1];

            for(int j=i+1;j<arr.length;j++){
                greatestToRight=Math.max(greatestToRight,arr[j]);
            }

            arr[i]=greatestToRight;
        }
        arr[arr.length-1]=-1;

        return arr;

     }




    /*
     * Method 2
     * TC O(N)
     * SC O(1)
     * Although, not a good practice to tamper with the input
     */

     public int[] replaceElementsII(int[] arr) {
        int greatestToRight=-1;
        int temp;

        for(int i=arr.length-1;i>=0;i--){
            temp=arr[i];
            arr[i]=greatestToRight;


            greatestToRight=Math.max(greatestToRight,temp);
        }

        return arr;

    }



    //Problem 3: Length of last word
    /*
     * Restricting the search zone and making sure there are no spaces
     * towards the start and the end in our search zone
     *
     * TC: O(N)
     * SC: O(1)
     */

    public int lengthOfLastWordI(String s) {
        int len=0;
        int i=0;

        while(i<s.length()-1&&s.charAt(i)==' ')
            i++;

        int j=s.length()-1;

        while(j>=i && s.charAt(j)==' ')
            j--;

        for(;i<=j;i++){
            if(s.charAt(i)==' '){
                len=0;
                continue;
            }

            len++;
        }

        return len;

    }

    //We can split the string into an array on one or more than one white spaces
    //using a regular expression and return the last element of the array


    /*
     * Method 2: A better approach
     * TC O(N)
     * SC O(1)
     */
    public int lengthOfLastWordII(String s) {
        int i=s.length()-1;
        while(i>=0 && s.charAt(i)==' ')
            i--;

        int len=0;
        while(s.charAt(i)!=' ')
            len++;

        return len;

    }


}
