package com.example.forleetcode

import com.example.forleetcode.tree.algorithm.SameTree
import com.example.forleetcode.tree.model.TreeNode
import org.junit.Test

/**
 * Nick, 2020/6/1
 *
 */
class TestSameTree {
    @Test
    fun testDifferentBranchTree() {
        val a = TreeNode(1).also {
            it.left = TreeNode(2)
        }

        val b = TreeNode(1).also {
            it.right = TreeNode(2)
        }

        val tree = SameTree()
        val result = tree.isSameTree(a, b)

        assert(!result)
    }

    @Test
    fun testDifferentVal() {
        val a = TreeNode(1).also {
            it.left = TreeNode(2)
            it.right = TreeNode(3)
        }

        val b = TreeNode(1).also {
            it.left = TreeNode(2)
            it.right = TreeNode(1)
        }

        val tree = SameTree()
        val result = tree.isSameTree(a, b)

        assert(!result)
    }

    @Test
    fun testSame() {
        val a = TreeNode(1).also {
            it.left = TreeNode(2)
            it.right = TreeNode(3)
        }

        val b = TreeNode(1).also {
            it.left = TreeNode(2)
            it.right = TreeNode(3)
        }

        val tree = SameTree()
        val result = tree.isSameTree(a, b)

        assert(result)
    }

}