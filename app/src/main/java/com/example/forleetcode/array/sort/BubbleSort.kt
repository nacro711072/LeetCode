package com.example.forleetcode.array.sort

class BubbleSort: ArraySort {
    override fun sortArray(nums: IntArray): IntArray {
        for (i in nums.indices) {
            for (j in (i + 1)..nums.lastIndex) {
                if (nums[i] > nums[j]) {
                    val temp = nums[i]
                    nums[i] = nums[j]
                    nums[j] = temp
                }
            }
        }
        return nums
    }
}