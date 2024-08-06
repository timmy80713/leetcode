/**
 * Problem: https://leetcode.com/problems/non-overlapping-intervals/
 */
class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.size == 1) return 0

        var removeCount = 0

        val sortedIntervals = intervals.sortedBy { it[0] }

        var leftIndex = 0
        var rightIndex = 1
        while (rightIndex < sortedIntervals.size) {
            val leftInterval = sortedIntervals[leftIndex]
            val rightInterval = sortedIntervals[rightIndex]
            if (rightInterval[0] >= leftInterval[1]) {
                leftIndex = rightIndex++
            } else {
                if (leftInterval[1] < rightInterval[1]) {
                    rightIndex++
                } else {
                    leftIndex = rightIndex++
                }
                removeCount++
            }
        }

        return removeCount
    }
}