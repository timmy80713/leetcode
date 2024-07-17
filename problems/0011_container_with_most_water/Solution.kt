import kotlin.math.min

/**
 * Problem: https://leetcode.com/problems/container-with-most-water/
 */
class Solution {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var max = 0
        while (left < right) {
            val leftValue = height[left]
            val rightValue = height[right]
            val product = min(leftValue, rightValue) * (right - left)
            if (product > max) {
                max = product
            }
            if (leftValue < rightValue) {
                left++
            } else {
                right--
            }
        }
        return max
    }
}