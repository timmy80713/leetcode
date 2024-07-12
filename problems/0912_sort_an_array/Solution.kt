/**
 * Problem: https://leetcode.com/problems/sort-an-array/
 */
class Solution {
    fun sortArray(nums: IntArray): IntArray {
        return mergeSort(nums)
    }

    private fun mergeSort(source: IntArray): IntArray {
        if (source.size == 1) return source

        val middle = source.size / 2

        val leftSize = middle
        val leftArray = IntArray(leftSize)
        for (i in 0 until leftSize) leftArray[i] = source[i]

        val rightSize = source.size - middle
        val rightArray = IntArray(rightSize)
        for (i in 0 until rightSize) rightArray[i] = source[middle + i]

        val mergedLeftArray = mergeSort(leftArray)
        val mergedRightArray = mergeSort(rightArray)

        return merge(mergedLeftArray, mergedRightArray)
    }

    private fun merge(leftArray: IntArray, rightArray: IntArray): IntArray {
        val result = IntArray(leftArray.size + rightArray.size)
        var leftIndex = 0
        var rightIndex = 0
        var currentIndex = 0

        while (leftIndex <= leftArray.size - 1 && rightIndex <= rightArray.size - 1) {
            val left = leftArray[leftIndex]
            val right = rightArray[rightIndex]
            if (left < right) {
                result[currentIndex] = left
                leftIndex++
            } else {
                result[currentIndex] = right
                rightIndex++
            }
            currentIndex++
        }

        while (leftIndex <= leftArray.size - 1) {
            result[currentIndex] = leftArray[leftIndex++]
            currentIndex++
        }

        while (rightIndex <= rightArray.size - 1) {
            result[currentIndex] = rightArray[rightIndex++]
            currentIndex++
        }
        return result
    }
}