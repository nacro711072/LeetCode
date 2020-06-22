package com.example.forleetcode.heap

import org.junit.Test

/**
 * Nick, 2020/6/20
 *
 */
class TestHeap {
    @Test
    fun testHeap() {
        val heap = Heap<Int>(Comparator { o1, o2 ->
            o1.compareTo(o2)
        })

        heap.insert(1)
        heap.insert(2)
        heap.insert(3)

        heap.printAll()

        heap.insert(-1)
        heap.printAll()

        heap.insert(2)
        heap.printAll()

        heap.delete()
        heap.printAll()

        heap.delete()
        heap.printAll()

        heap.delete()
        heap.printAll()

        heap.delete()
        heap.printAll()

        heap.insert(5)
        heap.printAll()
//        heap.delete()
    }

    @Test
    fun testHeapCapacity() {
        val heap = Heap<Int>(Comparator { o1, o2 ->
            o1.compareTo(o2)
        })

        for (i in 0..20) {
            heap.insert(i)
        }
        heap.printAll()
    }
}