package com.example.forleetcode.array.sort
//Given an array of integers nums, sort the array in ascending order.
//
//
// Example 1:
// Input: nums = [5,2,3,1]
//Output: [1,2,3,5]
// Example 2:
// Input: nums = [5,1,1,2,0,0]
//Output: [0,0,1,1,2,5]
//
//
// Constraints:
//
//
// 1 <= nums.length <= 50000
// -50000 <= nums[i] <= 50000
//
interface ArraySort {
    fun sortArray(nums: IntArray): IntArray
    fun swap(nums: IntArray, i: Int, j: Int) {
        if (i == j) return
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}