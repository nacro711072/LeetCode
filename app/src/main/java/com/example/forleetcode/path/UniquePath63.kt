package com.example.forleetcode.path
//A robot is located at the top-left corner of a m x n grid (marked 'Start' in t
//he diagram below).
//
// The robot can only move either down or right at any point in time. The robot
//is trying to reach the bottom-right corner of the grid (marked 'Finish' in the d
//iagram below).
//
// Now consider if some obstacles are added to the grids. How many unique paths
//would there be?
//
//
//
// An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
// Note: m and n will be at most 100.
//
// Example 1:
//
//
//Input:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//Output: 2
//Explanation:
//There is one obstacle in the middle of the 3x3 grid above.
//There are two ways to reach the bottom-right corner:
//1. Right -> Right -> Down -> Down
//2. Down -> Down -> Right -> Right
//
// Related Topics Array Dynamic Programming

class UniquePath63 {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val m = obstacleGrid.size
        val n = obstacleGrid[0].size
        val dp: Array<IntArray> = Array(m) { IntArray(n) }

        dp[0][0] = if (obstacleGrid[0][0] == 1) 0 else 1

        for (i in 1 until m) {
            dp[i][0] = if (obstacleGrid[i][0] == 1) 0 else dp[i - 1][0]
        }

        for (j in 1 until n) {
            dp[0][j] = if (obstacleGrid[0][j] == 1) 0 else dp[0][j - 1]
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                }
            }
        }

        return dp[m - 1][n - 1]
    }
}