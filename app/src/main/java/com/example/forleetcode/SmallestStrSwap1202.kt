package com.example.forleetcode

import java.util.ArrayList

/* 1202. Smallest String With Swaps

You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.

You can swap the characters at any pair of indices in the given pairs any number of times.

Return the lexicographically smallest string that s can be changed to after using the swaps.



Example 1:

Input: s = "dcab", pairs = [[0,3],[1,2]]
Output: "bacd"
Explaination:
Swap s[0] and s[3], s = "bcad"
Swap s[1] and s[2], s = "bacd"

Example 2:

Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
Output: "abcd"
Explaination:
Swap s[0] and s[3], s = "bcad"
Swap s[0] and s[2], s = "acbd"
Swap s[1] and s[2], s = "abcd"

Example 3:

Input: s = "cba", pairs = [[0,1],[1,2]]
Output: "abc"
Explaination:
Swap s[0] and s[1], s = "bca"
Swap s[1] and s[2], s = "bac"
Swap s[0] and s[1], s = "abc"



Constraints:

    1 <= s.length <= 10^5
    0 <= pairs.length <= 10^5
    0 <= pairs[i][0], pairs[i][1] < s.length
    s only contains lower case English letters.


 */
sealed class SmallestStrSwap1202 {
    abstract fun smallestStringWithSwaps(s: String, pairs: List<List<Int>>): String

    object UnionFindImpl: SmallestStrSwap1202() {

        override fun smallestStringWithSwaps(s: String, pairs: List<List<Int>>): String {
            val n = s.length
            val union = makeUnionFind(n, pairs) // O(Pair.size)
            val out: CharArray = CharArray(n) { i -> s[i] }

            val group: HashMap<Int, Pair<MutableList<Int>, MutableList<Char>>> = hashMapOf()
            for (i in s.indices) { // O(n)
                val root = find(union, i)
                group.getOrElse(root, { arrayListOf<Int>() to arrayListOf<Char>() }).also { pair ->
                    pair.first.add(i)
                    pair.second.add(s[i])
                    group[root] = pair
                }
            }

            group.values.forEach { pair ->
                pair.second.sort() // max: O(N logN)
                for (i in pair.first.indices) {
                    out[pair.first[i]] = pair.second[i]
                }
            }

            return String(out)
        }

        private fun makeUnionFind(size: Int, pairs: List<List<Int>>): IntArray {
            val out = IntArray(size) { i -> i }
            for (pair in pairs) {
                union(out, pair[0], pair[1])
            }
            return out
        }

        private fun union(out: IntArray, a: Int, b: Int) {
            val root1 = find(out, a)
            val root2 = find(out, b)
            if (root1 == root2) return
            out[root2] = root1
        }

        private fun find(out: IntArray, a: Int): Int {
            if (out[a] == a) return a
            return find(out, out[a]).also {
                out[a] = it
            }
        }
    }
}