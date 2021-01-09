package naver

import java.util.*

/*
blocks	result
[[0, 50], [0, 22], [2, 10], [1, 4], [4, -13]]	[50, 22, 28, 4, 18, 10, 0, 4, 14, -4, 1, -1, 5, 9, -13]
[(0, 92), (1, 20), (2, 11), (1, -81), (3, 98)]	[92, 72, 20, 63, 9, 11, 144, -81, 90, -79, 217, -73, -8, 98, -177]
 */

// blocks의 길이는 1 이상 15 이하입니다.

fun main() {
    println(
            solution(
                    arrayOf(
                            intArrayOf(0, 50),
                            intArrayOf(0, 22),
                            intArrayOf(2, 10),
                            intArrayOf(1, 4),
                            intArrayOf(4, -13)
                    )
            ).contentToString()
    )

    println(
            solution(
                    arrayOf(
                            intArrayOf(0, 92),
                            intArrayOf(1, 20),
                            intArrayOf(2, 11),
                            intArrayOf(1, -81),
                            intArrayOf(3, 98)
                    )
            ).contentToString()
    )
}


fun solution(blocks: Array<IntArray>): IntArray {
    val size = blocks.size
    val array = Array(size) { IntArray(size) }
    val visited = Array(size) { BooleanArray(size) }

    blocks.forEachIndexed { index, ints ->
        array[index][ints[0]] = ints[1]
        visited[index][ints[0]] = true
    }

    for (r in 1 until size) {
        for (c in 0 .. r) {
            calc(visited, array, r, c)
        }
    }

    var answer = IntArray((size * size + size) / 2)

    var cnt = 0
    for (r in 0 until size) {
        for (c in 0 .. r) {
            answer[cnt] = array[r][c]
            cnt++
        }
    }

    return answer
}

fun calc(visited:Array<BooleanArray>, array: Array<IntArray>, r: Int, c: Int) {
    if(visited[r][c]) {
        return
    }

    if(c == 0) {
        if(!visited[r][c+1]) {
            calc(visited, array, r, c + 1)
        }
        array[r][c] = array[r-1][c] - array[r][c+1]
    }

    else if(c == r) {
        if(!visited[r][c-1]) {
            calc(visited, array, r, c - 1)
        }
        array[r][c] = array[r-1][c-1] - array[r][c-1]
    }

    else {
        if(visited[r][c-1]) {
            array[r][c] = array[r-1][c-1] - array[r][c-1]
        } else if(visited[r][c+1]) {
            array[r][c] = array[r-1][c] - array[r][c+1]
        } else {
            calc(visited, array, r, c + 1)
            array[r][c] = array[r-1][c] - array[r][c+1]
        }
    }

    visited[r][c] = true
}