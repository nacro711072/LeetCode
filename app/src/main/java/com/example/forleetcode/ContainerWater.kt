package com.example.forleetcode

/**
 * Nick, 2020/6/9
 * [11] Container With Most Water
 */
class ContainerWater {
    fun maxArea(height: IntArray): Int {
        var res = 0
        var left = 0
        var right = height.lastIndex
        while (left < right) {
            val leftH = height[left]
            val rightH = height[right]

            res = Math.max(res, Math.min(leftH, rightH) * (right - left))

            if (leftH > rightH) {
                --right
            } else {
                ++left
            }

        }
        return res
    }
}