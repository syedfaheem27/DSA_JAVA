package NeetCode.TwoPointers.Easy;

public class MergeStringsAlternatively {

    //TC: O(Math.max(m,n))
    //SC: O(m+n)

    //Because everytime we are creating new string objects, this one is expensive
    public String mergeAlternatelyI(String word1, String word2) {
        String str="";

        int i=0,j=0;


        while(i<word1.length() || j<word2.length()){

            if(i<word1.length())
                str+=word1.charAt(i++);

            if(j<word2.length())
                str+=word2.charAt(j++);
        }

        return str;
    }


    //Using a string builder
    public String mergeAlternatelyII(String word1, String word2) {
        StringBuilder str=new StringBuilder();

        int i=0,j=0;


        while(i<word1.length() || j<word2.length()){

            if(i<word1.length())
                str.append(word1.charAt(i++));

            if(j<word2.length())
                str.append(word2.charAt(j++));
        }

        return str.toString();
    }
}
