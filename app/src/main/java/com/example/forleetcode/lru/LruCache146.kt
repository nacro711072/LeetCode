package com.example.forleetcode.lru

import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

/*
Constraints:

1 <= capacity <= 3000
0 <= key <= 3000
0 <= value <= 104
At most 3 * 104 calls will be made to get and put.

 */
typealias Impl = (capacity: Int) -> LRUCache

class LruCache146(internal val capacity: Int) {

    companion object {
        val LinkedHashMap: Impl = { LRUCacheLinkedHashMap(it) }
        val Queue: Impl = { LRUCacheQueue(it) }

    }
}

infix fun LruCache146.impl(impl: Impl): LRUCache = impl.invoke(capacity)

interface LRUCache {
    fun get(key: Int): Int
    fun put(key: Int, value: Int)
}

/**
 * easy way
 */
class LRUCacheLinkedHashMap(capacity: Int): LRUCache {
    private val max = capacity
    private val map: LinkedHashMap<Int, Int> = LinkedHashMap((capacity * 1.5).toInt(), 0.75f, true)
    private val noValue: Int = -1

    override fun get(key: Int): Int {
        return map.getOrElse(key) { noValue }
    }

    override fun put(key: Int, value: Int) {
        if (get(key) == noValue) {
            if (isReachMax()) {
                map.remove(map.entries.first().key)
            }
        }
        map[key] = value
    }

    private fun isReachMax(): Boolean {
        return (map.size >= max)
    }
}

class LRUCacheQueue(capacity: Int): LRUCache {
    private val max = capacity
    private val queue: Deque<Int> = java.util.ArrayDeque(capacity)
    private val map: HashMap<Int, Int> = HashMap()
    private val noValue = -1

    override fun get(key: Int): Int {
        queue.forEach { cacheKey ->
            if (key == cacheKey) {
                queue.remove(cacheKey)
                queue.addFirst(cacheKey)
                return map[key]!!
            }
        }
        return noValue
    }

    override fun put(key: Int, value: Int) {
        if (get(key) == noValue) {
            if (isReachMax()) {
                val cacheKey = queue.pollLast()
                map.remove(cacheKey!!)
            }
            queue.addFirst(key)
        }

        map[key] = value
    }

    private fun isReachMax(): Boolean {
        return queue.size >= max
    }

    private data class Node(
        val key: Int,
        val value: Int,
        var time: Long
    )
}