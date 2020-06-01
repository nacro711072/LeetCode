package com.example.forleetcode

import com.example.forleetcode.tree.algorithm.BalancedTree
import com.example.forleetcode.tree.model.TreeNode
import org.junit.Test

/**
 * Nick, 2020/5/26
 *
 */
class TestBinaryTree {

    @Test
    fun test() {
        val algorithm = BalancedTree()
        var root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(2)
//---------[1, 2, 2]--------//
        var isBalance = algorithm.isBalanced(root)
        println(isBalance)
        assert(isBalance)
//--------[1, 2, 2, null, null, null, 3]---------//
        root.right?.right = TreeNode(3)
        isBalance = algorithm.isBalanced(root)
        println(isBalance)
        assert(isBalance)
//----------------------[1,
//                      2, 2,
//             null, null, null, 3,
// null, null, null, null, null, null, null, 4]---------//
        root.right?.right?.right = TreeNode(4)
        isBalance = algorithm.isBalanced(root)
        println(isBalance)
        assert(!isBalance)
//---------[1,
//         2, 2,
//      3, 3, null, null,
//    4, 4]--------//
        root = TreeNode(1)
        root.left = TreeNode(2).also {
            it.left = TreeNode(3).also { a ->
                a.left = TreeNode(4)
                a.right = TreeNode(4)
            }
            it.right = TreeNode(3)
        }
        root.right = TreeNode(2)

        isBalance = algorithm.isBalanced(root)
        println(isBalance)
        assert(!isBalance)

    }

    @Test
    fun testCase() {
//        [1,2,2,3,3,null,null,4,4]
        val algorithm = BalancedTree()
        val root = TreeNode(1)
        root.left = TreeNode(2).also {
            it.left = TreeNode(3).also { a ->
                a.left = TreeNode(4)
                a.right = TreeNode(4)
            }
            it.right = TreeNode(3)
        }
        root.right = TreeNode(2)

        val isBalance = algorithm.isBalanced(root)
        println(isBalance)
        assert(!isBalance)
    }
}

