package com.example.forleetcode

//You are given a list of non-negative integers, a1, a2, ..., an, and a target,
//S. Now you have 2 symbols + and -. For each integer, you should choose one from
//+ and - as its new symbol.
//
// Find out how many ways to assign symbols to make sum of integers equal to tar
//get S.
//
// Example 1:
//
//
//Input: nums is [1, 1, 1, 1, 1], S is 3.
//Output: 5
//Explanation:
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//There are 5 ways to assign symbols to make the sum of nums be target 3.
//
//
//
// Constraints:
//
//
// The length of the given array is positive and will not exceed 20.
// The sum of elements in the given array will not exceed 1000.
// Your output answer is guaranteed to be fitted in a 32-bit integer.
//
// Related Topics Dynamic Programming Depth-first Search

/**
 * Nick, 2020/6/11
 * [494] Target Sum
 */
class TargetSum {
    fun findTargetSumWays(nums: IntArray, S: Int): Int {
        var hashMap = HashMap<Int, Int>()
        hashMap[0] = 1

        nums.forEachIndexed { index, num ->
            val temp = HashMap<Int, Int>(1 shl index)
            for ((sum, count) in hashMap.entries) {

                val addSum = sum + num
                val minusSum = sum - num
                temp[addSum] = (temp[addSum] ?: 0) + count
                temp[minusSum] = (temp[minusSum] ?: 0) + count
            }
            hashMap = temp
        }

        return hashMap[S] ?: 0
    }

}