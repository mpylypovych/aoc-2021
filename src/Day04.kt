fun main() {
    fun part1(input: List<String>): Int {
        val numbers = input.first().split(',').map { it.toInt() }

        val fields = mutableListOf<Field>()
        for (i in 2 until input.count() step 6) {
            fields.add(Field(input.subList(i, i + 5)))
        }
        numbers.forEach { x ->
            fields.forEach { field->
                val res = field.checkNumber(x)
                if(res != 0) {
                    return x*res
                }
            }
        }
        return -1
    }

    fun part2(input: List<String>): Int {
        val numbers = input.first().split(',').map { it.toInt() }

        val fields = mutableListOf<Field>()
        for (i in 2 until input.count() step 6) {
            fields.add(Field(input.subList(i, i + 5)))
        }
        var result = 0
        numbers.forEach { x ->
            fields.forEach { field->
                val res = field.checkNumber(x)
                if(res != 0) {
                    result = x*res
                }
            }
        }
        return result
    }

    val input = readInput("input-4")
    println(part1(input))
    println(part2(input))
}

class Field(strings: List<String>) {
    var field = Array(strings.count()) { IntArray(strings.count()) }

    val numberToPosition = mutableMapOf<Int, Pair<Int,Int>>()
    var sum = 0
    var isDone = false
    var rows = MutableList(strings.count()){strings.count()}
    var cols = MutableList(strings.count()){strings.count()}
    init {
        for(i in 0 until strings.count()) {
            field[i] = strings[i].split(' ').filter { it != "" }.map { it.toInt() }.toIntArray()
            sum += field[i].sum()
        }
        for(i in 0 until field.size) {
            for(j in 0 until field.first().size) {
                numberToPosition[field[i][j]] = Pair(i,j)
            }
        }
    }

    fun checkNumber(x: Int):Int {
        if (isDone)
            return 0
        if(!numberToPosition.contains(x))
            return 0
        else if(rows[numberToPosition[x]!!.first] == 0 || cols[numberToPosition[x]!!.second] == 0) {
            return 0
        } else {
            rows[numberToPosition[x]!!.first]-=1
            cols[numberToPosition[x]!!.second]-=1
            sum -= x
            if(rows[numberToPosition[x]!!.first] == 0 || cols[numberToPosition[x]!!.second] == 0) {
                isDone = true
                return sum
            } else
                return 0
        }
    }

}