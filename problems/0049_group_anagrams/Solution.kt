/**
 * Problem: https://leetcode.com/problems/group-anagrams/
 */
class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()
        for (i in 0 until strs.size) {
            val str = strs[i]

            val intArray = IntArray(str.length)
            for (j in 0 until str.length) {
                intArray[j] = str[j].code
            }

            sort(intArray)

            var sortedString = ""
            for (j in 0 until intArray.size) {
                sortedString += intArray[j]
            }

            if (map.containsKey(sortedString)) {
                map[sortedString]?.add(str)
            } else {
                map[sortedString] = mutableListOf(str)
            }
        }

        return map.map { it.value }
    }

    private fun sort(source: IntArray) {
        quickSort(source, 0, source.size - 1)
    }

    private fun quickSort(source: IntArray, startIndex: Int, endIndex: Int) {
        var pivotIndex = startIndex
        for (i in startIndex + 1..endIndex) {
            val current = source[i]
            val pivot = source[pivotIndex]
            if (current < pivot) {
                source[pivotIndex] = current
                if (i == pivotIndex + 1) {
                    source[i] = pivot
                } else {
                    source[i] = source[pivotIndex + 1]
                    source[pivotIndex + 1] = pivot
                }
                pivotIndex++
            }
        }
        if (startIndex < pivotIndex - 1) quickSort(source, startIndex, pivotIndex - 1)
        if (pivotIndex + 1 < endIndex) quickSort(source, pivotIndex + 1, endIndex)
    }
}