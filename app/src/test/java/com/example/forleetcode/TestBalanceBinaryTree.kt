package com.example.forleetcode

import org.junit.Test

/**
 * Nick, 2020/5/26
 *
 */
class TestBalanceBinaryTree {

    @Test
    fun test() {
        val algorithm = BalanceBinaryTree()
        val root = BalanceBinaryTree.TreeNode(1)
        root.left = BalanceBinaryTree.TreeNode(1)
        root.right = BalanceBinaryTree.TreeNode(1)

        var isBalance = algorithm.isBalanced(root)
        println(isBalance)
        assert(isBalance)

        root.right?.right = BalanceBinaryTree.TreeNode(1)
        isBalance = algorithm.isBalanced(root)
        println(isBalance)
        assert(isBalance)

        root.right?.right?.right = BalanceBinaryTree.TreeNode(1)
        isBalance = algorithm.isBalanced(root)
        println(isBalance)
        assert(!isBalance)
    }
}