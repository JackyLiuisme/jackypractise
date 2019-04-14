package leetcode.dynamicprograming;

/**
 *Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 */
public class maxProfit {
    public static void main(String[] args) {
        int [] price = {2,4,1};
        int n = maxProfit(price);
        System.out.println(n);
    }
    public static int maxProfit(int[] prices) {
        if(prices.length == 0 || prices == null || prices.length == 1){
            return 0;
        }

        int temp = 0, result =0;
        for(int i = 1; i < prices.length; i++){
            temp = Math.max(temp += prices[i] - prices[i-1], 0);
            result  = Math.max(result,temp);
        }
        return result;


        /*
        int[] copy = Arrays.copyOf(prices, prices.length);
        Arrays.sort(copy);
        int max = 0,count = 0;
        for (int i = 0; i < prices.length; i++){
            if (copy[0] == prices[i]){
                count = i;
            }
        }
        for (int i = count; i < prices.length; i++){
            max = Math.max(prices[i]-copy[0],max);
        }
        return max;*/
    }
}
