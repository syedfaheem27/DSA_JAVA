package _Others;

import java.util.HashMap;
import java.util.Map;

public class ProblemSet6 {
    //TC O(N)
    //SC O(N)


    //TODO: see if you everything can be done using a single map
    //TODO: Brute force implementation
    public boolean wordPatternI(String pattern,String s){
        String[] arr=s.split(" ");

        if(pattern.length()!=arr.length){
            return false;
        }

        Map<Character,String> map=new HashMap<>();
        Map<String,Character> revMap=new HashMap<>();



        for(int i=0;i<pattern.length();i++){
            Character ch=pattern.charAt(i);
            String rest=arr[i];

            if(map.containsKey(ch)){
                String val=map.get(ch);

                if(!val.equals(rest)){
                    return false;
                }
            }else{
                map.put(ch, rest);
            }


            if(revMap.containsKey(rest)){
                Character val=revMap.get(rest);

                if(!val.equals(ch)){
                    return false;
                }
            }else{
                revMap.put(rest, ch);
            }



        }


        return true;
    }
}
