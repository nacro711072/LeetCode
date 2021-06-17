package com.example.forleetcode
// 1722. Minimize Hamming Distance After Swap Operations
/*
ou are given two integer arrays, source and target, both of length n. You are also given an array allowedSwaps where each allowedSwaps[i] = [ai, bi] indicates that you are allowed to swap the elements at index ai and index bi (0-indexed) of array source. Note that you can swap elements at a specific pair of indices multiple times and in any order.

The Hamming distance of two arrays of the same length, source and target, is the number of positions where the elements are different. Formally, it is the number of indices i for 0 <= i <= n-1 where source[i] != target[i] (0-indexed).

Return the minimum Hamming distance of source and target after performing any amount of swap operations on array source.



Example 1:

Input: source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
Output: 1
Explanation: source can be transformed the following way:
- Swap indices 0 and 1: source = [2,1,3,4]
- Swap indices 2 and 3: source = [2,1,4,3]
The Hamming distance of source and target is 1 as they differ in 1 position: index 3.

Example 2:

Input: source = [1,2,3,4], target = [1,3,2,4], allowedSwaps = []
Output: 2
Explanation: There are no allowed swaps.
The Hamming distance of source and target is 2 as they differ in 2 positions: index 1 and index 2.

Example 3:

Input: source = [5,1,2,4,3], target = [1,5,4,2,3], allowedSwaps = [[0,4],[4,2],[1,3],[1,4]]
Output: 0



Constraints:

    n == source.length == target.length
    1 <= n <= 105
    1 <= source[i], target[i] <= 105
    0 <= allowedSwaps.length <= 105
    allowedSwaps[i].length == 2
    0 <= ai, bi <= n - 1
    ai != bi

 */
sealed class MinHDWithSwappable1722 {
    abstract fun minimumHammingDistance(source: IntArray, target: IntArray, allowedSwaps: Array<IntArray>): Int

    object UnionFindImpl: MinHDWithSwappable1722() {
        override fun minimumHammingDistance(
            source: IntArray,
            target: IntArray,
            allowedSwaps: Array<IntArray>
        ): Int {
            var res = 0
//            create union find
            val swapIndexMap = makeUnionFind(allowedSwaps, source.size)
//            [index: {value: count}]
            val rootCount: Array<MutableMap<Int, Int>?> = Array(swapIndexMap.size) { null }
            for (i in swapIndexMap.indices) {
                val root = findParent(swapIndexMap, i)

                (rootCount[root] ?: HashMap()).let { map ->
                    map[source[i]] = map.getOrDefault(source[i], 0) + 1
                    map[target[i]] = map.getOrDefault(target[i], 0) - 1
                    rootCount[root] = map

                }
            }
            for (root in rootCount) {
                root?.let { map ->
                    res += (map.values.sumBy { value -> Math.abs(value) } / 2)
                }
            }
            return res
        }

        private fun makeUnionFind(allowedSwaps: Array<IntArray>, n: Int): IntArray {
            val out = IntArray(n) { i -> i }
            allowedSwaps.forEach {
                union(out, it[0], it[1])
            }
            return out
        }

        private fun union(out: IntArray, a: Int, b: Int) {
            val root1 = findParent(out, a)
            val root2 = findParent(out, b)
            if (root1 == root2) return
            out[root2] = root1
        }

        private fun findParent(out: IntArray, a: Int): Int {
            if (out[a] == a) return a
            return findParent(out, out[a]).also {
                out[a] = it
            }
        }
    }

}