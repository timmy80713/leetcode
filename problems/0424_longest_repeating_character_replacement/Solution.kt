/**
 * Problem: https://leetcode.com/problems/longest-repeating-character-replacement/
 */
class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var result = 0

        val letterCountMap = mutableMapOf<Char, Int>()
        var startIndex = 0

        for (endIndex in 0 until s.length) {
            val endChar = s[endIndex]
            val countOfEndChar = letterCountMap.getOrElse(endChar) { 0 }
            letterCountMap[endChar] = countOfEndChar + 1

            val maxLetterCount = letterCountMap.values.max()

            if ((endIndex - startIndex + 1) - maxLetterCount > k) {
                val startChar = s[startIndex]
                val countOfStartChar = letterCountMap.getOrElse(startChar) { 0 }
                letterCountMap[startChar] = countOfStartChar - 1
                startIndex++
            }

            result = endIndex - startIndex + 1
        }

        return result
    }
}