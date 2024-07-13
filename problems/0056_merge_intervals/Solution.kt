import kotlin.math.max
import kotlin.math.min

/**
 * Problem: https://leetcode.com/problems/merge-intervals/
 */
class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.size == 1) return intervals

        val sortedIntervals = intervals.sortedBy { it[0] }

        var startIndex = 0
        var endIndex = startIndex + 1
        var mergeCount = 0

        while (endIndex <= sortedIntervals.size - 1) {
            val startArray = sortedIntervals[startIndex]
            val endArray = sortedIntervals[endIndex]

            val startLeft = startArray[0]
            val startRight = startArray[1]
            val endLeft = endArray[0]
            val endRight = endArray[1]
            if (endLeft <= startRight) {
                mergeCount++
                startArray[0] = min(startLeft, endLeft)
                startArray[1] = max(startRight, endRight)

                endArray[0] = 0
                endArray[1] = 0

                endIndex++
            } else {
                startIndex = endIndex++
            }
        }

        val result = Array(sortedIntervals.size - mergeCount) { IntArray(2) }
        var resultIndex = 0
        for (i in 0 until sortedIntervals.size) {
            val intArray = sortedIntervals[i]
            if (intArray[0] == 0 && intArray[1] == 0) continue

            result[resultIndex++] = intArray
        }
        return result
    }
}