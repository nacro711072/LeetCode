package com.example.forleetcode.sort

class QuickSort: ArraySort {

    override fun sortArray(nums: IntArray): IntArray {
        sortInterval(nums, 0, nums.lastIndex)
        return nums
    }

    private fun sortInterval(nums: IntArray, start: Int, end: Int) {
        if (start >= end) return
        val baseNum = nums[end]
        var i = start
        var j = end

        while (true) {
            while (i < j && nums[i] < baseNum) i++
            while (i < j && nums[j] >= baseNum) j--
            if (i < j) {
                swap(nums, i, j)
            } else {
                break
            }

        }

        swap(nums, i, end)

        sortInterval(nums, start, i - 1)
        sortInterval(nums, i + 1, end)
    }
}