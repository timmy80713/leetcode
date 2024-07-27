import java.util.*

/**
 * Problem: https://leetcode.com/problems/number-of-islands/
 */
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        var islands = 0

        for (rowIndex in 0 until grid.size) {
            for (columnIndex in 0 until grid[0].size) {
                val value = grid[rowIndex][columnIndex]
                if (value == '1') {
                    dfs(grid, rowIndex, columnIndex)
                    islands++
                }
            }
        }

        return islands
    }

    private fun dfs(grid: Array<CharArray>, rowIndex: Int, columnIndex: Int) {
        val directions = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
        val rows = grid.size
        val columns = grid[0].size

        val stack = Stack<Pair<Int, Int>>()

        fun addToQueueAndChangeToWater(row: Int, column: Int) {
            stack.push(row to column)
            grid[row][column] = '0'
        }

        addToQueueAndChangeToWater(rowIndex, columnIndex)

        while (stack.size != 0) {
            val indexPair = stack.pop()

            for (i in 0 until directions.size) {
                val directionPair = directions[i]
                val nextRowIndex = indexPair.first + directionPair.first
                val nextColumnIndex = indexPair.second + directionPair.second

                if (nextRowIndex !in IntRange(0, rows - 1)) continue
                if (nextColumnIndex !in IntRange(0, columns - 1)) continue

                val value = grid[nextRowIndex][nextColumnIndex]

                if (value == '1') addToQueueAndChangeToWater(nextRowIndex, nextColumnIndex)
            }
        }
    }
}