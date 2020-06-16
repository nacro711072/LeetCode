package com.example.forleetcode

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*
import kotlin.math.min

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
 */
class SlideWindowMedian {
    // version2 PriorityQueue
    // 為了改善swap 直線尋訪, 採用binary insert, 最簡單的上就是透過 PriorityQueue, 裡面是用 Balanced Binary Heap 實現的
    @RequiresApi(Build.VERSION_CODES.N)
    fun medianSlidingWindow2(nums: IntArray, k: Int): DoubleArray {
        val result = DoubleArray(nums.size - k + 1)
        val maxHeap = PriorityQueue<Int>(Comparator { o1, o2 ->
            when {
                nums[o1] < nums[o2] -> return@Comparator 1
                nums[o1] == nums[o2] -> return@Comparator 0
                else -> return@Comparator -1
            }
        })

        val minHeap = PriorityQueue<Int>(Comparator { o1, o2 ->
            when {
                nums[o1] > nums[o2] -> return@Comparator 1
                nums[o1] == nums[o2] -> return@Comparator 0
                else -> return@Comparator -1
            }
        })

        val half = k shr 1

        for (i in nums.indices) {
            maxHeap.add(i)
            if (maxHeap.size > half) {
                minHeap.add(maxHeap.poll())
            }
            if (maxHeap.size == half && minHeap.size == k - half) {
                val medianValue = if (k % 2 == 0) {
                    (nums[maxHeap.peek()].toDouble() + nums[minHeap.peek()]) / 2
                } else {
                    nums[minHeap.peek()].toDouble()
                }
                result[i - k + 1] = medianValue
                if (!minHeap.remove(i - k + 1)) {
                    maxHeap.remove(i - k + 1)
                    maxHeap.add(minHeap.poll())
                }
            }
        }

        return result
    }
    //    version1
    fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
        val result = DoubleArray(nums.size - k + 1)
        val window = IntArray(k) { i -> nums[i] }
        val medianIndex = IntArray(2) { i -> (k - i) / 2 }
        window.sort()
        result[0] = findMedian(window, medianIndex[0], medianIndex[1])

        for (i in 0 until nums.size - k) {

            val nextNum = nums[k + i]
            val removeNum = nums[i]
            val removeIndex = window.binarySearch(removeNum)

            window[removeIndex] = nextNum
            if (removeNum == nextNum) {
                result[i + 1] = result[i]
                continue
            } else if (nextNum < removeNum) {

                swap(window, removeIndex downTo 1)
            } else if (nextNum > removeNum) {
                swap(window, removeIndex + 1 until window.size)
            }

            result[i + 1] = findMedian(window, medianIndex[0], medianIndex[1])
        }
        return result
    }

    private fun swap(window: IntArray, range: IntProgression) {
        var temp: Int
        for (j in range) {
            if (window[j] < window[j - 1]) {
                temp = window[j - 1]
                window[j - 1] = window[j]
                window[j] = temp
            } else {
                break
            }
        }
    }

    private fun findMedian(window: IntArray, i1: Int, i2: Int): Double {
        return (window[i1].toDouble() + window[i2]) / 2.0
    }
}