/**
 * Problem: https://leetcode.com/problems/invert-binary-tree/
 */
class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        swap(root)
        return root
    }

    private fun swap(node: TreeNode?) {
        if (node == null) return
        val temp = node.left
        node.left = node.right
        node.right = temp
        swap(node.left)
        swap(node.right)
    }
}