//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("1. Задание\n")
    val staplesMap = mapOf(
        "{" to "}",
        "(" to ")",
        "[" to "]"
    )
    val strokeOne = "{([])}"
    val strokeTwo = "{([))}"
    val strokeThree = "{{[])}"

    val checkOne = staplesCheck(strokeOne, staplesMap)
    val checkTwo = staplesCheck(strokeTwo, staplesMap)
    val checkThree = staplesCheck(strokeThree, staplesMap)

    println("1. $strokeOne - $checkOne\n2. $strokeTwo - $checkTwo\n3. $strokeThree - $checkThree")

    getLine("-")

    println("\n2. Задание\n")

    val array = intArrayOf(1, 2, 3, 4)

    val result = variations(array)

    println("Заданный массив чисел: \n${array.contentToString()}\nВсе возможные перестановки его элементов:\n")
    result.forEach { i -> println(i) }
}

fun staplesCheck(stroke: String, map: Map<String, String>): Boolean {
    var checkIndex = 0
    for (i in stroke.indices) {
        if (map.containsKey(stroke[i].toString())) {
            checkIndex++
            if (map[stroke[i].toString()] == stroke[stroke.length - (i + 1)].toString()) {
                checkIndex--
            }
        }
    }
    val result = checkIndex == 0
    return result
}

fun variations(array: IntArray): List<List<Int>> {
    val list = mutableListOf<List<Int>>()
    list.add(array.toList())
    val arrayOut = array.toTypedArray()

    for (j in arrayOut.indices) {
        for (i in 0..array.size - 2) {
            if (i == array.size - 1) arrayOut[0] = arrayOut[arrayOut.size - 1]
            else arrayOut[i] = arrayOut[i + 1].also { arrayOut[i + 1] = arrayOut[i] }
            if (arrayOut.toList() !in list) list.add(arrayOut.toList())
        }

    }

    return list
}