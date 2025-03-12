package _CustomHashSet;
 //Brute Force
 // 0>=key<=10^6

 //Since this method uses an array, it would be faster as the space is allocated at the run-time and not dynamically

import java.util.ArrayList;
import java.util.List;

public class HashSetCustom {
    private boolean[] arr;

    public HashSetCustom() {
        this.arr=new boolean[(int)(Math.pow(10,6)+1)];
    }

    //TC:O(1)
    public void add(int key){
        this.arr[key]=true;
    }

    //TC: O(1)
    public void remove(int key){
        if(!this.arr[key])
            return;

        this.arr[key]=false;
    }

    //TC O(1)
    public boolean contains(int key){
        return this.arr[key];
    }

}



//Using the concept of buckets: Here we would take array list as a bucket
class HashSetCustomI{
    private int n=1000; // we can keep it less also. Keeping it less will increase the number of collision that is a lot of keys will have
    //the same bucket index and as thus the values will be chained to the end which slows down the operations
    private List<Integer>[] arr;

    public HashSetCustomI() {
        this.arr=new List[this.n];
        for(int i=0;i<n;i++){
            this.arr[i]=new ArrayList<>();
        }
    }

   public void add(int key){
        int bucketIdx=key%10_00_000;
        List<Integer> list=this.arr[bucketIdx];

        if(!list.contains(key)){
            list.add(key);
        }
    }

    public void remove(int key){
        int bucketIdx=key%10_00_000;
        List<Integer> list=this.arr[bucketIdx];

        if(list.contains(key)){
            return;
        }

        list.remove(key);
    }

    public boolean contains(int key){
        int bucketIdx=key%10_00_000;
        List<Integer> list=this.arr[bucketIdx];

        return list.contains(key);
    }

}