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
}
