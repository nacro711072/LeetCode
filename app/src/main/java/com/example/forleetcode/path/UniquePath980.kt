package com.example.forleetcode.path

/**
You are given an m x n integer array grid where grid[i][j] could be:

- `1` representing the starting square. There is exactly one starting square.

- `2` representing the ending square. There is exactly one ending square.

- `0` representing empty squares we can walk over.

- `-1` representing obstacles that we cannot walk over.


Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.



Example 1:
https://assets.leetcode.com/uploads/2021/08/02/lc-unique1.jpg

Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

Example 2:
https://assets.leetcode.com/uploads/2021/08/02/lc-unique2.jpg

Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)

Example 3:
https://assets.leetcode.com/uploads/2021/08/02/lc-unique3-.jpg

Input: grid = [[0,1],[2,0]]
Output: 0
Explanation: There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 20
1 <= m * n <= 20
-1 <= grid[i][j] <= 2
There is exactly one starting cell and one ending cell.

 */

// https://leetcode.com/problems/unique-paths-iii/description/
class UniquePath980 {
    fun uniquePathsIII(grid: Array<IntArray>): Int {
        var startX = 0
        var startY = 0
        var walkableCount = 0

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == startBlock) {
                    startX = i
                    startY = j
                    walkableCount++
                }
                if (grid[i][j] == walkableBlock) walkableCount++
            }
        }

        return countPath(grid, startX, startY, walkableCount)
    }

    private fun countPath(grid: Array<IntArray>, row: Int, col: Int, leftStep: Int): Int {
        val m = grid.size
        val n = grid[0].size

        if (!(row in 0 until m && col in 0 until n) || leftStep < 0) return 0

        return when(grid[row][col]) {
            startBlock, walkableBlock -> {
                grid[row][col] = obstacleBlock
                val nextLeftStep = leftStep - 1
                val count = countPath(grid, row + 1, col, nextLeftStep) +
                        countPath(grid, row - 1, col, nextLeftStep) +
                        countPath(grid, row, col + 1, nextLeftStep) +
                        countPath(grid, row, col - 1, nextLeftStep)
                grid[row][col] = walkableBlock
                count
            }
            obstacleBlock -> 0
            endBlock -> if (leftStep == 0) return 1 else 0
            else -> throw Exception("Not expected value")
        }
    }

    private val walkableBlock = 0
    private val obstacleBlock = -1
    private val startBlock = 1
    private val endBlock = 2

}