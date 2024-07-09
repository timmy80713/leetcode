/**
 * Problem: https://leetcode.com/problems/reorder-list/
 */
class Solution {
    fun reorderList(head: ListNode?): Unit {
        if (head == null) return

        val list = mutableListOf(head)
        var next = head.next
        while (next != null) {
            val nextNode = next
            list.add(nextNode)
            next = nextNode.next
        }

        var lastIndex = list.size - 1
        for (i in 0 until list.size) {
            val nextIndex = i + 1
            if (nextIndex >= lastIndex) {
                list[lastIndex].next = null
                break
            }

            val nextNode = list[nextIndex]
            val lastNode = list[lastIndex]

            list[i].next = lastNode
            lastNode.next = nextNode

            lastIndex--
        }
    }
}