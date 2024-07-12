/**
 * Problem: https://leetcode.com/problems/3sum/
 */
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        val sortedNums = mergeSort(nums)

        var comparedAnchorNum: Int? = null
        for (i in 0 until sortedNums.size - 1) {
            if (i >= sortedNums.size - 2) break

            val anchorNum = sortedNums[i]
            if (comparedAnchorNum == anchorNum) continue

            val target = 0 - anchorNum
            var leftIndex = i + 1
            var rightIndex = sortedNums.size - 1

            var comparedLeftNum: Int? = null
            var comparedRightNum: Int? = null

            while (leftIndex < rightIndex) {
                val leftNum = sortedNums[leftIndex]
                val rightNum = sortedNums[rightIndex]

                if (leftNum == comparedLeftNum && rightNum == comparedRightNum) {
                    rightIndex--
                    continue
                }

                if (leftNum + rightNum == target) {
                    result.add(listOf(anchorNum, leftNum, rightNum))
                    comparedLeftNum = leftNum
                    comparedRightNum = rightNum
                    rightIndex--
                }
                if (leftNum + rightNum > target) rightIndex--
                if (leftNum + rightNum < target) leftIndex++
            }

            comparedAnchorNum = anchorNum
        }

        return result
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