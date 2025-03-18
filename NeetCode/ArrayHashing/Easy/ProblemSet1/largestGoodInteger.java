package Easy.ProblemSet1;

public class largestGoodInteger {


    //TC: O(6*(n-2))
    //SC: O(n) because of the substring being created every time
    public static String largestGoodIntegerBrute(String num) {
        int max=-1;
        int n=num.length();



        for(int i=0;i<n-2;i++){
            boolean isValid=true;
            String substr=num.substring(i, i+3);

            for(int j=1;j<=2;j++){
                if(substr.charAt(j)!=substr.charAt(j-1)){
                    isValid=false;
                    break;
                }
            }

            if(isValid){
                max=Math.max(max,Integer.parseInt(substr));
            }
        }



        return max==-1?"":max==0?"000":""+max;

    }

    //Although the same complexity but fewer checks made in case of valid good integers
    public static String largestGoodIntegerOptimalI(String num){
       int max=-1;

        int n=num.length();

        int i=0;

        while(i<n-2){
            boolean isValid=true;
            String substring=num.substring(i, i+3);

            for(int j=1;j<3;j++){
                if(substring.charAt(j-1)!=substring.charAt(j)){
                    isValid=false;
                    break;
                }
            }

            if(isValid){
                max=Math.max(max, Integer.parseInt(substring));
                i+=3;
            }else{
                i++;
            }
        }


        return max==-1?"":max==0?"000":""+max;
    }


    //A better one than the previous one because we are not creating substrings unnecessarily
    public static String largestGoodIntegerOptimalII(String num){
        int max=-1;

        int n=num.length();

        int i=0;


        while(i<n-2){
            boolean isValid=true;
            for(int j=i+1;j<i+3 && j<n;j++){
                if(num.charAt(j)!=num.charAt(j-1)){
                        isValid=false;
                        break;
                }
            }

            if(isValid){
                String substr=num.substring(i, i+3);
                max=Math.max(max, Integer.parseInt(substr));
                i+=3;
            }else{
                i++;
            }
        }

        return max==-1?"":max==0?"000":""+max;

    }


    //No need to extract substrings because if we found a valid sub-string, all the chars are the same
    public static String largestGoodIntegerOptimalIII(String num){
        int max=-1;

        int n=num.length();

        int i=0;


        while(i<n-2){
            if(i<n-2 && num.charAt(i)==num.charAt(i+1) && num.charAt(i+1)==num.charAt(i+2)){
                int val=(num.charAt(i)-'0')*111;

                max=Math.max(max, val);
                i+=3;
            }else{
                i++;
            }


        }

        return max==-1? "" : max==0 ? "000" : "" + max;

    }
}
