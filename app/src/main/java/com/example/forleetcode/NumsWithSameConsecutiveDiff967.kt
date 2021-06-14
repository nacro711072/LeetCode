package com.example.forleetcode

import java.util.*

/*
Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.

Note that every number in the answer must not have leading zeros. For example, 01 has one leading zero and is invalid.

You may return the answer in any order.



Example 1:

Input: n = 3, k = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.

Example 2:

Input: n = 2, k = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]

Example 3:

Input: n = 2, k = 0
Output: [11,22,33,44,55,66,77,88,99]

Example 4:

Input: n = 2, k = 2
Output: [13,20,24,31,35,42,46,53,57,64,68,75,79,86,97]



Constraints:

    2 <= n <= 9
    0 <= k <= 9


 */
sealed class NumsWithSameConsecutiveDiff967 {
    abstract fun numsSameConsecDiff(n: Int, k: Int): IntArray

    object RecursiveImpl: NumsWithSameConsecutiveDiff967() {
//        time: 9 * 2^(n - 1)
//        DFS
        override fun numsSameConsecDiff(n: Int, k: Int): IntArray {

            val min = Math.pow(10.0, (n - 1).toDouble()).toInt()
            val range = IntRange(min, min * 10 - 1)
            val container = hashSetOf<Int>()
            for(i in 1..9) {
                genWithAddOne(i, i, range, k, container)
                genWithMinusOne(i, i, range, k, container)
            }

            return container.toIntArray()
        }

        private fun genWithAddOne(value: Int, unitDigit: Int, range: IntRange, k: Int, out: MutableSet<Int>) {
            val newDigit = unitDigit + k
            if (newDigit > 9) return

            val newVal = value * 10 + newDigit
            if (newVal in range) {
                out.add(newVal)
                return
            }
            genWithAddOne(newVal, newDigit, range, k, out)
            genWithMinusOne(newVal, newDigit, range, k, out)
        }

        private fun genWithMinusOne(value: Int, unitDigit: Int, range: IntRange, k: Int, out: MutableSet<Int>) {
            val newDigit = unitDigit - k
            if (newDigit < 0) return

            val newVal = value * 10 + newDigit
            if (newVal in range) {
                out.add(newVal)
                return
            }
            genWithAddOne(newVal, newDigit, range, k, out)
            genWithMinusOne(newVal, newDigit, range, k, out)
        }
    }

    object BFSImpl: NumsWithSameConsecutiveDiff967() {
        override fun numsSameConsecDiff(n: Int, k: Int): IntArray {
            val out = LinkedList<Int>()
            val addLambda = getAddLambda()
            val minusLambda = getMinusLambda(k)
            repeat(9) { i -> out.add(i + 1) }
            repeat(n - 1) { i ->
                println("i $i, list: [${out.joinToString()}]")
                repeat (out.size) {
                    val old = out.pop()
                    val unit = (old % 10)
                    addLambda(old, unit, k, out)
                    minusLambda(old, unit, k, out)
                }
            }
            return out.toIntArray()
        }

        private fun getAddLambda(): (old: Int, unit: Int, k: Int, out: MutableList<Int>) -> Unit {
            return { old, unit, k, out ->
                val newAddDigit = unit + k
                if (newAddDigit < 10) {
                    out.add(old * 10 + newAddDigit)
                }
            }

        }

        private fun getMinusLambda(kk: Int): (old: Int, unit: Int, k: Int, out: MutableList<Int>) -> Unit {
            return if (kk != 0) {
                { old, unit, k, out ->
                    val newMinusDigit = unit - k
                    if (newMinusDigit > -1) {
                        out.add(old * 10 + newMinusDigit)
                    }

                }
            } else {
                { _, _, _, _ -> }
            }
        }

    }

}