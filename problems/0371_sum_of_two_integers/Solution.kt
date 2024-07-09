/**
 * Problem: https://leetcode.com/problems/sum-of-two-integers/
 */
class Solution {
    fun getSum(a: Int, b: Int): Int {
        if (a == 0) return b
        if (b == 0) return a

        var sum = a xor b
        var carry = a and b
        while (carry != 0) {
            val tempCarry = carry shl 1
            val tempSum = sum
            sum = tempSum xor tempCarry
            carry = tempSum and tempCarry
        }
        return sum
    }
}