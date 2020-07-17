package com.example.forleetcode.array

class RotateArray189 {
//    reverse
    fun rotate(nums: IntArray, k: Int): Unit {
        val newK = k % nums.size
        nums.reverse()
        nums.reverse(0, newK - 1)
        nums.reverse(newK, nums.lastIndex)
    }

    private fun IntArray.reverse(start: Int, end: Int) {
        var s = start
        var e = end
        while (s < e) {
            swap(this, s++, e--)
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }

// change k
    fun rotate2(nums: IntArray, k: Int): Unit {
        val size = nums.size
        var newK = k % size

        if (size < 1 || newK == 0) return

        var tail = size % newK
        var start: Int = 0
        for (i in 0 until nums.lastIndex) {
            start %= newK
            if (size - i == tail) {
                newK %= tail
                if (newK == 0) break
                start = 0
                tail %= newK
            }

            swap(nums, i, size - (newK - start))
            start++
        }
    }

}