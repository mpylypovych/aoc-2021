fun main() {
    fun part1(input: List<String>): Int {
        var x = 0
        var y = 0
        input.forEach {
            val (action, d) = it.split(' ')
            val distance = d.toInt()
            when (action) {
                "forward" -> x += distance
                "up" -> y -= distance
                "down" -> y += distance
            }
        }
        return x * y
    }

    fun part2(input: List<String>): Int {
        var x = 0
        var y = 0
        var aim = 0
        input.forEach {
            val (action, d) = it.split(' ')
            val distance = d.toInt()
            when (action) {
                "forward" -> {
                    x += distance; y += aim * distance
                }
                "up" -> aim -= distance
                "down" -> aim += distance
            }
        }
        return x * y
    }

    val input = readInput("input-2")
    println(part1(input))
    println(part2(input))
}
