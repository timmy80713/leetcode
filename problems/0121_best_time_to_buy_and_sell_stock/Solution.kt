/**
 * Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
class Solution {
    fun maxProfit(prices: IntArray): Int {
        val pricesSize = prices.size
        if (pricesSize < 2) return 0

        val map = mutableMapOf<Int, Int>()
        var minPrice = prices[0]
        map[minPrice] = 0
        for (i in 1 until pricesSize) {
            val price = prices[i]
            if (price < minPrice) {
                minPrice = price
                map[minPrice] = 0
                continue
            }
            val delta = price - minPrice
            if (delta > (map[minPrice] ?: 0)) {
                map[minPrice] = delta
            }
        }

        var maxProfit = 0
        map.keys.forEach { key ->
            val profit = map[key] ?: 0
            if (profit > maxProfit) {
                maxProfit = profit
            }
        }
        return maxProfit
    }
}
