package com.example.forleetcode
//Given an unsorted array of integers, find the length of the longest consecutiv
//e elements sequence.
//
// Your algorithm should run in O(n) complexity.
//
// Example:
//
//
//Input: [100, 4, 200, 1, 3, 2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Theref
//ore its length is 4.
//
// Related Topics Array Union Find

class LongestConsecutiveSeq128 {
    fun longestConsecutive(nums: IntArray): Int {
        var result = 0
        val hashSet = HashSet<Int>()

        for (num in nums) {
            hashSet.add(num)
        }

        for (num in hashSet) {
            if (num - 1 in hashSet) continue

            var count = 1
            while (num + count in hashSet) {
                ++count
            }
            result = result.coerceAtLeast(count)
        }
        return result
    }
}