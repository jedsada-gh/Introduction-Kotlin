import java.lang.StringBuilder
import java.util.*

//fun main(args: Array<String>) {
//    println("Hello World")
//    println(getList())
//    println(maxOf(10, 5))
//
//    speak()
//    speak("Jedsada")
//    speak(age = 25)
//}

fun toJSON(list: List<Int>): String {
    val sb = StringBuilder()
    sb.append("[")
    val iterator = list.iterator()
    while (iterator.hasNext()) {
        sb.append(iterator.next())
        if (iterator.hasNext()) sb.append(",")
    }
    sb.append("]")
    return sb.toString().trim()
}

fun joinOptions(options: Collection<String>) = options.joinToString(prefix = "[", postfix = "]")

fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
    val test = client?.personalInfo?.email ?: ""
    mailer.sendMessage(client?.personalInfo?.email ?: "", message ?: "")
}

//fun getList(): List<Int> {
//    val arrayList = arrayListOf(1, 5, 2)
//    Collections.sort(arrayList) { o1, o2 -> o2-o1 }
//    return arrayList
//}

//fun getList(): List<Int> {
//    val arrayList = arrayListOf(1, 5, 2).sortDescending()
//    Collections.sort(arrayList, { x, y -> y - x })
//    return arrayList
//}

fun getList(): List<Int> = arrayListOf(1, 5, 2).sortedDescending()

fun plus(client: Client?) {
    print("Obj : ${client?.personalInfo}")
}

fun p(x: Int, y: Int): Int = x + y

fun maxOf(a: Int, b: Int) = if (a > b) a else b

fun speak(name: String = "20Scoops", age: Int = 23) {
    println("My name is $name, I'm $age years old")
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}

open class A {
    open fun a() {
        println("a In A")
    }
}

class B : A() {
    override fun a() {
        println("a in B")
        super.a()
    }
}

class C(val a: A, val b : B) {

    fun somthigns() {
        a.a()
    }
}