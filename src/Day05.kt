import java.lang.Integer.max
import java.lang.Integer.min
import java.lang.Math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val start = mutableListOf<Pair<Int, Int>>()
        val end = mutableListOf<Pair<Int, Int>>()
        val points: List<List<List<Int>>> = input.map { line ->
            line.split(" -> ").map { it.split(',').map { it.toInt() } }
        }
//        val xxx = min (points.map { it.first().first() }.minOrNull(),points.map { it.first().first() }.minOrNull())
        val minX =
            min(points.minOfOrNull { it.first().first() } ?: 0, points.minOfOrNull { it.last().first() } ?: 0)
        val maxX =
            max(points.maxOfOrNull { it.first().first() } ?: 0, points.maxOfOrNull { it.last().first() } ?: 0)
        val minY =
            min(points.minOfOrNull { it.first().last() } ?: 0, points.minOfOrNull { it.last().last() } ?: 0)
        val maxY =
            max(points.maxOfOrNull { it.first().last() } ?: 0, points.maxOfOrNull { it.last().last() } ?: 0)

        val field = Array(maxX - minX + 1) { IntArray(maxY - minY + 1) { 0 } }
        points
            .forEach {
                if (it.first().first() == it.last().first() || it.first().last() == it.last().last()) {
                    for (x in min(it.first().first(), it.last().first())..max(it.first().first(), it.last().first())) {
                        for (y in min(it.first().last(), it.last().last())..max(it.first().last(), it.last().last())) {
                            field[x - minX][y - minY]++
                        }
                    }
                }
            }

        return field.flatMap { it.asList() }.count { it > 1 }
    }

    fun part2(input: List<String>): Int {
        val start = mutableListOf<Pair<Int, Int>>()
        val end = mutableListOf<Pair<Int, Int>>()
        val points: List<List<List<Int>>> = input.map { line ->
            line.split(" -> ").map { it.split(',').map { it.toInt() } }
        }
//        val xxx = min (points.map { it.first().first() }.minOrNull(),points.map { it.first().first() }.minOrNull())
        val minX =
            min(points.minOfOrNull { it.first().first() } ?: 0, points.minOfOrNull { it.last().first() } ?: 0)
        val maxX =
            max(points.maxOfOrNull { it.first().first() } ?: 0, points.maxOfOrNull { it.last().first() } ?: 0)
        val minY =
            min(points.minOfOrNull { it.first().last() } ?: 0, points.minOfOrNull { it.last().last() } ?: 0)
        val maxY =
            max(points.maxOfOrNull { it.first().last() } ?: 0, points.maxOfOrNull { it.last().last() } ?: 0)

        val field = Array(maxX - minX + 1) { IntArray(maxY - minY + 1) { 0 } }
        points
            .forEach {
                if (it.first().first() == it.last().first() || it.first().last() == it.last().last()) {
                    for (x in min(it.first().first(), it.last().first())..max(it.first().first(), it.last().first())) {
                        for (y in min(it.first().last(), it.last().last())..max(it.first().last(), it.last().last())) {
                            field[x - minX][y - minY]++
                        }
                    }
                } else {
                    val stepX = (it.last().first() - it.first().first()) / abs(it.last().first() - it.first().first())
                    val stepY = (it.last().last() - it.first().last()) / abs(it.last().last() - it.first().last())
                    var x = it.first().first()
                    var y = it.first().last()
                    val steps = abs((it.last().first() - it.first().first())) + 1
                    repeat(steps) {
                        field[x - minX][y - minY]++
                        x += stepX
                        y += stepY
                    }

                }
            }

        return field.flatMap { it.asList() }.count { it > 1 }
    }

    val input = readInput("input-5")
//    println(part1(input))
    println(part2(input))
}
