import java.util.*

/**
 * Problem: https://leetcode.com/problems/validate-binary-search-tree/
 */
class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        var previousValue: Int? = null
        val stack = Stack<TreeNode>()
        var currentNode = root
        while (true) {

            while (currentNode != null) {
                stack.push(currentNode)
                currentNode = currentNode.left
            }

            if (stack.size != 0) {
                currentNode = stack.pop()
                if (previousValue == null || currentNode.`val` > previousValue) {
                    previousValue = currentNode.`val`
                    currentNode = currentNode.right
                } else {
                    return false
                }
            } else {
                break
            }
        }
        return true
    }
}