package com.example.forleetcode

import com.example.forleetcode.array.sort.HeapSort
import com.example.forleetcode.array.sort.InsertSort
import com.example.forleetcode.array.sort.MergeSort
import com.example.forleetcode.array.sort.QuickSort
import org.junit.Test

class TestArraySort {
    val test1 = intArrayOf(5, 2, 1)
    val test2 = intArrayOf(0, 5, 0, 1, 2, 1)

    @Test
    fun testQuickSort() {
        val algorithm = QuickSort()
        algorithm.sortArray(test1).printArray()
        algorithm.sortArray(test2).printArray()
    }

    private inline fun IntArray.printArray() {
        println(joinToString(prefix = "[", postfix = "]"))
    }

    @Test
    fun testHeapSort() {
        val algorithm = HeapSort()
        algorithm.sortArray(test1).printArray()
        algorithm.sortArray(test2).printArray()
    }

    @Test
    fun testMergeSort() {
        val algorithm = MergeSort()
        algorithm.sortArray(test1).printArray()
        algorithm.sortArray(test2).printArray()
        algorithm.sortArray(intArrayOf(0)).printArray()
    }

    @Test
    fun testInsertSort() {
        val algorithm = InsertSort()
        algorithm.sortArray(test1).printArray()
        algorithm.sortArray(test2).printArray()
        algorithm.sortArray(intArrayOf(0)).printArray()
    }

}