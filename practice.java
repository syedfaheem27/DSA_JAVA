public class practice {
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
