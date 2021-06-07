package com.example.forleetcode.array

import kotlin.math.max

/*
You are given an integer array nums of length n which represents a permutation of all the integers in the range [0, n - 1].

The number of global inversions is the number of the different pairs (i, j) where:

    0 <= i < j < n
    nums[i] > nums[j]

The number of local inversions is the number of indices i where:

    0 <= i < n - 1
    nums[i] > nums[i + 1]

Return true if the number of global inversions is equal to the number of local inversions.



Example 1:

Input: nums = [1,0,2]
Output: true
Explanation: There is 1 global inversion and 1 local inversion.

Example 2:

Input: nums = [1,2,0]
Output: false
Explanation: There are 2 global inversions and 1 local inversion.



Constraints:

    n == nums.length
    1 <= n <= 105
    0 <= nums[i] < n
    All the integers of nums are unique.
    nums is a permutation of all the numbers in the range [0, n - 1].

 */
class GlobalAndLocalInversion775 {
    companion object {
        val simple: Inversion = SimpleImpl()
        val reverse: Inversion = ReverseImpl()
        val keepMax: Inversion = KeepMaxImpl()
        val neighbor: Inversion = NeighborImpl()
    }
}

interface Inversion {
    fun isIdealPermutation(nums: IntArray): Boolean
}

class SimpleImpl: Inversion {
    override fun isIdealPermutation(nums: IntArray): Boolean {
        return getGlobalCount(nums) == getLocalCount(nums)
    }

    private fun getGlobalCount(nums: IntArray): Int {
        var count = 0
        for (i in nums.indices) {
            for (j in (i + 1) until nums.size) {
                if (nums[i] > nums[j]) {
                    count++
                }
            }
        }
        return count
    }

    private fun getLocalCount(nums: IntArray): Int {
        var count = 0
        for (i in 0 until nums.lastIndex) {
            if (nums[i] > nums[i + 1]) {
                count++
            }
        }
        return count
    }
}

class ReverseImpl: Inversion {
//    Return true if the number of `global` inversions is equal to the number of `local` inversions.
//    Namely:
/*
    - 0 <= i < j < n
    - nums[i] > nums[j]
    - (j - i) > 2
    should NOT exist.
 */
    override fun isIdealPermutation(nums: IntArray): Boolean {
        val iDiff = 2
        for (i in 0..(nums.lastIndex - iDiff)) {
            for (j in (i + iDiff)..(nums.lastIndex)) {
                if (nums[i] > nums[j]) {
                    return false
                }
            }
        }
        return true
    }

}

class KeepMaxImpl: Inversion {
//    Return true if the number of `global` inversions is equal to the number of `local` inversions.
//    Namely:
/*
    - 0 <= i < j < n
    - nums[i] > nums[j]
    - (j - i) > 1
    should NOT exist.
 */
    override fun isIdealPermutation(nums: IntArray): Boolean {
        if (nums.size <= 1) return true
        var maxIndex = 0
        for (i in 2..nums.lastIndex) {
            if (nums[maxIndex] > nums[i]) return false

            val a = i - 1
            val b = maxIndex

            maxIndex = if (nums[a] > nums[b]) a else b
        }
        return true
    }

}

class NeighborImpl: Inversion {
//    Point:
/*
    - All the integers of nums are unique.
    - nums is a permutation of all the numbers in the range [0, n - 1].
 */
//    Therefore,
    override fun isIdealPermutation(nums: IntArray): Boolean {
        for (i in nums.indices) {
            if (Math.abs(nums[i] - i) > 1) return false
        }
        return true
    }

}