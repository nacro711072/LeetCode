package com.example.forleetcode

import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.math.min

//Design a stack that supports push, pop, top, and retrieving the minimum elemen
//t in constant time.
//
//
// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// getMin() -- Retrieve the minimum element in the stack.
//
//
//
// Example 1:
//
//
//Input
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//Output
//[null,null,null,null,-3,null,0,-2]
//
//Explanation
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin(); // return -3
//minStack.pop();
//minStack.top();    // return 0
//minStack.getMin(); // return -2
//
//
//
// Constraints:
//
//
// Methods pop, top and getMin operations will always be called on non-empty sta
//cks.
//
// Related Topics Stack Design
class MinStack155 {

    /** initialize your data structure here. */
    private var node: Node? = null

    fun push(x: Int) {
        node?.let {
            node = if (x < it.min) {
                Node(x, x, it)
            } else {
                Node(x, it.min, it)
            }
        } ?: kotlin.run {
            node = Node(x, x, null)
        }
    }

    fun pop() {
        node = node?.previous
    }

    fun top(): Int {
        return node?.value ?: throw Exception("stack is empty")
    }

    fun getMin(): Int {
        return node?.min ?: throw Exception("stack is empty")
    }

    data class Node(
        val value: Int,
        val min: Int,
        val previous: Node?
    )

}