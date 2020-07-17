package com.example.forleetcode

class FourSumII454 {
    fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
        var count = 0
        val sumAB = twoSumFlow(A, B)

        for (c in C) {
            for (d in D) {
                val sum = -(c + d)
                if (sumAB.containsKey(sum)) {
                    count += sumAB[sum]!!
                }
            }
        }
        return count
    }

    private fun twoSumFlow(nums1: IntArray, nums2: IntArray): Map<Int, Int> {
        val result: MutableMap<Int, Int> = HashMap()
        for (a in nums1) {
            for (b in nums2) {
                val sum = a + b
                if (result.containsKey(sum)) {
                    result[sum] = result[sum]!! + 1
                } else {
                    result[sum] = 1
                }
            }
        }
        return result
    }
}