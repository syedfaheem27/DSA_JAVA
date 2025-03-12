package _ProductOfArrayExceptSelf;


import java.util.Arrays;

public class main {

    //Brute force approach
    //TC O(N)
    //SC O(1)
    public int[] productExceptSelf(int[] arr) {
        int numZeroes=0;
        int prod=1;

        for(int num:arr){
            if(num==0){
                numZeroes++;
            }else{
                prod*=num;
            }
        }


        int[] result=new int[arr.length];
        Arrays.fill(result, 0);


        for(int i=0;i<arr.length;i++){
            int num=arr[i];

            if(num==0){
                if(numZeroes==1){
                    result[i]=prod;
                }else{
                    result[i]=0;
                }
            }else if(numZeroes>0){
            result[i]=0;
            }else{
                result[i]=prod/num;
            }
        }


        return result;
    }
}
