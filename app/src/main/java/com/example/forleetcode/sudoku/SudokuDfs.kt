package com.example.forleetcode.sudoku

class SudokuDfs: ISudoku37 {
    private val cacheSquare: Array<BooleanArray> = Array(9) { BooleanArray(9) { false } }
    private val cacheRow: Array<BooleanArray> = Array(9) { BooleanArray(9) { false } }
    private val cacheCol: Array<BooleanArray> = Array(9) { BooleanArray(9) { false } }

    override fun solveSudoku(board: Array<CharArray>): Unit {
        for (pos in 0 until 81) {
            val i = pos / 9
            val j = pos % 9
            val char = board[i][j]
            if (char == '.') continue

            val squareI = i / 3 * 3 + j / 3
            val charIndex = char.digitToInt() - 1

            cacheSquare[squareI][charIndex] = true
            cacheRow[i][charIndex] = true
            cacheCol[j][charIndex] = true
        }

        dfs(board, 0)
    }

    private fun dfs(board: Array<CharArray>, pos: Int): Boolean {
        if (pos == 81) return true

        val i = pos / 9
        val j = pos % 9
        val squareI = i/ 3 * 3 + j / 3
        val char = board[i][j]

        if (char == '.') {
            val candidateSet = findCandidate(i, j)

            candidateSet.forEachIndexed { ii, isCandidate ->
                if (isCandidate) return@forEachIndexed
                board[i][j] = (ii + 1).digitToChar()
                cacheSquare[squareI][ii] = true
                cacheRow[i][ii] = true
                cacheCol[j][ii] = true
//                println(board.joinToString(separator = "") { it.joinToString(prefix = "[", postfix = "]\n") })
                if (!dfs(board, pos + 1)) {
                    cacheSquare[squareI][ii] = false
                    cacheRow[i][ii] = false
                    cacheCol[j][ii] = false
                    board[i][j] = '.'
                } else {
                    return true
                }
            }
            return false
        } else {
            return dfs(board, pos + 1)
        }
    }

    private fun findCandidate(i: Int, j: Int): BooleanArray {

        val candidates = BooleanArray(9) { ii ->
            cacheSquare[i / 3 * 3 + j / 3][ii] or cacheRow[i][ii] or cacheCol[j][ii]
        }

        return candidates
    }
}