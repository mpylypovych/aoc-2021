fun main() {
    fun part1(input: List<Int>): Int = input.zipWithNext().count{
        it.second > it.first
    }

    fun part2(input: List<Int>): Int {
        return input.windowed(3).map { it.sum() }.zipWithNext().count {
            it.second > it.first
        }
    }

    val input = readInts("input-1-1")
    println(part1(input))
    println(part2(input))
}
