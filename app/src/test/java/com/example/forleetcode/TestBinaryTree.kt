package com.example.forleetcode

import org.junit.Test

/**
 * Nick, 2020/5/26
 *
 */
class TestBinaryTree {

    @Test
    fun test() {
        val algorithm = BinaryTree()
        var root = BinaryTree.TreeNode(1)
        root.left = BinaryTree.TreeNode(2)
        root.right = BinaryTree.TreeNode(2)
//---------[1, 2, 2]--------//
        var isBalance = algorithm.isBalanced(root)
        println(isBalance)
        assert(isBalance)
//--------[1, 2, 2, null, null, null, 3]---------//
        root.right?.right = BinaryTree.TreeNode(3)
        isBalance = algorithm.isBalanced(root)
        println(isBalance)
        assert(isBalance)
//----------------------[1,
//                      2, 2,
//             null, null, null, 3,
// null, null, null, null, null, null, null, 4]---------//
        root.right?.right?.right = BinaryTree.TreeNode(4)
        isBalance = algorithm.isBalanced(root)
        println(isBalance)
        assert(!isBalance)
//---------[1,
//         2, 2,
//      3, 3, null, null,
//    4, 4]--------//
        root = BinaryTree.TreeNode(1)
        root.left = BinaryTree.TreeNode(2).also {
            it.left = BinaryTree.TreeNode(3).also { a ->
                a.left = BinaryTree.TreeNode(4)
                a.right = BinaryTree.TreeNode(4)
            }
            it.right = BinaryTree.TreeNode(3)
        }
        root.right = BinaryTree.TreeNode(2)

        isBalance = algorithm.isBalanced(root)
        println(isBalance)
        assert(!isBalance)

    }

    @Test
    fun testCase() {
//        [1,2,2,3,3,null,null,4,4]
        val algorithm = BinaryTree()
        val root = BinaryTree.TreeNode(1)
        root.left = BinaryTree.TreeNode(2).also {
            it.left = BinaryTree.TreeNode(3).also { a ->
                a.left = BinaryTree.TreeNode(4)
                a.right = BinaryTree.TreeNode(4)
            }
            it.right = BinaryTree.TreeNode(3)
        }
        root.right = BinaryTree.TreeNode(2)

        val isBalance = algorithm.isBalanced(root)
        println(isBalance)
        assert(!isBalance)
    }
}