package com.example.forleetcode.tree.algorithm

import com.example.forleetcode.tree.model.TreeNode

/**
 * Nick, 2020/6/1
 *
 */
class BalancedTree {
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

        println("value of r, l: (${root.left?.`val`}, ${root.right?.`val`})")
        println("(r, l): (${r}, $l)")

        if (r - l > 1 || r - l < -1) {
            isBalance = false
            return 0
        }
        return Math.max(r, l)
    }

}