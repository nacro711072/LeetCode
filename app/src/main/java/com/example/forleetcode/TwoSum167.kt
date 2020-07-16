package com.example.forleetcode
//Given an array of integers that is already sorted in ascending order, find two
// numbers such that they add up to a specific target number.
//
// The function twoSum should return indices of the two numbers such that they a
//dd up to the target, where index1 must be less than index2.
//
// Note:
//
//
// Your returned answers (both index1 and index2) are not zero-based.
// You may assume that each input would have exactly one solution and you may no
//t use the same element twice.
//
//
// Example:
//
//
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
// Related Topics Array Two Pointers Binary Search

class TwoSum167 {
//    N * (log N)
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        numbers.forEachIndexed { index, num ->
            val left = target - num
            val j = numbers.binarySearch(left, 1)
            if (j > -1) return intArrayOf(index + 1, j + 1)
        }
        throw Exception("No such answer")

    }

    fun twoSum2(numbers: IntArray, target: Int): IntArray {
        var start: Int = 0
        var end: Int = numbers.lastIndex

        while (start < end) {
            val sum = numbers[start] + numbers[end]
            when {
                sum == target -> {
                    return intArrayOf(start + 1, end + 1)
                }
                sum < target -> {
                    start++
                }
                sum > target -> {
                    end--
                }
            }
        }
        throw Exception("No such answer")
    }

}