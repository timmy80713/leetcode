/**
 * Problem: https://leetcode.com/problems/reverse-linked-list/
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var current = head
        var previous: ListNode? = null
        while (current != null) {
            val next = current.next

            current.next = previous
            previous = current

            current = next
        }
        return previous
    }
}