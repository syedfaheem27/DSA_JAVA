package _CanPlaceFlowers;


//This is the Greedy approach.

//Someone might argue that the number of flowers planted would turn out to be different if
//we started from the first or the zeroth index but that is not the case.

//We place the flower as soon as we find an appropriate position to plant which is the essence of the greedy algorithm

public class main {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int numFlowersPlanted=0;


        boolean isLeftPlanted=false;
        boolean isRightPlanted=false;


        for(int i=0;i<len;i++){
                if(i==0){
                    isLeftPlanted=false;
                }else{
                    isLeftPlanted=flowerbed[i-1]==1;
                }

                if(i==len-1){
                    isRightPlanted=false;
                }else {
                    isRightPlanted=flowerbed[i+1]==1;
                }

                if(isLeftPlanted || isRightPlanted){
                    continue;
                }

                if(flowerbed[i]==0 && !isLeftPlanted && !isRightPlanted){
                    numFlowersPlanted++;
                    flowerbed[i]=1;

                    if(numFlowersPlanted==n)
                        return true;
                }

        }


        return numFlowersPlanted>=n;
    }
}



//Implement a brute force