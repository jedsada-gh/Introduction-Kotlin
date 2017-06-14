package goto_chicato

fun main(args: Array<String>) {
    val message = "Hello Chicago"
    println(message)
    higherOrderFunction(func = ::myPlus)
}

fun higherOrderFunction(a: Int = 9, func: (Int, Int) -> Int) = func(a, 3)

fun myPlus(x: Int, y: Int) = x.plus(y)