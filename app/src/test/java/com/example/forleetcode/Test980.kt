package com.example.forleetcode

import com.example.forleetcode.path.UniquePath980
import com.example.forleetcode.util.parse2DArray_IntArray
import org.junit.Assert
import org.junit.Test

class Test980 {

    @Test
    fun testUniquePath() {
        val tester = UniquePath980()
        getData().forEachIndexed { i, inOut ->
            val result = tester.uniquePathsIII(inOut.testcase)
            assert(result == inOut.ans)
        }
    }

    private fun getData(): List<InOut> {
        return listOf(
            InOut("[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]".parse2DArray_IntArray(), 2),
            InOut("[[1,0,0,0],[0,0,0,0],[0,0,0,2]]".parse2DArray_IntArray(), 4),
            InOut("[[0,1],[2,0]]".parse2DArray_IntArray(), 0),
        )
    }

    private data class InOut(val testcase: Array<IntArray>, val ans: Int)
}