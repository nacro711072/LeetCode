package com.example.forleetcode

import java.util.*

//Given an unsorted array of integers, find the length of longest increasing sub
//sequence.
//
// Example:
//
//
//Input: [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the
//length is 4.
//
// Note:
//
//
// There may be more than one LIS combination, it is only necessary for you to r
//eturn the length.
// Your algorithm should run in O(n2) complexity.
//
//
// Follow up: Could you improve it to O(n log n) time complexity?
// Related Topics Binary Search Dynamic Programming

class LongestIncreaseSubSeq300 {
    //Input: [10,9,5,3,7,101,2,18]
//    [10,9,2,5,3,4,101,18]
    fun lengthOfLIS(nums: IntArray): Int {
        val resultArray = IntArray(nums.size)
        var resultSize = 0
        for (num in nums) {
            var index = resultArray.binarySearch(num, 0, resultSize)
            if (index >= 0) {
                continue
            }

            index = -index - 1

            resultArray[index] = num
            if (index == resultSize) {
                ++resultSize
            }
        }
        return resultSize
    }

}