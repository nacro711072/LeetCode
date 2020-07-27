package com.example.forleetcode

class ThreeSum15 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        println(nums.joinToString(prefix = "[", postfix = "]"))
        val result = arrayListOf<List<Int>>()

        for (i1 in 0..nums.lastIndex - 2) {
            if (i1 > 0 && nums[i1] == nums[i1 - 1]) continue

            var i2 = i1 + 1
            var i3 = nums.lastIndex
            println("i1: $i1, i2: $i2, i3: $i3")

            while (i2 < i3) {
                val a = nums[i2]
                val b = nums[i3]
                val sum = a + b + nums[i1]

                if (sum == 0) {
                    result.add(arrayListOf(nums[i1], nums[i2], nums[i3]))
                    i2 = getNotDuplicateIndex(nums, i2 + 1, i3, true)
                    i3 = getNotDuplicateIndex(nums, i3 - 1, i2, false)
                } else {
                    if (sum < 0) {
                        i2 = getNotDuplicateIndex(nums, i2 + 1, i3, true)
                    } else {
                        i3 = getNotDuplicateIndex(nums, i3 - 1, i2, false)
                    }
                }
            }
        }

        return result
    }

    private fun getNotDuplicateIndex(nums: IntArray, i: Int, bound: Int, isIncrease: Boolean): Int {
        var out = i
        if (isIncrease) {
            while (out < bound && nums[out] == nums[out - 1]) ++out
        } else {
            while (bound < out && nums[out] == nums[out + 1]) --out
        }
        return out
    }
}