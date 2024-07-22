import kotlin.math.max

/**
 * Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var result = 0
        val letterSet = mutableSetOf<Char>()
        var startIndex = 0

        for (endIndex in 0 until s.length) {
            val endChar = s[endIndex]

            while (letterSet.contains(endChar)) {
                letterSet.remove(s[startIndex])
                startIndex++
            }

            letterSet.add(endChar)

            result = max(result, endIndex - startIndex + 1)
        }

        return result
    }
}