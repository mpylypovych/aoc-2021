fun main() {
    fun part1(input: List<String>): Int {
        var x = 0
        var y = 0
        var bit = 1
        for (i in input.first().length - 1 downTo 0) {
            var ones = input.map { it[i].digitToInt() }.sum()
            x += bit * if (ones > input.count() - ones) 1 else 0
            y += bit * if (ones > input.count() - ones) 0 else 1
            bit = bit shl 1
        }

        return x * y
    }

    fun part2(input: List<String>): Int {
        var x = 0
        var y = 0
        var bit = 1
        var filtered = input
        for (i in 0 until input.first().length) {
            val ones = filtered.map { it[i].digitToInt() }.sum()
            filtered = if (ones >= filtered.count() - ones) {
                filtered.filter { it[i] == '1' }
            } else {
                filtered.filter { it[i] == '0' }
            }
            if (filtered.count() == 1) {
                break
            }
        }
        x = Integer.parseInt(filtered.first(), 2)

        filtered = input
        for (i in 0 until input.first().length) {
            val ones = filtered.map { it[i].digitToInt() }.sum()
            filtered = if (ones >= filtered.count() - ones) {
                filtered.filter { it[i] == '0' }
            } else {
                filtered.filter { it[i] == '1' }
            }
            if (filtered.count() == 1) {
                break
            }
        }
        y = Integer.parseInt(filtered.first(), 2)
        return x * y
    }

    val input = readInput("input-3")
    println(part1(input))
    println(part2(input))
}
