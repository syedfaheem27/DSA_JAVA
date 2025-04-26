package NeetCode.SlidingWindow.Easy;

public class BestTimeToBuyAndSellStock {
    //TC:O(N)
    //SC:O(1)

    //TODO: Why is it listed in sliding window if it is solvable using a simple iteration

    //You can think of it as a dynamic sliding window problem because the first pointer can be the costPrice one
    //and this pointer shifts when we find a lesser cp.



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
