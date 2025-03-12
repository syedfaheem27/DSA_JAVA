package _NamingACompany;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class main{


    //Brute force approach

    //Time complexity : TC O(N^2)
    //Space Complexity : SC O(N^2)
    public long distinctNames(String[] ideas) {
       Map<String,Boolean> map=new HashMap<>();
       Set<String> set =new HashSet<>();

       int n=ideas.length;

       for(int i=0;i<n;i++){
           map.put(ideas[i], true);
       }

       for(int i=0;i<n;i++){
           String firstWord=ideas[i];

           for(int j=0;j<n;j++){
               if(i==j){
                   continue;
               }

               String secondWord=ideas[j];

               char a=firstWord.charAt(0);
               char b=secondWord.charAt(0);

               String comp1=b + firstWord.substring(1);
               if(map.containsKey(comp1)){
                   continue;
               }

               String comp2=a+secondWord.substring(1);
               if(map.containsKey(comp2)){
                   continue;
               }

               String companyName=comp1+" "+comp2;
               set.add(companyName);
           }
       }


       return set.size();
   }

}