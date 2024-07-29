/**
 * Problem: https://leetcode.com/problems/palindromic-substrings/submissions/
 */
class Solution {
    fun countSubstrings(s: String): Int {
        var result = 0
        for (i in 0 until s.length) {
            result += calculatePalindromeCount(s, i, i)
            result += calculatePalindromeCount(s, i, i + 1)
        }
        return result
    }

    private fun calculatePalindromeCount(s: String, startIndex: Int, endIndex: Int): Int {
        var result = 0
        var leftIndex = startIndex
        var rightIndex = endIndex
        while (leftIndex >= 0 && rightIndex <= s.length - 1 && s[leftIndex] == s[rightIndex]) {
            result++
            leftIndex--
            rightIndex++
        }
        return result
    }
}