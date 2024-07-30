/**
 * Problem: https://leetcode.com/problems/pacific-atlantic-water-flow/
 */
class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val rows = heights.size
        val columns = heights[0].size

        val canFlowToPacificIndexSet = mutableSetOf<Pair<Int, Int>>()
        val canFlowToAtlanticIndexSet = mutableSetOf<Pair<Int, Int>>()

        for (column in 0 until columns) {
            dfs(heights, 0, column, heights[0][column], canFlowToPacificIndexSet)
            dfs(heights, rows - 1, column, heights[rows - 1][column], canFlowToAtlanticIndexSet)
        }

        for (row in 0 until rows) {
            dfs(heights, row, 0, heights[row][0], canFlowToPacificIndexSet)
            dfs(heights, row, columns - 1, heights[row][columns - 1], canFlowToAtlanticIndexSet)
        }

        for (column in 0 until columns) {
            for (row in 0 until rows) {
                val indexPair = row to column
                if (canFlowToPacificIndexSet.contains(indexPair) && canFlowToAtlanticIndexSet.contains(indexPair)) {
                    result.add(listOf(row, column))
                }
            }
        }

        return result
    }

    private fun dfs(
        heights: Array<IntArray>,
        row: Int,
        column: Int,
        previousHeight: Int,
        visitedSet: MutableSet<Pair<Int, Int>>
    ) {
        if (row < 0 || row >= heights.size) return
        if (column < 0 || column >= heights[0].size) return
        if (visitedSet.contains(row to column)) return
        if (heights[row][column] < previousHeight) return

        visitedSet.add(row to column)

        dfs(heights, row - 1, column, heights[row][column], visitedSet)
        dfs(heights, row + 1, column, heights[row][column], visitedSet)
        dfs(heights, row, column + 1, heights[row][column], visitedSet)
        dfs(heights, row, column - 1, heights[row][column], visitedSet)
    }
}