package com.example.forleetcode.array.sort

class InsertSort: ArraySort {
    override fun sortArray(nums: IntArray): IntArray {
        for (i in 1..nums.lastIndex) {
            for (j in (i - 1) downTo 0) {
                if (nums[j + 1] < nums[j]) {
                    swap(nums, j + 1, j)
                } else {
                    break
                }
            }
        }
        return nums
    }
}