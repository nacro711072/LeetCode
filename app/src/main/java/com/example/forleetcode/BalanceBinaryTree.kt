package com.example.forleetcode

import kotlin.math.abs
import kotlin.math.max

/**
 * Nick, 2020/5/26
 *  // TODO: 2020/5/26 send to leetcode
 */
class BalanceBinaryTree {

    class TreeNode(var value: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
    }

    var result: Boolean = true

    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        getDepth(root)
        return result
    }

    private fun getDepth(root: TreeNode): Int {
        val r = if (root.right != null) {
             getDepth(root.right!!) + 1
        }  else {
            0
        }
        val l = if (root.left != null) {
            return getDepth(root.left!!) + 1
        } else {
            0
        }

        if (abs(r - l) > 1) {
            result = false
            return 0
        }
        return max(r, l)
    }
}