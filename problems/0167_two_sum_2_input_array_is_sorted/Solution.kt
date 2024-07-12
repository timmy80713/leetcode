/**
 * Problem: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val result = IntArray(2)
        var leftIndex = 0
        var rightIndex = numbers.size - 1
        while (leftIndex < rightIndex) {
            val leftNum = numbers[leftIndex]
            val rightNum = numbers[rightIndex]
            if (leftNum + rightNum == target) {
                result[0] = ++leftIndex
                result[1] = ++rightIndex
                break
            }
            if (leftNum + rightNum > target) rightIndex--
            if (leftNum + rightNum < target) leftIndex++
        }
        return result
    }
}