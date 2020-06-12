package com.example.forleetcode

//Median is the middle value in an ordered integer list. If the size of the list
// is even, there is no middle value. So the median is the mean of the two middle
//value.
//Examples:
//
// [2,3,4] , the median is 3
//
// [2,3], the median is (2 + 3) / 2 = 2.5
//
// Given an array nums, there is a sliding window of size k which is moving from
// the very left of the array to the very right. You can only see the k numbers in
// the window. Each time the sliding window moves right by one position. Your job
//is to output the median array for each window in the original array.
//
// For example,
//Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
//
//
//Window position                Median
//---------------               -----
//[1  3  -1] -3  5  3  6  7       1
// 1 [3  -1  -3] 5  3  6  7       -1
// 1  3 [-1  -3  5] 3  6  7       -1
// 1  3  -1 [-3  5  3] 6  7       3
// 1  3  -1  -3 [5  3  6] 7       5
// 1  3  -1  -3  5 [3  6  7]      6
//
//
// Therefore, return the median sliding window as [1,-1,-1,3,5,6].
//
// Note:
//You may assume k is always valid, ie: k is always smaller than input array's s
//ize for non-empty array.
//Answers within 10^-5 of the actual value will be accepted as correct.
/**
 * Nick, 2020/6/12
 * [480] Slide Window Median
 * // TODO: 2020/6/12 fix bug
 */
class SlideWindowMedian {
    fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
        val result = DoubleArray(nums.size - k + 1)
        val window = IntArray(k) { i -> nums[i] }
        val medianIndex = IntArray(2) { i -> (k - i) / 2 }
        window.sort()
        result[0] = findMedian(window, medianIndex[0], medianIndex[1])

        for (i in 0 until nums.size - k) {
            window.forEach(::print)
            println()
            val removeIndex = window.binarySearch(nums[i])
            val nextNum = nums[k + i]
            var insertIndex = 0
            while (insertIndex < window.lastIndex && nextNum > window[insertIndex]) {
                insertIndex++
            }

            if (insertIndex == window.lastIndex) {
                if (nextNum < window[insertIndex]) {
                    insertIndex--
                }
                if (nextNum > window[insertIndex]) {
                    insertIndex++
                }
            }
            println("remove, insert: ($removeIndex, ${nums[i]}), ($insertIndex, $nextNum)")
            if (removeIndex < insertIndex) {
                for (j in removeIndex until insertIndex) {
                    window[j] = window[j + 1]
                }
                window[insertIndex] = nextNum
            } else if (insertIndex < removeIndex) {
                for (j in removeIndex downTo insertIndex + 1) {
                    window[j] = window[j - 1]
                }
                window[insertIndex] = nextNum
            } else {
                window[removeIndex] = nextNum
            }


            result[i + 1] = findMedian(window, medianIndex[0], medianIndex[1])
        }

//        window.forEach(::print)
//        println()
        return result
    }

    private fun findMedian(window: IntArray, i1: Int, i2: Int): Double {
        return (window[i1].toDouble() + window[i2]) / 2.0
    }
}