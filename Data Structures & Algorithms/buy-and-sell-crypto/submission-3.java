
// class Solution{
//     public int maxProfit(int[] prices){
//         int minPrice = Integer.MAX_VALUE;
//         int maxProfit = Integer.MIN_VALUE;
//         for(int p : prices){
//             minPrice = Math.min(minPrice, p);
//             maxProfit = Math.max(maxProfit, p - minPrice);
//         }
//         return maxProfit;
//     }
// }

class Solution{
    public int maxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int p : prices){
            if(p < minPrice){
                minPrice = p;
            }
            if(p - minPrice > maxProfit){
                maxProfit = p - minPrice;
            }
        }
        return maxProfit;
    }
}