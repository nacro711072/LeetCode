package com.example.forleetcode.sort

class MergeSort: ArraySort {

    override fun sortArray(nums: IntArray): IntArray {
        val half = nums.size shr 1
        divide(nums, 0, half)
        divide(nums, half + 1, nums.lastIndex)
        merge(nums, 0, half, nums.lastIndex)
        return nums
    }

    private fun divide(nums: IntArray, start: Int, end: Int) {
        if (end <= start) return

        val half = (end + start) shr 1

        divide(nums, start, half)
        divide(nums, half + 1, end)
        merge(nums, start, half, end)
    }

    private fun merge(nums: IntArray, start: Int, half: Int, end: Int) {
        var leftIndex = 0
        var rightIndex = half + 1
        var currentIndex = start
        var copyLeft = IntArray(half - start + 1) {
            nums[start + it]
        }


        while (currentIndex <= end) {
            val left  = if (leftIndex < copyLeft.size) copyLeft[leftIndex] else Int.MAX_VALUE
            val right = if (rightIndex <= end) nums[rightIndex] else Int.MAX_VALUE
            if (left < right) {
                nums[currentIndex++] = copyLeft[leftIndex++]
            } else {
                nums[currentIndex++] = nums[rightIndex++]
            }
        }
    }
}