package NeetCode.SlidingWindow.Easy;

public class BestTimeToBuyAndSellStock {
    //TC:O(N)
    //SC:O(1)

    //TODO: Figure out why is it listed in sliding window when it's just a single pointer problem
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int cp = 100000;


        for(int i=0;i<prices.length;i++){
            int sp = prices[i];

            if(sp>cp){
                maxProfit = Math.max(sp-cp,maxProfit);
            }else{
                cp = prices[i];
            }
        }


        return maxProfit;
    }
}
