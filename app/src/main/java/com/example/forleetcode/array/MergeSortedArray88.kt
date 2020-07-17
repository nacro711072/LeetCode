package com.example.forleetcode.array
//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one
// sorted array.
//
// Note:
//
//
// The number of elements initialized in nums1 and nums2 are m and n respectivel
//y.
// You may assume that nums1 has enough space (size that is equal to m + n) to h
//old additional elements from nums2.
//
//
// Example:
//
//
//Input:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//Output: [1,2,2,3,5,6]
//
//
//
// Constraints:
//
//
// -10^9 <= nums1[i], nums2[i] <= 10^9
// nums1.length == m + n
// nums2.length == n
//
// Related Topics Array Two Pointers

class MergeSortedArray88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i1 = m - 1
        var i2 = n - 1

        while (i2 > -1 || i1 + i2 > -1) {
            if (i2 < 0 || (i1 > -1 && nums1[i1] > nums2[i2])) {
                nums1[i1 + i2 + 1] = nums1[i1]
                i1--
            } else {
                nums1[i1 + i2 + 1] = nums2[i2]
                i2--
            }
        }
    }
}