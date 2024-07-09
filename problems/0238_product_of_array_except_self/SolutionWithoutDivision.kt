/**
 * Problem: https://leetcode.com/problems/product-of-array-except-self/
 */
class SolutionWithoutDivision {
    fun productExceptSelf(nums: IntArray): IntArray {
        val answers = IntArray(nums.size)

        val leftToRight = IntArray(nums.size) { 1 }
        val rightToLeft = IntArray(nums.size) { 1 }

        var previousIndex = 0
        for (i in 0 until nums.size) {
            if (i == 0) {
                leftToRight[i] = nums[i]
                continue
            }
            leftToRight[i] = leftToRight[previousIndex] * nums[i]
            previousIndex++
        }

        previousIndex = nums.size - 1
        for (i in nums.size - 1 downTo 0) {
            if (i == previousIndex) {
                rightToLeft[i] = nums[i]
                continue
            }
            rightToLeft[i] = rightToLeft[previousIndex] * nums[i]
            previousIndex--
        }

        for (i in 0 until nums.size) {
            if (i == 0) {
                answers[i] = rightToLeft[i + 1]
                continue
            }
            if (i == nums.size - 1) {
                answers[i] = leftToRight[i - 1]
                continue
            }
            answers[i] = leftToRight[i - 1] * rightToLeft[i + 1]
        }

        return answers
    }
}