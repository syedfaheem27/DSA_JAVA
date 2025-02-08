import java.util.ArrayList;
import java.util.List;

public class ProblemSet4 {
    //Problem 1: Is Subsequence

    /*
     * Method 1: Horizontal scanning: Taking the first character and then comparing it to the whole string
     * TC: O(n * m) where n is the length of target string and m is the length of the subsequence to be found
     * SC: O(1)
     */

    public boolean isSubsequenceI(String s,String target){
        if(s.length()>target.length())
            return false;

        if(s.length()==target.length() && s.equals(target)){
            if(s.equals(target))
                return true;
            else
                return false;
        }


        int prevIndex=-1;
        int len=0;

        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);
            for(int j=prevIndex+1;j<target.length();j++){
                if(temp==target.charAt(j)){
                    prevIndex=j;
                    len++;
                    break;
                }
            }
        }

        return len==s.length();
    }


    /*
     * Method 2: Two pointer approach
     * TC: O(n) where n is the length of the target string
     * Sc: O(1)
     */
    public boolean isSubsequenceII(String s,String target){
        int s_pointer=0;
        int target_pointer=0;

        while(s_pointer < s.length() && target_pointer<target.length()){
            if(s.charAt(s_pointer)==target.charAt(target_pointer)){
                s_pointer++;
                target_pointer++;
            }else{
                target_pointer++;
            }
        }


        return s_pointer==s.length();
    }



    //Problem 2: Pascals triangle
    /*
     * Method 1:
     * TC: O(n^2)
     * The outer loop runs for n times
     * The inner loop runs for 0+1+2+...+n-1 times which is n(n-1)/2 which is O(n^2)
     * Thus the time complexity is quadratic
     * SC: O(1) if we exclude the List of Integer lists that we need to return
     */
     public List<List<Integer>> generatePascalsTriangleI(int numRows) {
        List<List<Integer>> result=new ArrayList<>();

        for(int i=0;i<numRows;i++){
            List<Integer> ls=new ArrayList<>();
            ls.add(1);

            if(i-1>=0){
                for(int j=1;j<result.get(i-1).size();j++){
                    List<Integer> temp=result.get(i-1);
                    Integer num=temp.get(j) + temp.get(j-1);

                    ls.add(num);
                }
            }

            if(i>=1){
                ls.add(1);
            }

            result.add(ls);
        }

        return result;
    }


}
