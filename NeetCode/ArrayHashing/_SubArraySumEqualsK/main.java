package _SubArraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

public class main {

    //Brute force
    //TC: O(N^2)
    //SC: O(1)


    //TC: O(N)
    //SC: O(N)
    public static int prefSumEqualsK(int[] arr,int k){
        Map<Integer,Integer> prefSumMap=new HashMap<>();

        int result=0;
        int prefSum=0;

        for(int i=0;i<arr.length;i++){
            prefSum+=arr[i];

            if(prefSum==k){
                result++;
            }

            int desiredSum=prefSum-k;

            int freq=prefSumMap.getOrDefault(desiredSum, 0);

            if(freq>0){
                result+=freq;
            }

            if(prefSumMap.containsKey(prefSum)){
                int num=prefSumMap.get(prefSum);
                prefSumMap.put(prefSum, num+1);
            }else{
                prefSumMap.put(prefSum, 1);
            }

        }


        return result;
    }

}
