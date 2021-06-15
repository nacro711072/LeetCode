package com.example.forleetcode

/*
Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.



Example 1:

Input: arr = [1,15,7,9,2,5,10], k = 3
Output: 84
Explanation: arr becomes [15,15,15,9,10,10,10]

Example 2:

Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
Output: 83

Example 3:

Input: arr = [1], k = 1
Output: 1



Constraints:

    1 <= arr.length <= 500
    0 <= arr[i] <= 109
    1 <= k <= arr.length


 */
sealed class PartitionArrForMaxSum1043 {
    abstract fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int

    object SimpleImpl: PartitionArrForMaxSum1043() {
        override fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
            return findMaxRange(arr, k, 0)
        }

        private fun findMaxRange(arr: IntArray, k: Int, start: Int): Int {
            if (start == arr.lastIndex) return arr.last()
            var maxArea = 0
            var max = 0
            val end = (start + k).coerceAtMost(arr.size)
            for (i in start until end) {
                max = arr[i].coerceAtLeast(max)
                val area = max * (i - start + 1)
                maxArea = (area + findMaxRange(arr, k, i + 1)).coerceAtLeast(maxArea)
            }
            return maxArea
        }
    }

    object DPImpl: PartitionArrForMaxSum1043() {
        /*
        從SimpleImpl 延伸
        Simple 會有重複的:
        1. | 1, 2 | 3 | findMaxAfter(i + 1) |
        2. | 1 | 2, 3 | findMaxAfter(i + 1) |
        1. 跟 2. 的 findMaxAfter() 其實是一樣的.
        只要記著後面的結果就不會重覆計算

        反過來說:
        3. | findMaxBefore(i) | i + 1, ...|
        4. | findMaxBefore(i) | i + 1| ...|
        只要記住前 i個 的結果就不會重覆計算

        因此使用 dp[i] 去記:
        前 i 個元素, 可能出現的最大的結果
         */
        override fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
            val dp = IntArray(arr.size + 1) // 為了方便, 第一個裝0

            for (i in 1..dp.lastIndex) {
                var maxHeight = 0
                var maxArea = 0
                val maxStep = Math.min(i, k)
                for (sub in 1..maxStep) {
                    maxHeight = arr[i - sub].coerceAtLeast(maxHeight)
                    maxArea = (maxHeight * sub + dp[i - sub]).coerceAtLeast(maxArea)
                }
                dp[i] = maxArea
            }
            return dp.last()
        }

    }

}