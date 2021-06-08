package com.example.forleetcode.array

import org.junit.Test

class Test350 {
    @Test
    fun testSimple() {
        with(IntersectionTwoArray350.SimpleImpl) {
            getData().forEach { case ->
                intersect(case.data1, case.data2).also {
                    it.sort()
                    println("${it.joinToString()}")
                    assert(it.contentEquals(case.ans))
                }
            }
        }
    }

    @Test
    fun testSort() {
        with(IntersectionTwoArray350.SortImpl) {
            getData().forEach { case ->
                println(case)
                intersect(case.data1, case.data2).also {
                    it.sort()
                    println("${it.joinToString()}")
                    assert(it.contentEquals(case.ans))
                }
            }
        }
    }

    private fun getData(): List<Case> {
        return arrayListOf(
            Case(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4), intArrayOf(4, 9)),
            Case(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2), intArrayOf(2, 2))
        )
    }
}

data class Case(val data1: IntArray, val data2: IntArray, val ans: IntArray) {
    override fun toString(): String {
        return "nums1: ${data1.joinToString(prefix = "[", postfix = "]")}, nums2: ${data2.joinToString(prefix = "[", postfix = "]")}"
    }
}