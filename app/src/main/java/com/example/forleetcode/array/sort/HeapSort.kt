package com.example.forleetcode.array.sort

class HeapSort: ArraySort {
    override fun sortArray(nums: IntArray): IntArray {
        if (nums.size < 2) return nums
        val n = nums.lastIndex

        for (i in n.getParentIndex() downTo 0) {
            heapify(nums, i, n)
        }

        for (i in n downTo 1) {
            swap(nums, 0, i)
            heapify(nums, 0, i - 1)
        }
        return nums
    }

    private fun Int.getParentIndex(): Int = (this - 1) shr 1

    private fun heapify(nums: IntArray, i: Int, lastIndex: Int) {
        var parent = i
        val r = (i + 1) shl 1
        val l = r - 1

        if (l <= lastIndex && nums[parent] < nums[l]) {
            parent = l
        }
        if (r <= lastIndex && nums[parent] < nums[r]) {
            parent = r
        }
        if (i == parent) return

        swap(nums, i, parent)
        heapify(nums, parent, lastIndex)
    }

}