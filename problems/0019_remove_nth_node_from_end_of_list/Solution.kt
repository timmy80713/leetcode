/**
 * Problem: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val list = mutableListOf<ListNode>()
        var node = head
        while (node != null) {
            list.add(node)
            node = node.next
        }

        if (list.size == 1) return null
        if (n == list.size) return list[1]

        list[list.size - n - 1].next = if (n == 1) null else list[list.size - n + 1]

        return list[0]
    }
}