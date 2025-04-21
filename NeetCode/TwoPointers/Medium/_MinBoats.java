package NeetCode.TwoPointers.Medium;

import java.util.Arrays;


//Approach 1: Sort and use two pointers
//TC: O(nlogn)
//SC: O(1)
//TODO: Do with brute force
public class _MinBoats {
    public static int minBoatsToSavePeopleI(int[] people,int limit){
        int numPeople = people.length;
        int minBoats = 0;

        Arrays.sort(people);

        if(people[0] > limit)
        {
            return 0;
        }

        int left = 0, right = numPeople - 1;

        //reducing our search space
        while(right>=left && people[right] > limit){
            right--;
        }


        while(left <= right){
            if(people[right] == limit){
                minBoats++;
                right--;
            }else{
                int sum = people[left] + people[right];

                if(sum<=limit){
                    minBoats++;
                    left++;
                    right--;
                }else{
                    if(people[right]<limit){
                        minBoats++;
                    }
                    right--;
                }
            }
        }


        return minBoats;
    }
}
