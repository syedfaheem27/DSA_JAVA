package _NamingACompany;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class main{


    //Brute force approach

    //Time complexity : TC O(N^2) * m where m is the average length of the word
    //Space Complexity : SC O(N^2)
    public long distinctNamesBrute(String[] ideas) {
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



   //Total time: n(for map) + 26^2*m where m is the average number of words starting with a letter
   //TC: O(n+26^2*m) ~ O(K), that is linear time complexity
   //SC: O(N)
   public long distinctNamesOptimal(String[] ideas) {
        Map<Character,Set<String>> map =new HashMap<>(); //n

    //n
        for(String idea : ideas){
            Character ch=idea.charAt(0);
            String rest=idea.substring(1);

            if(map.containsKey(ch)){
                Set<String> set=map.get(ch);

                set.add(rest);
            }else{
                Set<String> set=new HashSet<>();
                set.add(rest);

                map.put(ch, set);
            }
        }

        long totalNames=0;

        //n
        List<Map.Entry<Character,Set<String>>> newEntries=new ArrayList<>(map.entrySet()); //n

        //26^2*m in worst case
        for(int i=0;i<newEntries.size();i++){
            Set<String> setA = newEntries.get(i).getValue();

            for(int j=i+1;j<newEntries.size();j++){
                Set<String> setB=newEntries.get(j).getValue();

                int notUnique=0;

                //in worst case, every set would be of size 1
                for(String idea: setA){
                    if(setB.contains(idea)){
                        notUnique++;
                    }
                }

                int validIdeasI=setA.size()-notUnique;
                int validIdeasII=setB.size()-notUnique;

                totalNames+=(long)(validIdeasI*validIdeasII*2);
            }

        }

        return totalNames;

   }

}