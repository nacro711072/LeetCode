package com.example.forleetcode

import kotlin.math.max

/**
 * Nick, 2020/5/26
 *
 */
class BinaryTree {

    class TreeNode(var value: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
    }
// [104] Maximum Depth of Binary Tree
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val r = maxDepth(root.right) + 1
        val l = maxDepth(root.left) + 1
        return Math.max(r, l)
    }

//    [110] Balanced Binary Tree
    private var isBalance: Boolean = true
    fun isBalanced(root: TreeNode?): Boolean {
        isBalance = true
        if (root == null) {
            return true
        }
        getDepth(root)
        return isBalance
    }

    private fun getDepth(root: TreeNode): Int {
        val r = if (root.right != null) {
             getDepth(root.right!!) + 1
        }  else {
            0
        }
        val l = if (root.left != null) {
            getDepth(root.left!!) + 1
        } else {
            0
        }

        println("value of r, l: (${root.left?.value}, ${root.right?.value})")
        println("(r, l): (${r}, $l)")

        if (r - l > 1 || r - l < -1) {
            isBalance = false
            return 0
        }
        return Math.max(r, l)
    }
}