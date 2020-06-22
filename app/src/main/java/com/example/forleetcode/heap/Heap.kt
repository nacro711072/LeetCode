package com.example.forleetcode.heap

import java.util.*

/**
 * Nick, 2020/6/20
 * Practice
 */
class Heap<T> {
    companion object {
        const val DEFAULT_INITIAL_CAPACITY = 16
    }

    private val MAX_ARRAY_SIZE = Int.MAX_VALUE - 8

    private val mComparator: Comparator<T>
    private var realSize: Int = 0
    private var items: Array<Any?>

    constructor(comparable: Comparator<T>) {
        items = arrayOfNulls(DEFAULT_INITIAL_CAPACITY)
        mComparator = comparable
    }

    fun delete() {
        if (realSize <= 1) {
            items[0] = null
            return
        }
        var i = 0
        val lastItem = items[realSize - 1] as T
        items[realSize - 1] = null
        realSize--

        while (i < realSize shr 1) {
            val indexOfR = (i + 1) shl 1
            val indexOfL = indexOfR - 1
            val left = items[indexOfL] as T
            val right = items[indexOfR] as T

            var targetIndex = indexOfL
            if (right != null && mComparator.compare(left, right) > 0) {
                targetIndex = indexOfR
            }

            val target = items[targetIndex] as T
            if (mComparator.compare(target, lastItem) < 0) {
                items[i] = target
                i = targetIndex
            } else {
                break
            }
        }

        items[i] = lastItem
    }

    fun get(): T {
        return items[0] as T
    }

    fun insert(element: T) {
        if (realSize >= items.size) {
            growUpCapacity(items.size + 1)
        }

        if (realSize == 0) {
            items[0] = element
            realSize++
            return
        }

        shiftUp(realSize++, element)
    }

    private fun shiftUp(i: Int, element: T) {
        var j = i
        while (j > 0) {
            val indexOfParent = (j - 1) shr 1
            val parent = items[indexOfParent] as T
            if (mComparator.compare(element, parent) >= 0)
                break
            items[j] = parent
            j = indexOfParent
        }
        items[j] = element
    }

    private fun growUpCapacity(minCapacity: Int) {
        val capacity = items.size
        var newCapacity = capacity + capacity shr 1

        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity

        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity)

        items = items.copyOf(newCapacity)
    }

    private fun hugeCapacity(minCapacity: Int): Int {
        if (minCapacity < 0) throw OutOfMemoryError()
        return if (minCapacity > MAX_ARRAY_SIZE) Int.MAX_VALUE else MAX_ARRAY_SIZE
    }

    fun printAll() {
        val it = items.iterator()
        while (it.hasNext()) {
            val data = it.next()
            if (data == null) break
            else print("$data, ")
        }
        println()
    }
}