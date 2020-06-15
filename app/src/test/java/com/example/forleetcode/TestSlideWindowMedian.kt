package com.example.forleetcode

import org.junit.Test

/**
 * Nick, 2020/6/12
 *
 */
class TestSlideWindowMedian {
    @Test
    fun testSlideWindowMedian() {
        val algorithm = SlideWindowMedian()
//        in: [1,3,-1,-3,5,3,6,7] k = 3, out: [1,-1,-1,3,5,6]
        algorithm.medianSlidingWindow(arrayOf(1, 3, -1, -3, 5, 3, 6 ,7).toIntArray(), 3)
            .forEach { print("$it ") }
        print("\n")

//        in: [1,2,3,4,2,3,1,4,2] k = 3, out: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]
        algorithm.medianSlidingWindow(arrayOf(1, 2, 3, 4, 2, 3, 1, 4, 2).toIntArray(), 3)
            .forEach { print("$it ") }
        print("\n")

//        in: [2147483647,1,2,3,4,5,6,7,2147483647] k = 2,
//        out [1.073741824E9, 1.5, 2.5, 3.5, 4.5, 5.5, 6.5, 1.073741827E9]
        algorithm.medianSlidingWindow(arrayOf(2147483647, 1, 2, 3, 4, 5, 6, 7, 2147483647).toIntArray(), 2)
            .forEach { print("$it ") }

    }
}