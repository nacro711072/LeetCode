package com.example.forleetcode.array

class MaximumSubArray53 {
    fun maxSubArray(nums: IntArray): Int {
        var acc = nums[0]
        var max: Int = nums[0]
        for (i in 1..nums.lastIndex) {
            val temp = Math.max(acc, nums[i - 1]) + nums[i]
            acc = Math.max(temp, nums[i])
            max = Math.max(max, acc)
        }
        return max
    }

}