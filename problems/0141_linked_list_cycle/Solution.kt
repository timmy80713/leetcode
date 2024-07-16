/**
 * Problem: https://leetcode.com/problems/linked-list-cycle/
 */
class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        val set = mutableSetOf<ListNode>()

        var node = head
        while (node != null) {
            if (set.contains(node)) return true
            set.add(node)
            node = node.next
        }

        return false
    }
}