/**
 * Problem: https://leetcode.com/problems/valid-anagram/
 */
class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val map = mutableMapOf<Char, Int>()
        for (i in 0 until s.length) {
            val char = s[i]
            val count = map[char]
            if (count != null) {
                map[char] = count + 1
            } else {
                map[char] = 1
            }
        }

        for (i in 0 until t.length) {
            val char = t[i]
            val count = map[char]
            if (count != null) {
                map[char] = count - 1
            } else {
                map[char] = -1
            }
        }

        var remainCount = 0
        map.keys.forEach {
            map[it]?.run {
                if (this < 0) return false
                remainCount += this
            }
        }
        return remainCount == 0
    }
}