package com.example.forleetcode.path

class UniquePath62 {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp: Array<IntArray> = Array(m) { IntArray(n) { 1 } }
        for (i in 1 until m) {
            for (j in 1 until n) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }

        return dp[m - 1][n - 1]
    }
}