/**
 * Problem: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
class Solution {
    fun findMin(nums: IntArray): Int {
        var minimum = Int.MAX_VALUE
        var leftIndex = 0
        var rightIndex = nums.size - 1

        while (leftIndex <= rightIndex) {
            val middleIndex = (leftIndex + rightIndex) / 2

            val middle = nums[middleIndex]
            val left = nums[leftIndex]

            if (middle >= left) {
                if (left < minimum) minimum = left
                leftIndex = middleIndex + 1
            } else {
                if (middle < minimum) minimum = middle
                rightIndex = middleIndex - 1
            }
        }
        return minimum
    }
}