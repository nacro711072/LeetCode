package com.example.forleetcode.array
/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.



Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.



Constraints:

    1 <= nums1.length, nums2.length <= 1000
    0 <= nums1[i], nums2[i] <= 1000



Follow up:

    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?


 */

sealed class IntersectionTwoArray350 {
    abstract fun intersect(nums1: IntArray, nums2: IntArray): IntArray

    object SimpleImpl : IntersectionTwoArray350() {
        override fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
            val map = HashMap<Int, Int>()
            for (e1 in nums1) {
                if (map.containsKey(e1)) {
                    map[e1] = map[e1]!! + 1
                } else {
                    map[e1] = 1
                }
            }

            val out = ArrayList<Int>(Math.min(nums1.size, nums2.size))
            for (e2 in nums2) {
                if (map.contains(e2) && map[e2] != 0) {
                    out.add(e2)
                    map[e2] = map[e2]!! - 1
                }
            }
            return out.toIntArray()
        }

    }

    object SortImpl : IntersectionTwoArray350() {
        override fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
            val out = arrayListOf<Int>()
            nums1.sort()
            nums2.sort()
            var i = 0
            var j = 0
            while (i < nums1.size && j < nums2.size) {
                val compare = nums1[i].compareTo(nums2[j])
                when {
                    compare > 0 -> {
                        j++
                    }
                    compare < 0 -> {
                        i++
                    }
                    else -> {
                        out.add(nums1[i])
                        i++
                        j++
                    }
                }
            }
            return out.toIntArray()
        }
    }
}

