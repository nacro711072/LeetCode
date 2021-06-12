package com.example.forleetcode

import java.util.*

sealed class PlusOne66 {
    abstract fun plusOne(digits: IntArray): IntArray

    /*
    - 如果是 9 會進位, 因此設為0
    - 直到非9的位數 + 1
    - 高位數不動
     */
    object SimpleImpl: PlusOne66() {
        override fun plusOne(digits: IntArray): IntArray {
            val out = ArrayDeque<Int>(digits.size + 1)
            var isAddOne = false
            for (i in digits.indices.reversed()) {
                when {
                    isAddOne -> {
                        out.addFirst(digits[i])
                    }
                    digits[i] == 9 -> {
                        out.addFirst(0)
                    }
                    else -> {
                        out.addFirst(digits[i] + 1)
                        isAddOne = true
                    }
                }
            }
            if (!isAddOne) {
                out.addFirst(1)
            }
            return out.toIntArray()
        }
    }
}