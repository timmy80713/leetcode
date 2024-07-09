/**
 * Problem: https://leetcode.com/problems/two-sum/
 */
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val deltaMap = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, num ->
            val delta = target - num
            deltaMap[delta]?.run {
                return intArrayOf(this, index)
            }
            deltaMap[num] = index
        }
        throw IllegalArgumentException("no solution found")
    }
}