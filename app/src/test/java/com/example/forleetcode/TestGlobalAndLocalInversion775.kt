package com.example.forleetcode

import com.example.forleetcode.array.GlobalAndLocalInversion775
import org.junit.Test

class TestGlobalAndLocalInversion775 {
    @Test
    fun testSimple() {
        with(GlobalAndLocalInversion775.simple) {
            isIdealPermutation(getData1()).also { b -> assert(b) }
            isIdealPermutation(getData2()).also { b -> assert(!b) }
            isIdealPermutation(getData3()).also { b -> assert(b) }
            isIdealPermutation(getData4()).also { b -> assert(b) }
            isIdealPermutation(getData5()).also { b -> assert(b) }
        }
    }

    @Test
    fun testReverse() {
        with(GlobalAndLocalInversion775.reverse) {
            isIdealPermutation(getData1()).also { b -> assert(b) }
            isIdealPermutation(getData2()).also { b -> assert(!b) }
            isIdealPermutation(getData3()).also { b -> assert(b) }
            isIdealPermutation(getData4()).also { b -> assert(b) }
            isIdealPermutation(getData5()).also { b -> assert(b) }
        }
    }

    @Test
    fun testKeppMax() {
        with(GlobalAndLocalInversion775.keepMax) {
            isIdealPermutation(getData1()).also { b -> assert(b) }
            isIdealPermutation(getData2()).also { b -> assert(!b) }
            isIdealPermutation(getData3()).also { b -> assert(b) }
            isIdealPermutation(getData4()).also { b -> assert(b) }
            isIdealPermutation(getData5()).also { b -> assert(b) }
        }
    }

    @Test
    fun testNeighbor() {
        with(GlobalAndLocalInversion775.neighbor) {
            isIdealPermutation(getData1()).also { b -> assert(b) }
            isIdealPermutation(getData2()).also { b -> assert(!b) }
            isIdealPermutation(getData3()).also { b -> assert(b) }
            isIdealPermutation(getData4()).also { b -> assert(b) }
            isIdealPermutation(getData5()).also { b -> assert(b) }
        }
    }


    private fun getData1(): IntArray {
        return intArrayOf(1, 0, 2)
    }

    private fun getData2(): IntArray {
        return intArrayOf(1, 2, 0)
    }

    private fun getData3(): IntArray {
        return intArrayOf(0)
    }

    private fun getData4(): IntArray {
        return IntArray(10000) { i -> i }.also {
            it[0] = 1
            it[1] = 0
        }
    }

    private fun getData5(): IntArray {
        return intArrayOf(0, 2, 1)
    }

}