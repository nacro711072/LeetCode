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

    private fun heapify(nums: IntArray, root: Int, lastIndex: Int) {

        val nextRoot = findLargestIndexOfTree(nums, root, lastIndex)
        if (root == nextRoot) return

        swap(nums, root, nextRoot)
        heapify(nums, nextRoot, lastIndex)
    }

    private fun findLargestIndexOfTree(nums: IntArray, root: Int, lastIndex: Int): Int {
        var largestIndex = root
        val r = (root + 1) shl 1
        val l = r - 1

        if (l <= lastIndex && nums[l] > nums[largestIndex]) {
            largestIndex = l
        }
        if (r <= lastIndex && nums[r] > nums[largestIndex]) {
            largestIndex = r
        }
        return largestIndex
    }
}