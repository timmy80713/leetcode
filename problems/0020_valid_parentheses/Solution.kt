import java.util.*

/**
 * Problem: https://leetcode.com/problems/valid-parentheses/
 */
class Solution {
    fun isValid(s: String): Boolean {
        val map = mutableMapOf('(' to ')', '[' to ']', '{' to '}')
        val stack = Stack<Char>()
        for (i in 0 until s.length) {
            val char = s[i]
            if (map.containsKey(char)) {
                stack.push(char)
            } else {
                if (stack.size == 0) return false
                val previousChar = stack.pop()
                if (map[previousChar] != char) return false
            }
        }
        return stack.size == 0
    }
}