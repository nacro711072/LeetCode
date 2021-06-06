package com.example.forleetcode.lru

import org.junit.Test


class TestLruCache {

//    ["LRUCache","put","put","get","put","get","put","get","get","get"]
//    [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
    @Test
    fun testWithLinkedHashMap() {
        (LruCache146(2) impl LruCache146.LinkedHashMap).also(::startTest)
    }

    @Test
    fun testWithPriority() {
        (LruCache146(2) impl LruCache146.Queue).also(::startTest)
    }


    private fun startTest(cache: LRUCache) {
        with(cache) {
            put(1, 1)
            put(2, 2)
            get(1).also { assert(it == 1) }
            put(3, 3)
            get(2).also { assert(it == -1) }
            put(4, 4)
            get(1).also { assert(it == -1) }
            get(3).also { assert(it == 3) }
            get(4).also { assert(it == 4) }

        }
    }
}