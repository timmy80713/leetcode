/**
 * Problem: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) return null

        if (preorder.size == 1) return TreeNode(preorder[0])

        val root = preorder[0]
        val rootIndexOfInorder = inorder.indexOf(root)
        return TreeNode(root).apply {
            left = buildTree(
                preorder.copyOfRange(1, rootIndexOfInorder + 1),
                inorder.copyOfRange(0, rootIndexOfInorder)
            )
            right = buildTree(
                preorder.copyOfRange(rootIndexOfInorder + 1, preorder.size),
                inorder.copyOfRange(rootIndexOfInorder + 1, inorder.size)
            )
        }
    }
}