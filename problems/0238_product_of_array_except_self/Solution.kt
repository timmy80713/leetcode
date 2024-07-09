/**
 * Problem: https://leetcode.com/problems/product-of-array-except-self/
 */
class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val answers = IntArray(nums.size)
        val zeroSet = mutableSetOf<Int>()
        var productWithoutZero = 1
        for (i in 0 until nums.size) {
            val num = nums[i]
            if (num == 0) {
                zeroSet.add(i)
                continue
            }
            productWithoutZero *= num
        }

        val zeroCount = zeroSet.size
        for (i in 0 until nums.size) {
            val num = nums[i]
            when {
                zeroCount == 0 -> answers[i] = productWithoutZero / num
                zeroCount == 1 && zeroSet.contains(i) -> answers[i] = productWithoutZero
                else -> answers[i] = 0
            }
        }

        return answers
    }
}