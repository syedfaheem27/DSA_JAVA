package _CustomHashMap;
//Brute force approach
public class HashMapCustom {
    private int n=1000000;
    private int[] arr;

    public HashMapCustom() {
        this.arr=new int[this.n+1];
        for(int i=0;i<this.arr.length;i++){
            this.arr[i]=-1;
        }
    }

    public void put(int key, int value) {
        this.arr[key]=value;
    }

    public int get(int key) {
        return this.arr[key];
    }

    public void remove(int key) {
        if(this.arr[key]==-1){
            return;
        }

        this.arr[key]=-1;
    }
}

//TODO:
//Implement another approach using linked lists