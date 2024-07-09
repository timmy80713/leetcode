/**
 * Problem: https://leetcode.com/problems/contains-duplicate/
 */
class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = mutableSetOf<Int>()
        for (i in 0 until nums.size) {
            val num = nums[i]
            if (set.contains(num)) {
                return true
            }
            set.add(num)
        }
        return false
    }
}