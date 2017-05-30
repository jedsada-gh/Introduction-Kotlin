package test

fun test(): Int {
    return 5
}

fun test2() {
    val  test = Test().testInTest()
}

class Test {
    fun testInTest() {

    }
}