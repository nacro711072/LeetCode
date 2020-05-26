package com.example.forleetcode
//Input: [1,2,2]
//Output:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]

/**
 * Nick, 2020/5/26
 *  [90]Subsets II
 */
class SubSets2 {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        nums.sort()

        generateSubset(nums, 0, mutableListOf(), result)
        return result
    }

    private fun generateSubset(
        nums: IntArray,
        start: Int,
        subset: MutableList<Int>,
        result: MutableList<List<Int>>
    ) {
        result.add(subset.toList())
        for (i in start until nums.size) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue
            }
            subset.add(nums[i])
            generateSubset(nums, i + 1, subset, result)
            subset.removeAt(subset.lastIndex)
        }
    }

}